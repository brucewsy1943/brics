package com.xcz.object.dao.localhostdao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xcz.object.model.Roleinfo;

@Mapper
public interface RoleinfoDao {
	
	public List<Roleinfo> getObjectList(Roleinfo bean);
	public List<Roleinfo> getObjectByRole(Roleinfo bean);

	
	public void addObjectOnly(Roleinfo bean);
	public void updateObjectOnly(Roleinfo bean);
	public void deleteObjectOnly(Roleinfo bean);

}
