package com.czmen.wireless.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerExceptionResolverComposite;

/**
 * 异常处理页面
 * 
 * @author YANGYONG
 *
 */
public class MyExceptionHandler extends HandlerExceptionResolverComposite {
	private static Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

	public ModelAndView resolveException(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception e) {
		logger.error("resolveException", e);
		return new ModelAndView("global/error");
	}
}
