package com.zlh.wx.dto;

import java.io.Serializable;
import java.util.Date;

/**
 * 公众号实体
 * 
 * @author z
 * 
 */
public class PublicNumberDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2936615956863057151L;

	private int id;

	private String avatar;

	private String qrcode;

	private String publicName;

	private String publicDesc;

	private String wechat;

	private String email;

	private String mobilephone;

	private String appId;

	private String appSecret;

	private int creator;

	private Date createDate;

	public int getCreator() {
		return creator;
	}

	public void setCreator(int creator) {
		this.creator = creator;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getPublicName() {
		return publicName;
	}

	public void setPublicName(String publicName) {
		this.publicName = publicName;
	}

	public String getPublicDesc() {
		return publicDesc;
	}

	public void setPublicDesc(String publicDesc) {
		this.publicDesc = publicDesc;
	}

	public String getWechat() {
		return wechat;
	}

	public void setWechat(String wechat) {
		this.wechat = wechat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilephone() {
		return mobilephone;
	}

	public void setMobilephone(String mobilephone) {
		this.mobilephone = mobilephone;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

}
