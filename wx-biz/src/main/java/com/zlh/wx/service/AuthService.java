package com.zlh.wx.service;

import com.zlh.wx.dto.AuthDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface AuthService {

		public List<AuthDTO> getAuthList(PageBounds page);
	
		public 	AuthDTO getAuth(int id);
		
		public 	int saveAuth(AuthDTO authDTO);
		
		public 	int updateAuth(AuthDTO authDTO);
		
		public 	int deleteAuth(int id);
}
