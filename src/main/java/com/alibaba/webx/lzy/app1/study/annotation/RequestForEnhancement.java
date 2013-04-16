package com.alibaba.webx.lzy.app1.study.annotation;

public @interface RequestForEnhancement {
    
    int id();

    String synopsis();

    String engineer() default "[unassigned]";

    String date() default "[unimplemented]";
}
