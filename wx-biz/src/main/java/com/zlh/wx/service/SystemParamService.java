package com.zlh.wx.service;

import com.zlh.wx.dto.SystemParamDTO;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类SystemParamService.java的实现描述：系统参数实现接口 类实现描述 * @author zlh 2017-10-15 15:29:12
 */
public interface SystemParamService {

		public List<SystemParamDTO> getSystemParamList(PageBounds page);
	
		public 	SystemParamDTO getSystemParam(int id);
		
		public 	int saveSystemParam(SystemParamDTO systemParamDTO);
		
		public 	int updateSystemParam(SystemParamDTO systemParamDTO);
		
		public 	int deleteSystemParam(int id);
		
		 public SystemParamDTO getSystemParamByName(String name);
}
