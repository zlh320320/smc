package com.zlh.wx.dto;

import java.io.Serializable;
 /**
 * * 类LoginLogDTO.java的实现描述：登陆日志 类实现描述 * @author zlh 2016-11-27 16:52:14
 */
public class LoginLogDTO implements Serializable{
	/** * */
    private static final long serialVersionUID = 1L;
    
		private int id;//   	private String username;//   	private int userId;//   	private java.util.Date createDate;//   创建时间	private String loginIp;//   登陆ip	private String mac;//   mac 地址	private String message;//   日志	private int type;//    0 登陆  1 登出	public int getId() {	    return this.id;	}	public void setId(int id) {	    this.id=id;	}	public String getUsername() {	    return this.username;	}	public void setUsername(String username) {	    this.username=username;	}	public int getUserId() {	    return this.userId;	}	public void setUserId(int userId) {	    this.userId=userId;	}	public java.util.Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(java.util.Date createDate) {	    this.createDate=createDate;	}	public String getLoginIp() {	    return this.loginIp;	}	public void setLoginIp(String loginIp) {	    this.loginIp=loginIp;	}	public String getMac() {	    return this.mac;	}	public void setMac(String mac) {	    this.mac=mac;	}	public String getMessage() {	    return this.message;	}	public void setMessage(String message) {	    this.message=message;	}	public int getType() {	    return this.type;	}	public void setType(int type) {	    this.type=type;	}
}

