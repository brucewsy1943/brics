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
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcz.object.model.Roleinfo;
import com.xcz.object.model.Roleuserinfo;
import com.xcz.object.model.Userinfo;
import com.xcz.object.service.RoleinfoService;
import com.xcz.object.service.RoleuserinfoService;
import com.xcz.object.service.UserinfoService;
import com.xcz.object.util.DataGrid;
import com.xcz.object.util.ToolsUtil;
@RequestMapping("/roleinfo")
@RestController
public class RoleinfoController {
	
	@Autowired
	private RoleinfoService service;
	
	
	
	@Autowired
	private RoleuserinfoService ruService;
	
	
	@Autowired
	private UserinfoService uService;

	@ResponseBody
	@RequestMapping(value="/getObjectList",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public DataGrid getObjectList(HttpServletRequest request){
		DataGrid dg=new DataGrid();
		String page = null!=request.getParameter("page")?request.getParameter("page"):"1";
		String rows = null!=request.getParameter("rows")?request.getParameter("rows"):"20";
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);		
		PageHelper.startPage(currentPage, pageSize, true);
		
		Roleinfo bean=new Roleinfo();
		bean.setRoleName(!"".equals(request.getParameter("roleName"))?"%"+request.getParameter("roleName")+"%":"");
		
		List<Roleinfo> list=service.getObjectList(bean);
		
		PageInfo <Roleinfo> pi = new PageInfo <Roleinfo> (list);
		
		
		//System.out.println("Roleinfo pi.getTotal():"+pi.getTotal());
		//System.out.println("Roleinfo pi.getList():"+pi.getList());
		dg.setTotal(pi.getTotal());
		dg.setRows(pi.getList());
		
		return dg;
	}
	

	@ResponseBody
	@RequestMapping(value="/getRole",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public String getRole(HttpServletRequest request){
		
		JSONArray json=new JSONArray();
		List<Roleinfo> list=service.getObjectByRole(null);
		for(Roleinfo bean : list) {
			JSONObject obj=new JSONObject();
			obj.put("id", bean.getId());
			obj.put("text", bean.getRoleName());
			json.put(obj);
		}
		//System.out.println("角色列表："+json.toString());
		return json.toString();
	}
	
	
	
	@ResponseBody  
	@RequestMapping(value="addObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String addObjectOnly(HttpServletRequest request){
		JSONObject json = new JSONObject();

			Roleinfo bean=new Roleinfo();
		    
			bean.setRoleName(null!=request.getParameter("roleName")?request.getParameter("roleName"):"");
			bean.setRsv2(null!=request.getParameter("rsv2")?request.getParameter("rsv2"):"");
			bean.setRsv3(null!=request.getParameter("rsv3")?request.getParameter("rsv3"):"");
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
			
			
			
			System.out.println("网站菜单："+bean.getRsv2());
			
			try{
			        service.addObjectOnly(bean);
					json.put("status", true);
			        json.put("msg", "新增成功！");
			        json.put("result", "0");
			}catch(Exception e){
				e.printStackTrace();
				json.put("status", false);
		        json.put("msg", "新增失败！请联系系统管理员！");
		        json.put("result", "1");
			}
			
		
		return json.toString();
	}
	
	
	@ResponseBody  
	@RequestMapping(value="updateObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String updateObjectOnly(HttpServletRequest request){
		JSONObject json = new JSONObject();
		Roleinfo bean=new Roleinfo();
		bean.setId(null!=request.getParameter("id")?request.getParameter("id"):"");
		bean.setRoleName(null!=request.getParameter("roleName")?request.getParameter("roleName"):"");
		bean.setRsv2(null!=request.getParameter("rsv2")?request.getParameter("rsv2"):"");
		bean.setRsv3(null!=request.getParameter("rsv3")?request.getParameter("rsv3"):"");
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
			Roleinfo bean=new Roleinfo();
			bean.setId(id);
			service.deleteObjectOnly(bean);
			
			
			//删除角色下所有的权限菜单
			Roleuserinfo rub=new  Roleuserinfo();
			rub.setId(id);
			ruService.deleteObjectByrole(rub);
			
			//删除角色下所有的用户
			Userinfo ubean= new Userinfo();
			ubean.setRid(id);
			uService.deleteObjectByRsv7(ubean);
			
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
