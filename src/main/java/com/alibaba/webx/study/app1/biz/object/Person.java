package com.alibaba.webx.study.app1.biz.object;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;

public class Person implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1762531990118168305L;

	private String name;
	
	private int age;
	
	private Date birthday;
	
	private List<String> favorite;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public List<String> getFavorite() {
		return favorite;
	}

	public void setFavorite(List<String> favorite) {
		this.favorite = favorite;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}

