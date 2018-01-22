package com.zlh.wx.dao;

import java.util.List;
import com.zlh.wx.dto.AuthDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface AuthDao {

		public List<AuthDTO> getAuthList(PageBounds page);
	
		public 	AuthDTO getAuth(int id);
		
		public 	int saveAuth(AuthDTO authDTO);
		
		public 	int updateAuth(AuthDTO authDTO);
		
		public 	int deleteAuth(int id);
}
