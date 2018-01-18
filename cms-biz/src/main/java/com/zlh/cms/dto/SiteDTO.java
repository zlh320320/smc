package com.zlh.cms.dto;

import java.io.Serializable;

/**
 * * 类SiteDTO.java的实现描述：站点表 类实现描述 * @author zlh 2016-07-22 21:34:39
 */
public class SiteDTO implements Serializable {

    /** * */
    private static final long serialVersionUID = 1L;

    private java.lang.Integer id;                    //
    private java.lang.String  siteName;              //
    private java.lang.String  domain;                //
    private java.util.Date    createDate;            //
    private java.lang.String  keywords;              //
    private java.lang.String  siteDesc;              //
    private String            logo;

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public java.lang.Integer getId() {
        return this.id;
    }

    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    public java.lang.String getSiteName() {
        return this.siteName;
    }

    public void setSiteName(java.lang.String siteName) {
        this.siteName = siteName;
    }

    public java.lang.String getDomain() {
        return this.domain;
    }

    public void setDomain(java.lang.String domain) {
        this.domain = domain;
    }

    public java.util.Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(java.util.Date createDate) {
        this.createDate = createDate;
    }

    public java.lang.String getKeywords() {
        return this.keywords;
    }

    public void setKeywords(java.lang.String keywords) {
        this.keywords = keywords;
    }

    public java.lang.String getSiteDesc() {
        return this.siteDesc;
    }

    public void setSiteDesc(java.lang.String siteDesc) {
        this.siteDesc = siteDesc;
    }
}
