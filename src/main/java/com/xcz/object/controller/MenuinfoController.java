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
import com.xcz.object.model.Menuinfo;
import com.xcz.object.service.MenuinfoService;
import com.xcz.object.util.DataGrid;
import com.xcz.object.util.MenuTree;
import com.xcz.object.util.ToolsUtil;
@RequestMapping("/menuinfo")
@RestController
public class MenuinfoController {
	
	@Autowired
	private MenuinfoService service;
	
	

	@ResponseBody
	@RequestMapping(value="/getObjectList",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String getObjectList(HttpServletRequest request){
		
		String str="";
		Menuinfo m=new Menuinfo();
		if(null!=request.getParameter("F")&&
		  "T".equals(request.getParameter("F"))){
			m.setIsFb("已发布");
		}else{
			m.setIsFb("");
		}
		
		List<Menuinfo> list=service.getObjectList(m);
		MenuTree tree=new MenuTree(list);
		Menuinfo O=tree.generateTreeNode("1");
		JSONObject job=new JSONObject();
		job.put("total", list.size());
		job.put("rows", JSONArray.fromObject(O));
		if(request.getParameter("T").equals("L")){
			str=job.toString();
		}else{
			str=JSONArray.fromObject(O).toString();
		}
		
		return str;
	}
	
	
	
	
	@ResponseBody
	@RequestMapping(value="/getObjectListByRole",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String getObjectListByRole(HttpServletRequest request){
		
		String str="";
		String role=request.getParameter("role");
		Menuinfo m=new Menuinfo();
		m.setText(role);
		
		List<Menuinfo> list=service.getObjectListByRole(m);
		
		MenuTree tree=new MenuTree(list);
		Menuinfo O=tree.generateTreeNode("1");
		JSONObject job=new JSONObject();
		job.put("total", list.size());
		job.put("rows", JSONArray.fromObject(O));
		if(request.getParameter("T").equals("L")){
			str=job.toString();
		}else{
			str=JSONArray.fromObject(O).toString();
		}
		
		return str;
	}
	
	
	
	@ResponseBody
	@RequestMapping(value="/getMenuS",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String getMenuS(HttpServletRequest request){
		
		JSONArray json=new JSONArray();
		String pid=!"".equals(request.getParameter("pid"))?request.getParameter("pid"):"1";
		
		System.out.println("pid:"+pid);
		Menuinfo b=new Menuinfo();
		b.setPid(pid);
		
		
		
		
		List<Menuinfo> list=service.getMenuS(b);
		for(Menuinfo bean : list) {
			JSONObject obj=new JSONObject();
			obj.put("id", bean.getId());
			obj.put("text", bean.getText());
			json.add(obj);
		}
		//System.out.println("角色列表："+json.toString());
		return json.toString();
	}
	
	
	@ResponseBody  
	@RequestMapping(value="getTreeList", method=RequestMethod.POST,produces="application/json;charset=UTF-8") 
	public DataGrid getTreeList (HttpServletRequest request){
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);
		DataGrid dg = new  DataGrid();
		dg =  service.formateListDataGrid(currentPage, pageSize);
		return dg;
	}
	
	@ResponseBody  
	@RequestMapping(value="getObjectById", method=RequestMethod.GET,produces="application/json;charset=UTF-8") 
	public Menuinfo getObjectById (HttpServletRequest request){
		String id = request.getParameter("id");
		Menuinfo bean=new Menuinfo();
		bean.setId(id);
	    bean=service.getObjectById(bean);
		return bean;
	}
	
	
	
	@ResponseBody  
	@RequestMapping(value="addObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String addObjectOnly(HttpServletRequest request){
		JSONObject json = new JSONObject();
		
		
				Menuinfo bean=new Menuinfo();
				bean.setPid((null!=request.getParameter("pid")?request.getParameter("pid"):""));;
				bean.setText(null!=request.getParameter("text")?request.getParameter("text"):"");
				bean.setIconCls(null!=request.getParameter("iconCls")?request.getParameter("iconCls"):"");
				bean.setState(null!=request.getParameter("state")?request.getParameter("state"):"");
				bean.setUrl(null!=request.getParameter("url")?request.getParameter("url"):"");
				bean.setChecked(null!=request.getParameter("checked")?request.getParameter("checked"):"");
				bean.setNum(null!=request.getParameter("num")?request.getParameter("num"):"999");
				bean.setIsFb(null!=request.getParameter("isFb")?request.getParameter("isFb"):"未发布");
		        bean.setCreate_time(ToolsUtil.getDateAndTime());
		        bean.setRsv10(null!=request.getParameter("url1")?request.getParameter("url1"):"");
				bean.setRsv11(null!=request.getParameter("maxImg")?request.getParameter("maxImg"):"");
				bean.setMenuType(null!=request.getParameter("menuType")?request.getParameter("menuType"):"");
				bean.setRsv13(null!=request.getParameter("rsv13")?request.getParameter("rsv13"):"");
				bean.setRsv14(null!=request.getParameter("rsv14")?request.getParameter("rsv14"):"");
				bean.setRsv15(null!=request.getParameter("rsv15")?request.getParameter("rsv15"):"");
				bean.setRsv16(null!=request.getParameter("rsv16")?request.getParameter("rsv16"):"");
				bean.setRsv17(null!=request.getParameter("rsv17")?request.getParameter("rsv17"):"");
				bean.setRsv18(null!=request.getParameter("rsv18")?request.getParameter("rsv18"):"");
				bean.setRsv19(null!=request.getParameter("rsv19")?request.getParameter("rsv19"):"");
				bean.setRsv20(null!=request.getParameter("rsv20")?request.getParameter("rsv20"):"");
				
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
		 
		Menuinfo bean=new Menuinfo();
		bean.setId(null!=request.getParameter("id")?request.getParameter("id"):"");
		bean.setPid((null!=request.getParameter("pid")?request.getParameter("pid"):""));;
		bean.setText(null!=request.getParameter("text")?request.getParameter("text"):"");
		bean.setIconCls(null!=request.getParameter("iconCls")?request.getParameter("iconCls"):"");
		bean.setState(null!=request.getParameter("state")?request.getParameter("state"):"");
		bean.setUrl(null!=request.getParameter("url")?request.getParameter("url"):"");
		bean.setChecked(null!=request.getParameter("checked")?request.getParameter("checked"):"");
		bean.setNum(null!=request.getParameter("num")?request.getParameter("num"):"");
		bean.setIsFb(null!=request.getParameter("isFb")?request.getParameter("isFb"):"");
        bean.setCreate_time(ToolsUtil.getDateAndTime());
		bean.setUrl1(null!=request.getParameter("url1")?request.getParameter("url1"):"");
		bean.setMaxImg(null!=request.getParameter("maxImg")?request.getParameter("maxImg"):"");
		bean.setMenuType(null!=request.getParameter("menuType")?request.getParameter("menuType"):"");
		bean.setRsv13(null!=request.getParameter("rsv13")?request.getParameter("rsv13"):"");
		bean.setRsv14(null!=request.getParameter("rsv14")?request.getParameter("rsv14"):"");
		bean.setRsv15(null!=request.getParameter("rsv15")?request.getParameter("rsv15"):"");
		bean.setRsv16(null!=request.getParameter("rsv16")?request.getParameter("rsv16"):"");
		bean.setRsv17(null!=request.getParameter("rsv17")?request.getParameter("rsv17"):"");
		bean.setRsv18(null!=request.getParameter("rsv18")?request.getParameter("rsv18"):"");
		bean.setRsv19(null!=request.getParameter("rsv19")?request.getParameter("rsv19"):"");
		bean.setRsv20(null!=request.getParameter("rsv20")?request.getParameter("rsv20"):"");
		
		//System.out.println("url1:"+bean.getUrl1());
		//System.out.println("maxImg:"+bean.getMaxImg());
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
		 
		Menuinfo bean=new Menuinfo();
		bean.setId(null!=request.getParameter("id")?request.getParameter("id"):"");
		bean.setIsFb(null!=request.getParameter("isFb")?request.getParameter("isFb"):"");
        bean.setCreate_time(ToolsUtil.getDateAndTime());
		
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
			Menuinfo bean=new Menuinfo();
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
