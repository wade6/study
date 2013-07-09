package com.study.test.service;

import javax.annotation.Resource;

import org.junit.Test;

import com.alibaba.webx.study.app1.biz.service.UserService;
import com.study.test.BaseTestCase;

public class UserServiceITest extends BaseTestCase {
	
	@Resource
	UserService userService;
	
	@Test
	public void addUserTest(){
		
	}

}
