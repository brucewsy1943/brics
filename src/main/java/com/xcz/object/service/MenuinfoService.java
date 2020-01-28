package com.xcz.object.service;

import java.util.List;

import com.xcz.object.model.Menuinfo;
import com.xcz.object.util.DataGrid;



public interface MenuinfoService {

	public List<Menuinfo> getObjectList(Menuinfo bean);
	public List<Menuinfo> getObjectListByRole(Menuinfo bean);
	public Menuinfo getObjectById(Menuinfo bean);
	public List<Menuinfo> getMenuS(Menuinfo bean);
	public void addObjectOnly(Menuinfo bean);
	public void updateObjectOnly(Menuinfo bean);
	public void deleteObjectOnly(Menuinfo bean);
	
	public DataGrid formateListDataGrid(int currentPage, int pageSize);
	public List<Menuinfo> getListByPid(Menuinfo bean);
	
	
	public void updateIsFb(Menuinfo bean);
}
