package com.zlh.web.common.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zlh.cache.common.util.DateUtils;
import com.zlh.cache.common.vo.FileVo;
import com.zlh.web.front.intercepter.NeedLogin;

/**
 * * 类FileUploadController.java的实现描述：文件上传 类实现描述 * @author z 2016-7-9 上午7:35:54
 */
@Controller
@RequestMapping("/file")
public class FileUploadController {

    @RequestMapping(value = "/uploadFile")
    @ResponseBody
    @NeedLogin
    public List<FileVo> uploadFile(@RequestParam(required=false) MultipartFile[] files, HttpServletRequest request, String prePath) {
        List<FileVo> fileVos = new ArrayList<FileVo>();
        if (files != null && files.length > 0) {
            for (MultipartFile file :files) {
                // 保存文件
                fileVos.add(saveFile(request, file, prePath));
            }
        }
        return fileVos;
    }

    private FileVo saveFile(HttpServletRequest request, MultipartFile file, String prePath) {
        FileVo fileVo = new FileVo();
        prePath+="/image/";
        String filePath = "upload/" + prePath ;
        String realPath=request.getSession().getServletContext().getRealPath("/");
        // 判断文件是否为空
        if (!file.isEmpty()) {
            try {
                String saveFile = realPath + filePath;
                File saveDir = new File(saveFile);
                if (!saveDir.exists()) {
                    saveDir.mkdirs();
                }
                String targetPath=realPath+filePath+DateUtils.getDateFormat("yyyyMMddhhmmssSSS")+".jpg";
                File targetFile=new File(targetPath);
                // 转存文件
                file.transferTo(targetFile);
                fileVo.setFileName(targetFile.getName());
                fileVo.setFilePath("/upload/" + prePath + targetFile.getName());
                fileVo.setFileSize(file.getSize() + "k");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return fileVo;
    }
}
