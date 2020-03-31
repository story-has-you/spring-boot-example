package com.storyhasyou.example.boot.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

/**
 * @author fangxi
 */
@Data
@Document(indexName = "qa", type = "_doc", replicas = 0)
public class QuestionAnswer {

    @Id
    @Field(index = false,type = FieldType.Long)
    private Long questionId;
    @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
    private String questionContent;
    @Field(index = false,type = FieldType.Long)
    private Long userId;
    @Field(type = FieldType.Object)
    private List<Answer> answers;

    @Data
    public static class Answer {
        @Field(index = false, type = FieldType.Long)
        private Long answerId;
        @Field(index = false,type = FieldType.Long)
        private Long questionId;
        @Field(type = FieldType.Text, analyzer = "ik_max_word", searchAnalyzer = "ik_max_word")
        private String answerContent;
        @Field(index = false,type = FieldType.Integer)
        private Integer sort;
    }
}