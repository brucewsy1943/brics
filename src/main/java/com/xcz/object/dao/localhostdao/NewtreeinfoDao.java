package com.xcz.object.dao.localhostdao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xcz.object.model.Newtreeinfo;

@Mapper
public interface NewtreeinfoDao {
	
	public List<Newtreeinfo> getObjectList(Newtreeinfo bean);
	public List<Newtreeinfo> getObjectListIsFb(Newtreeinfo bean);
	public List<Newtreeinfo> getObjectListIsFbByPid(Newtreeinfo bean);
	
	
	
	
	public List<Newtreeinfo> getTrees(Newtreeinfo bean);
	public Newtreeinfo getObjectByUser(Newtreeinfo bean);
	
	public Newtreeinfo getObjectById(Newtreeinfo bean);
	
	
	public void addObjectOnly(Newtreeinfo bean);
	public void updateObjectOnly(Newtreeinfo bean);
	public void deleteObjectOnly(Newtreeinfo bean);
	public void updateIsFb(Newtreeinfo bean);
	public List<Newtreeinfo> getListByPid(Newtreeinfo bean);
	
	

}
