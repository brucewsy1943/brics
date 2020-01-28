package com.xcz.object.service;

import java.util.List;

import com.xcz.object.model.Roleinfo;



public interface RoleinfoService {

	public List<Roleinfo> getObjectList(Roleinfo bean);
	public List<Roleinfo> getObjectByRole(Roleinfo bean);
	public void addObjectOnly(Roleinfo bean);
	public void updateObjectOnly(Roleinfo bean);
	public void deleteObjectOnly(Roleinfo bean);
}
