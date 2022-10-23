package com.example.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * packageName    : com.example.mvcpractice.annotation
 * fileName       : Controller
 * author         : swch
 * date           : 2022-10-04
 * description    :
 */
@Target({ElementType.TYPE}) // type지정
@Retention(RetentionPolicy.RUNTIME) // 유지기간은 run time
public @interface Controller {
}
