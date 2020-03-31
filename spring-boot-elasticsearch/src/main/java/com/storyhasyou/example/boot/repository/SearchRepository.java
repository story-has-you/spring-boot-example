package com.storyhasyou.example.boot.repository;

import com.storyhasyou.example.boot.entity.QuestionAnswer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;


/**
 * @author fangxi
 */
@Repository
public interface SearchRepository extends ElasticsearchRepository<QuestionAnswer, Long> {


}
