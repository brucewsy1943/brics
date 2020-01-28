package com.xcz.object.service;

import java.util.List;

import com.xcz.object.model.Newsinfo;



public interface NewsinfoService {

	public List<Newsinfo> getObjectList(Newsinfo bean);
	public List<Newsinfo> getObjectListIsFb(Newsinfo bean);
	public Newsinfo getObjectByUser(Newsinfo bean);
	public Newsinfo getObjectById(Newsinfo bean);
	public void addObjectOnly(Newsinfo bean);
	public void updateObjectOnly(Newsinfo bean);
	public void deleteObjectOnly(Newsinfo bean);
	public void updateIsFb(Newsinfo bean);
}
