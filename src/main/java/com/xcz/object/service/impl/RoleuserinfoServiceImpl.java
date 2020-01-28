package com.xcz.object.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xcz.object.dao.localhostdao.RoleuserinfoDao;
import com.xcz.object.model.Roleuserinfo;
import com.xcz.object.service.RoleuserinfoService;
import com.xcz.object.util.DataGrid;

@Service
public class RoleuserinfoServiceImpl implements RoleuserinfoService {

	@Autowired
	private RoleuserinfoDao dao;

	@Override
	public List<Roleuserinfo> getObjectList(Roleuserinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectList(bean);
	}

	@Override
	public void addObjectOnly(Roleuserinfo bean) {
		// TODO Auto-generated method stub
		dao.addObjectOnly(bean);
	}

	@Override
	public void updateObjectOnly(Roleuserinfo bean) {
		// TODO Auto-generated method stub
		dao.updateObjectOnly(bean);
	}

	@Override
	public void deleteObjectOnly(Roleuserinfo bean) {
		// TODO Auto-generated method stub
		dao.deleteObjectOnly(bean);
	}

	@Override
	public List<Roleuserinfo> getObjectByRoleuser(Roleuserinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectByRoleuser(bean);
	}

	@Override
	public void deleteObjectByrole(Roleuserinfo bean) {
		// TODO Auto-generated method stub
		dao.deleteObjectByrole(bean);
	}
	
	
	public DataGrid formateListDataGrid(int currentPage, int pageSize,String role_id){
		DataGrid dg = new DataGrid();
		
		PageHelper.startPage(currentPage, pageSize, true);//进行count查询，第三个參数设为true
		//List <Yy1swp> wpList = getwpTree(pid, getYy1swpByPId(pid));
		//先获取根节点列表
		Roleuserinfo b=new Roleuserinfo();
		b.setPid("1");
		b.setRid(role_id);
		List <Roleuserinfo> wpPidList =getListByPid(b);
		
		
		//对根节点进行分页
		PageInfo <Roleuserinfo> pi = new PageInfo <Roleuserinfo> (wpPidList);
		//根据根节点，获取到所有子节点树
		List <Roleuserinfo> wpTreeList = getwpTree(pi.getList(),role_id );

		dg.setTotal(pi.getTotal());
		dg.setRows(wpTreeList);
		return dg;
	}
	
	
	private List < Roleuserinfo > getwpTree(List <Roleuserinfo> wplist,String role_id){
		Roleuserinfo bean=new Roleuserinfo();
		bean.setRid(role_id);
    	List  <Roleuserinfo>  allwp = getObjectList(bean);
    	List <Roleuserinfo> TreeList = new ArrayList<Roleuserinfo>();
		List <Integer> pidgroup = new ArrayList <Integer> ();
		// 将获取到的系统菜单list的父节点放入一个list里面，方便后面判断是否有子节点
		for (Roleuserinfo tmpWP : allwp) {
			pidgroup.add(Integer.parseInt(tmpWP.getPid()));
		}
		
		//保证子节点的状态是close的
		for (Roleuserinfo tmpWP : allwp) {
			if (pidgroup.contains(Integer.parseInt(tmpWP.getMid()))) {
				//如果父节点ID群中，包含当前菜单的ID，我们认为当前菜单有子菜单
					tmpWP.setState("closed");
				} else {
					tmpWP.setState("open");
				}
		}

		for(Roleuserinfo tmpWP : wplist){
			int pid = Integer.parseInt(tmpWP.getMid());
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
	
	private List <Roleuserinfo> getFormatTree(int pId,
			List<Roleuserinfo> treesList) {
		List<Roleuserinfo> newTrees = new ArrayList<Roleuserinfo>();
		for (Roleuserinfo TreeNode : treesList) {
			if (pId == Integer.parseInt(TreeNode.getPid())) {
				// 递归获取最高父节点下的子节点
				TreeNode.setChildren(getChildrenNode(Integer.parseInt(TreeNode.getMid()),
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
	private List <Roleuserinfo> getChildrenNode(int pId, List<Roleuserinfo> list) {

		List<Roleuserinfo> treeList = new ArrayList <Roleuserinfo>();
		for (Roleuserinfo TreeNode : list) {
			if (Integer.parseInt(TreeNode.getPid()) == pId) {
				// 递归获取子节点下的子节点，即设置树控件中的children
				TreeNode.setChildren(getChildrenNode(Integer.parseInt(TreeNode.getMid()), list));
				treeList.add(TreeNode);
			}
		}
		return treeList;
	}

	@Override
	public List<Roleuserinfo> getListByPid(Roleuserinfo bean) {
		// TODO Auto-generated method stub
		return dao.getListByPid(bean);
	}

	
}
