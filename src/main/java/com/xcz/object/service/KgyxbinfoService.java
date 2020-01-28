package com.xcz.object.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.xcz.object.model.Kgyxbinfo;



public interface KgyxbinfoService {

	public List<Kgyxbinfo> getObjectList(Kgyxbinfo bean);
	public List<Kgyxbinfo> getObjectListByKj(Kgyxbinfo bean);
	public List<Kgyxbinfo> getObjectListByFl(Kgyxbinfo bean);
	public List<Kgyxbinfo> getObjectListByMk(Kgyxbinfo bean);
	public Kgyxbinfo getObjectByUser(Kgyxbinfo bean);
	public void addObjectOnly(Kgyxbinfo bean);
	public void updateObjectOnly(Kgyxbinfo bean);
	public void deleteObjectOnly(Kgyxbinfo bean);
	public boolean addObjectAll(MultipartFile file) throws Exception;
}
