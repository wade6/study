package com.alibaba.webx.study.annotations;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 注解<type>UseCase</type>的处理器<p>
 * 使用反射方法getDeclaredMethods()和getAnnotation()
 *
 * 
 * @author zhaoyuanli
 * 
 */
public class UseCaseTracker {

	public static void trackUseCase(List<Integer> useCase, Class<?> cl) {

		// 通过遍历类的方法，找出标注在类方法上的注解，完成相应的功能
		for (Method m : cl.getDeclaredMethods()) {
			UseCase uc = m.getAnnotation(UseCase.class);
			if (uc != null) {
				System.out.println("found use case :" + uc.id() + " "
						+ uc.desc());
				useCase.remove(new Integer(uc.id()));
			}
		}

		for (int i : useCase) {
			System.out.println("warning:Missing use case-" + i);
		}

	}

	public static void main(String[] args) {
		List<Integer> useCases = new ArrayList<Integer>();
		Collections.addAll(useCases, 47, 48, 49, 50);
		UseCaseTracker.trackUseCase(useCases, PassWordUtils.class);
	}

}
