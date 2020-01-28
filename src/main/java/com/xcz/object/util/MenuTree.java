package com.xcz.object.util;

import java.util.ArrayList;
import java.util.List;

import com.xcz.object.model.Menuinfo;


public class MenuTree {

	private List<Menuinfo> treeNodeList = new ArrayList<Menuinfo>();

	public MenuTree(List<Menuinfo> list){
	treeNodeList = list;
	//System.out.println("treeNodeList的个数："+treeNodeList.size());
	}

	/**s
	* 
	* @param nodeId
	* @return
	*/
	public Menuinfo getNodeById(String nodeId){
		Menuinfo treeNode = new Menuinfo();
	for (Menuinfo item : treeNodeList) {
	if (item.getId().equals(nodeId) ) {
	treeNode = item;
	break;
	}
	}
	return treeNode;
	}

	/**
	* 
	* @param nodeId
	* @return
	*/
	public List<Menuinfo> getChildrenNodeById(String nodeId){
	List<Menuinfo> childrenTreeNode = new ArrayList<Menuinfo>();
	for (Menuinfo item : treeNodeList) {
	if(item.getPid().equals(nodeId)){
	childrenTreeNode.add(item);
	}
	}
	return childrenTreeNode;
	}

	/**
	* 递归生成Tree结构数据
	* @param rootId
	* @return
	*/
	public Menuinfo generateTreeNode(String rootId){
		Menuinfo root = this.getNodeById(rootId);
	    List<Menuinfo> childrenTreeNode = this.getChildrenNodeById(rootId);
    	for (Menuinfo item : childrenTreeNode) {
		    Menuinfo node =this.generateTreeNode(item.getId()) ;
	        root.getChildren().add(node);
	    }
	  return root;
	}
	
	/**
	* 递归生成Tree结构数据
	* @param rootId
	* @return
	*/
	public Menuinfo generateTreeBean(String rootId){
		
		Menuinfo root = this.getNodeById(rootId);
		
	    List<Menuinfo> childrenTreeNode = this.getChildrenNodeById(rootId);
    	for (Menuinfo item : childrenTreeNode) {
		    Menuinfo node =this.generateTreeNode(item.getId()) ;
	        root.getChildren().add(node);
	    }
	   return root;
    	//return tree;
	}
	
}
