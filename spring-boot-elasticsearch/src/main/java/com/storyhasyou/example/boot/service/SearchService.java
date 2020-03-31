package com.storyhasyou.example.boot.service;

import com.storyhasyou.example.boot.entity.QuestionAnswer;
import com.storyhasyou.example.boot.common.PageResponse;
import com.storyhasyou.example.boot.repository.SearchRepository;
import com.storyhasyou.example.boot.resultmapper.HighlightResultMapper;
import com.storyhasyou.example.boot.vo.QuestionContentRequestVO;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.List;

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
        elasticsearchRestTemplate.createIndex(QuestionAnswer.class);
        elasticsearchRestTemplate.putMapping(QuestionAnswer.class);
        // List<QuestionAnswer> questionAnswers = this.questionAnswers();
        // searchRepository.saveAll(questionAnswers);

    }

    public void deleteIndex() {
        elasticsearchRestTemplate.deleteIndex(QuestionAnswer.class);
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

        AggregatedPage<QuestionAnswer> questionAnswerPage = elasticsearchRestTemplate.queryForPage(searchQuery, QuestionAnswer.class,
                new HighlightResultMapper(questionContent));
        return PageResponse.of(questionAnswerPage.getContent(),
                questionAnswerPage.getTotalElements(),
                (long) questionAnswerPage.getTotalPages(),
                (long) questionAnswerPage.getSize());
    }

}