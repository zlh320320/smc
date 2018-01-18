package com.zlh.cms.dto;

import java.io.Serializable;

/**
 * * 类ColumnDTO.java的实现描述：网站栏目表 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public class ColumnDTO implements Serializable {

    /** * */
    private static final long serialVersionUID = 1L;

    private int               id;                   //
    private java.lang.String  columnName;           //
    private java.lang.Integer orderFlag;            //
    private java.lang.Integer parentId;             //
    private java.util.Date    createDate;           //
    private java.lang.Integer siteId;               //
    private int               isShow;
    private int               isMenu;

    public int getIsShow() {
        return isShow;
    }

    public void setIsShow(int isShow) {
        this.isShow = isShow;
    }

    public int getIsMenu() {
        return isMenu;
    }

    public void setIsMenu(int isMenu) {
        this.isMenu = isMenu;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getColumnName() {
        return this.columnName;
    }

    public void setColumnName(java.lang.String columnName) {
        this.columnName = columnName;
    }

    public java.lang.Integer getOrderFlag() {
        return this.orderFlag;
    }

    public void setOrderFlag(java.lang.Integer orderFlag) {
        this.orderFlag = orderFlag;
    }

    public java.lang.Integer getParentId() {
        return this.parentId;
    }

    public void setParentId(java.lang.Integer parentId) {
        this.parentId = parentId;
    }

    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.lang.Integer getSiteId() {
        return this.siteId;
    }

    public void setSiteId(java.lang.Integer siteId) {
        this.siteId = siteId;
    }
}