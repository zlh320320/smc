package com.zlh.wx.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zlh.wx.biz.GroupBiz;
import com.zlh.wx.service.GroupService;
import com.zlh.wx.dto.GroupDTO;
import java.util.List;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  GroupServiceImpl implements GroupService {

	@Autowired
    private GroupBiz groupBiz;

	@Override
	public 	GroupDTO getGroup(int id){
	      return groupBiz.getGroup(id);
	}
		
	@Override
	public 	int saveGroup(GroupDTO groupDTO){
		   return groupBiz.saveGroup(groupDTO);
	}
	
	@Override
	public 	int updateGroup(GroupDTO groupDTO){
		  return groupBiz.updateGroup(groupDTO);
	}
	
	@Override
	public 	int deleteGroup(int id){
		  return groupBiz.deleteGroup(id);
	}
	
	@Override
	public List<GroupDTO> getGroupList(PageBounds page){
		 return groupBiz.getGroupList(page);
	}
}
