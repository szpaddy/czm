package com.czmen.wireless.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.czmen.common.base.XSSReplaceUtils;

/**
 * 防XSS攻击。
 * 
 * @author YANGYONG
 *
 */
public class XSSSafeInterceptor extends HandlerInterceptorAdapter {
	public static Logger logger = LoggerFactory.getLogger(XSSSafeInterceptor.class);

	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		Enumeration params = request.getParameterNames();
		while (params.hasMoreElements()) {
			String key = (String) params.nextElement();
			String cache = request.getParameter(key);
			String safeVale = XSSReplaceUtils.antiXSS(cache);
			// String safeVale = HTMLFilter.makeSafe(cache);
			// logger.info("key:"+key+",value:"+cache+"--->"+safeVale);
			request.setAttribute(key, safeVale);
		}
		return true;
	}
}
