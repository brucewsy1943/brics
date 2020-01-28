package com.xcz.object.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;
import com.xcz.object.model.Kgyxbinfo;
import com.xcz.object.service.KgyxbinfoService;
import com.xcz.object.util.DataGrid;
import com.xcz.object.util.ToolsUtil;
@RequestMapping("/kgyxbinfo")
@RestController
public class KgyxbinfoController {
	
	@Autowired
	private KgyxbinfoService service;
	

	@ResponseBody
	@RequestMapping(value="/getObjectList",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
	public DataGrid getObjectList(HttpServletRequest request){
		DataGrid dg=new DataGrid();
		String page = null!=request.getParameter("page")?request.getParameter("page"):"1";
		String rows = null!=request.getParameter("rows")?request.getParameter("rows"):"20";
		
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);		
		PageHelper.startPage(currentPage, pageSize, true);
		
		Kgyxbinfo bean=new Kgyxbinfo();
		bean.setType(!"".equals(request.getParameter("type"))?request.getParameter("type"):"");
		bean.setName(!"".equals(request.getParameter("name"))?"%"+request.getParameter("name")+"%":"");
		bean.setNum(!"".equals(request.getParameter("num"))?"%"+request.getParameter("num")+"%":"");
		bean.setDescription(!"".equals(request.getParameter("description"))?"%"+request.getParameter("description")+"%":"");
		bean.setModel(!"".equals(request.getParameter("model"))?"%"+request.getParameter("model")+"%":"");
		bean.setPrice(!"".equals(request.getParameter("price"))?"%"+request.getParameter("price")+"%":"");
		bean.setState(!"".equals(request.getParameter("state"))?"%"+request.getParameter("state")+"%":"");
		List<Kgyxbinfo> list=service.getObjectList(bean);
		
		PageInfo <Kgyxbinfo> pi = new PageInfo <Kgyxbinfo> (list);
		dg.setTotal(pi.getTotal());
		dg.setRows(pi.getList());
		
		return dg;
	}
	

	
	
	@ResponseBody
	@RequestMapping(value="/getObjectListByKj",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public DataGrid getObjectListByKj(HttpServletRequest request){
		DataGrid dg=new DataGrid();
		String page = null!=request.getParameter("page")?request.getParameter("page"):"1";
		String rows = null!=request.getParameter("rows")?request.getParameter("rows"):"20";
		
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);		
		PageHelper.startPage(currentPage, pageSize, true);
		
		Kgyxbinfo bean=new Kgyxbinfo();
		bean.setType(!"".equals(request.getParameter("type"))?request.getParameter("type"):"");
		bean.setRsv19(!"".equals(request.getParameter("name"))?"%"+request.getParameter("name")+"%":"");
		List<Kgyxbinfo> list=service.getObjectListByKj(bean);
		
		PageInfo <Kgyxbinfo> pi = new PageInfo <Kgyxbinfo> (list);
		dg.setTotal(pi.getTotal());
		dg.setRows(pi.getList());
		
		return dg;
	}
	
	@ResponseBody
	@RequestMapping(value="/getObjectListByMk",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public DataGrid getObjectListByMk(HttpServletRequest request){
		DataGrid dg=new DataGrid();
		String page = null!=request.getParameter("page")?request.getParameter("page"):"1";
		String rows = null!=request.getParameter("rows")?request.getParameter("rows"):"20";
		
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);		
		PageHelper.startPage(currentPage, pageSize, true);
		
		Kgyxbinfo bean=new Kgyxbinfo();
		bean.setType(!"".equals(request.getParameter("type"))?request.getParameter("type"):"");
		bean.setModel(!"".equals(request.getParameter("model"))?"%"+request.getParameter("model")+"%":"");
		List<Kgyxbinfo> list=service.getObjectListByMk(bean);
		
		PageInfo <Kgyxbinfo> pi = new PageInfo <Kgyxbinfo> (list);
		dg.setTotal(pi.getTotal());
		dg.setRows(pi.getList());
		
		return dg;
	}
	
	
	@ResponseBody
	@RequestMapping(value="/getObjectListByFl",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
	public DataGrid getObjectListByFl(HttpServletRequest request){
		DataGrid dg=new DataGrid();
		String page = null!=request.getParameter("page")?request.getParameter("page"):"1";
		String rows = null!=request.getParameter("rows")?request.getParameter("rows"):"20";
		
		int currentPage = Integer.parseInt(page);
		int	pageSize = Integer.parseInt(rows);		
		PageHelper.startPage(currentPage, pageSize, true);
		
		Kgyxbinfo bean=new Kgyxbinfo();
		bean.setType(!"".equals(request.getParameter("type"))?request.getParameter("type"):"");
		
		bean.setRsv2(!"null".equals(request.getParameter("rsv2"))&&!"".equals(request.getParameter("rsv2"))?request.getParameter("rsv2"):"");
		bean.setRsv4(!"null".equals(request.getParameter("rsv4"))&&!"".equals(request.getParameter("rsv4"))?request.getParameter("rsv4"):"");
		bean.setRsv6(!"null".equals(request.getParameter("rsv6"))&&!"".equals(request.getParameter("rsv6"))?request.getParameter("rsv6"):"");
		bean.setRsv8(!"null".equals(request.getParameter("rsv8"))&&!"".equals(request.getParameter("rsv8"))?request.getParameter("rsv8"):"");
		bean.setRsv10(!"null".equals(request.getParameter("rsv10"))&&!"".equals(request.getParameter("rsv10"))?request.getParameter("rsv10"):"");
		bean.setRsv12(!"null".equals(request.getParameter("rsv12"))&&!"".equals(request.getParameter("rsv12"))?request.getParameter("rsv12"):"");
		bean.setRsv14(!"null".equals(request.getParameter("rsv14"))&&!"".equals(request.getParameter("rsv14"))?request.getParameter("rsv14"):"");
		bean.setRsv16(!"null".equals(request.getParameter("rsv16"))&&!"".equals(request.getParameter("rsv16"))?request.getParameter("rsv16"):"");
		bean.setRsv18(!"null".equals(request.getParameter("rsv18"))&&!"".equals(request.getParameter("rsv18"))?request.getParameter("rsv18"):"");
		
		bean.setRsv3(!"".equals(request.getParameter("rsv3"))?"%"+request.getParameter("rsv3")+"%":"");
		bean.setRsv5(!"".equals(request.getParameter("rsv5"))?"%"+request.getParameter("rsv5")+"%":"");
		bean.setRsv7(!"".equals(request.getParameter("rsv7"))?"%"+request.getParameter("rsv7")+"%":"");
		bean.setRsv9(!"".equals(request.getParameter("rsv9"))?"%"+request.getParameter("rsv9")+"%":"");
		bean.setRsv11(!"".equals(request.getParameter("rsv11"))?"%"+request.getParameter("rsv11")+"%":"");
		bean.setRsv13(!"".equals(request.getParameter("rsv13"))?"%"+request.getParameter("rsv13")+"%":"");
		bean.setRsv15(!"".equals(request.getParameter("rsv15"))?"%"+request.getParameter("rsv15")+"%":"");
		bean.setRsv17(!"".equals(request.getParameter("rsv17"))?"%"+request.getParameter("rsv17")+"%":"");
		bean.setRsv19(!"".equals(request.getParameter("rsv19"))?"%"+request.getParameter("rsv19")+"%":"");
		
		
		
		List<Kgyxbinfo> list=service.getObjectListByFl(bean);
		
		PageInfo <Kgyxbinfo> pi = new PageInfo <Kgyxbinfo> (list);
		dg.setTotal(pi.getTotal());
		dg.setRows(pi.getList());
		
		return dg;
	}
	
	
	@ResponseBody  
	@RequestMapping(value="addObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String addObjectOnly(HttpServletRequest request){
		JSONObject json = new JSONObject();

			Kgyxbinfo bean=new Kgyxbinfo();
		    bean.setType(null!=request.getParameter("type")?request.getParameter("type"):"");
			bean.setName(null!=request.getParameter("name")?request.getParameter("name"):"");
			bean.setNum(null!=request.getParameter("num")?request.getParameter("num"):"");
			bean.setDescription(null!=request.getParameter("description")?request.getParameter("description"):"");
			bean.setModel(null!=request.getParameter("model")?request.getParameter("model"):"");
			bean.setPrice(null!=request.getParameter("price")?request.getParameter("price"):"");
			bean.setState(null!=request.getParameter("state")?request.getParameter("state"):"");
			bean.setDetails(null!=request.getParameter("details")?request.getParameter("details"):"");
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
				if(e.getCause() instanceof MySQLIntegrityConstraintViolationException) {
					json.put("status", false);
			        json.put("msg", "新增失败，细胞名称不能重复！");
			        json.put("result", "1");
				}else {
				
				    json.put("status", false);
		            json.put("msg", "新增失败！请联系系统管理员！");
		            json.put("result", "1");
				}
			}
			
		
		return json.toString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="/addObjectAll",produces="application/json;charset=UTF-8")
	public String  uploadFile(@RequestParam(value="upkgy")MultipartFile mf,HttpServletRequest request){
		JSONObject json = new JSONObject();
		try {
			//System.out.println("没有回去到文件名吗？");
	          boolean flag=service.addObjectAll(mf);
	          
	          if(flag){
	        	  json.put("status", true);
	  	          json.put("msg", "导入成功！");
	          }else{
	        	  json.put("status", false);
	  	          json.put("msg", "导入失败！上传的文件不正确！");
	          }
		}catch(Exception e) {
			e.printStackTrace();
			if(e.getCause() instanceof MySQLIntegrityConstraintViolationException) {
				json.put("status", false);
		        json.put("msg", "导入失败，细胞名称不能重复！");
			}else {
			
			    json.put("status", false);
	            json.put("msg", "导入失败！请联系系统管理员！");
			}
		}
		
		return json.toString();
	}
	
	@ResponseBody  
	@RequestMapping(value="updateObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String updateObjectOnly(HttpServletRequest request){
		 
		Kgyxbinfo bean=new Kgyxbinfo();
		bean.setId(null!=request.getParameter("id")?request.getParameter("id"):"");
		bean.setType(null!=request.getParameter("type")?request.getParameter("type"):"");
		bean.setName(null!=request.getParameter("name")?request.getParameter("name"):"");
		bean.setNum(null!=request.getParameter("num")?request.getParameter("num"):"");
		bean.setDescription(null!=request.getParameter("description")?request.getParameter("description"):"");
		bean.setModel(null!=request.getParameter("model")?request.getParameter("model"):"");
		bean.setPrice(null!=request.getParameter("price")?request.getParameter("price"):"");
		bean.setState(null!=request.getParameter("state")?request.getParameter("state"):"");
		bean.setDetails(null!=request.getParameter("details")?request.getParameter("details"):"");
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
	@RequestMapping(value="deleteObjectOnly", method=RequestMethod.POST, produces="application/json;charset=UTF-8") 
	public String deleteObjectOnly(HttpServletRequest request){
		
		JSONObject json = new JSONObject();
		try{
		String ids []=request.getParameter("ids").split(",");
		for(String id:ids){
			Kgyxbinfo bean=new Kgyxbinfo();
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
