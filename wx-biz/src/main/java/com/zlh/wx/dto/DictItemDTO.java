package com.zlh.wx.dto;

import java.io.Serializable;
 /**
 * * 类DictItemDTO.java的实现描述：数据字典项 类实现描述 * @author zlh 2016-11-17 22:12:48
 */
public class DictItemDTO implements Serializable{
	/** * */
    private static final long serialVersionUID = 1L;
    
		private int id;//   	private int dictId;//   	private String itemValue;//   	private String itemLabel;//   	private int delFlag;//   	public int getId() {	    return this.id;	}	public void setId(int id) {	    this.id=id;	}	public int getDictId() {	    return this.dictId;	}	public void setDictId(int dictId) {	    this.dictId=dictId;	}	public String getItemValue() {	    return this.itemValue;	}	public void setItemValue(String itemValue) {	    this.itemValue=itemValue;	}	public String getItemLabel() {	    return this.itemLabel;	}	public void setItemLabel(String itemLabel) {	    this.itemLabel=itemLabel;	}	public int getDelFlag() {	    return this.delFlag;	}	public void setDelFlag(int delFlag) {	    this.delFlag=delFlag;	}
}

