package com.zlh.wx.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.wx.dao.GroupDao;
import com.zlh.wx.dto.GroupDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;

@Component
public class GroupBiz {
	
	@Autowired
	private GroupDao groupDao;
	
	public 	GroupDTO getGroup(int id){
	      return groupDao.getGroup(id);
	}
		
	public 	int saveGroup(GroupDTO groupDTO){
		   return groupDao.saveGroup(groupDTO);
	}
	
	public 	int updateGroup(GroupDTO groupDTO){
		  return groupDao.updateGroup(groupDTO);
	}
	
	public 	int deleteGroup(int id){
		  return groupDao.deleteGroup(id);
	}
	
	public List<GroupDTO> getGroupList(PageBounds page){
		 return groupDao.getGroupList(page);
	}
}
