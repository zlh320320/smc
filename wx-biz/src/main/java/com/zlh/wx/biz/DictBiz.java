package com.zlh.wx.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.zlh.wx.dao.DictDao;
import com.zlh.wx.dto.DictDTO;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

import java.util.List;
 /**
 * * 类DictBiz.java的实现描述：数据字典 类实现描述 * @author zlh 2016-11-17 22:12:47
 */
@Component
public class DictBiz {
	
	@Autowired
	private DictDao dictDao;
	
	public 	DictDTO getDict(int id){
	      return dictDao.getDict(id);
	}
		
	public 	int saveDict(DictDTO dictDTO){
		   return dictDao.saveDict(dictDTO);
	}
	
	public 	int updateDict(DictDTO dictDTO){
		  return dictDao.updateDict(dictDTO);
	}
	
	public 	int deleteDict(int id){
		  return dictDao.deleteDict(id);
	}
	
	public List<DictDTO> getDictList(PageBounds page){
		 return dictDao.getDictList(page);
	}
	
	public DictDTO getDictByName(String dictName){
	    return dictDao.getDictByName(dictName);
	}
}
