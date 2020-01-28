package com.xcz.object.service.impl;

import java.io.InputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.xcz.object.dao.localhostdao.KgyxbinfoDao;
import com.xcz.object.model.Kgyxbinfo;
import com.xcz.object.service.KgyxbinfoService;
import com.xcz.object.util.ToolsUtil;

@Service
public class KgyxbinfoServiceImpl implements KgyxbinfoService {

	@Autowired
	private KgyxbinfoDao dao;

	@Override
	public List<Kgyxbinfo> getObjectList(Kgyxbinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectList(bean);
	}

	@Override
	public void addObjectOnly(Kgyxbinfo bean) {
		// TODO Auto-generated method stub
		dao.addObjectOnly(bean);
	}

	@Override
	public void updateObjectOnly(Kgyxbinfo bean) {
		// TODO Auto-generated method stub
		dao.updateObjectOnly(bean);
	}

	@Override
	public void deleteObjectOnly(Kgyxbinfo bean) {
		// TODO Auto-generated method stub
		dao.deleteObjectOnly(bean);
	}

	@Override
	public Kgyxbinfo getObjectByUser(Kgyxbinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectByUser(bean);
	}
	
	@Override
	public boolean addObjectAll(MultipartFile file) throws Exception {
		// TODO Auto-generated method stub
		//dao.addObjectOnly(bean);
		DecimalFormat df = new DecimalFormat("0");
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		boolean notNull=true;//判断Excel文件是否有内容
		String filename=file.getOriginalFilename();
		
		if (!filename.matches("^.+\\.(?i)(xls)$") && !filename.matches("^.+\\.(?i)(xlsx)$")) {
            //throw new Exception("上传文件格式不正确");
			notNull=false;
        }
		//判断Excel文件的版本
		boolean isExcel2003=true;
        if (filename.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
	         InputStream is = file.getInputStream();
	         Workbook wb=null;	    
	         if (isExcel2003) {
		         wb = new HSSFWorkbook(is);
		     } else {
			     wb = new XSSFWorkbook(is);
			 }

	         //获取Excel文件的第一页sheet，判断是否有信息
		     Sheet sheet=wb.getSheetAt(0);
		     if(sheet!=null){
		    	notNull=true;
		     }
		     int rowNum=sheet.getLastRowNum()+1;
				for(int i=1;i<rowNum;i++){
					Kgyxbinfo bean=new Kgyxbinfo();
					Row row=sheet.getRow(i);
					int cellNum=row.getLastCellNum();
					 for(int j=0;j<cellNum;j++){
						 Cell cell=row.getCell(j);
						 String cellValue=null;
						 switch (cell.getCellType()) {
						  case 0:
							  if(HSSFDateUtil.isCellDateFormatted(cell)){
								//用于转化为日期格式
								cellValue = sdf.format(cell.getDateCellValue());
							  }else{
							  cellValue=df.format(cell.getNumericCellValue());
							  };break;
						  case 1:cellValue=cell.getStringCellValue();break;
						  case 2:cellValue=sdf.format(cell.getDateCellValue());break;
						  case 3:cellValue="";break;
						  case 4:cellValue=String.valueOf(cell.getBooleanCellValue());break;
						  case 5:cellValue=String.valueOf(cell.getErrorCellValue());break;
						 }
						 
						 
						 switch (j) {
						// case 0:;break;
						 case 0:bean.setType(cellValue==null?"":cellValue);break;
						 case 1:bean.setName(cellValue==null?"":cellValue);break;
						 case 2:bean.setNum(cellValue==null?"":cellValue);break;
						 case 3:bean.setDescription(cellValue==null?"":cellValue);break;
						 case 4:bean.setModel(cellValue==null?"":cellValue);break;
						 case 5:bean.setPrice(cellValue==null?"":cellValue);break;
						 case 6:bean.setState(cellValue==null?"":cellValue);break;
						 case 7:bean.setDetails(cellValue==null?"":cellValue);break;
						
						 }
					 }
					 bean.setRsv20(ToolsUtil.getDateAndTime());
					// System.out.println("name:"+bean.getName());
					 if(bean.getName()!=null&&!"".equals(bean.getName())) {
						 dao.addObjectOnly(bean);
					 }
					
					 
					}

	
	    return notNull;
	
	}

	@Override
	public List<Kgyxbinfo> getObjectListByKj(Kgyxbinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectListByKj(bean);
	}

	@Override
	public List<Kgyxbinfo> getObjectListByFl(Kgyxbinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectListByFl(bean);
	}

	@Override
	public List<Kgyxbinfo> getObjectListByMk(Kgyxbinfo bean) {
		// TODO Auto-generated method stub
		return dao.getObjectListByMk(bean);
	}

	
}
