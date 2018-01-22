package com.zlh.wx.service;

import com.zlh.wx.dto.GroupDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

public interface GroupService {

		public List<GroupDTO> getGroupList(PageBounds page);
	
		public 	GroupDTO getGroup(int id);
		
		public 	int saveGroup(GroupDTO groupDTO);
		
		public 	int updateGroup(GroupDTO groupDTO);
		
		public 	int deleteGroup(int id);
}
