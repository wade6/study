/**
 * Project: study
 * File Created at 2013-5-16下午11:02:35
 */
package com.alibaba.webx.study.app1.biz.dao;

import com.alibaba.webx.study.app1.biz.object.UserDO;

/**
 * 
 * @author zhaoyuanli
 * 2013-5-16下午11:02:35
 */
public interface UserDAO {

    public boolean addUser(UserDO userDO);  
    
    public boolean deleteUser(UserDO userDO);  
  
    public UserDO getByUsername(String username);  
  
    public boolean updateUser(UserDO userDO);  
}
