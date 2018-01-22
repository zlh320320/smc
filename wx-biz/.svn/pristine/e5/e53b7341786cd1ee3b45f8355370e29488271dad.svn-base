package com.zlh.wx.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.wx.dto.DictDTO;

/**
 * * 类DictDao.java的实现描述：//TODO 类实现描述 * @author zlh 2016-11-17 22:12:47
 */
public interface DictDao {

    public List<DictDTO> getDictList(PageBounds page);

    public DictDTO getDictByName(@Param("dictName")String dictName);

    public DictDTO getDict(int id);

    public int saveDict(DictDTO dictDTO);

    public int updateDict(DictDTO dictDTO);

    public int deleteDict(int id);
}
