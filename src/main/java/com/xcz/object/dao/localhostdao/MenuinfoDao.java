package com.xcz.object.dao.localhostdao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xcz.object.model.Menuinfo;

@Mapper
public interface MenuinfoDao {
	
	public List<Menuinfo> getObjectList(Menuinfo bean);
	public List<Menuinfo> getObjectListByRole(Menuinfo bean);
	
	
	public Menuinfo getObjectById(Menuinfo bean);
	public List<Menuinfo> getMenuS(Menuinfo bean);
	
	public void addObjectOnly(Menuinfo bean);
	public void updateObjectOnly(Menuinfo bean);
	public void deleteObjectOnly(Menuinfo bean);
	public List<Menuinfo> getListByPid(Menuinfo bean);
	public void updateIsFb(Menuinfo bean);
	
	
	
	
	

}
