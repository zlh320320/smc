package com.zlh.web.front.controller;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.zlh.baby.BabyServiceLocator;
import com.zlh.baby.dto.SearchTagDTO;
import com.zlh.baby.service.SearchTagService;
import com.zlh.baby.service.TopicReplyService;
import com.zlh.cms.CmsServiceLocator;
import com.zlh.cms.dto.ContentDTO;
import com.zlh.cms.service.ContentService;

@Controller
@RequestMapping("/search")
public class SearchController {

    private static TopicReplyService replyService     = BabyServiceLocator.getTopicReplyService();
    private static Log               logger           = LogFactory.getLog(SearchController.class);
    private static SearchTagService  searchTagService = BabyServiceLocator.getSearchTagService();
    private static ContentService contentService=CmsServiceLocator.getContentService();
    @RequestMapping(value = "/searchTopics/{tagId}.html")
    public ModelAndView searchTopics(String tagName, Integer type,@PathVariable Integer tagId, @RequestParam(defaultValue = "1") Integer pageNo,
                                     @RequestParam(defaultValue = "10") Integer pageSize) {
        logger.info("to searchTopics Method...");

        ModelAndView modelAndView = new ModelAndView();
        PageBounds page = new PageBounds(pageNo, pageSize);
        
        if(tagId!=null&&tagId>0){
            SearchTagDTO searchTag=searchTagService.getSearchTag(tagId);
            tagName=searchTag==null?"":searchTag.getTagName();
        }
        if (StringUtils.isNotBlank(tagName)) {
            List<ContentDTO> topicList = contentService.searchContents(page, tagName);
            PageList<ContentDTO> pageList = (PageList<ContentDTO>) topicList;
            modelAndView.addObject("topicList", topicList);
            modelAndView.addObject("page", pageList.getPaginator());
            SearchTagDTO searchTag=searchTagService.getSearchTagByName(tagName);
            if(searchTag==null){
                searchTag=new SearchTagDTO();
                searchTag.setTimes(1);
                searchTag.setTagName(tagName);
                searchTagService.saveSearchTag(searchTag);
            }else{
                searchTag.setTimes(searchTag.getTimes()+1);
                searchTagService.updateSearchTag(searchTag);
            }
            
        }
       
        modelAndView.addObject("tagName", tagName);
        modelAndView.addObject("type", type);
        modelAndView.setViewName("/views/searchList");
        return modelAndView;
    }

}
