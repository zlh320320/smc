package com.zlh.wx.service;

import com.zlh.wx.dto.UserAuthDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface UserAuthService {

		public List<UserAuthDTO> getUserAuthList(PageBounds page);
	
		public 	UserAuthDTO getUserAuth(int id);
		
		public 	int saveUserAuth(UserAuthDTO userAuthDTO);
		
		public 	int updateUserAuth(UserAuthDTO userAuthDTO);
		
		public 	int deleteUserAuth(int id);
}
