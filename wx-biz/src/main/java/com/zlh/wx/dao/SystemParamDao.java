package com.zlh.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.wx.dto.SystemParamDTO;
 /**
 * * 类SystemParamDao.java的实现描述：//TODO 类实现描述 * @author zlh 2017-10-15 15:29:12
 */
public interface SystemParamDao {

		public List<SystemParamDTO> getSystemParamList(PageBounds page);
	
		public 	SystemParamDTO getSystemParam(int id);
		public 	SystemParamDTO getSystemParamByName(@Param("name")String name);
		
		public 	int saveSystemParam(SystemParamDTO systemParamDTO);
		
		public 	int updateSystemParam(SystemParamDTO systemParamDTO);
		
		public 	int deleteSystemParam(int id);
}
