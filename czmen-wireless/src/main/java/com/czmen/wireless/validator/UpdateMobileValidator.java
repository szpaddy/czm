package com.czmen.wireless.validator;

import java.io.Serializable;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 * 更新手机号验证。
 * 
 * @author YANGYONG
 *
 */
public class UpdateMobileValidator implements Serializable {
	private static final long serialVersionUID = 4434429922446495791L;

 	@Pattern(regexp = "((\\+86)?|\\(\\+86\\))0?1[3578]\\d{9}$", message = "{phone.illegal}") //java validator验证（用户名字母数字组成，长度为6-20）
    private String phone;
    
    @Length(min=6,max=6, message = "{phoneVerify.illegal}") 
    private String phoneVerify;

 	@Pattern(regexp = "((\\+86)?|\\(\\+86\\))0?1[3578]\\d{9}$", message = "{phone.illegal}") //java validator验证（用户名字母数字组成，长度为6-20）
    private String newPhone;
 	@Pattern(regexp = "((\\+86)?|\\(\\+86\\))0?1[3578]\\d{9}$", message = "{phone.illegal}") //java validator验证（用户名字母数字组成，长度为6-20）
    private String oldPhone;
 	 @Length(min=6,max=6, message = "{phoneVerify.illegal}") 
     private String newPhoneVerify;
 	 @Length(min=6,max=6, message = "{phoneVerify.illegal}") 
     private String oldPhoneVerify;
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPhoneVerify() {
		return phoneVerify;
	}
	public void setPhoneVerify(String phoneVerify) {
		this.phoneVerify = phoneVerify;
	}
	public String getNewPhone() {
		return newPhone;
	}
	public void setNewPhone(String newPhone) {
		this.newPhone = newPhone;
	}
	public String getOldPhone() {
		return oldPhone;
	}
	public void setOldPhone(String oldPhone) {
		this.oldPhone = oldPhone;
	}
	public String getNewPhoneVerify() {
		return newPhoneVerify;
	}
	public void setNewPhoneVerify(String newPhoneVerify) {
		this.newPhoneVerify = newPhoneVerify;
	}
	public String getOldPhoneVerify() {
		return oldPhoneVerify;
	}
	public void setOldPhoneVerify(String oldPhoneVerify) {
		this.oldPhoneVerify = oldPhoneVerify;
	}
 	  
}
