package com.alibaba.webx.study.app1.biz.capture;

import java.awt.Color;

import com.octo.captcha.CaptchaFactory;
import com.octo.captcha.component.image.backgroundgenerator.FunkyBackgroundGenerator;
import com.octo.captcha.component.image.color.SingleColorGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.RandomTextPaster;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.engine.image.fisheye.SimpleFishEyeEngine;
import com.octo.captcha.engine.image.gimpy.BasicGimpyEngine;
import com.octo.captcha.engine.image.gimpy.SimpleListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;
import com.octo.captcha.service.captchastore.FastHashMapCaptchaStore;
import com.octo.captcha.service.image.DefaultManageableImageCaptchaService;
import com.octo.captcha.service.image.ImageCaptchaService;

public class CaptchaServiceSingleton {
	
	 

	private static ImageCaptchaService instance  = initailizeService();
//	= new DefaultManageableImageCaptchaService(10,100000,75000);
	
    public static ImageCaptchaService getInstance(){
        return instance;
    }
    
    
    public static ImageCaptchaService initailizeService(){
    	// 设置字体大小范围
    	RandomFontGenerator fonts = new RandomFontGenerator(20, 20);
		
		
		// ***FunkyBackgroundGenerator,可以设置四中颜色混合的背景**  
		// 第一个参数是图片宽度
		// 第二个参数是图片高度 
		// 第三至第6个分别是  中，左下，左上，右下，右上四个部分的颜色
		// 第七个参数是 颜色混杂程度  0-1  
    	SingleColorGenerator leftUpColor = new SingleColorGenerator(Color.white);  
    	SingleColorGenerator leftDownColor = new SingleColorGenerator(Color.white);  
    	SingleColorGenerator rightUpColor = new SingleColorGenerator(Color.white);  
    	SingleColorGenerator rightDownColor = new SingleColorGenerator(Color.white);
    	FunkyBackgroundGenerator background = new FunkyBackgroundGenerator(100, 40, 
    			leftUpColor, leftDownColor, rightUpColor, rightDownColor, 0f); 
    	
    	//设置单词的长度，最后一个是颜色
    	RandomTextPaster textPaster =  
    			new RandomTextPaster(new Integer(4), new Integer(4), Color.BLUE); 
    	
    	ComposedWordToImage cwti =  new ComposedWordToImage(fonts, background, textPaster);
    	
    	// 设置取词范围
    	RandomWordGenerator words =  new RandomWordGenerator("ABCDEFGHIJKLMNOPQRSTUVWXYZ"); 
    	GimpyFactory gimpy = new GimpyFactory(words, cwti);
    	
    	SimpleListImageCaptchaEngine engine = new SimpleListImageCaptchaEngine();
    	
    	engine.setFactories(new CaptchaFactory[] { gimpy });   
    	FastHashMapCaptchaStore captchaStore = new FastHashMapCaptchaStore(); 
    	
    	// 創建一個用來生成圖片的服務,參數如下: 
    	// 第一個參數是存儲器,用來存儲生成的文本,最終等待User輸入驗證碼后,驗證輸入是否正確  
    	// 第二個參數是生成圖片的引擎 
    	// 第三個參數是最小保證存儲的時間,單位是秒 
    	// 第四個參數是最大的存儲大小,可能是生成圖片最大使用的大小  
    	// 第五個參數是Captcha在存儲安裝前的廢鏈接數量
    	DefaultManageableImageCaptchaService defaultService =  new DefaultManageableImageCaptchaService( 
    		    captchaStore, engine, 30, 100000, 75000);
		
    	return defaultService;
    }

}
