package com.alibaba.webx.study.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 声明自定义注解，用来表示一个方法用例已经完成
 * 
 * @author zhaoyuanli
 * 
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {
	public int id();

	public String desc() default "no desc";
}
