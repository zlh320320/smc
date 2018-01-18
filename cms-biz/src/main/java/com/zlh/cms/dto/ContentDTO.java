package com.zlh.cms.dto;

import java.io.Serializable;

/**
 * * 类ContentDTO.java的实现描述：新闻内容表 类实现描述 * @author zlh 2016-07-22 21:34:38
 */
public class ContentDTO implements Serializable {

    /** * */
    private static final long serialVersionUID = 1L;

    private int               id;                   //
    private java.lang.String  title;                //
    private java.lang.String  summary;              //
    private java.lang.Integer clickNum;             //
    private java.lang.String  content;              //
    private java.lang.Integer orderFlag;            //
    private java.util.Date    createDate;           //
    private java.util.Date    updateDate;           //
    private java.lang.String  fromname;             //
    private java.lang.String  fromUrl;              //
    private java.lang.Integer siteId;               //
    private int               columnId;
    private String            editor;
    private String            picture;

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public int getColumnId() {
        return columnId;
    }

    public void setColumnId(int columnId) {
        this.columnId = columnId;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getTitle() {
        return this.title;
    }

    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    public java.lang.String getSummary() {
        return this.summary;
    }

    public void setSummary(java.lang.String summary) {
        this.summary = summary;
    }

    public java.lang.Integer getClickNum() {
        return this.clickNum;
    }

    public void setClickNum(java.lang.Integer clickNum) {
        this.clickNum = clickNum;
    }

    public java.lang.String getContent() {
        return this.content;
    }

    public void setContent(java.lang.String content) {
        this.content = content;
    }

    public java.lang.Integer getOrderFlag() {
        return this.orderFlag;
    }

    public void setOrderFlag(java.lang.Integer orderFlag) {
        this.orderFlag = orderFlag;
    }

    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.util.Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(java.util.Date updateDate) {
        this.updateDate = updateDate;
    }

    public java.lang.String getFromname() {
        return this.fromname;
    }

    public void setFromname(java.lang.String fromname) {
        this.fromname = fromname;
    }

    public java.lang.String getFromUrl() {
        return this.fromUrl;
    }

    public void setFromUrl(java.lang.String fromUrl) {
        this.fromUrl = fromUrl;
    }

    public java.lang.Integer getSiteId() {
        return this.siteId;
    }

    public void setSiteId(java.lang.Integer siteId) {
        this.siteId = siteId;
    }
}
