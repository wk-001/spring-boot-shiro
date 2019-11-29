package com.wk.handler;

import com.wk.utils.ResultObj;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常监控
 * @author LJH
 *
 */
//@ControllerAdvice		//监视controller是否有异常发生，只要发生指定异常就跳转到指定页面
@RestControllerAdvice	//监视controller是否有异常发生，只要发生指定异常就返回json数据
public class GlobalExceptionHanderAdvise {
	/**
	 * 只要当前项目的代码抛出UnauthorizedException(访问未授权的资源触发)就会回调
     */
	@ExceptionHandler(value= {UnauthorizedException.class})
	public ResultObj unauthorized() {
		return ResultObj.UNAUTHORIZED;
	}
}
