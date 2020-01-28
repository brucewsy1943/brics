package com.xcz.object.model;

import java.util.ArrayList;
import java.util.List;

public class Menuinfo {

	private String id;
	private String text;
	private String menuType;
	public String getMenuType() {
		return menuType;
	}
	public void setMenuType(String menuType) {
		this.menuType = menuType;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getIconCls() {
		return iconCls;
	}
	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}

	private String pid;
	private String iconCls;
	private String state;
	private String url;
	public String getUrl1() {
		return url1;
	}
	public void setUrl1(String url1) {
		this.url1 = url1;
	}
	public String getMaxImg() {
		return maxImg;
	}
	public void setMaxImg(String maxImg) {
		this.maxImg = maxImg;
	}

	private String url1;
	private String maxImg;
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	private String checked;
	private String create_time;
	private String num;
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getIsFb() {
		return isFb;
	}
	public void setIsFb(String isFb) {
		this.isFb = isFb;
	}

	private String isFb;

	public List<Menuinfo> getChildren() {
		return children;
	}
	public void setChildren(List<Menuinfo> children) {
		this.children = children;
	}
	
	private List<Menuinfo> children=new ArrayList<Menuinfo>();
	private String rsv10;
	private String rsv11;
	private String rsv12;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	private String rsv13;
	private String rsv14;
	private String rsv15;
	private String rsv16;
	public String getRsv10() {
		return rsv10;
	}
	public void setRsv10(String rsv10) {
		this.rsv10 = rsv10;
	}
	public String getRsv11() {
		return rsv11;
	}
	public void setRsv11(String rsv11) {
		this.rsv11 = rsv11;
	}
	public String getRsv12() {
		return rsv12;
	}
	public void setRsv12(String rsv12) {
		this.rsv12 = rsv12;
	}
	public String getRsv13() {
		return rsv13;
	}
	public void setRsv13(String rsv13) {
		this.rsv13 = rsv13;
	}
	public String getRsv14() {
		return rsv14;
	}
	public void setRsv14(String rsv14) {
		this.rsv14 = rsv14;
	}
	public String getRsv15() {
		return rsv15;
	}
	public void setRsv15(String rsv15) {
		this.rsv15 = rsv15;
	}
	public String getRsv16() {
		return rsv16;
	}
	public void setRsv16(String rsv16) {
		this.rsv16 = rsv16;
	}
	public String getRsv17() {
		return rsv17;
	}
	public void setRsv17(String rsv17) {
		this.rsv17 = rsv17;
	}
	public String getRsv18() {
		return rsv18;
	}
	public void setRsv18(String rsv18) {
		this.rsv18 = rsv18;
	}
	public String getRsv19() {
		return rsv19;
	}
	public void setRsv19(String rsv19) {
		this.rsv19 = rsv19;
	}
	public String getRsv20() {
		return rsv20;
	}
	public void setRsv20(String rsv20) {
		this.rsv20 = rsv20;
	}

	private String rsv17;
	private String rsv18;
	private String rsv19;
	private String rsv20;
	
	
}
