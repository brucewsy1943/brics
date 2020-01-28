package com.xcz.object.util;

import java.util.ArrayList;
import java.util.List;

import com.xcz.object.model.Newtreeinfo;


public class NewTree {

	private List<Newtreeinfo> treeNodeList = new ArrayList<Newtreeinfo>();

	public NewTree(List<Newtreeinfo> list){
	treeNodeList = list;
	//System.out.println("treeNodeList的个数："+treeNodeList.size());
	}

	/**s
	* 
	* @param nodeId
	* @return
	*/
	public Newtreeinfo getNodeById(String nodeId){
		Newtreeinfo treeNode = new Newtreeinfo();
	for (Newtreeinfo item : treeNodeList) {
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
	public List<Newtreeinfo> getChildrenNodeById(String nodeId){
	List<Newtreeinfo> childrenTreeNode = new ArrayList<Newtreeinfo>();
	for (Newtreeinfo item : treeNodeList) {
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
	public Newtreeinfo generateTreeNode(String rootId){
		Newtreeinfo root = this.getNodeById(rootId);
	    List<Newtreeinfo> childrenTreeNode = this.getChildrenNodeById(rootId);
    	for (Newtreeinfo item : childrenTreeNode) {
		    Newtreeinfo node =this.generateTreeNode(item.getId()) ;
	        root.getChildren().add(node);
	    }
	  return root;
	}
	
	/**
	* 递归生成Tree结构数据
	* @param rootId
	* @return
	*/
	public Newtreeinfo generateTreeBean(String rootId){
		
		Newtreeinfo root = this.getNodeById(rootId);
		
	    List<Newtreeinfo> childrenTreeNode = this.getChildrenNodeById(rootId);
    	for (Newtreeinfo item : childrenTreeNode) {
		    Newtreeinfo node =this.generateTreeNode(item.getId()) ;
	        root.getChildren().add(node);
	    }
	   return root;
    	//return tree;
	}
	
}
