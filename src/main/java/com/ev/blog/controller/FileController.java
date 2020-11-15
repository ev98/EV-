package com.ev.blog.controller;

import com.ev.blog.util.AliyunOssUtil;
import com.ev.blog.vo.FileVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@Controller
@Slf4j
public class FileController {

    @Autowired
    AliyunOssUtil aliyunOssUtil;

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileVo testUpload(@RequestParam("editormd-image-file") MultipartFile file) {
        FileVo fileVo = new FileVo();
        String filename = file.getOriginalFilename();
        try {
            if (file != null) {
                if (!"".equals(filename.trim())) {
                    File newFile = new File(filename);
                    FileOutputStream outputStream = new FileOutputStream(newFile);
                    outputStream.write(file.getBytes());
                    outputStream.close();
                    file.transferTo(newFile);
                    String url = aliyunOssUtil.upLoad(newFile);
                    fileVo.setSuccess(1);
                    fileVo.setUrl(url);
                    fileVo.setMessage("上传成功");
                }
            }
        } catch (FileNotFoundException e) {
            fileVo.setSuccess(0);
            fileVo.setMessage("上传失败");
            e.printStackTrace();
        } catch (IOException e) {
            fileVo.setSuccess(0);
            fileVo.setMessage("上传失败");
            e.printStackTrace();
        }
        return fileVo;
    }

}
