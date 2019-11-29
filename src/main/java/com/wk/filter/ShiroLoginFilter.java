package com.wk.filter;

import com.alibaba.fastjson.JSON;
import com.wk.utils.ResultObj;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class ShiroLoginFilter extends FormAuthenticationFilter {
	
	/**
	 * 当用户访问未登陆资源时，会走的方法。
	 * 返回true代表已登陆，不用处理
	 * 返回false代表未登陆。提示前端
	 * 在请求controller之前判断是否登录，返回json，不进行重定向
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		//判断用户是否是浏览器访问 如果是ajax请求就返回json
		if(isAjax(request)) {
			ResultObj resultObj = ResultObj.UNLOGIN;
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/json");
			PrintWriter out = response.getWriter();
			out.write(JSON.toJSONString(resultObj));
			out.flush();
			out.close();
		}else {//重定向
			HttpServletResponse httpServletResponse=(HttpServletResponse) response;
			httpServletResponse.sendRedirect("/toLogin");
		}
		return false;
	}

	/**
	 * 判断当前请求是否为ajax请求
	 */
	private boolean isAjax(ServletRequest request) {
		String header = ((HttpServletRequest) request).getHeader("X-Requested-With");
		if ("XMLHttpRequest".equalsIgnoreCase(header)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
