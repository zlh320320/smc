package com.zlh.cms;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.zlh.cms.service.ColumnService;
import com.zlh.cms.service.ContentAttrService;
import com.zlh.cms.service.ContentFileService;
import com.zlh.cms.service.ContentService;
import com.zlh.cms.service.ModuleItemService;
import com.zlh.cms.service.ModuleService;
import com.zlh.cms.service.SiteLogoService;
import com.zlh.cms.service.SiteMarkService;
import com.zlh.cms.service.SiteService;
import com.zlh.cms.service.impl.ColumnServiceImpl;
import com.zlh.cms.service.impl.ContentAttrServiceImpl;
import com.zlh.cms.service.impl.ContentFileServiceImpl;
import com.zlh.cms.service.impl.ContentServiceImpl;
import com.zlh.cms.service.impl.ModuleItemServiceImpl;
import com.zlh.cms.service.impl.ModuleServiceImpl;
import com.zlh.cms.service.impl.SiteLogoServiceImpl;
import com.zlh.cms.service.impl.SiteMarkServiceImpl;
import com.zlh.cms.service.impl.SiteServiceImpl;

/**
 * @author z
 */
public class CmsServiceLocator {

    private static Log                logger = LogFactory.getLog(CmsServiceLocator.class);
    private static ApplicationContext applicationContext;

    static {
        synchronized (CmsServiceLocator.class) {
            try {
                applicationContext = new ClassPathXmlApplicationContext(
                                                                        new String[] { "classpath*:conf/cms-service-locator.xml" });

            } catch (Exception e) {
                logger.error("Init RelateServiceLocator services error!", e);
                applicationContext = null;
            }
        }
    }

    public static ContentService getContentService() {
        return (ContentService) applicationContext.getBean(ContentServiceImpl.class);
    }

    public static ColumnService getColumnService() {
        return (ColumnService) applicationContext.getBean(ColumnServiceImpl.class);
    }

    public static ContentAttrService getContentAttrService() {
        return (ContentAttrService) applicationContext.getBean(ContentAttrServiceImpl.class);
    }

    public static ContentFileService getContentFileService() {
        return (ContentFileService) applicationContext.getBean(ContentFileServiceImpl.class);
    }

    public static ModuleService getModuleService() {
        return (ModuleService) applicationContext.getBean(ModuleServiceImpl.class);
    }

    public static ModuleItemService getModuleItemService() {
        return (ModuleItemService) applicationContext.getBean(ModuleItemServiceImpl.class);
    }

    public static SiteLogoService getSiteLogoService() {
        return (SiteLogoService) applicationContext.getBean(SiteLogoServiceImpl.class);
    }

    public static SiteMarkService getSiteMarkService() {
        return (SiteMarkService) applicationContext.getBean(SiteMarkServiceImpl.class);
    }

    public static SiteService getSiteService() {
        return (SiteService) applicationContext.getBean(SiteServiceImpl.class);
    }
}
