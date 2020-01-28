package com.xcz.object.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.xcz.object.model.Userinfo;
import com.xcz.object.service.UserinfoService;
@RequestMapping("/")
@RestController
public class LoginController {
	
	@Autowired
	private UserinfoService service;

	@RequestMapping(value="/getLogin",method = RequestMethod.POST)
	public ModelAndView getLogin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		try {
			if(null!=request.getParameter("password")&&null!=request.getParameter("username")&&
					   !"".equals(request.getParameter("password"))&&!"".equals(request.getParameter("username"))){
						Userinfo bean=new Userinfo();
						
						bean.setUsername(request.getParameter("username"));
						Userinfo user=service.getObjectByUser(bean);
						
						String password=DigestUtils.md5Hex(request.getParameter("password"));
						password=DigestUtils.md5Hex(password);
						if(null!=user&&user.getPassword().equals(password)){
							request.getSession().setAttribute("user", bean.getUsername());
							mv.setViewName("/fun/main");
							mv.addObject("user", user.getUsername());
							mv.addObject("role", user.getRid());
						}else{
							mv.setViewName("login");
							mv.addObject("msg", "请输入正确的用户和密码");
						}
					}else{
						mv.setViewName("login");
						mv.addObject("msg", "用户名和密码不能为空");
					}
		} catch (Exception e2) {
			mv.setViewName("login");
			mv.addObject("msg", "系统异常，请联系管理员");
		}
		
        return mv;
		
	}
	
	

	@RequestMapping(value="/exitLogin",method = RequestMethod.GET)
	public ModelAndView exitLogin(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv=new ModelAndView();
		mv.setViewName("login");
		mv.addObject("msg", "您已安全退出登录");
		request.getSession().removeAttribute("user");
		request.getSession().removeAttribute("msg");
		
		return mv;
		
	}

	
	
}
