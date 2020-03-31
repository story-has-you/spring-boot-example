package com.storyhasyou.example.boot.controller;

import com.storyhasyou.example.boot.common.PageResponse;
import com.storyhasyou.example.boot.common.Result;
import com.storyhasyou.example.boot.entity.QuestionAnswer;
import com.storyhasyou.example.boot.service.SearchService;
import com.storyhasyou.example.boot.vo.QuestionContentRequestVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

;

/**
 * @author fangxi
 */
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @PostMapping("/index")
    public Result<Void> createIndex() {
        searchService.createIndex();
        return Result.ok();
    }

    @DeleteMapping("/index")
    public Result<Void> deleteIndex() {
        searchService.deleteIndex();
        return Result.ok();
    }

    @GetMapping("/question-content")
    public Result<PageResponse<QuestionAnswer>> searchByContent(@Validated QuestionContentRequestVO requestVO) {
        PageResponse<QuestionAnswer> pageResponse = searchService.pageByQuestionContent(requestVO);
        return Result.ok(pageResponse);
    }

}