/**
 * Project: study
 * File Created at 2013-6-26下午10:37:30
 */
package com.alibaba.webx.study.spring.chapter5.ibatis;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.alibaba.webx.study.app1.biz.object.UserDO;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-26下午10:37:30
 */
public class UserDAOImpl implements UserDAO {
    
    private SqlMapClientTemplate sqlMapClientTemplate;

    /**
     * @author zhaoyuanli
     * 2013-6-26下午10:38:05
     */
    @Override
    public Integer insert() {
        UserDO userDO = new UserDO();
        userDO.setPassword("ibaitsTest");
        userDO.setUsername("ibaitsTest");
        return (Integer) sqlMapClientTemplate.insert("insertUser", userDO);
    }

    public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
        this.sqlMapClientTemplate = sqlMapClientTemplate;
    }

    /**
     * @author zhaoyuanli
     * 2013-6-26下午11:05:01
     */
    @Override
    public UserDO find(String username) {
        return (UserDO) sqlMapClientTemplate.queryForObject("selectByUsername", username);
    }

}
