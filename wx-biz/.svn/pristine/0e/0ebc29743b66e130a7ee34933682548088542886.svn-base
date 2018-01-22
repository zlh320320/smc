package com.zlh.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.wx.dto.LoginLogDTO;
 /**
 * * 类LoginLogDao.java的实现描述：//TODO 类实现描述 * @author zlh 2016-11-27 16:52:14
 */
public interface LoginLogDao {

		public List<LoginLogDTO> getLoginLogList(PageBounds page,@Param("type") Integer type);
	
		public 	LoginLogDTO getLoginLog(int id);
		
		public 	int saveLoginLog(LoginLogDTO loginLogDTO);
		
		public 	int updateLoginLog(LoginLogDTO loginLogDTO);
		
		public 	int deleteLoginLog(int id);
}
