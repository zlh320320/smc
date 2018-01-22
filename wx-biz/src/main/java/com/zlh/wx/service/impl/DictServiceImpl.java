package com.zlh.wx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zlh.wx.biz.DictBiz;
import com.zlh.wx.biz.DictItemBiz;
import com.zlh.wx.service.DictService;
import com.zlh.wx.dto.DictDTO;
import com.zlh.wx.dto.DictItemDTO;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;

@Service
public class  DictServiceImpl implements DictService {

	@Autowired
    private DictBiz dictBiz;

	@Override
	public 	DictDTO getDict(int id){
	      return dictBiz.getDict(id);
	}
		
	@Override
	public 	int saveDict(DictDTO dictDTO){
		   return dictBiz.saveDict(dictDTO);
	}
	
	@Override
	public 	int updateDict(DictDTO dictDTO){
		  return dictBiz.updateDict(dictDTO);
	}
	
	@Override
	public 	int deleteDict(int id){
		  return dictBiz.deleteDict(id);
	}
	
	@Override
	public List<DictDTO> getDictList(PageBounds page){
		 return dictBiz.getDictList(page);
	}
	
	public DictDTO getDictByName(String dictName){
        return dictBiz.getDictByName(dictName);
    }
	

    @Autowired
    private DictItemBiz dictItemBiz;

    @Override
    public  DictItemDTO getDictItem(int id){
          return dictItemBiz.getDictItem(id);
    }
        
    @Override
    public  int saveDictItem(DictItemDTO dictItemDTO){
           return dictItemBiz.saveDictItem(dictItemDTO);
    }
    
    @Override
    public  int updateDictItem(DictItemDTO dictItemDTO){
          return dictItemBiz.updateDictItem(dictItemDTO);
    }
    
    @Override
    public  int deleteDictItem(int id){
          return dictItemBiz.deleteDictItem(id);
    }
    
    @Override
    public List<DictItemDTO> getDictItemList(int dictId){
         return dictItemBiz.getDictItemList(dictId);
    }
}
