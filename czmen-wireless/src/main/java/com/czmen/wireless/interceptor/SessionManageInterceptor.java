package com.czmen.wireless.interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.czmen.model.User;

/**
 * Session拦截器
 * @author YANGYONG
 *
 */
public class SessionManageInterceptor extends HandlerInterceptorAdapter {
	private static Logger logger = LoggerFactory.getLogger(SessionManageInterceptor.class);

	//private UserLoginService userLoginService;
	//private IUserService userService;
	//private CommonService commonService;

	/*
	public void setCommonService(CommonService commonService) {
		this.commonService = commonService;
	}

	public void setUserLoginService(UserLoginService userLoginService) {
		this.userLoginService = userLoginService;
	}

	public void setUserService(IUserService userService) {
		this.userService = userService;
	} */

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		if (handler instanceof org.springframework.web.servlet.resource.ResourceHttpRequestHandler) {
			return true;
		}
		return true;
	}

	/**
	 * 返回 错误提示信息
	 * 
	 * @param session
	 * @param response
	 * @return
	 * @throws IOException
	 */
	private boolean writeErrorMessage(HttpSession session, HttpServletResponse response) throws IOException {
		/*
		session.removeAttribute("userVo");
		session.removeAttribute("token");
		session.invalidate();

		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().print(
				StringUtil.object2JSON(new ResponseData(ErrorConst.LOGIN_OUT, ErrorConst.LOGIN_OUT_M)));
		*/
		return false;
	}

	private boolean checkToken(HttpSession session, HttpServletRequest request, HttpServletResponse response,
			String token) throws IOException {
		return true;
	}

	/**
	 * 更新 user_main 信息
	 * @param userId
	 */
	private void updateUserMain(HttpSession session) {
		/**
		logger.info("updateUserMain is start");
		Object userObj = session.getAttribute("userMain");
		User user = null;
		if (userObj != null) {
			user = (User) userObj;
		} else {
			try {
				user = userService.getUserByID(userBase.getUserId());
			} catch (PlatformException e) {
				logger.error(" updateUserMain is error ", e);
			}
		}
		if (user == null) {
			logger.error(" updateUserMain user == null");
			return;
		}
		//校验数据是否一直，不一致则同步。
		if (!checkIsSame(user, userBase)) {
			user = updateUser(user, userBase);
		}
		session.setAttribute("userMain", user);
		logger.info("updateUserMain is end");
		**/
	}

	/*
	private boolean checkIsSame(User user, UserBase userBase) {

		if (!checkValue(user.getEmail(), userBase.getEmail())) {
			return false;
		}

		if (!checkValue(user.getRealName(), userBase.getRealName())) {
			return false;
		}

		if (!checkValue(user.getIdCardNo(), userBase.getIdCardNo())) {
			return false;
		}

		if (!checkValue(user.getMobile(), userBase.getMobile())) {
			return false;
		}

		if (!checkValue(user.getStatus(), userBase.getStatus())) {
			return false;
		}
		if (!checkValue(user.getPortrait(), userBase.getPortrait())) {
			return false;
		}
		return true;
	} */

	public boolean checkValue(Object userValue, Object userBaseValue) {
		//判断邮箱是否一致
		if (userValue != null) {
			if (userBaseValue != null) {
				boolean reBoo = true;
				if (userValue instanceof String && userBaseValue instanceof String) {
					reBoo = userBaseValue.toString().equals(userValue.toString());
				}
				if (userValue instanceof Integer && userBaseValue instanceof Integer) {
					reBoo = (Integer) userBaseValue == (Integer) userValue;
				}
				if (userValue instanceof Short && userBaseValue instanceof Short) {
					reBoo = (Short) userValue == (Short) userBaseValue;
				}
				return reBoo;
			} else {
				return false;
			}
		} else {
			if (userBaseValue != null) {
				return false;
			} else {
				return true;
			}
		}
	}

	/*
	private User updateUser(User user, UserBase userBase) {
		logger.info("update user_main is start");
		try {
			int re = userService.updateUserFromUserBase(userBase.getUserId(), userBase.getEmail(),
					userBase.getRealName(), userBase.getIdCardNo(), userBase.getMobile(), userBase.getStatus(),
					userBase.getPortrait());
			if (re > 0) {
				logger.info("用户登录实时同步成功。");
			}
			user.setEmail(userBase.getEmail());
			user.setRealName(userBase.getRealName());
			user.setIdCardNo(userBase.getIdCardNo());
			user.setMobile(userBase.getMobile());
			user.setStatus(userBase.getStatus());
		} catch (PlatformException e) {
			logger.error("同步失败:" + e.getMessage());
		}
		logger.info("update user_main is end");
		return user;
	} */
}
