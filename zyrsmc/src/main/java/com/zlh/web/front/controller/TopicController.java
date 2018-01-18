package com.zlh.web.front.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.miemiedev.mybatis.paginator.domain.Order;
import com.github.miemiedev.mybatis.paginator.domain.PageBounds;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.zlh.baby.BabyServiceLocator;
import com.zlh.baby.dto.SearchTagDTO;
import com.zlh.baby.dto.TopicDTO;
import com.zlh.baby.dto.TopicReplyDTO;
import com.zlh.baby.service.SearchTagService;
import com.zlh.baby.service.TopicReplyService;
import com.zlh.baby.service.TopicService;
import com.zlh.baby.vo.TopUserTopic;
import com.zlh.cms.CmsServiceLocator;
import com.zlh.cms.dto.ContentDTO;
import com.zlh.cms.service.ContentService;
import com.zlh.web.front.intercepter.NeedLogin;
import com.zlh.web.utils.UserUtils;

@Controller
@RequestMapping("/topic")
public class TopicController {

    private static TopicService      topicService = BabyServiceLocator.getTopicService();
    private static TopicReplyService replyService = BabyServiceLocator.getTopicReplyService();
    private static Log               logger       = LogFactory.getLog(TopicController.class);
    private static SearchTagService  searchTagService = BabyServiceLocator.getSearchTagService();
    private static ContentService contentService=CmsServiceLocator.getContentService();

    @RequestMapping(value = "/getTopicList")
    @NeedLogin
    public ModelAndView getTopicList(Integer userId,Integer columnId,@RequestParam(defaultValue = "1")
    Integer pageNo, @RequestParam(defaultValue = "10")
    Integer pageSize) {
        logger.info("to getTopicList Method...");

        ModelAndView modelAndView = new ModelAndView();
        PageBounds page = new PageBounds(pageNo, pageSize);
        List<ContentDTO> contentList = contentService.getContentList(page, columnId);
        PageList<ContentDTO> pageList = (PageList<ContentDTO>) contentList;
        modelAndView.addObject("contentList", contentList);
        modelAndView.addObject("page", pageList.getPaginator());
        modelAndView.setViewName("/content/topicList");
        return modelAndView;
    }
    
    @RequestMapping(value = "/list/{columnId}.html")
    public ModelAndView getTopicList(@PathVariable int columnId,@RequestParam(defaultValue = "1")
    Integer pageNo, @RequestParam(defaultValue = "10")
    Integer pageSize) {
        logger.info("to getTopicList Method...");

        ModelAndView modelAndView = new ModelAndView();
        PageBounds page = new PageBounds(pageNo, pageSize);
        List<ContentDTO> contentList = contentService.getContentList(page, columnId);
        PageList<ContentDTO> pageList=(PageList<ContentDTO>)contentList;
        
        List<SearchTagDTO> searchTags=searchTagService.getSearchTagList(new PageBounds(30));
        modelAndView.addObject("searchTags", searchTags);
        
        List<TopUserTopic> topUsers=topicService.topUserTopic(new PageBounds(3),columnId);
        modelAndView.addObject("topUsers", topUsers);
        
        modelAndView.addObject("columnId", columnId);
        modelAndView.addObject("contentList", contentList);
        modelAndView.addObject("page", pageList.getPaginator());
        modelAndView.setViewName("/views/topicByTypes");
        return modelAndView;
    }
    
    @RequestMapping(value = "/deleteTopic")
    @NeedLogin
    public String deleteTopic(int id) {
        logger.info("to deleteTopic Method...");
        int row  = contentService.deleteContent(id);
        return row>0?"success":"error";
    }
    @RequestMapping(value = "/getTopic/{id}.html")
    @NeedLogin
    public ModelAndView getTopic(@PathVariable int id) {
        logger.info("to getTopic Method...");

        ModelAndView modelAndView = new ModelAndView();
        ContentDTO content = contentService.getContent(id);
        modelAndView.addObject("topic", content);
        modelAndView.setViewName("/views/topic_add");
        return modelAndView;
    }
    @RequestMapping(value = "/editTopic")
    @NeedLogin
    public ModelAndView editTopic(int id) {
        logger.info("to editTopic Method...");
        
        ModelAndView modelAndView = new ModelAndView();
        TopicDTO topic = topicService.getTopic(id);
        if(topic==null){
            topic=new TopicDTO();
        }
        modelAndView.addObject("topic", topic);
        modelAndView.setViewName("/content/editTopic");
        return modelAndView;
    }
    
    @RequestMapping(value = "/detail/{id}.html")
    public ModelAndView detail(@PathVariable int id) {
        logger.info("to detail Method...");

        ModelAndView modelAndView = new ModelAndView();
        ContentDTO topic = contentService.getContent(id);
        modelAndView.addObject("topic", topic);
        
        List<ContentDTO> hotList = contentService.getContentList(new PageBounds(1,8,Order.formString("click_num.desc")), null);
        List<ContentDTO> relateList = contentService.getContentList(new PageBounds(1,8), topic.getColumnId());
        modelAndView.addObject("hotList", hotList);
        modelAndView.addObject("relateList", relateList);
        modelAndView.addObject("topic", topic);
        modelAndView.setViewName("/views/showTopic");
        return modelAndView;
    }
    
    @RequestMapping(value = "/saveTopic")
    @ResponseBody
    @NeedLogin
    public String saveTopic(ContentDTO topic,HttpServletRequest request) {
        logger.info("to saveTopic Method...");
        topic.setCreateDate(new Date());
       /* UserDTO user=UserUtils.getCurrentUser(request);   //暂时去除发稿限制
        if(user.getLevel()>0){
            topic.setStatus(0);
        }else{
            topic.setStatus(1);
        }*/
        topic.setEditor(UserUtils.getCurrentUser(request).getUsername());
        int row = contentService.saveContent(topic);
        return row>0?"success":"error";
    }
    
    @RequestMapping(value = "/updateTopic")
    @ResponseBody
    @NeedLogin
    public String updateTopic(ContentDTO topic,HttpServletRequest request) {
        logger.info("to updateTopic Method..."); 
        int row=0;
        if(topic.getId()<1){
         topic.setCreateDate(new Date());
         topic.setEditor(UserUtils.getCurrentUser(request).getUsername());
         row = contentService.saveContent(topic);
        }else{
            topic.setUpdateDate(new Date());
          row=  contentService.updateContent(topic);
        }
        return row>0?"success":"error";
    }
    
    @RequestMapping(value = "/hotTopics.html")
    public ModelAndView hotTopics(Integer columnId,@RequestParam(defaultValue = "1")
    Integer pageNo, @RequestParam(defaultValue = "10")
    Integer pageSize) {
        logger.info("to hotTopics Method...");

        ModelAndView modelAndView = new ModelAndView();
        PageBounds page = new PageBounds(pageNo, pageSize);
        List<ContentDTO> topicList = contentService.getContentList(new PageBounds(pageNo,pageSize,Order.formString("click_num.desc")),columnId);
        PageList<ContentDTO> pageList=(PageList<ContentDTO>)topicList;
        
       
        modelAndView.addObject("topicList", topicList);
        modelAndView.addObject("page", pageList.getPaginator());
        modelAndView.setViewName("/views/hotTopics");
        return modelAndView;
    }
    @RequestMapping(value = "/topicByTypes/{columnId}.html")
    public ModelAndView topicByTypes(@PathVariable Integer columnId,@RequestParam(defaultValue = "1")
    Integer pageNo, @RequestParam(defaultValue = "10")
    Integer pageSize) {
        logger.info("to topicByTypes Method...");
        
        ModelAndView modelAndView = new ModelAndView();
        PageBounds page = new PageBounds(pageNo, pageSize);
        List<ContentDTO> contentList = contentService.getContentList(page, columnId);
        PageList<ContentDTO> pageList=(PageList<ContentDTO>)contentList;
        
        List<SearchTagDTO> searchTags=searchTagService.getSearchTagList(new PageBounds(30));
        modelAndView.addObject("searchTags", searchTags);
        
        List<TopUserTopic> topUsers=topicService.topUserTopic(new PageBounds(3),columnId);
        modelAndView.addObject("topUsers", topUsers);
        
        modelAndView.addObject("columnId", columnId);
        modelAndView.addObject("contentList", contentList);
        modelAndView.addObject("page", pageList.getPaginator());
        modelAndView.setViewName("/views/topicByTypes");
        if(columnId==4){
            modelAndView.setViewName("/views/topicByTypes4");
        }
        return modelAndView;
    }
    
    @RequestMapping(value = "/hotQuestions.html")
    public ModelAndView hotQuestions(@RequestParam(defaultValue = "1")
    Integer pageNo, @RequestParam(defaultValue = "10")
    Integer pageSize) {
        logger.info("to hotQuestions Method...");

        ModelAndView modelAndView = new ModelAndView();
        PageBounds page = new PageBounds(pageNo, pageSize);
        List<TopicDTO> topicList = topicService.getTopicList(page, 3,0);
        
        List<TopUserTopic> topUsers=topicService.topUserTopic(new PageBounds(3),3);
        modelAndView.addObject("topUsers", topUsers);
        
        List<TopUserTopic> topReplyUsers=replyService.topUserReply(new PageBounds(3));
        modelAndView.addObject("topReplyUsers", topReplyUsers);
        
        modelAndView.addObject("topicList", topicList);
        modelAndView.setViewName("/views/hotQuestions");
        return modelAndView;
    }
    
    @RequestMapping(value = "/addQuestions.html")
    @NeedLogin
    public ModelAndView addQuestions() {
        logger.info("to addQuestions Method...");

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("/views/question_add");
        return modelAndView;
    }
    
    @RequestMapping(value = "/saveQuestion")
    @ResponseBody
    @NeedLogin
    public String saveQuestion(TopicDTO topic,HttpServletRequest request) {
        logger.info("to saveTopic Method...");
        topic.setCreateDate(new Date());
        topic.setStatus(0);
        topic.setCreator(UserUtils.getCurrentUserId(request));
        int row = topicService.saveTopic(topic);
        return row>0?"success":"error";
    }
    
    @RequestMapping(value = "/saveReply")
    @ResponseBody
    @NeedLogin
    public String saveReply(TopicReplyDTO reply,HttpServletRequest request) {
        logger.info("to saveTopic Method...");
        reply.setUserId(UserUtils.getCurrentUserId(request));
        reply.setCreateDate(new Date());
        reply.setParentId(0);
        int row = replyService.saveTopicReply(reply);
        return row>0?"success":"error";
    }
    
    @RequestMapping(value = "/showQuestion/{id}.html")
    public ModelAndView showQuestion(@PathVariable int id) throws Exception {
        logger.info("to showQuestion Method...");
        TopicDTO topic = topicService.getTopic(id);
        List<TopicReplyDTO> replys=replyService.getTopicReplyList(new PageBounds(), id);
        if(topic.getType()!=3)
            topic=null;
        ModelAndView modelAndView = new ModelAndView();
        if(topic==null)
            throw new Exception("找不到该提问.");
        
        List<TopUserTopic> topUsers=topicService.topUserTopic(new PageBounds(3),3);
        modelAndView.addObject("topUsers", topUsers);
        
        List<TopUserTopic> topReplyUsers=replyService.topUserReply(new PageBounds(3));
        modelAndView.addObject("topReplyUsers", topReplyUsers);
        
        modelAndView.addObject("topic", topic);
        modelAndView.addObject("replys", replys);
        modelAndView.setViewName("/views/showquestion");
        return modelAndView;
    }
    
    @RequestMapping(value = "/updateClick")
    @ResponseBody
    public String updateClick(int topicId) {
        logger.info("to saveTopic Method...");
        ContentDTO topic=contentService.getContent(topicId);
        topic.setClickNum(topic.getClickNum()+1);
        int row = contentService.updateContent(topic);
        return row>0?"success":"error";
    }
    
    @RequestMapping(value = "/updateTopicClick")
    @ResponseBody
    public String updateTopicClick(int topicId) {
        logger.info("to saveTopic Method...");
        TopicDTO topic=topicService.getTopic(topicId);
        topic.setClickNum(topic.getClickNum()+1);
        int row = topicService.updateTopic(topic);
        return row>0?"success":"error";
    }
}
