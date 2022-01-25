package com.gruntik.foodmatcher.utils;

import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Service
public class FileUtils {

    @Autowired
    private HttpServletRequest request;

    @Value("${project.resource-dir}")
    private String realPathUpload;


    public File multiPartFileToFile(MultipartFile multipartFile) {

        String orgName = multipartFile.getOriginalFilename();
        String filePath = realPathUpload + "/upload/" + orgName;
        File file = null;
        try {
            file = new File(filePath);
            multipartFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return file;
    }
}
