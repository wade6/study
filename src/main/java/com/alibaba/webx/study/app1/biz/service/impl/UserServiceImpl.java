/**
 * Project: study
 * File Created at 2013-5-27下午11:04:41
 */
package com.alibaba.webx.study.app1.biz.service.impl;

import javax.annotation.Resource;

import org.springframework.transaction.annotation.Transactional;

import com.alibaba.webx.study.app1.biz.dao.UserDAO;
import com.alibaba.webx.study.app1.biz.object.UserDO;
import com.alibaba.webx.study.app1.biz.service.UserService;

/**
 * 
 * @author zhaoyuanli
 * 2013-5-27下午11:04:41
 */
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserDAO userDAO;

    /**
     * @author zhaoyuanli
     * 2013-5-27下午11:04:41
     */
    @Override
    @Transactional
    public boolean addUser(UserDO userDO) {
        // TODO Auto-generated method stub
        boolean result =  userDAO.addUser(userDO);
        if(result){
            throw new RuntimeException();
        }
        return result;
    }

    /**
     * @author zhaoyuanli
     * 2013-5-27下午11:04:41
     */
    @Override
    public boolean deleteUser(UserDO userDO) {
        // TODO Auto-generated method stub
        return userDAO.deleteUser(userDO);
    }

    /**
     * @author zhaoyuanli
     * 2013-5-27下午11:04:41
     */
    @Override
    public UserDO getByUsername(String username) {
        // TODO Auto-generated method stub
        return userDAO.getByUsername(username);
    }

    /**
     * @author zhaoyuanli
     * 2013-5-27下午11:04:41
     */
    @Override
    public boolean updateUser(UserDO userDO) {
        // TODO Auto-generated method stub
        return userDAO.updateUser(userDO);
    }

}
