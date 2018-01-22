package com.zlh.wx.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.wx.dao.SystemParamDao;
import com.zlh.wx.dto.SystemParamDTO;

/**
 * * 类SystemParamBiz.java的实现描述：系统参数 类实现描述 * @author zlh 2017-10-15 15:29:12
 */
@Component
public class SystemParamBiz {

    @Autowired
    private SystemParamDao systemParamDao;

    public SystemParamDTO getSystemParam(int id) {
        return systemParamDao.getSystemParam(id);
    }

    public int saveSystemParam(SystemParamDTO systemParamDTO) {
        return systemParamDao.saveSystemParam(systemParamDTO);
    }

    public int updateSystemParam(SystemParamDTO systemParamDTO) {
        return systemParamDao.updateSystemParam(systemParamDTO);
    }

    public int deleteSystemParam(int id) {
        return systemParamDao.deleteSystemParam(id);
    }

    public List<SystemParamDTO> getSystemParamList(PageBounds page) {
        return systemParamDao.getSystemParamList(page);
    }

    public SystemParamDTO getSystemParamByName(String name) {
        return systemParamDao.getSystemParamByName(name);
    }
}
