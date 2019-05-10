package myWorld.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import myWorld.entity.ResponseVO;
import myWorld.entity.UserVO;
import myWorld.service.MyWorldService;
import myWorld.utils.EncryptDecryptUtil;

/** 
* @author zpl 
* @version 创建时间：2018年5月8日 下午3:33:14 
* 类说明 
*/
@Controller
@RequestMapping("/login")
public class LoginController {
	
	@Resource
	MyWorldService myWorldService;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, UserVO user){
		if(user.getUserCount()==null||user.getUserCount().equals("")){
			request.setAttribute("msg", "账号为空！");
			request.setAttribute("status", 400);
			return "/login";
		}
		UserVO uservo = myWorldService.selectUser(user);
        String passwordMD5 = EncryptDecryptUtil.SHA(user.getPwd(), EncryptDecryptUtil.KEY_MD5);
		if (uservo.getPwd().equals(passwordMD5)) {
			request.setAttribute("user", uservo);
			request.setAttribute("msg", "登录成功！");
			request.setAttribute("status", 200);
			return "success";
		}
		request.setAttribute("msg", "账户名或者密码错误！");
		request.setAttribute("status", 300);
		return "login";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, UserVO user){
        String passwordMD5 = EncryptDecryptUtil.SHA(user.getPwd(), EncryptDecryptUtil.KEY_MD5);
        	user.setPwd(passwordMD5);
        	ResponseVO response = myWorldService.insertUser(user);
			request.setAttribute("user", response);
			request.setAttribute("msg", "注册成功！");
			request.setAttribute("status", 200);
			return "registerSuccess";
		}
}
