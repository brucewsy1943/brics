package com.xcz.object.service;

import java.util.List;

import com.xcz.object.model.Newtreeinfo;
import com.xcz.object.util.DataGrid;



public interface NewtreeinfoService {

	public List<Newtreeinfo> getObjectList(Newtreeinfo bean);
	public List<Newtreeinfo> getObjectListIsFb(Newtreeinfo bean);
	public List<Newtreeinfo> getObjectListIsFbByPid(Newtreeinfo bean);
	public List<Newtreeinfo> getTrees(Newtreeinfo bean);
	public void addObjectOnly(Newtreeinfo bean);
	public void updateObjectOnly(Newtreeinfo bean);
	public void deleteObjectOnly(Newtreeinfo bean);
	
	public Newtreeinfo getObjectById(Newtreeinfo bean);
	
	public DataGrid formateListDataGrid(int currentPage, int pageSize,Newtreeinfo bean);
	public List<Newtreeinfo> getListByPid(Newtreeinfo bean);
	
	
	public void updateIsFb(Newtreeinfo bean);
}
