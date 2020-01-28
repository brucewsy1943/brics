package com.xcz.object.service;

import java.util.List;

import com.xcz.object.model.Userinfo;



public interface UserinfoService {

	public List<Userinfo> getObjectList(Userinfo bean);
	public Userinfo getObjectByUser(Userinfo bean);
	public void addObjectOnly(Userinfo bean);
	public void updateObjectOnly(Userinfo bean);
	public void deleteObjectOnly(Userinfo bean);
	public void deleteObjectByRsv7(Userinfo bean);
}
