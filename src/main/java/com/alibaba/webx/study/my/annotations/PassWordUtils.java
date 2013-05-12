package com.alibaba.webx.study.my.annotations;

import java.util.List;

/**
 * 使用自定义注解
 * 
 * @author zhaoyuanli
 * 
 */
public class PassWordUtils {

	@UseCase(id = 47, desc = "pwd must contain at least one numeric")
	public boolean validate(String pwd) {
		return pwd.matches("\\w*\\d\\w*");
	}

	@UseCase(id = 48)
	public String encryptPwd(String pwd) {
		return new StringBuilder(pwd).reverse().toString();
	}

	@UseCase(id = 49, desc = "exist duplicate pwd")
	public boolean checkNewPwd(List<String> prePwd, String pwd) {
		return !prePwd.contains(pwd);
	}

}
