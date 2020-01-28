package com.xcz.object.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcz.object.dao.localhostdao.UserinfoDao;
import com.xcz.object.model.Userinfo;
import com.xcz.object.service.UserinfoService;

@Service
public class UserinfoServiceImpl implements UserinfoService {

	@Autowired
	private UserinfoDao dao;

	@Override
	public List<Userinfo> getObjectList(Userinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectList(bean);
	}

	@Override
	public void addObjectOnly(Userinfo bean) {
		// TODO Auto-generated method stub
		dao.addObjectOnly(bean);
	}

	@Override
	public void updateObjectOnly(Userinfo bean) {
		// TODO Auto-generated method stub
		dao.updateObjectOnly(bean);
	}

	@Override
	public void deleteObjectOnly(Userinfo bean) {
		// TODO Auto-generated method stub
		dao.deleteObjectOnly(bean);
	}

	@Override
	public Userinfo getObjectByUser(Userinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectByUser(bean);
	}

	@Override
	public void deleteObjectByRsv7(Userinfo bean) {
		// TODO Auto-generated method stub
		dao.deleteObjectByRsv7(bean);
	}

	
}
