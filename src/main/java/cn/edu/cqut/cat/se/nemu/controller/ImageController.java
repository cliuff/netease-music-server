package cn.edu.cqut.cat.se.nemu.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@CrossOrigin
@RequestMapping("/image")

public class ImageController {

    //前台获取后台的图片路径,图片上传测试
    @ResponseBody
    @RequestMapping("/upload")
    public Map upload(MultipartFile file, HttpServletRequest request) {
        String prefix = "";
        /*    String dateStr = "";*/
        //保存上传
        OutputStream out = null;
        InputStream fileInput = null;
        try {
            if (file != null) {
                String originalName = file.getOriginalFilename();
                prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
                /*Date date = new Date();*/
                String uuid = UUID.randomUUID() + "";
                /*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                dateStr = simpleDateFormat.format(date);*/
                String filepath = "E:\\ThirdGrade\\Job\\furnitureweb\\images\\goods\\"  + uuid + "." + prefix;

                File files = new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);

                if (!files.getParentFile().exists()) {
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
                Map<String, Object> map2 = new HashMap<>();
                Map<String, Object> map = new HashMap<>();
                map.put("code", 0);
                map.put("msg", "");
                map.put("data", map2);
                map2.put("src", "E:\\ThirdGrade\\Job\\furnitureweb\\images\\goods\\"  + uuid + "." + prefix);
                return map;
            }
        } catch (Exception e) {
        } finally {

            try{
                if(out!=null){
                    out.close();
                }
                if(fileInput!=null){
                    fileInput.close();
                }
            }catch (IOException e){

            }
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code",1);
        map.put("msg","");
        return map;


    }
}
