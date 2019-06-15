/*package com.lara.report;

import java.util.Map;
import com.lara.beans.Emp;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

public class ExcelEmpListReportView extends AbstractXlsView
{

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest req,
			HttpServletResponse res) throws Exception {
		res.setHeader("Content-disposition", "attachment; filename=\"user_list.xls\"");
		List<Emp> list = (List<Emp>) model.get("list");
		Sheet sheet = workbook.createSheet("Emp List");
		  
		Row header = sheet.createRow(0);
		header.createCell(0).setCellValue("id");
		header.createCell(1).setCellValue("name");
		header.createCell(2).setCellValue("salary");
		header.createCell(3).setCellValue("designation");
		
		int rowNum = 1;
		  
		  for(Emp emp : list){
		   Row row = sheet.createRow(rowNum++);
		   row.createCell(0).setCellValue(String.valueOf(emp.getId()));
		   row.createCell(1).setCellValue(emp.getName());
		   row.createCell(2).setCellValue(String.valueOf(emp.getSalary()));
		   row.createCell(3).setCellValue(emp.getDesignation());
		  }
		  
	}

}
*/