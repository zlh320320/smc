package com.zlh.wx.dto;

import java.io.Serializable;

/**
 * * 类SystemParamDTO.java的实现描述：系统参数 类实现描述 * @author zlh 2017-10-15 15:29:12
 */
public class SystemParamDTO implements Serializable {

    /** * */
    private static final long serialVersionUID = 1L;

    private long              id;                    //
    private String            name;                  //
    private String            value;                 //
    private String            remark;                //

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
