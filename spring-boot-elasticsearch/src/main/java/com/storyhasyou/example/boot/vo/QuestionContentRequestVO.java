package com.storyhasyou.example.boot.vo;

import com.storyhasyou.example.boot.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author fangxi
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionContentRequestVO extends PageRequest {

    private String keyword;

}