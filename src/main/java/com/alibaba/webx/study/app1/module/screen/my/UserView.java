/**
 * Project: study
 * File Created at 2013-5-27下午11:01:37
 */
package com.alibaba.webx.study.app1.module.screen.my;

import javax.annotation.Resource;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.webx.study.app1.biz.object.UserDO;
import com.alibaba.webx.study.app1.biz.service.UserService;

/**
 * 
 * @author zhaoyuanli
 * 2013-5-27下午11:01:37
 */
public class UserView {
    @Resource
    private UserService userService;
    
    public void execute(Context context) {
        System.out.println("UserView");
        UserDO userDO = new UserDO();
        userDO.setUsername("userView");
        userDO.setPassword("213");
        userService.addUser(userDO);
    }
    
//    protected String getFullUrl(HttpServletRequest request) {
//
//        StringBuffer requestUrl = new StringBuffer();
//        if (StringUtils.isNotBlank(FilterManager.getAppServer()) || StringUtils.isNotBlank(FilterManager.getAppPort())) {
//            String appServer = StringUtils.isNotBlank(FilterManager.getAppServer()) ? FilterManager.getAppServer() : request.getServerName();
//            requestUrl.append(request.getScheme()).append("://").append(appServer);
//
//            String appPort = StringUtils.isNotBlank(FilterManager.getAppPort()) ? FilterManager.getAppPort() : String.valueOf(request.getLocalPort());
//            if (!StringUtils.equals(appPort, "80") && !StringUtils.equals(appPort, "443")) {
//                requestUrl.append(":" + appPort);
//            }
//            requestUrl.append(request.getRequestURI());
//        } else requestUrl = request.getRequestURL();
//
//        if (StringUtils.isNotBlank(request.getQueryString())) {
//            requestUrl.append("?").append(request.getQueryString());
//        }
//        return requestUrl.toString();
//    }

}
