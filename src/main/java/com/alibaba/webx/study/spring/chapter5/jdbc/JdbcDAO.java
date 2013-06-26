/**
 * Project: study
 * File Created at 2013-6-26下午9:33:01
 */
package com.alibaba.webx.study.spring.chapter5.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;


/**
 * @author zhaoyuanli 2013-6-26下午9:33:01
 */
public class JdbcDAO {

    private DataSource dataSource;

    private static final String MOTORIST_INSERT 
    = "insert into person (id, gmt_create, gmt_modified, name, age,sex) values (null, now(),now(),?,?,?)";

    public void save() {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn =   dataSource.getConnection();
            stmt =   conn.prepareStatement(MOTORIST_INSERT);
            stmt.setString(1, "jdbc-test");
            stmt.setString(2, "12");
            stmt.setString(3, "男");
            stmt.execute();
        } catch (SQLException e) {
            System.out.println("******error!"+e.getMessage());
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
            }
        }
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
}
