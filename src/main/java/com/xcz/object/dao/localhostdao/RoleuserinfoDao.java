package com.xcz.object.dao.localhostdao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.xcz.object.model.Roleuserinfo;

@Mapper
public interface RoleuserinfoDao {
	
	public List<Roleuserinfo> getObjectList(Roleuserinfo bean);
	public List<Roleuserinfo> getListByPid(Roleuserinfo bean);
	
	public List<Roleuserinfo> getObjectByRoleuser(Roleuserinfo bean);

	
	public void addObjectOnly(Roleuserinfo bean);
	public void updateObjectOnly(Roleuserinfo bean);
	public void deleteObjectOnly(Roleuserinfo bean);
	public void deleteObjectByrole(Roleuserinfo bean);
	

}
