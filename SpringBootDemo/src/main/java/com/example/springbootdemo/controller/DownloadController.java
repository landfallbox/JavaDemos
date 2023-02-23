package com.example.springbootdemo.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import org.springframework.stereotype.Controller;

@Controller
public class DownloadController {
    @RequestMapping("/download")
    public String fileDownload(HttpServletResponse response) throws Exception {
        String filename = "5.jpg";

        // 这里将文件放在 resources 目录的 static/upload 子目录下，通过 ClassPathResource 的方式先拿到 application.properties
        // 文件的路径。然后，取父目录得到 resources 目录。

        // 先通过 ClassPathResource 获取 application.properties 的路径
        Resource applicationProperties = new ClassPathResource("application.properties");

        // 然后通过取其父目录获得resources目录，设置上传文件的目录
        String uploadFileSavePath = applicationProperties.getFile().getParentFile().getAbsolutePath() + File.separator
                + "static/upload";
        File downloadFile = new File(uploadFileSavePath + File.separator + filename);

        // System.out.println("下载文件的完整路径：" + downloadFile.getAbsolutePath());

        if (!downloadFile.exists()) {
            // System.out.println("要下载的文件不存在：" + downloadFile.getAbsolutePath());
            return "File not exists, download fail!";
        }
        else {
            // 第一步：设置响应类型
            response.setContentType("application/force-download");  // 应用程序强制下载

            // 第二读取文件
            InputStream in = new FileInputStream(downloadFile);

            // 设置响应头，对文件进行url编码
            filename = URLEncoder.encode(filename, StandardCharsets.UTF_8);
            response.setHeader("Content-Disposition", "attachment;filename=" + filename);
            response.setContentLength(in.available());

            // 第三步：读文件写入http响应
            OutputStream out = response.getOutputStream();
            byte[] b = new byte[1024];
            int len = 0;
            while ((len = in.read(b)) != -1) {
                out.write(b, 0, len);
            }

            out.flush();
            out.close();
            in.close();

            return "Download success!";
        }
    }
}
