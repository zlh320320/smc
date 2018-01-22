package com.zlh.wx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlh.wx.biz.SystemParamBiz;
import com.zlh.wx.service.SystemParamService;
import com.zlh.wx.dto.SystemParamDTO;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class SystemParamServiceImpl implements SystemParamService {

    @Autowired
    private SystemParamBiz systemParamBiz;

    @Override
    public SystemParamDTO getSystemParam(int id) {
        return systemParamBiz.getSystemParam(id);
    }

    @Override
    public int saveSystemParam(SystemParamDTO systemParamDTO) {
        return systemParamBiz.saveSystemParam(systemParamDTO);
    }

    @Override
    public int updateSystemParam(SystemParamDTO systemParamDTO) {
        return systemParamBiz.updateSystemParam(systemParamDTO);
    }

    @Override
    public int deleteSystemParam(int id) {
        return systemParamBiz.deleteSystemParam(id);
    }

    @Override
    public List<SystemParamDTO> getSystemParamList(PageBounds page) {
        return systemParamBiz.getSystemParamList(page);
    }

    public SystemParamDTO getSystemParamByName(String name) {
        return systemParamBiz.getSystemParamByName(name);
    }
}
