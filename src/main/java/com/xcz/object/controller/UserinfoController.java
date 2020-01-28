package com.xcz.object.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcz.object.model.Userinfo;
import com.xcz.object.service.UserinfoService;
import com.xcz.object.util.DataGrid;
import com.xcz.object.util.ToolsUtil;
@RequestMapping("/userinfo")
@RestController
public class UserinfoController {
	
	@Autowired
	private UserinfoService service;
	

	@ResponseBody
	@RequestMapping(value="/getObjectList",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public DataGrid getObjectList(HttpServletRequest request){
		DataGrid dg=new DataGrid();
		String page = null!=request.getParameter("page")?request.getParameter("page"):"1";
		String rows = null!=request.getParameter("rows")?request.getParameter("rows"):"20";
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);		
		PageHelper.startPage(currentPage, pageSize, true);
		
		Userinfo bean=new Userinfo();
		bean.setUsername(!"".equals(request.getParameter("username"))?"%"+request.getParameter("username")+"%":"");
		bean.setChinaname(!"".equals(request.getParameter("chinaname"))?"%"+request.getParameter("chinaname")+"%":"");
		bean.setEmail(!"".equals(request.getParameter("email"))?"%"+request.getParameter("email")+"%":"");
		bean.setPhone(!"".equals(request.getParameter("phone"))?"%"+request.getParameter("phone")+"%":"");
		List<Userinfo> list=service.getObjectList(bean);
		
		PageInfo <Userinfo> pi = new PageInfo <Userinfo> (list);
		
		
		//System.out.println("userinfo pi.getTotal():"+pi.getTotal());
		//System.out.println("userinfo pi.getList():"+pi.getList());
		dg.setTotal(pi.getTotal());
		dg.setRows(pi.getList());
		
		return dg;
	}
	

	@ResponseBody  
	@RequestMapping(value="addObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String addObjectOnly(HttpServletRequest request){
		JSONObject json = new JSONObject();

			Userinfo bean=new Userinfo();
			
			
			bean.setUsername(null!=request.getParameter("username")?request.getParameter("username"):"");
			
			Userinfo checkBean=service.getObjectByUser(bean);
			if(checkBean!=null) {
				json.put("status", false);
		        json.put("msg", "新增失败！用户名已存在！");
		        json.put("result", "1");
		        return json.toString();
			}

		    if(null!=request.getParameter("password")&&!"".equals(request.getParameter("password"))){
		    	
		    	String password=DigestUtils.md5Hex(request.getParameter("password"));
		    	password=DigestUtils.md5Hex(password);
		    	bean.setPassword(password);
		    	
		    }else{
		    	json.put("status", false);
		        json.put("msg", "新增失败！密码不能为空！");
		        json.put("result", "1");
		        return json.toString();
		    }
			
			bean.setChinaname(null!=request.getParameter("chinaname")?request.getParameter("chinaname"):"");
			bean.setEmail(null!=request.getParameter("email")?request.getParameter("email"):"");
			bean.setPhone(null!=request.getParameter("phone")?request.getParameter("phone"):"");
			bean.setDes(null!=request.getParameter("des")?request.getParameter("des"):"");
			bean.setRid(null!=request.getParameter("rid")?request.getParameter("rid"):"");
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
		Userinfo bean=new Userinfo();
		bean.setUsername(null!=request.getParameter("username")?request.getParameter("username"):"");
		
		Userinfo checkBean=service.getObjectByUser(bean);
		if(checkBean!=null) {
			json.put("status", false);
	        json.put("msg", "新增失败！用户名已存在！");
	        json.put("result", "1");
	        return json.toString();
		}
		
		bean.setId(null!=request.getParameter("id")?request.getParameter("id"):"");
		if(null!=request.getParameter("password")&&!"".equals(request.getParameter("password"))){
	    	
	    	String password=DigestUtils.md5Hex(request.getParameter("password"));
	    	password=DigestUtils.md5Hex(password);
	    	bean.setPassword(password);
	    	
	    }else{
	    	json.put("status", false);
	        json.put("msg", "新增失败！密码不能为空！");
	        json.put("result", "1");
	    }
		bean.setChinaname(null!=request.getParameter("chinaname")?request.getParameter("chinaname"):"");
		bean.setEmail(null!=request.getParameter("email")?request.getParameter("email"):"");
		bean.setPhone(null!=request.getParameter("phone")?request.getParameter("phone"):"");
		bean.setDes(null!=request.getParameter("des")?request.getParameter("des"):"");
		bean.setRid(null!=request.getParameter("rid")?request.getParameter("rid"):"");
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
			Userinfo bean=new Userinfo();
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
