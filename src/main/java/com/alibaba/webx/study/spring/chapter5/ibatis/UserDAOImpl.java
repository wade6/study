/**
 * Project: study
 * File Created at 2013-6-26下午10:37:30
 */
package com.alibaba.webx.study.spring.chapter5.ibatis;

import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.alibaba.webx.study.app1.biz.object.UserDO;

/**
 * 
 * @author zhaoyuanli
 * 2013-6-26下午10:37:30
 */
public class UserDAOImpl implements UserDAO {
    
    private SqlMapClientTemplate sqlMapClientTemplate;
    
    private TransactionTemplate transactionTemplate;
    
    public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
        this.sqlMapClientTemplate = sqlMapClientTemplate;
    }
    
    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }



    /**
     * @author zhaoyuanli
     * 2013-6-26下午10:38:05
     */
    @SuppressWarnings("unchecked")
    @Override
    public Integer insert() {
        Integer result = (Integer) transactionTemplate.execute(new TransactionCallback() {
            @Override
            public Object doInTransaction(TransactionStatus status) {
                try {
                    UserDO userDO = new UserDO();
                    userDO.setPassword("ibaitsTest");
                    userDO.setUsername("ibaitsTest");
                    Integer id = (Integer) sqlMapClientTemplate.insert("insertUser", userDO);
                    throw new RuntimeException();
//                    return id;
                } catch (Exception e) {
                    status.setRollbackOnly();
                }
                return null;
            }
        });
        return result;
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
