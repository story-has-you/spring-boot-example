package com.storyhasyou.example.boot.service;

import com.storyhasyou.example.boot.entity.QuestionAnswer;
import com.storyhasyou.example.boot.common.PageResponse;
import com.storyhasyou.example.boot.repository.SearchRepository;
import com.storyhasyou.example.boot.vo.QuestionContentRequestVO;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.aggregations.Aggregations;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author fangxi
 */
@Service
public class SearchService {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;
    @Autowired
    private SearchRepository searchRepository;

    public void createIndex() {
        // this.deleteIndex();
        elasticsearchRestTemplate.indexOps(QuestionAnswer.class).createMapping();
        // List<QuestionAnswer> questionAnswers = this.questionAnswers();
        // searchRepository.saveAll(questionAnswers);

    }

    public void deleteIndex() {
        elasticsearchRestTemplate.indexOps(QuestionAnswer.class).delete();
    }

    public PageResponse<QuestionAnswer> pageByQuestionContent(QuestionContentRequestVO requestVO) {
        Pageable pageable = PageRequest.of(requestVO.getCurrent() - 1, requestVO.getLimit());
        String questionContent = "questionContent";

        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        if (StringUtils.isNotBlank(requestVO.getKeyword())) {
            queryBuilder.withQuery(QueryBuilders.multiMatchQuery(requestVO.getKeyword(), questionContent))
                    .withHighlightBuilder(
                            new HighlightBuilder()
                                    .field(questionContent)
                                    .preTags("<font color='red'>")
                                    .postTags("</font>")
                    );

        }
        NativeSearchQuery searchQuery = queryBuilder.withPageable(pageable).build();

        SearchHits<QuestionAnswer> searchHits = elasticsearchRestTemplate.search(searchQuery, QuestionAnswer.class);
        List<QuestionAnswer> questionAnswers = searchHits.stream().map(SearchHit::getContent).collect(Collectors.toList());
        return PageResponse.of(questionAnswers, searchHits.getTotalHits(), pageable.getOffset(), (long) pageable.getPageSize());
    }

}