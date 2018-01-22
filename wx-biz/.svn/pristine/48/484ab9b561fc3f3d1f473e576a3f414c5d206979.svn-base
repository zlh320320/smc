package com.zlh.wx.service;

import com.zlh.wx.dto.DictDTO;
import com.zlh.wx.dto.DictItemDTO;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
 /**
 * * 类DictService.java的实现描述：数据字典实现接口 类实现描述 * @author zlh 2016-11-17 22:12:47
 */
public interface DictService {

		public List<DictDTO> getDictList(PageBounds page);
	
		public 	DictDTO getDict(int id);
		
		public 	int saveDict(DictDTO dictDTO);
		
		public 	int updateDict(DictDTO dictDTO);
		
		public 	int deleteDict(int id);
		
		public DictDTO getDictByName(String dictName);
		

        public List<DictItemDTO> getDictItemList(int dictId);
    
        public  DictItemDTO getDictItem(int id);
        
        public  int saveDictItem(DictItemDTO dictItemDTO);
        
        public  int updateDictItem(DictItemDTO dictItemDTO);
        
        public  int deleteDictItem(int id);
}
