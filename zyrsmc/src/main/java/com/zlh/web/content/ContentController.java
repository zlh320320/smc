package com.zlh.web.content;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.zlh.cms.CmsServiceLocator;
import com.zlh.cms.dto.ColumnDTO;
import com.zlh.cms.dto.ContentDTO;
import com.zlh.cms.dto.SiteDTO;
import com.zlh.cms.service.ColumnService;
import com.zlh.cms.service.ContentService;
import com.zlh.cms.service.SiteService;
import com.zlh.web.front.controller.TopicController;
import com.zlh.web.front.intercepter.NeedLogin;

@Controller
@RequestMapping("/content")
public class ContentController {

    private static ContentService contentService = CmsServiceLocator.getContentService();
    private static ColumnService  columnService  = CmsServiceLocator.getColumnService();
    private static SiteService    siteService    = CmsServiceLocator.getSiteService();
    private static Log            logger         = LogFactory.getLog(TopicController.class);

    @RequestMapping(value = "/contentManage")
    @NeedLogin
    public ModelAndView contentManage() {
        logger.info("to contentManage Method...");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/content/contentManage");
        return modelAndView;
    }

    @RequestMapping(value = "/getContentList")
    @NeedLogin
    public ModelAndView getContentList(@RequestParam(defaultValue = "1") Integer pageNo,
                                       @RequestParam(defaultValue = "10") Integer pageSize, Integer columnId) {
        logger.info("to getContentList Method...");
        ModelAndView modelAndView = new ModelAndView();
        PageBounds page = new PageBounds(pageNo, pageSize);
        List<ContentDTO> contentList = contentService.getContentList(page, columnId);
        PageList<ContentDTO> pageList = (PageList<ContentDTO>) contentList;
        modelAndView.addObject("contentList", contentList);
        modelAndView.addObject("columnId", columnId);
        modelAndView.addObject("page", pageList.getPaginator());
        modelAndView.setViewName("/content/contentList");
        return modelAndView;
    }

    @RequestMapping(value = "/getColumnList")
    @NeedLogin
    public ModelAndView getColumnList(@RequestParam(defaultValue = "1") Integer pageNo,
                                      @RequestParam(defaultValue = "10") Integer pageSize) {
        logger.info("to getColumnList Method...");
        int siteId=1;
        ModelAndView modelAndView = new ModelAndView();
        List<ColumnDTO> columnList = columnService.getColumnList(new PageBounds(),siteId);
        modelAndView.addObject("columnList", columnList);
        modelAndView.setViewName("/content/columnList");
        return modelAndView;
    }

    @RequestMapping(value = "/getContent")
    @NeedLogin
    public ModelAndView getContent(int id) {
        logger.info("to getContent Method...");
        ModelAndView modelAndView = new ModelAndView();
        int siteId=1;
        List<ColumnDTO> columnList = columnService.getColumnList(new PageBounds(),siteId);
        modelAndView.addObject("columnList", columnList);
        ContentDTO content = contentService.getContent(id);
        modelAndView.addObject("content", content == null ? new ContentDTO() : content);
        modelAndView.setViewName("/content/editContent");
        return modelAndView;
    }

    @RequestMapping(value = "/saveContent")
    @ResponseBody
    @NeedLogin
    public String saveContent(ContentDTO content, HttpServletRequest request) {
        logger.info("to saveContent Method...");
        int row = 0;
        if (content.getId() < 1) {
            content.setCreateDate(new Date());
            row = contentService.saveContent(content);
        } else {
            row = contentService.updateContent(content);
        }
        return row > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/getColumn")
    @NeedLogin
    public ModelAndView getColumn(int id, int pid) {
        logger.info("to getColumn Method...");
        ModelAndView modelAndView = new ModelAndView();
        ColumnDTO column = columnService.getColumn(id);
        ColumnDTO pcolumn = columnService.getColumn(pid);
        modelAndView.addObject("column", column == null ? new ColumnDTO() : column);
        modelAndView.addObject("pcolumn", pcolumn == null ? new ColumnDTO() : pcolumn);
        modelAndView.setViewName("/content/editColumn");
        return modelAndView;
    }

    @RequestMapping(value = "/saveColumn")
    @ResponseBody
    @NeedLogin
    public String saveColumn(ColumnDTO column, HttpServletRequest request) {
        logger.info("to saveColumn Method...");
        int row = 0;
        if (column.getId() < 1) {
            column.setCreateDate(new Date());
            column.setSiteId(1);
            row = columnService.saveColumn(column);
        } else {
            row = columnService.updateColumn(column);
        }
        return row > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/delColumn")
    @ResponseBody
    @NeedLogin
    public String delColumn(int id) {
        logger.info("to saveColumn Method...");
        int row = columnService.deleteColumn(id);
        return row > 0 ? "success" : "error";
    }
    
    @RequestMapping(value = "/delContent")
    @ResponseBody
    @NeedLogin
    public String delContent(int id) {
        logger.info("to delContent Method...");
        int row = contentService.deleteContent(id);
        return row > 0 ? "success" : "error";
    }

    @RequestMapping(value = "/columnTree")
    @ResponseBody
    @NeedLogin
    public List<Map<String, Object>> columnTree(HttpServletRequest request) {
        logger.info("to columnTree Method...");
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        int siteId=1;
        List<ColumnDTO> columnList = columnService.getColumnList(new PageBounds(),siteId);

        Map<String, Object> map1 = new HashMap<String, Object>();
        map1.put("id", 0);
        map1.put("pId", "root");
        map1.put("name", "根目录");
        map1.put("open", true);
        list.add(map1);
        for (ColumnDTO column : columnList) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", column.getId());
            map.put("pId", column.getParentId() == null ? 0 : column.getParentId());
            map.put("name", column.getColumnName());
            map.put("open", true);
            list.add(map);
        }
        return list;
    }

    @RequestMapping(value = "/getSite")
    @NeedLogin
    public ModelAndView getSite(Integer id) {
        if (id == null) id = 1;
        logger.info("to getSite Method...");
        ModelAndView modelAndView = new ModelAndView();
        SiteDTO site = siteService.getSite(id);
        modelAndView.addObject("site", site);
        modelAndView.setViewName("/content/editSite");
        return modelAndView;
    }
    
    @RequestMapping(value = "/saveSite")
    @ResponseBody
    @NeedLogin
    public String saveSite(SiteDTO site, HttpServletRequest request) {
        logger.info("to saveSite Method...");
        int row = 0;
//        if (site.getId() < 1) {
//            site.setCreateDate(new Date());
//            row = contentService.saveContent(site);
//        } else {
            row = siteService.updateSite(site);
       // }
        return row > 0 ? "success" : "error";
    }
}
