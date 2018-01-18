package com.zlh.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.cms.dto.ContentDTO;

/**
 * * 类ContentDao.java的实现描述：//TODO 类实现描述 * @author zlh 2016-07-22 21:34:38
 */
public interface ContentDao {

    public List<ContentDTO> getContentList(PageBounds page,@Param("columnId")Integer columnId);

    public ContentDTO getContent(int id);

    public int saveContent(ContentDTO contentDTO);

    public int updateContent(ContentDTO contentDTO);

    public int delContent(int id);
    
    public List<ContentDTO> searchContents(PageBounds page,@Param("title")String title);
}
