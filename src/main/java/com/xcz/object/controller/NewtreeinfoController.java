package com.xcz.object.controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcz.object.model.Newtreeinfo;
import com.xcz.object.service.NewtreeinfoService;
import com.xcz.object.util.DataGrid;
import com.xcz.object.util.NewTree;
import com.xcz.object.util.ToolsUtil;
@RequestMapping("/newtreeinfo")
@RestController
public class NewtreeinfoController {
	
	@Autowired
	private NewtreeinfoService service;
	
	@ResponseBody
	@RequestMapping(value="/getTrees",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String getObjectList(HttpServletRequest request){
		String str="";
		Newtreeinfo bean=new Newtreeinfo();
		bean.setType(null!=request.getParameter("type")?request.getParameter("type"):"");
		List<Newtreeinfo> list=service.getTrees(bean);
		if(list.size()>0){
			NewTree tree=new NewTree(list);
			Newtreeinfo O=tree.generateTreeNode("0");
			str=JSONArray.fromObject(O).toString();
		}
		
		return str;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getObjectListIsFb",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String getObjectListIsFb(HttpServletRequest request){
		
		JSONObject obj=new JSONObject();
		try {
			Newtreeinfo bean=new Newtreeinfo();
			bean.setType(null!=request.getParameter("type")?request.getParameter("type"):"");
			bean.setPid(null!=request.getParameter("pid")?request.getParameter("pid"):"");
			bean.setIsFb("已发布");
			
			List<Newtreeinfo> list=service.getObjectListIsFb(bean);
			NewTree tree=new NewTree(list);
			Newtreeinfo O=tree.generateTreeNode(bean.getPid());
			obj.put("state", true);
			obj.put("list", O);
			
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("state", false);
			obj.put("msg", "数据库异常，请联系系统管理员");
		}
		
		//System.out.println("str:"+obj.toJSONString());
		return obj.toJSONString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getObjectListIsFbByPid",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String getObjectListIsFbByPid(HttpServletRequest request){
		JSONObject obj=new JSONObject();
        try {
        	String page = null!=request.getParameter("page")?request.getParameter("page"):"1";
    		String rows = null!=request.getParameter("rows")?request.getParameter("rows"):"20";
    		int currentPage = Integer.parseInt(page);
    		int	pageSize = Integer.parseInt(rows);		
    		PageHelper.startPage(currentPage, pageSize, true);
    		Newtreeinfo bean=new Newtreeinfo();
    		bean.setPid(!"".equals(request.getParameter("pid"))?request.getParameter("pid"):"");
    		bean.setIsFb("已发布");
    		List<Newtreeinfo> list=service.getObjectListIsFbByPid(bean);
    		PageInfo <Newtreeinfo> pi = new PageInfo <Newtreeinfo> (list);
			obj.put("state", true);
			obj.put("list", pi.getList());
			obj.put("totsize", pi.getTotal());
		} catch (Exception e) {
			e.printStackTrace();
			obj.put("state", false);
			obj.put("msg", "数据库异常，请联系系统管理员");
		}
        
		return obj.toJSONString();
		
		
	}
	
	@ResponseBody  
	@RequestMapping(value="getTreeList", method=RequestMethod.POST,produces="application/json;charset=UTF-8") 
	public DataGrid getTreeList (HttpServletRequest request){
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);
		Newtreeinfo bean=new Newtreeinfo();
		bean.setType(null!=request.getParameter("type")?request.getParameter("type"):"");
		DataGrid dg = new  DataGrid();
		dg =  service.formateListDataGrid(currentPage, pageSize,bean);
		return dg;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/getObjectById",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public Newtreeinfo getObjectById(HttpServletRequest request){
		
		Newtreeinfo bean=new Newtreeinfo();
		bean.setId(!"".equals(request.getParameter("id"))?request.getParameter("id"):"");
		bean=service.getObjectById(bean);
		return bean;
	}
	
	
	@ResponseBody  
	@RequestMapping(value="addObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String addObjectOnly(HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		
				Newtreeinfo bean=new Newtreeinfo();
				bean.setType(null!=request.getParameter("type")?request.getParameter("type"):"");
				bean.setColumns(null!=request.getParameter("columns")?request.getParameter("columns"):"");
				bean.setSubhead(null!=request.getParameter("subhead")?request.getParameter("subhead"):"");
				bean.setIntro(null!=request.getParameter("intro")?request.getParameter("intro"):"");
				bean.setContent(null!=request.getParameter("content")?request.getParameter("content"):"");
				bean.setImg(null!=request.getParameter("img")?request.getParameter("img"):"");
				bean.setPid(null!=request.getParameter("pid")&&!"".equals(request.getParameter("pid"))?request.getParameter("pid"):"0");
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
		 
		Newtreeinfo bean=new Newtreeinfo();
		bean.setId(null!=request.getParameter("id")?request.getParameter("id"):"");
		bean.setType(null!=request.getParameter("type")?request.getParameter("type"):"");
		bean.setColumns(null!=request.getParameter("columns")?request.getParameter("columns"):"");
		bean.setSubhead(null!=request.getParameter("subhead")?request.getParameter("subhead"):"");
		bean.setIntro(null!=request.getParameter("intro")?request.getParameter("intro"):"");
		bean.setContent(null!=request.getParameter("content")?request.getParameter("content"):"");
		bean.setImg(null!=request.getParameter("img")?request.getParameter("img"):"");
		bean.setPid(null!=request.getParameter("pid")&&!"".equals(request.getParameter("pid"))?request.getParameter("pid"):"0");
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
		 
		Newtreeinfo bean=new Newtreeinfo();
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
			Newtreeinfo bean=new Newtreeinfo();
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
