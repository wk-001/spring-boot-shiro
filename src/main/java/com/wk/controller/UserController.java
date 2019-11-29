package com.wk.controller;


import com.wk.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 角色表 前端控制器
 * </p>
 *
 * @author wk
 * @since 2019-11-26
 */
@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("list")
	public String list(){
		return "list";
	}

	//必须有指定权限才可以访问该方法
	@RequiresPermissions(value = "user:add")
	@RequestMapping("add")
	@ResponseBody
	public Map<String,Object> add(){
		Map<String,Object> map = new HashMap<>();
		map.put("msg","add");
		return map;
	}

	@RequiresPermissions(value = "user:delete")
	@RequestMapping("del")
	@ResponseBody
	public Map<String,Object> del(){
		Map<String,Object> map = new HashMap<>();
		map.put("msg","del");
		return map;
	}

	//必须同时拥有两个权限才可以访问该方法
	@RequiresPermissions(value = {"user:update","user:delete"})
	@RequestMapping("upd")
	@ResponseBody
	public Map<String,Object> upd(){
		Map<String,Object> map = new HashMap<>();
		map.put("msg","upd");
		return map;
	}

	@RequiresPermissions(value = "user:list")
	@RequestMapping("query")
	@ResponseBody
	public Map<String,Object> query(){
		Map<String,Object> map = new HashMap<>();
		map.put("msg","query");
		return map;
	}
}

