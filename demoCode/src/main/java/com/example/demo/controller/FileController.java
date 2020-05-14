package com.example.demo.controller;

import com.example.demo.common.exception.DemoException;
import com.example.demo.common.utils.FileUtils;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * 描述：
 *
 * @author ZQQ
 * @date 2020/4/16 14:07
 */
@RestController
@RequestMapping("/file")
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    @GetMapping("/downFile")
    public void downloadExcel(HttpServletResponse res, HttpServletRequest req, String fileName) throws Exception {

        if (StringUtils.isEmpty(fileName)) {
            throw new DemoException("文件名为空");
        }
        try {
            ServletOutputStream out;
            res.setContentType("multipart/form-data");
            res.setCharacterEncoding("UTF-8");
            res.setContentType("text/html");
            String filePath = "/files/" + fileName;
            String userAgent = req.getHeader("User-Agent");
            if (userAgent.contains("MSIE") || userAgent.contains("Trident")) {
                fileName = URLEncoder.encode(fileName, "UTF-8");
            } else {
                fileName = new String((fileName).getBytes("UTF-8"), "ISO-8859-1");
            }
            filePath = URLDecoder.decode(filePath, "UTF-8");
            res.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
            InputStream inputStream = this.getClass().getResourceAsStream(filePath);
            out = res.getOutputStream();
            int b = 0;
            byte[] buffer = new byte[1024];
            while ((b = inputStream.read(buffer)) != -1) {
                out.write(buffer, 0, b);
            }
            inputStream.close();
            if (out != null) {
                out.flush();
                out.close();
            }
        } catch (Exception e) {
            logger.error("下载出错:{}", e);
            throw new DemoException("下载失败");
        }
    }
}