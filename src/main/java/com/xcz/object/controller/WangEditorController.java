package com.xcz.object.controller;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
@RequestMapping("/Upload")
@RestController
public class WangEditorController {
	
	/*
	@Autowired
	private UserInfoService service;
	*/       
	@Value("${spring.upload.path.files}")
    private  String filesPath;
	
	
	@Value("${spring.upload.path.images}")
    private  String imgsPath;
	
	
	@ResponseBody
	@RequestMapping(value="/wangEditorUp",produces="application/json;charset=UTF-8")
	public Object  wangEditorUp(@RequestParam(value="myFileName")MultipartFile mf,HttpServletRequest request){
           // System.out.println("文件路径："+realPath);
		
		
		    String contextPath =request.getSession().getServletContext().getRealPath("/");
		    String brics = request.getContextPath();
		   // System.out.println("上传路径："+contextPath);
		    //获取源文件
		    String filename = mf.getOriginalFilename();
		    /*
		    String[] names=filename.split("\\.");//
		    String tempNum=(int)(Math.random()*100000)+"";
		    String uploadFileName=tempNum +System.currentTimeMillis()+"."+names[names.length-1];
		    */
		    String imgPath=contextPath+imgsPath+filename;
		    File targetFile = new File (imgPath);//目标文件
		    //开始从源文件拷贝到目标文件
		     
		    //传图片一步到位
		    try {
		        mf.transferTo(targetFile);
		    } catch (IllegalStateException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
		     
		    Map<String, String> map = new HashMap<String, String>();
		    map.put("data",brics+"/"+imgsPath+filename);//这里应该是项目路径
		    map.put("realPath",imgPath);//这里应该是项目路径
		    //System.out.println("上传成功后，图片保存在："+imgPath);
		    return map;//将图片地址返回
		
	}
	
	
	@ResponseBody
	@RequestMapping(value="/uploadImage",produces="application/json;charset=UTF-8")
	public Object  uploadImage(@RequestParam(value="upImage")MultipartFile mfs [],HttpServletRequest request){
		    String contextPath =request.getSession().getServletContext().getRealPath("/");
	        String brics = request.getContextPath();
	        
	        Map<String, String> map = new HashMap<String, String>();
		    try {
		    	
		    	
		    	StringBuffer filenames=new StringBuffer();
		    	for(int i=0;i<mfs.length;i++) {
		    		MultipartFile mf=mfs[i];
		    		 //获取源文件
		    		String filename = mf.getOriginalFilename();
		    /*
		    String[] names=filename.split("\\.");//
		    String tempNum=(int)(Math.random()*100000)+"";
		    String uploadFileName=tempNum +System.currentTimeMillis()+"."+names[names.length-1];
		    */
		    String imgPath=contextPath+imgsPath+filename;
		    File targetFile = new File (imgPath);//目标文件
		     
		    //开始从源文件拷贝到目标文件
		     
		    //传图片一步到位
		    try {
		        mf.transferTo(targetFile);
		        if(i<(mfs.length-1)) {
			    	filenames.append(brics+"/"+imgsPath+filename+",");
			    }else {
			    	filenames.append(brics+"/"+imgsPath+filename);
			    }
		    } catch (IllegalStateException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	      }
    	
    	 System.out.println("上传成功后，图片保存在："+filenames.toString());
    	 map.put("filenames",filenames.toString());//这里应该是项目路径
         }catch(Exception e) {
    	      map.put("status","false");
         }

         map.put("status","true");
         return map;//将图片地址返回

		
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/uploadFile",produces="application/json;charset=UTF-8")
	public Object  uploadFile(@RequestParam(value="upfile")MultipartFile mfs[],HttpServletRequest request){
		    String contextPath =request.getSession().getServletContext().getRealPath("/");
	        String brics = request.getContextPath();
	        
	        Map<String, String> map = new HashMap<String, String>();
		    try {

		    	StringBuffer filenames=new StringBuffer();
		    	for(int i=0;i<mfs.length;i++) {
		    		MultipartFile mf=mfs[i];
			    //获取源文件
			    String filename = mf.getOriginalFilename();
		    /*
		    String[] names=filename.split("\\.");//
		    String tempNum=(int)(Math.random()*100000)+"";
		    String uploadFileName=tempNum +System.currentTimeMillis()+"."+names[names.length-1];
		    */
		    String filePath=contextPath+filesPath+filename;
		    System.out.println("文件存放路径："+filePath);
		    File targetFile = new File (filePath);//目标文件
		     
		    //开始从源文件拷贝到目标文件		
		    
		    
		  //传图片一步到位
		    try {
		        mf.transferTo(targetFile);
		        if(i<(mfs.length-1)) {
			    	filenames.append(brics+"/"+filesPath+filename+",");
			    }else {
			    	filenames.append(brics+"/"+filesPath+filename);
			    }
		    } catch (IllegalStateException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    } catch (IOException e) {
		        // TODO Auto-generated catch block
		        e.printStackTrace();
		    }
	    	}
		    System.out.println("上传成功后，文件保存在："+filenames.toString());
	    	 map.put("filenames",filenames.toString());//这里应该是项目路径
	    }catch(Exception e) {
	    	 map.put("status","false");
	    }

	    map.put("status","true");
	    return map;//将图片地址返回
		
		
	}

}
