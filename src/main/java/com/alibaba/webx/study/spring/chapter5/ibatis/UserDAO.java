/**
 * Project: study
 * File Created at 2013-6-26下午10:37:05
 */
package com.alibaba.webx.study.spring.chapter5.ibatis;

import com.alibaba.webx.study.app1.biz.object.UserDO;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-26下午10:37:05
 */
public interface UserDAO {

    public Integer insert();
    
    public UserDO find(String username);
}
