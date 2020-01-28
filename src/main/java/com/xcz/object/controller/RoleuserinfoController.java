package com.xcz.object.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.xcz.object.model.Roleuserinfo;
import com.xcz.object.service.RoleuserinfoService;
import com.xcz.object.util.DataGrid;
import com.xcz.object.util.ToolsUtil;
@RequestMapping("/roleuserinfo")
@RestController
public class RoleuserinfoController {
	
	@Autowired
	private RoleuserinfoService service;
	

	@ResponseBody
	@RequestMapping(value="/getObjectList",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public DataGrid getObjectList(HttpServletRequest request){
		String role_id=request.getParameter("role_id");
		/*
		DataGrid dg=new DataGrid();
		String page = null!=request.getParameter("page")?request.getParameter("page"):"1";
		String rows = null!=request.getParameter("rows")?request.getParameter("rows"):"20";
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);		
		PageHelper.startPage(currentPage, pageSize, true);
		
		Roleuserinfo bean=new Roleuserinfo();
		bean.setRsv1(request.getParameter("id"));
		//System.out.println("id:"+bean.getRsv1());
		List<Roleuserinfo> list=service.getObjectList(bean);
		
		PageInfo <Roleuserinfo> pi = new PageInfo <Roleuserinfo> (list);
		
		
		//System.out.println("Roleuserinfo pi.getTotal():"+pi.getTotal());
		//System.out.println("Roleuserinfo pi.getList():"+pi.getList());
		dg.setTotal(pi.getTotal());
		dg.setRows(pi.getList());
		
		return dg;
		*/
		
		
		String page = request.getParameter("page");
		String rows = request.getParameter("rows");
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);
		DataGrid dg = new  DataGrid();
		dg =  service.formateListDataGrid(currentPage, pageSize,role_id);
		return dg;
	}
	

	@ResponseBody
	@RequestMapping(value="/getRoleuser",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String getRoleuser(HttpServletRequest request){
		
		JSONArray json=new JSONArray();
		List<Roleuserinfo> list=service.getObjectByRoleuser(null);
		for(Roleuserinfo bean : list) {
			JSONObject obj=new JSONObject();
			obj.put("id", bean.getId());
			obj.put("text", bean.getRsv1());
			json.put(obj);
		}
		//System.out.println("角色列表："+json.toString());
		return json.toString();
	}
	
	
	
	@ResponseBody  
	@RequestMapping(value="addObjectAll", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String addObjectAll(HttpServletRequest request){
		JSONObject json = new JSONObject();
		try{
			Roleuserinfo bean=new Roleuserinfo();
			bean.setRid(null!=request.getParameter("rid")?request.getParameter("rid"):"");
			bean.setPid(null!=request.getParameter("pid")?request.getParameter("pid"):"");
			String ids[]=request.getParameter("mid").split(",");
			for(String id :ids) {
				bean.setMid(id);
				bean.setRsv4(null!=request.getParameter("rsv4")?request.getParameter("rsv4"):"");
				bean.setRsv5(null!=request.getParameter("rsv5")?request.getParameter("rsv5"):"");
				bean.setRsv6(null!=request.getParameter("rsv6")?request.getParameter("rsv6"):"");
				bean.setRsv7(null!=request.getParameter("rsv7")?request.getParameter("rsv7"):"");
				bean.setRsv8(null!=request.getParameter("rsv8")?request.getParameter("rsv8"):"");
				bean.setRsv9(null!=request.getParameter("rsv9")?request.getParameter("rsv9"):"");
				bean.setRsv10(null!=request.getParameter("rsv10")?request.getParameter("rsv10"):"");
				bean.setRsv11(null!=request.getParameter("rsv11")?request.getParameter("rsv11"):"");
				bean.setRsv12(null!=request.getParameter("rsv12")?request.getParameter("rsv12"):"");
				bean.setRsv13(null!=request.getParameter("rsv13")?request.getParameter("rsv13"):"");
				bean.setRsv14(null!=request.getParameter("rsv14")?request.getParameter("rsv14"):"");
				bean.setRsv15(null!=request.getParameter("rsv15")?request.getParameter("rsv15"):"");
				bean.setRsv16(null!=request.getParameter("rsv16")?request.getParameter("rsv16"):"");
				bean.setRsv17(null!=request.getParameter("rsv17")?request.getParameter("rsv17"):"");
				bean.setRsv18(null!=request.getParameter("rsv18")?request.getParameter("rsv18"):"");
				bean.setRsv19(null!=request.getParameter("rsv19")?request.getParameter("rsv19"):"");
				bean.setRsv20(ToolsUtil.getDateAndTime());
				service.addObjectOnly(bean);
			}
					json.put("status", true);
			        json.put("msg", "新增成功！");
			        json.put("result", "0");
			}catch(Exception e) {
				e.printStackTrace();
				if(e.getCause() instanceof MySQLIntegrityConstraintViolationException) {
					json.put("status", false);
			        json.put("msg", "分配权限失败，菜单不能重复！");
			        json.put("result", "1");
				}else {
					json.put("status", false);
			        json.put("msg", "分配权限失败！请联系系统管理员！");
			        json.put("result", "1");
				}
				
			}
			
		System.out.println(json.toString());
		
		return json.toString();
	}
	
	
	@ResponseBody  
	@RequestMapping(value="updateObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String updateObjectOnly(HttpServletRequest request){
		JSONObject json = new JSONObject();
		Roleuserinfo bean=new Roleuserinfo();
		bean.setId(null!=request.getParameter("id")?request.getParameter("id"):"");
		bean.setRid(null!=request.getParameter("rid")?request.getParameter("rid"):"");
		bean.setMid(null!=request.getParameter("mid")?request.getParameter("mid"):"");
		bean.setPid(null!=request.getParameter("pid")?request.getParameter("pid"):"");
		bean.setRsv4(null!=request.getParameter("rsv4")?request.getParameter("rsv4"):"");
		bean.setRsv5(null!=request.getParameter("rsv5")?request.getParameter("rsv5"):"");
		bean.setRsv6(null!=request.getParameter("rsv6")?request.getParameter("rsv6"):"");
		bean.setRsv7(null!=request.getParameter("rsv7")?request.getParameter("rsv7"):"");
		bean.setRsv8(null!=request.getParameter("rsv8")?request.getParameter("rsv8"):"");
		bean.setRsv9(null!=request.getParameter("rsv9")?request.getParameter("rsv9"):"");
		bean.setRsv10(null!=request.getParameter("rsv10")?request.getParameter("rsv10"):"");
		bean.setRsv11(null!=request.getParameter("rsv11")?request.getParameter("rsv11"):"");
		bean.setRsv12(null!=request.getParameter("rsv12")?request.getParameter("rsv12"):"");
		bean.setRsv13(null!=request.getParameter("rsv13")?request.getParameter("rsv13"):"");
		bean.setRsv14(null!=request.getParameter("rsv14")?request.getParameter("rsv14"):"");
		bean.setRsv15(null!=request.getParameter("rsv15")?request.getParameter("rsv15"):"");
		bean.setRsv16(null!=request.getParameter("rsv16")?request.getParameter("rsv16"):"");
		bean.setRsv17(null!=request.getParameter("rsv17")?request.getParameter("rsv17"):"");
		bean.setRsv18(null!=request.getParameter("rsv18")?request.getParameter("rsv18"):"");
		bean.setRsv19(null!=request.getParameter("rsv19")?request.getParameter("rsv19"):"");
		bean.setRsv20(ToolsUtil.getDateAndTime());
		
		
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
	@RequestMapping(value="deleteObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String deleteObjectOnly(HttpServletRequest request){
		
		JSONObject json = new JSONObject();
		try{
		String ids []=request.getParameter("ids").split(",");
		for(String id:ids){
			Roleuserinfo bean=new Roleuserinfo();
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
