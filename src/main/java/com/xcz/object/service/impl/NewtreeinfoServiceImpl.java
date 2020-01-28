package com.xcz.object.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcz.object.dao.localhostdao.NewtreeinfoDao;
import com.xcz.object.model.Newtreeinfo;
import com.xcz.object.service.NewtreeinfoService;
import com.xcz.object.util.DataGrid;

@Service
public class NewtreeinfoServiceImpl implements NewtreeinfoService {

	@Autowired
	private NewtreeinfoDao dao;

	@Override
	public List<Newtreeinfo> getObjectList(Newtreeinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectList(bean);
	}

	@Override
	public void addObjectOnly(Newtreeinfo bean) {
		// TODO Auto-generated method stub
		dao.addObjectOnly(bean);
	}

	@Override
	public void updateObjectOnly(Newtreeinfo bean) {
		// TODO Auto-generated method stub
		dao.updateObjectOnly(bean);
	}

	@Override
	public void deleteObjectOnly(Newtreeinfo bean) {
		// TODO Auto-generated method stub
		dao.deleteObjectOnly(bean);
	}

	
	public List<Newtreeinfo> getListByPid(Newtreeinfo bean){
		return dao.getListByPid(bean);
	}
	
	
	public DataGrid formateListDataGrid(int currentPage, int pageSize,Newtreeinfo bean){
		DataGrid dg = new DataGrid();
		
		PageHelper.startPage(currentPage, pageSize, true);//进行count查询，第三个參数设为true
		//List <Yy1swp> wpList = getwpTree(pid, getYy1swpByPId(pid));
		//先获取根节点列表
		bean.setPid("0");
		List <Newtreeinfo> wpPidList = getListByPid(bean);
		
		
		//对根节点进行分页
		PageInfo <Newtreeinfo> pi = new PageInfo <Newtreeinfo> (wpPidList);
		//根据根节点，获取到所有子节点树
		List <Newtreeinfo> wpTreeList = getwpTree(pi.getList(),bean);

		dg.setTotal(pi.getTotal());
		dg.setRows(wpTreeList);
		return dg;
	}
	
	
	private List < Newtreeinfo > getwpTree(List <Newtreeinfo> wplist,Newtreeinfo bean){
    	List  <Newtreeinfo>  allwp = getObjectList(bean);
    	List <Newtreeinfo> TreeList = new ArrayList<Newtreeinfo>();
		List <Integer> pidgroup = new ArrayList <Integer> ();
		// 将获取到的系统菜单list的父节点放入一个list里面，方便后面判断是否有子节点
		for (Newtreeinfo tmpWP : allwp) {
			pidgroup.add(Integer.parseInt(tmpWP.getPid()));
		}
		
		//保证子节点的状态是close的
		for (Newtreeinfo tmpWP : allwp) {
			if (pidgroup.contains(Integer.parseInt(tmpWP.getId()))) {
				//如果父节点ID群中，包含当前菜单的ID，我们认为当前菜单有子菜单
					tmpWP.setState("closed");
				} else {
					tmpWP.setState("open");
				}
		}

		for(Newtreeinfo tmpWP : wplist){
			int pid = Integer.parseInt(tmpWP.getId());
			//保证最高父节点的状态是closed的
			if(pidgroup.contains(pid)){
				tmpWP.setState("closed");
			}else {
				tmpWP.setState("open");
			}
			//查找当前节点的所有下属子节点
			tmpWP.setChildren(getFormatTree(pid, allwp));
			//将该节点添加到list列表
			TreeList.add(tmpWP);
		}
		
		//int pid = 0;
		//TreeList = getFormatTree(pid, allwp);
		return TreeList;
    }
	
	private List <Newtreeinfo> getFormatTree(int pId,
			List<Newtreeinfo> treesList) {
		List<Newtreeinfo> newTrees = new ArrayList<Newtreeinfo>();
		for (Newtreeinfo TreeNode : treesList) {
			if (pId == Integer.parseInt(TreeNode.getPid())) {
				// 递归获取最高父节点下的子节点
				TreeNode.setChildren(getChildrenNode(Integer.parseInt(TreeNode.getId()),
						treesList));
				newTrees.add(TreeNode);
			}
		}
		return newTrees;
	}
    
	/**
	 * 递归获取子节点下的子节点
	 * 
	 * @param pId
	 *            父节点的ID
	 * @param wpList
	 *            所有菜单树集合
	 * @return 所有子树所组成的List
	 */
	private List <Newtreeinfo> getChildrenNode(int pId, List<Newtreeinfo> list) {

		List<Newtreeinfo> treeList = new ArrayList <Newtreeinfo>();
		for (Newtreeinfo TreeNode : list) {
			if (Integer.parseInt(TreeNode.getPid()) == pId) {
				// 递归获取子节点下的子节点，即设置树控件中的children
				TreeNode.setChildren(getChildrenNode(Integer.parseInt(TreeNode.getId()), list));
				treeList.add(TreeNode);
			}
		}
		return treeList;
	}

	@Override
	public void updateIsFb(Newtreeinfo bean) {
		// TODO Auto-generated method stub
	    dao.updateIsFb(bean);
	}

	@Override
	public List<Newtreeinfo> getTrees(Newtreeinfo bean) {
		// TODO Auto-generated method stub
		return dao.getTrees(bean);
	}

	@Override
	public List<Newtreeinfo> getObjectListIsFb(Newtreeinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectListIsFb(bean);
	}

	@Override
	public List<Newtreeinfo> getObjectListIsFbByPid(Newtreeinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectListIsFbByPid(bean);
	}

	@Override
	public Newtreeinfo getObjectById(Newtreeinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectById(bean);
	}

	
}
