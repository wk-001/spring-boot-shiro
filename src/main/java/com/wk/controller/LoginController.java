package com.wk.controller;

import com.wk.entity.User;
import com.wk.service.UserService;
import com.wk.utils.ActiverUser;
import com.wk.utils.ResultObj;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/")
	public String index(){
		return "login";
	}

	//普通项目 未登录时跳转到登录页面
	@RequestMapping("toLogin")
	public String toLogin(){
		return "login";
	}

	/* 普通项目 跳转页面
	@RequestMapping("login")
	public String login(User user, HttpSession session){
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPwd());
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			//登录成功后将用户信息放入session
			ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
			session.setAttribute("user",activerUser.getUser());
			return "list";
		} catch (AuthenticationException e) {
			e.printStackTrace();
			//重定向不走视图解析器，所以需要加上后缀
			return "redirect:/login.html";
		}
	}*/

	/*前后端分离 返回json数据*/
	@RequestMapping("login")
	@ResponseBody
	public ResultObj login(User user, HttpSession session){
		UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPwd());
		Subject subject = SecurityUtils.getSubject();
		try {
			subject.login(token);
			//登录成功后将用户信息放入session
			ActiverUser activerUser = (ActiverUser) subject.getPrincipal();
			session.setAttribute("user",activerUser.getUser());
			return ResultObj.LOGIN_SUCCESS;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			//重定向不走视图解析器，所以需要加上后缀
			return ResultObj.LOGIN_ERROR;
		}
	}

}
