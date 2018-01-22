package com.zlh.wx.dto;

import java.io.Serializable;
 /**
 * * 类GroupDTO.java的实现描述：//TODO 类实现描述 * @author user03 2016-07-22 20:34:50
 */
public class GroupDTO implements Serializable{
	
		private java.lang.Integer groupId;//   	private java.lang.String groupName;//   	private java.lang.Integer parentId;//   	private java.util.Date createDate;//   	private java.lang.String description;//   	public java.lang.Integer getGroupId() {	    return this.groupId;	}	public void setGroupId(java.lang.Integer groupId) {	    this.groupId=groupId;	}	public java.lang.String getGroupName() {	    return this.groupName;	}	public void setGroupName(java.lang.String groupName) {	    this.groupName=groupName;	}	public java.lang.Integer getParentId() {	    return this.parentId;	}	public void setParentId(java.lang.Integer parentId) {	    this.parentId=parentId;	}	public java.util.Date getCreateDate() {	    return this.createDate;	}	public void setCreateDate(java.util.Date createDate) {	    this.createDate=createDate;	}	public java.lang.String getDescription() {	    return this.description;	}	public void setDescription(java.lang.String description) {	    this.description=description;	}
}

