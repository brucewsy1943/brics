/**
 * 
 */
package com.xcz.object.util;

import java.util.List;

/**
 * @author xczhang1
 *
 */
public class DataGrid {

	private long total;	// 总记录数
	private List < ? > rows;	// 每行记录
	/**
	 * @return the total
	 */
	public long getTotal() {
		return total;
	}
	/**
	 * @param total the total to set
	 */
	public void setTotal(long total) {
		this.total = total;
	}
	/**
	 * @return the rows
	 */
	public List<?> getRows() {
		return rows;
	}
	/**
	 * @param rows the rows to set
	 */
	public void setRows(List<?> rows) {
		this.rows = rows;
	}

}
