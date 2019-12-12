package com.mybatis.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 海神阁
 */
@Controller
@RequestMapping("/fileUploadController")
public class FileUploadController
{
    @RequestMapping("/fileUp")
    public String fileUp(){
        return "fileup";
    }

	@RequestMapping(value = "/fileUpload" , method = RequestMethod.POST)
	public String fileUpload(@RequestParam("file") MultipartFile file , HttpServletRequest request )
	{
		System.out.println(file.getOriginalFilename());
		String filename = file.getOriginalFilename();

//		/upload/  传在 out 文件夹下
//        String realPath = request.getSession().getServletContext().getRealPath("/upload/");
        // 获取文件类型
//        String fileType = fileName.substring(fileName.lastIndexOf("."));

//        File newFile = new File(realPath,filename);
//        if( !newFile.getParentFile().exists()) {
//            // 如果目标文件所在的目录不存在，则创建父目录
//            newFile.getParentFile().mkdirs();
//        }
//        System.out.println(newFile);

		try
		{
			file.transferTo(new File(filename));
		} catch (IllegalStateException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "success";
	}


}
