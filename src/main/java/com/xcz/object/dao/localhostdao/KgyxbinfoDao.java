package com.xcz.object.dao.localhostdao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xcz.object.model.Kgyxbinfo;

@Mapper
public interface KgyxbinfoDao {
	
	public List<Kgyxbinfo> getObjectList(Kgyxbinfo bean);
	public List<Kgyxbinfo> getObjectListByKj(Kgyxbinfo bean);
	public List<Kgyxbinfo> getObjectListByFl(Kgyxbinfo bean);
	public List<Kgyxbinfo> getObjectListByMk(Kgyxbinfo bean);
	
	public Kgyxbinfo getObjectByUser(Kgyxbinfo bean);
	
	
	public void addObjectOnly(Kgyxbinfo bean);
	public void updateObjectOnly(Kgyxbinfo bean);
	public void deleteObjectOnly(Kgyxbinfo bean);

}
