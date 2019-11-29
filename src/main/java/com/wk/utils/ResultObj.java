package com.wk.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResultObj {
	
	public static final ResultObj UNLOGIN = new ResultObj("403", "未登陆");
	public static final ResultObj UNAUTHORIZED = new ResultObj("405", "未授权");
	public static ResultObj LOGIN_SUCCESS=new ResultObj("200", "登陆成功");
	public static ResultObj LOGIN_ERROR=new ResultObj("-1","登陆失败");
	
	private String code;
	private String msg;

}
