package com.zlh.web.utils;

import java.util.List;

import com.zlh.wx.WechatServiceLocator;
import com.zlh.wx.dto.DictDTO;
import com.zlh.wx.dto.DictItemDTO;
import com.zlh.wx.service.DictService;

public class DictUtils {
    private final static DictService dictService = WechatServiceLocator.getDictService();

    public static List<DictItemDTO> getDictList(String dictName) {
        DictDTO dict= dictService.getDictByName(dictName);
        
        List<DictItemDTO> itemList=dictService.getDictItemList(dict.getId());
        return itemList;
    }
    
    public static DictItemDTO getDictLabel(String dictName,String dictValue){
        List<DictItemDTO> dictItems= getDictList(dictName);
        for(DictItemDTO dictItem:dictItems){
            if(dictItem.getItemValue().equals(dictValue)){
                return dictItem;
            }
        }
        return null;
    }
}
