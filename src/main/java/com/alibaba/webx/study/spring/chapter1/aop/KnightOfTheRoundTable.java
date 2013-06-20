/**
 * Project: study
 * File Created at 2013-6-20下午10:55:58
 */
package com.alibaba.webx.study.spring.chapter1.aop;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-20下午10:55:58
 */
public class KnightOfTheRoundTable implements Knight {

    /**
     * @author zhaoyuanli
     * 2013-6-20下午10:56:20
     */
    @Override
    public void embarkOnQuest() {
        System.out.println("**embarkOnQuest call!");
    }

}
