package com.xcz.object.service;

import java.util.List;

import com.xcz.object.model.Roleuserinfo;
import com.xcz.object.util.DataGrid;



public interface RoleuserinfoService {

	public List<Roleuserinfo> getObjectList(Roleuserinfo bean);
	public List<Roleuserinfo> getListByPid(Roleuserinfo bean);
	public List<Roleuserinfo> getObjectByRoleuser(Roleuserinfo bean);
	public DataGrid formateListDataGrid(int currentPage, int pageSize,String role_id);
	public void addObjectOnly(Roleuserinfo bean);
	public void updateObjectOnly(Roleuserinfo bean);
	public void deleteObjectOnly(Roleuserinfo bean);
	public void deleteObjectByrole(Roleuserinfo bean);
}
