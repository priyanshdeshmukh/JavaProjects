package jasperExample.com.jasper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

public class FromTheMainDatabase {
	 public static void main(String[] args) {
			Connection connection = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection(
		                    "jdbc:mysql://localhost:3306/skillinventory","root", "Test_1234");
			} catch (SQLException e) {
				e.printStackTrace();
				return;
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return;
			}

			try {
			    Map<String, Object> reportParameters = new HashMap<String, Object>();
			    JasperPrint jasperPrint = JasperFillManager.fillReport("D:\\Workspace\\com.jasper\\res\\example2.jasper", reportParameters, connection);
			    @SuppressWarnings("unchecked")
				Exporter<SimpleExporterInput, ?, ?, SimpleOutputStreamExporterOutput> exporter = (Exporter<SimpleExporterInput, ?, ?, SimpleOutputStreamExporterOutput>) new JRDocxExporter();
			    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
			    File exportReportFile = new File("D:/report.docx");
			    exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(exportReportFile));
			    exporter.exportReport();
			    
			} catch (JRException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }	
}
