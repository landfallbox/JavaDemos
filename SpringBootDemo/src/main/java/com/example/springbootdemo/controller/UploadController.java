package com.example.springbootdemo.controller;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

@RestController
public class UploadController {

    /**
     * 文件存储的路径
     */
    private static final String targetFilePath = "D:/LocalRepositories/Java/SpringBootDemoUploads/";

    @PostMapping("/upload")
    public String uploadSingleFile(@RequestParam("file") MultipartFile uploadFile) {
        try {
            // 本地测试，先删除路径
            FileUtils.deleteDirectory(new File(targetFilePath));

            if (uploadFile == null || StringUtils.isEmpty(uploadFile.getOriginalFilename())) {
                System.out.println("no file available");

                return "uploadFailure";
            }

            System.out.println(uploadFile.getOriginalFilename());

            saveFile(uploadFile.getBytes(), targetFilePath, uploadFile.getOriginalFilename());
        }
        catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));

            return "uploadFailure";
        }

        return "uploadSuccess";
    }

    /**
     * 多文件上传
     *
     */

    @PostMapping("/uploadFiles")
    public String multiFileUpload(@RequestParam("file") MultipartFile[] uploadFiles) {
        try {
            // 本地测试，先删除路径
            FileUtils.deleteDirectory(new File(targetFilePath));

            if (uploadFiles != null && uploadFiles.length > 0) {
                for (MultipartFile uploadFile : uploadFiles) {
                    // check file
                    if (StringUtils.isEmpty((uploadFile.getOriginalFilename()))) {
                        continue;
                    }

                    System.out.println(uploadFile.getOriginalFilename());

                    saveFile(uploadFile.getBytes(), targetFilePath, uploadFile.getOriginalFilename());
                }
            }
            else {
                System.out.println("no file available");

                return "uploadFailure";
            }
        }
        catch (Exception e) {
            System.out.println(Arrays.toString(e.getStackTrace()));

            return "uploadFailure";
        }

        return "uploadSuccess";
    }

    /*
     * 保存文件
     */
    private void saveFile(byte[] file, String filePath, String fileName) throws Exception {
        FileUtils.forceMkdir(new File(filePath));

        File targetFile = new File(filePath + fileName);

        FileOutputStream out = new FileOutputStream(targetFile);
        out.write(file);

        out.flush();
        out.close();
    }

}
