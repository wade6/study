/**
 * Project: study
 * File Created at 2013-5-16下午10:59:58
 */
package com.alibaba.webx.study.app1.biz.object;

import java.util.Date;

/**
 * @author zhaoyuanli 2013-5-16下午10:59:58
 */
public class UserDO {

    private long   id;
    private String username;
    private String password;
    private Date   gmt_create;
    private Date   gmt_modified;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(Date gmt_create) {
        this.gmt_create = gmt_create;
    }

    public Date getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(Date gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

}
