package com.xcz.object.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcz.object.dao.localhostdao.RoleinfoDao;
import com.xcz.object.model.Roleinfo;
import com.xcz.object.service.RoleinfoService;

@Service
public class RoleinfoServiceImpl implements RoleinfoService {

	@Autowired
	private RoleinfoDao dao;

	@Override
	public List<Roleinfo> getObjectList(Roleinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectList(bean);
	}

	@Override
	public void addObjectOnly(Roleinfo bean) {
		// TODO Auto-generated method stub
		dao.addObjectOnly(bean);
	}

	@Override
	public void updateObjectOnly(Roleinfo bean) {
		// TODO Auto-generated method stub
		dao.updateObjectOnly(bean);
	}

	@Override
	public void deleteObjectOnly(Roleinfo bean) {
		// TODO Auto-generated method stub
		dao.deleteObjectOnly(bean);
	}

	@Override
	public List<Roleinfo> getObjectByRole(Roleinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectByRole(bean);
	}

	
}
