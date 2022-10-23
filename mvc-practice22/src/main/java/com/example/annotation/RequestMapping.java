package com.example.annotation;

import com.example.controller.RequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * packageName    : com.example.mvcpractice.annotation
 * fileName       : RequestMapping
 * author         : swch
 * date           : 2022-10-04
 * description    :
 */
@Target({ElementType.TYPE, ElementType.METHOD}) // class와 method에 가능
@Retention(RetentionPolicy.RUNTIME)
public @interface RequestMapping {
    String value() default  ""; // 어떤 값도 입력하지 않으면 빈 문자열
    RequestMethod[] method() default {};
}
