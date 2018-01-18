package com.zlh.cms.dto;

import java.io.Serializable;
 /**
 * * 类SiteMarkDTO.java的实现描述：站点水印表 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public class SiteMarkDTO implements Serializable{
	/** * */
    private static final long serialVersionUID = 1L;
    
		private java.lang.Integer siteId;//   	private java.lang.Integer markType;//   	private java.lang.Integer markPosition;//   	private java.lang.String markWord;//   	private java.lang.String markPicture;//   	public java.lang.Integer getSiteId() {	    return this.siteId;	}	public void setSiteId(java.lang.Integer siteId) {	    this.siteId=siteId;	}	public java.lang.Integer getMarkType() {	    return this.markType;	}	public void setMarkType(java.lang.Integer markType) {	    this.markType=markType;	}	public java.lang.Integer getMarkPosition() {	    return this.markPosition;	}	public void setMarkPosition(java.lang.Integer markPosition) {	    this.markPosition=markPosition;	}	public java.lang.String getMarkWord() {	    return this.markWord;	}	public void setMarkWord(java.lang.String markWord) {	    this.markWord=markWord;	}	public java.lang.String getMarkPicture() {	    return this.markPicture;	}	public void setMarkPicture(java.lang.String markPicture) {	    this.markPicture=markPicture;	}
}

