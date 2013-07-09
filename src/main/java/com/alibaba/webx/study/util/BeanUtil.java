package com.alibaba.webx.study.util;

import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.DateConverter;
import org.springframework.beans.BeanUtils;

import com.alibaba.webx.study.app1.biz.object.Person;
import com.alibaba.webx.study.util.test.PlanDO;

import net.sf.cglib.beans.BeanCopier;

/**
 * bean copy
 * 
 * @author zhaoyuanli
 *
 */
public class BeanUtil {

	/**
	 * cglib's beanCopier 
	 * 
	 * must and only has set get method
	 *   
	 * @param orignal
	 * @param dest
	 */
	public static void cglibBeanCopier(Object source,Object target){
		
		final BeanCopier copy = BeanCopier.create(source.getClass(), target.getClass(), false);
		
		copy.copy(source,target,null);
	}
	
	/**
	 * spring's BeanUtils
	 * 
	 * @param source
	 * @param target
	 */
	public static void springBeanUtils(Object source,Object target){
		BeanUtils.copyProperties(source, target);
	}
	
	/**
	 * apache's BeanUtils.copyProperties
	 * 
	 * @param source
	 * @param target
	 */
	public static void apacheBeanUtils(Object source,Object target){
		try {
			
			ConvertUtils.register(new DateConverter(null), java.util.Date.class); // Exception in thread "main" org.apache.commons.beanutils.ConversionException: No value specified for 'Date'
			org.apache.commons.beanutils.BeanUtils.copyProperties(target, source);
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) throws ParseException {
		
		test2();
	}
	
	private static void test1(){
		Person p1 = new Person();
		p1.setName("test");
		p1.setAge(12);
		p1.setBirthday(new Date());
		List<String> list = new ArrayList<String>();
		list.add("bob");
		list.add("tou");
		p1.setFavorite(list);
		
		Person p2 = new Person();
		
		
		cglibBeanCopier(p1,p2);
		System.out.println("========cglibBeanCopier=========");
		System.out.println(p1.toString());
		System.out.println(p2.toString());
		
		Person p3 = new Person();
		
		springBeanUtils(p1,p3);
		System.out.println("========springBeanUtils=========");
		System.out.println(p1.toString());
		System.out.println(p3.toString());
		
		Person p4 = new Person();
		
		apacheBeanUtils(p1,p4);
		System.out.println("========apacheBeanUtils=========");
		System.out.println(p1.toString());
		System.out.println(p4.toString());
	}
	
	/**
	 * @throws ParseException
	 */
	private static void test2() throws ParseException{
		PlanDO planDO = new PlanDO();
		planDO.setEndTimeStr("2013-07-01 00:00:00");
		planDO.setBrands("test");
		planDO.setModel("tst");
		planDO.setShopNick("test");
		planDO.setModelType(1);
		planDO.setPatternType(1);
		planDO.setStartTimeStr("2013-07-01 00:00:00");
		planDO.setCompanyName("tet");
		planDO.setQuantity(12);
		planDO.setTmallPrice("322");
		planDO.setKaNick("df");
		
		PlanDO planDO2 = new PlanDO();
		
		cglibBeanCopier(planDO,planDO2);
		System.out.println("========cglibBeanCopier=========");
		System.out.println(planDO.toString());
		System.out.println(planDO2.toString());
		
		
	}

}

