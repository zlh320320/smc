package com.zlh.web.utils;

import java.util.List;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.zlh.cms.CmsServiceLocator;
import com.zlh.cms.dto.ColumnDTO;
import com.zlh.cms.dto.SiteDTO;
import com.zlh.cms.service.ColumnService;
import com.zlh.cms.service.SiteService;

public class ContentUtils {

    public static ColumnDTO getColumnById(int columnId) {
        ColumnService columnService = CmsServiceLocator.getColumnService();
        return columnService.getColumn(columnId);
    }
    public static SiteDTO getSiteById(int siteId) {
        SiteService siteService = CmsServiceLocator.getSiteService();
        return siteService.getSite(siteId);
    }
    
    public static List<ColumnDTO> getColumnList(int siteId) {
        ColumnService columnService = CmsServiceLocator.getColumnService();
        return columnService.getColumnList(new PageBounds(),siteId);
    }
}
