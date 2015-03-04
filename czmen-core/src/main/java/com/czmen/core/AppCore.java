package com.czmen.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.czmen.common.DateTimeUtils;
import com.czmen.core.service.UserService;
import com.czmen.core.utils.ApplicationContextHandler;

/**
 * @author yangyong
 */
public class AppCore {
	private static Logger logger = LoggerFactory.getLogger(AppCore.class);

	public static void main(String[] args) {
		logger.info("==== 开始启动Core程序 ====");
		logger.info("==== 系统时间： " + DateTimeUtils.currentDateTime() + " =====");

		/*
		 * 开启远程调用接口，不作拆分时不需要启动。 try { RMISocketFactory.setSocketFactory(new
		 * HermRMISocket()); } catch (IOException ex) {
		 * logger.error(ex.getMessage(), ex); }
		 */
		
		ApplicationContext context = ApplicationContextHandler.init();
		
		UserService userService = (UserService)context.getBean("userService");
		System.out.println("用户信息： " + userService.getUserById(1).getNickname());
		
        try {
            // 检查并启动定时器
            // checkQuartz();
            System.in.read();
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
	}
}
