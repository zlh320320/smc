package com.zlh.web.front.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.zlh.baby.BabyServiceLocator;
import com.zlh.baby.dto.SuggestionDTO;
import com.zlh.baby.service.SuggestionService;
import com.zlh.web.front.intercepter.NeedLogin;
import com.zlh.web.utils.UserUtils;

@Controller
@RequestMapping("/suggest")
public class SuggestionController {
    
    private static Log               logger          = LogFactory.getLog(IndexController.class);
    private static SuggestionService suggestionService=BabyServiceLocator.getSuggestionService();
    
    @RequestMapping(value = "/suggest.html")
    @NeedLogin
    public ModelAndView suggest() {
        logger.info("to suggest Method...");
        
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("suggestion", new SuggestionDTO());
        modelAndView.setViewName("/views/suggestion");
        return modelAndView;
    }
    
    @RequestMapping(value = "/addsuggest")
    @NeedLogin
    @ResponseBody
    public String addsuggest(SuggestionDTO suggestion,HttpServletRequest request) {
        logger.info("to addsuggest Method...");
        suggestion.setUserId(UserUtils.getCurrentUserId(request));
        suggestion.setCreateDate(new Date());
       int row= suggestionService.saveSuggestion(suggestion);
            
        return row>0?"success":"error";
    }
}
