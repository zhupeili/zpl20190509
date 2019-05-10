package myWorld.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import myWorld.dao.MyWorldDao;
import myWorld.service.MyWorldService;

/** 
* @author zpl 
* @version 创建时间：2018年3月16日 下午3:39:09 
* 类说明 
*/
public class Main {
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new ClassPathXmlApplicationContext(new String[]{"spring/spring-mvc.xml","spring/spring-mybatis.xml"});
//		ApplicationContext context2 = 
//				new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
		MyWorldService myService = context.getBean("myWorldService",MyWorldService.class);
//		String www = myService.selectById("11");
//		System.out.println(www);
		String str = "^2^3da42b3中文sae34科e技b2报2`~!@#$%^&*()_+-=[]{};':\",.<>/?\\93飞";
		str = str.replaceAll("[^0-9\\u4e00]", "");
		System.out.println(str);
		
//		String tel = "";
//		{
//		Pattern p = Pattern.compile("\t|\r|\n");  
//		Matcher m = p.matcher(tel);  
//		tel = m.replaceAll("");  
//		tel = tel.replaceAll(" +", " "); 
//		}
//		// 判断是否电话号码开头为86
//		Pattern p = Pattern.compile("^[1][0-9][0-9]{9}$");
//		Matcher m = p.matcher(tel);
	}

}
