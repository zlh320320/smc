package com.zlh.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.zlh.wx.dto.DictItemDTO;
 /**
 * * 类DictItemDao.java的实现描述：//TODO 类实现描述 * @author zlh 2016-11-17 22:12:48
 */
public interface DictItemDao {

		public List<DictItemDTO> getDictItemList(@Param("dictId")int dictId);
	
		public 	DictItemDTO getDictItem(int id);
		
		public 	int saveDictItem(DictItemDTO dictItemDTO);
		
		public 	int updateDictItem(DictItemDTO dictItemDTO);
		
		public 	int deleteDictItem(int id);
}
