/**
 * Project: study
 * File Created at 2013-5-27下午11:03:34
 */
package com.alibaba.webx.study.app1.biz.service;

import com.alibaba.webx.study.app1.biz.object.UserDO;

/**
 * @author zhaoyuanli 2013-5-27下午11:03:34
 */
public interface UserService {

    public boolean addUser(UserDO userDO);

    public boolean deleteUser(UserDO userDO);

    public UserDO getByUsername(String username);

    public boolean updateUser(UserDO userDO);

}
