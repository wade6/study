/**
 * Project: study
 * File Created at 2013-5-16下午11:03:08
 */
package com.alibaba.webx.study.app1.biz.dao.impl;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import com.alibaba.webx.study.app1.biz.dao.UserDAO;
import com.alibaba.webx.study.app1.biz.object.UserDO;

/**
 * @author zhaoyuanli 2013-5-16下午11:03:08
 */
public class UserDAOImpl extends SqlMapClientDaoSupport implements UserDAO {

    public boolean addUser(UserDO userDO) {
        Object result = getSqlMapClientTemplate().insert("insertUser", userDO);
        return ((Integer) result > 0);
    }

    public boolean deleteUser(UserDO userDO) {
        int result = getSqlMapClientTemplate().delete("deleteuser", userDO);
        return (result > 0);
    }

    public UserDO getByUsername(String username) {
        return (UserDO) getSqlMapClientTemplate().queryForObject("selectByUsername", username);
    }

    public boolean updateUser(UserDO userDO) {
        int result = getSqlMapClientTemplate().update("updateuser", userDO);
        return (result > 0);
    }

}
