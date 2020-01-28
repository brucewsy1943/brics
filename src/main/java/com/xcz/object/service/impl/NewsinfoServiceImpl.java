package com.xcz.object.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xcz.object.dao.localhostdao.NewsinfoDao;
import com.xcz.object.model.Newsinfo;
import com.xcz.object.service.NewsinfoService;

@Service
public class NewsinfoServiceImpl implements NewsinfoService {

	@Autowired
	private NewsinfoDao dao;

	@Override
	public List<Newsinfo> getObjectList(Newsinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectList(bean);
	}

	@Override
	public void addObjectOnly(Newsinfo bean) {
		// TODO Auto-generated method stub
		dao.addObjectOnly(bean);
	}

	@Override
	public void updateObjectOnly(Newsinfo bean) {
		// TODO Auto-generated method stub
		dao.updateObjectOnly(bean);
	}

	@Override
	public void deleteObjectOnly(Newsinfo bean) {
		// TODO Auto-generated method stub
		dao.deleteObjectOnly(bean);
	}

	@Override
	public Newsinfo getObjectByUser(Newsinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectByUser(bean);
	}

	@Override
	public void updateIsFb(Newsinfo bean) {
		// TODO Auto-generated method stub
		dao.updateIsFb(bean);
	}

	@Override
	public List<Newsinfo> getObjectListIsFb(Newsinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectListIsFb(bean);
	}

	@Override
	public Newsinfo getObjectById(Newsinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectById(bean);
	}

	
}
