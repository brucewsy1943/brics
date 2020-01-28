package com.xcz.object.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcz.object.model.Newsinfo;
import com.xcz.object.service.NewsinfoService;
import com.xcz.object.util.DataGrid;
import com.xcz.object.util.ToolsUtil;
@RequestMapping("/newsinfo")
@RestController
public class NewsinfoController {
	
	@Autowired
	private NewsinfoService service;
	

	@ResponseBody
	@RequestMapping(value="/getObjectList",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public DataGrid getObjectList(HttpServletRequest request){
		DataGrid dg=new DataGrid();
		String page = null!=request.getParameter("page")?request.getParameter("page"):"1";
		String rows = null!=request.getParameter("rows")?request.getParameter("rows"):"20";
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);		
		PageHelper.startPage(currentPage, pageSize, true);
		
		Newsinfo bean=new Newsinfo();
		bean.setType(!"".equals(request.getParameter("type"))?request.getParameter("type"):"");
		bean.setTitle(!"".equals(request.getParameter("title"))?"%"+request.getParameter("title")+"%":"");
		bean.setSubhead(!"".equals(request.getParameter("subhead"))?"%"+request.getParameter("subhead")+"%":"");
		bean.setIntro(!"".equals(request.getParameter("intro"))?"%"+request.getParameter("intro")+"%":"");
		bean.setContent(!"".equals(request.getParameter("content"))?"%"+request.getParameter("content")+"%":"");
		bean.setIsFb(!"all".equals(request.getParameter("isFb"))?request.getParameter("isFb"):"");
		List<Newsinfo> list=service.getObjectList(bean);
		
		PageInfo <Newsinfo> pi = new PageInfo <Newsinfo> (list);
		dg.setTotal(pi.getTotal());
		dg.setRows(pi.getList());
		
		return dg;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getObjectById",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public Newsinfo getObjectById(HttpServletRequest request){
		
		Newsinfo bean=new Newsinfo();
		bean.setId(!"".equals(request.getParameter("id"))?request.getParameter("id"):"");
		bean=service.getObjectById(bean);
		return bean;
	}
	
	@ResponseBody
	@RequestMapping(value="/getObjectListIsFb",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String getObjectListIsFb(HttpServletRequest request){
		JSONObject obj=new JSONObject();
        try {
        	String page = null!=request.getParameter("page")?request.getParameter("page"):"1";
    		String rows = null!=request.getParameter("rows")?request.getParameter("rows"):"20";
    		int currentPage = Integer.parseInt(page);
    		int	pageSize = Integer.parseInt(rows);		
    		PageHelper.startPage(currentPage, pageSize, true);
    		Newsinfo bean=new Newsinfo();
    		bean.setType(!"".equals(request.getParameter("type"))?request.getParameter("type"):"");
    		bean.setIsFb("已发布");
    		List<Newsinfo> list=service.getObjectListIsFb(bean);
    		PageInfo <Newsinfo> pi = new PageInfo <Newsinfo> (list);
			obj.put("state", true);
			obj.put("list", pi.getList());
			obj.put("totsize", pi.getTotal());
		} catch (Exception e) {
			obj.put("state", false);
			obj.put("msg", "数据库异常，请联系系统管理员");
		}
        
		return obj.toJSONString();
		
		
	}
	

	@ResponseBody  
	@RequestMapping(value="addObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String addObjectOnly(HttpServletRequest request){
		JSONObject json = new JSONObject();

			Newsinfo bean=new Newsinfo();
		    bean.setType(null!=request.getParameter("type")?request.getParameter("type"):"");
			bean.setTitle(null!=request.getParameter("title")?request.getParameter("title"):"");
			bean.setSubhead(null!=request.getParameter("subhead")?request.getParameter("subhead"):"");
			bean.setIntro(null!=request.getParameter("intro")?request.getParameter("intro"):"");
			bean.setContent(null!=request.getParameter("content")?request.getParameter("content"):"");
			bean.setImg(null!=request.getParameter("img")?request.getParameter("img"):"");
			bean.setPid(null!=request.getParameter("pid")?request.getParameter("pid"):"");
			bean.setFiles(null!=request.getParameter("files")?request.getParameter("files"):"");
			bean.setDisplay(null!=request.getParameter("display")?request.getParameter("display"):"");
			bean.setNum(null!=request.getParameter("num")?request.getParameter("num"):"999");
			bean.setIsFb(null!=request.getParameter("isFb")?request.getParameter("isFb"):"未发布");
			bean.setFbDate(null!=request.getParameter("fbDate")?request.getParameter("fbDate"):"");
			bean.setRsv13(null!=request.getParameter("rsv13")?request.getParameter("rsv13"):"");
			bean.setRsv14(null!=request.getParameter("rsv14")?request.getParameter("rsv14"):"");
			bean.setRsv15(null!=request.getParameter("rsv15")?request.getParameter("rsv15"):"");
			bean.setRsv16(null!=request.getParameter("rsv16")?request.getParameter("rsv16"):"");
			bean.setRsv17(null!=request.getParameter("rsv17")?request.getParameter("rsv17"):"");
			bean.setRsv18(null!=request.getParameter("rsv18")?request.getParameter("rsv18"):"");
			bean.setRsv19(null!=request.getParameter("rsv19")?request.getParameter("rsv19"):"");
			bean.setRsv20(ToolsUtil.getDateAndTime());
			
			try{
			        service.addObjectOnly(bean);
					json.put("status", true);
			        json.put("msg", "新增成功！");
			        json.put("result", "0");
			}catch(Exception e){
				e.printStackTrace();
				json.put("status", false);
		        json.put("msg", "新增失"
		        		+ "败！请联系系统管理员！");
		        json.put("result", "1");
			}
			
		
		return json.toString();
	}
	
	
	@ResponseBody  
	@RequestMapping(value="updateObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String updateObjectOnly(HttpServletRequest request){
		 
		Newsinfo bean=new Newsinfo();
		bean.setId(null!=request.getParameter("id")?request.getParameter("id"):"");
		bean.setType(null!=request.getParameter("type")?request.getParameter("type"):"");
		bean.setTitle(null!=request.getParameter("title")?request.getParameter("title"):"");
		bean.setSubhead(null!=request.getParameter("subhead")?request.getParameter("subhead"):"");
		bean.setIntro(null!=request.getParameter("intro")?request.getParameter("intro"):"");
		bean.setContent(null!=request.getParameter("content")?request.getParameter("content"):"");
		bean.setImg(null!=request.getParameter("img")?request.getParameter("img"):"");
		bean.setPid(null!=request.getParameter("pid")?request.getParameter("pid"):"");
		bean.setFiles(null!=request.getParameter("files")?request.getParameter("files"):"");
		bean.setDisplay(null!=request.getParameter("display")?request.getParameter("display"):"");
		bean.setNum(null!=request.getParameter("num")?request.getParameter("num"):"");
		bean.setIsFb(null!=request.getParameter("isFb")?request.getParameter("isFb"):"");
		bean.setFbDate(null!=request.getParameter("fbDate")?request.getParameter("fbDate"):"");
		bean.setRsv13(null!=request.getParameter("rsv13")?request.getParameter("rsv13"):"");
		bean.setRsv14(null!=request.getParameter("rsv14")?request.getParameter("rsv14"):"");
		bean.setRsv15(null!=request.getParameter("rsv15")?request.getParameter("rsv15"):"");
		bean.setRsv16(null!=request.getParameter("rsv16")?request.getParameter("rsv16"):"");
		bean.setRsv17(null!=request.getParameter("rsv17")?request.getParameter("rsv17"):"");
		bean.setRsv18(null!=request.getParameter("rsv18")?request.getParameter("rsv18"):"");
		bean.setRsv19(null!=request.getParameter("rsv19")?request.getParameter("rsv19"):"");
		bean.setRsv20(ToolsUtil.getDateAndTime());
		
		JSONObject json = new JSONObject();
		try{
			service.updateObjectOnly(bean);
			json.put("status", true);
	        json.put("msg", "修改成功！");
	        return json.toString();
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", false);
	        json.put("msg", "修改失败！请联系系统管理员！");
	        return json.toString();
		}
	}
	
	
	@ResponseBody  
	@RequestMapping(value="updateIsFb", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String updateIsFb(HttpServletRequest request){
		 
		Newsinfo bean=new Newsinfo();
		bean.setId(null!=request.getParameter("id")?request.getParameter("id"):"");
		bean.setIsFb(null!=request.getParameter("isFb")?request.getParameter("isFb"):"");
        bean.setRsv20(ToolsUtil.getDateAndTime());
		
		JSONObject json = new JSONObject();
		try{
			service.updateIsFb(bean);
			json.put("status", true);
	        json.put("msg", "发布成功！");
	        return json.toString();
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", false);
	        json.put("msg", "发布失败！请联系系统管理员！");
	        return json.toString();
		}
	}
	
	@ResponseBody  
	@RequestMapping(value="deleteObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String deleteObjectOnly(HttpServletRequest request){
		
		JSONObject json = new JSONObject();
		try{
		String ids []=request.getParameter("ids").split(",");
		for(String id:ids){
			Newsinfo bean=new Newsinfo();
			bean.setId(id);
			service.deleteObjectOnly(bean);
		}
			json.put("status", true);
	        json.put("msg", "删除成功！");
	        return json.toString();
		}catch(Exception e){
			e.printStackTrace();
			json.put("status", false);
	        json.put("msg", "删除失败！请联系系统管理员！");
	        return json.toString();
		}
	}
}
