package com.xcz.object.dao.localhostdao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xcz.object.model.Userinfo;

@Mapper
public interface UserinfoDao {
	
	public List<Userinfo> getObjectList(Userinfo bean);
	public Userinfo getObjectByUser(Userinfo bean);
	
	
	public void addObjectOnly(Userinfo bean);
	public void updateObjectOnly(Userinfo bean);
	public void deleteObjectOnly(Userinfo bean);
	public void deleteObjectByRsv7(Userinfo bean);
	

}
