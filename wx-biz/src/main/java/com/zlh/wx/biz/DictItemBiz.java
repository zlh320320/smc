package com.zlh.wx.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.zlh.wx.dao.DictItemDao;
import com.zlh.wx.dto.DictItemDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import java.util.List;
 /**
 * * 类DictItemBiz.java的实现描述：数据字典项 类实现描述 * @author zlh 2016-11-17 22:12:48
 */
@Component
public class DictItemBiz {
	
	@Autowired
	private DictItemDao dictItemDao;
	
	public 	DictItemDTO getDictItem(int id){
	      return dictItemDao.getDictItem(id);
	}
		
	public 	int saveDictItem(DictItemDTO dictItemDTO){
		   return dictItemDao.saveDictItem(dictItemDTO);
	}
	
	public 	int updateDictItem(DictItemDTO dictItemDTO){
		  return dictItemDao.updateDictItem(dictItemDTO);
	}
	
	public 	int deleteDictItem(int id){
		  return dictItemDao.deleteDictItem(id);
	}
	
	public List<DictItemDTO> getDictItemList(int dictId){
		 return dictItemDao.getDictItemList(dictId);
	}
}
