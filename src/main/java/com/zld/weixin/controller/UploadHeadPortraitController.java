package com.zld.weixin.controller;

import com.alibaba.fastjson.JSON;
import com.zld.weixin.mapper.CardInfoMapper;
import com.zld.weixin.model.CardInfo;
import com.zld.weixin.model.CardInfoExample;
import com.zld.weixin.util.WeixinUtil;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.*;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/12/29.
 */
@RestController
public class UploadHeadPortraitController {
    private static final Logger logger = LoggerFactory.getLogger(UploadHeadPortraitController.class);
    @Autowired
    CardInfoMapper cardInfoMapper;
    @RequestMapping(value = "/uploadHeadPortrait",method = RequestMethod.POST)
    public CardInfo uploadHeadPortrait(HttpServletRequest request, HttpServletResponse response
                                     ,HttpSession session,
                                     @RequestParam("file") MultipartFile image,
                                     CardInfo formdata) throws IOException, ServletException {

        System.out.println("sessionId:" + formdata);
        String sessionKey = formdata.getId();
        request.setCharacterEncoding("utf-8");  //设置编码
        String session_value = (String)session.getAttribute(sessionKey);
        System.out.println(session_value);
        String[] openid_and_secret = session_value.split(" ");
        String openid = openid_and_secret[0];
        String secret = openid_and_secret[1];
        String path = request.getRealPath("/static") + "/";
        logger.debug("path=" + path);
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }
        logger.debug("path=" + path);
//        System.out.println();
        System.out.println(image.getOriginalFilename());
        String fileName = image.getOriginalFilename();
        String filePath = path + fileName;
        System.out.println(fileName);
        CardInfoExample updateImgUrlExample = new CardInfoExample();
        CardInfoExample.Criteria updateImgUrlExampleCriteria = updateImgUrlExample.createCriteria();
        updateImgUrlExampleCriteria.andIdEqualTo(openid);
        formdata.setId(openid);

//        CardInfo cardInfo = new CardInfo();//+new Random().nextInt()+
        formdata.setImgurl(WeixinUtil.APP_URL + "/static/" + fileName);
        cardInfoMapper.updateByExampleSelective(formdata,updateImgUrlExample);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));//真大型写入文件
        BufferedInputStream bis = new BufferedInputStream(image.getInputStream());
        byte[] b = new byte[1024];
        while (bis.read(b) != -1) {
            bos.write(b);
        }
        bos.close();
        bis.close();
        return formdata;
    }
}
//    File dir = new File(path);
//        if (!dir.exists()) {
//                dir.mkdir();
//                }
//                logger.debug("path=" + path);
////        System.out.println();
//                request.setCharacterEncoding("utf-8");  //设置编码
//                //获得磁盘文件条目工厂
//                DiskFileItemFactory factory = new DiskFileItemFactory();
//
//                //如果没以下两行设置的话,上传大的文件会占用很多内存，
//                //设置暂时存放的存储室,这个存储室可以和最终存储文件的目录不同
//                /**
//                 * 原理: 它是先存到暂时存储室，然后再真正写到对应目录的硬盘上，
//                 * 按理来说当上传一个文件时，其实是上传了两份，第一个是以 .tem 格式的
//                 * 然后再将其真正写到对应目录的硬盘上
//                 */
//                factory.setRepository(dir);
//                //设置缓存的大小，当上传文件的容量超过该缓存时，直接放到暂时存储室
//                factory.setSizeThreshold(1024 * 1024);
//                //高水平的API文件上传处理
//                ServletFileUpload upload = new ServletFileUpload(factory);
//                System.out.println(request);
//                try {
//                List<FileItem> list = upload.parseRequest(request);
//        System.out.println(list);
//        FileItem picture = null;
//        for (FileItem item : list) {
//        //获取表单的属性名字
//        String name = item.getFieldName();
//        //如果获取的表单信息是普通的 文本 信息
//        if (item.isFormField()) {
//        //获取用户具体输入的字符串
//        String value = item.getString();
//        request.setAttribute(name, value);
//        logger.debug("name=" + name + ",value=" + value);
//        } else {
//        picture = item;
//        }
//        }
//        //自定义上传图片的名字为userId.jpg
//        String fileName = request.getAttribute("sessionKey") + ".jpg";
//        String destPath = path + fileName;
//        logger.debug("destPath=" + destPath);
//
//        //真正写到磁盘上
//        File file = new File(destPath);
//        OutputStream out = new FileOutputStream(file);
//        InputStream in = picture.getInputStream();
//        int length = 0;
//        byte[] buf = new byte[1024];
//        // in.read(buf) 每次读到的数据存放在buf 数组中
//        while ((length = in.read(buf)) != -1) {
//        //在buf数组中取出数据写到（输出流）磁盘上
//        out.write(buf, 0, length);
//        }
//        in.close();
//        out.close();
//        } catch (FileUploadException e1) {
//        logger.error("", e1);
//        } catch (Exception e) {
//        logger.error("", e);
//        }
//
//
//        PrintWriter printWriter = response.getWriter();
//        response.setContentType("application/json");
//        response.setCharacterEncoding("utf-8");
//        HashMap<String, Object> res = new HashMap<String, Object>();
//        res.put("success", true);
//        printWriter.write(JSON.toJSONString(res));
//        printWriter.flush();