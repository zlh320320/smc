/*package com.zlh.web.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.zlh.cache.common.util.DateUtils;

public class ReptileUtil {

    private static String filePath="G:/test.txt";
    private static String fileDir="G:/test";
    private static File file=new File(filePath);
    private static File dir=new File(fileDir);
    private static boolean isAppend=true;
    private static int hign=3;
    private static int piccount=0;
    
    public static void parseUrl(String  url,String domain,int high) throws Exception{
        
        if(high>hign)
            return;
        
        Document doc=null;
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            doc = Jsoup.connect(url).get();
            throw e;	
        }
        Elements links = doc.select("a");
        Elements media = doc.select("img");
       // Elements imports = doc.select("link[href]");
            for (Element src : media) {
                if (src.tagName().equals("img"))
                   // writeToFile(src.attr("src"));
                try {
                    getPictures(src.attr("src"));
                } catch (Exception e) {
                    try {
                        getPictures(domain+src.attr("src"));
                    } catch (Exception e1) {
                        	
                    }
                }
            }
        for(Element link : links){
            writeToFile(link.attr("href"));
            try {
                parseUrl(link.attr("href"),domain,++high);
            } catch (Exception e) {
                parseUrl(domain+link.attr("href"),domain,++high);
                System.out.println("该链接超时:"+link.attr("href")+"----"+e.getMessage());
            }
        }
        
        for(Element impor : imports){
            writeToFile(impor.attr("href"));
        }
    }
    
    private static void writeToFile(String data) throws Exception{
        if(file==null){
         file=new File(filePath);
        }
        if(!file.exists())
            file.createNewFile();
        FileUtils.writeStringToFile(file, data+"\r\n", isAppend);
    }
    
    private static void getPictures(String picurl) throws Exception{
        
        if(!picurl.endsWith(".jpg")&&!picurl.toLowerCase().endsWith(".png")&&!picurl.toLowerCase().endsWith(".gif"))
            return;
        
        if(dir==null)
            dir=new File(fileDir);
        if(!dir.exists())
            dir.mkdirs();
        try {
            Map<String,String> cookie=new HashMap<String,String>();
            Response resultImageResponse = Jsoup.connect(picurl).cookies(cookie).ignoreContentType(true).execute();
            String filePath=fileDir+picurl.substring(picurl.lastIndexOf("/"));
            filePath=fileDir+"/"+DateUtils.getDateFormat("yyyyMMddHHmmssSSS")+".jpg";
            File file=new File(filePath);
         double length=resultImageResponse.bodyAsBytes().length/1000;
         System.out.println("输出图片:"+filePath+"----"+piccount+++"----length="+length+"kb");
         if(length>30){
             FileOutputStream out = (new FileOutputStream(file));
             out.write(resultImageResponse.bodyAsBytes());           
             out.close();
         }
        } catch (Exception e) {
            System.out.println("获取图片出错:"+picurl+"---------"+e.getMessage());
            throw  e;
        }
    }
    
    public static void main(String[] args) {
        String url="";
        String domain="/";
        try {
            ReptileUtil.parseUrl(url,domain,0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
*/