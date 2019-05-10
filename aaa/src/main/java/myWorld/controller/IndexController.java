package myWorld.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import myWorld.service.MyWorldService;

/** 
* @author zpl 
* @version 创建时间：2018年5月8日 上午9:18:14 
* 类说明 
*/
@Controller
public class IndexController {
	
	@Resource
	MyWorldService myWorldService;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request){
		
//		String www = myWorldService.selectById("11");
//		request.setAttribute("myWorld", www);
		return "login";
	}

}
