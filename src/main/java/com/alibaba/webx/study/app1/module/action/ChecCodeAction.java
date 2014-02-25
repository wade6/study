package com.alibaba.webx.study.app1.module.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.citrus.turbine.Context;
import com.alibaba.citrus.turbine.Navigator;
import com.alibaba.citrus.turbine.dataresolver.Param;
import com.alibaba.webx.study.app1.biz.capture.CaptchaServiceSingleton;
import com.octo.captcha.service.CaptchaServiceException;

public class ChecCodeAction {
	
	@Resource
	private HttpServletRequest request;
	
	@Resource
	private CaptchaServiceSingleton captchaServiceSingleton;
	
	public void doCheck(@Param("jcaptcha") String jcaptcha, Navigator nav,Context context){
		
		Boolean isResponseCorrect =Boolean.FALSE;
        //remenber that we need an id to validate!
        String captchaId = request.getSession().getId();
        //retrieve the response
        String response = request.getParameter("jcaptcha");
        // Call the Service method
         try {
             isResponseCorrect = captchaServiceSingleton.getInstance().validateResponseForID(captchaId,
                     response);
         } catch (CaptchaServiceException e) {
              //should not happen, may be thrown if the id is not valid
         }
		
		if(isResponseCorrect){
		// proceed to submit action
			context.put("msg", "ok");
		}else{
		// return error to user
			context.put("msg", "fail!");
		}
	}

}
