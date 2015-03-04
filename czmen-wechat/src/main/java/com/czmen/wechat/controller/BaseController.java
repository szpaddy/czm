package com.czmen.wechat.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.czmen.common.base.ResponseData;
import com.czmen.core.service.UserService;
import com.czmen.model.User;

/**
 * @author yangyong
 */
abstract public class BaseController {
	protected final Logger logger = LoggerFactory.getLogger(getClass());
	private ObjectMapper mapper = new ObjectMapper();
	@Autowired
	protected UserService userService;

	/*
	 * 处理异常
	 */
	@ExceptionHandler()
	public @ResponseBody
	String handle(Exception exception, HttpServletRequest request, HttpServletResponse response) {
		logger.error(request.getRequestURI() + " 请求失败", exception);

		ResponseData data = new ResponseData("", "请求失败", exception.getMessage());
		data.setRequestURI(request.getRequestURI());

		StackTraceElement[] trace = exception.getStackTrace();
		StringBuilder traceContent = new StringBuilder();
		for (int i = 0; i < trace.length; i++)
			traceContent.append("\tat " + trace[i]);
		data.setExecptionTrace(traceContent.toString());

		String json = "";
		try {
			json = mapper.writeValueAsString(data);
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		//		if(!(request.getRequestURI().endsWith(".json") || request.getRequestURI().endsWith("Json")))
		//			throw new RuntimeException(exception);

		response.setStatus(500);//服务端处理失败
		response.setContentType("application/json;charset=UTF-8");
		try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(HttpServletRequest request) {
		Object o = request.getSession().getAttribute("userVo");
		User user = o == null ? null : (User) o;
		return user;
	}

	public String getErrorMessage(List<ObjectError> errors) {
		String message = "";
		for (int i = 0; i < errors.size(); i++) {
			ObjectError objectError = errors.get(i);
			if (i > 0)
				message += ";  " + objectError.getDefaultMessage();
			else
				message = objectError.getDefaultMessage();
		}
		return message;
	}
	
	/**
	 * 获取 当前用户 信息
	 *  如果获取失败 会跳转到 login 界面
	 * @param request
	 * @param response
	 * @return
	 */
	public User getUser(HttpServletRequest request, HttpServletResponse response) {
		//session 中
		User user = (User) request.getSession().getAttribute("userVo");
		if (user == null || user.getId() == 0) {
			logger.error("user is null by session");
			return null;
		}
		//数据库中
		user = userService.getUserById(user.getId());
		if (user == null || user.getId() == 0) {
			logger.error("user is null by db  userid: " + user.getId());
			return null;
		}
		return user;
	}
}
