package com.study.test;

import com.taobao.itest.ITestSpringContextBaseCase;
import com.taobao.itest.annotation.ITestSpringContext;

@ITestSpringContext({"/applicationContext-test.xml"})
public class BaseTestCase extends ITestSpringContextBaseCase{

}
