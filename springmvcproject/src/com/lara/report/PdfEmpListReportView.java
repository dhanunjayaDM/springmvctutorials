package com.lara.report;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lara.beans.Emp;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Table;
public class PdfEmpListReportView extends AbstractPdfView
{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer , HttpServletRequest req,
		HttpServletResponse res) throws Exception 
	{
	res.setHeader("Content-Disposition", "attachment; filename=\"emp_list.pdf\"");
		
		List<Emp> list = (List<Emp>) model.get("list");
		
		Table table = new Table(4);
	    table.addCell("id");
		table.addCell("name");
		table.addCell("salary");
		table.addCell("designation");
		
		for(Emp emp : list){
			   table.addCell(String.valueOf(emp.getId()));
			   table.addCell(emp.getName());
			   table.addCell(String.valueOf(emp.getSalary()));
			   table.addCell(emp.getDesignation());
			  }
		document.add(table);
			
	}

}
