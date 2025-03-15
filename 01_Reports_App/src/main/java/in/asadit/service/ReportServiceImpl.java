package in.asadit.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.asadit.entity.CitizenPlan;
import in.asadit.repo.CitizenPlanRepository;
import in.asadit.request.SearchRequest;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportServices {

	@Autowired
	private CitizenPlanRepository planRepo;
	private List<CitizenPlan> all;

	@Override
	public List<String> getPlanNames() {
		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatuses() {
		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		CitizenPlan entity = new CitizenPlan();

		if (request.getPlanName() != null && !request.getPlanName().isEmpty()) {
			entity.setPlanName(request.getPlanName());
		}
		if (request.getPlanStatus() != null && !request.getPlanStatus().isEmpty()) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if (request.getGender() != null && !request.getGender().isEmpty()) {
			entity.setGender(request.getGender());
		}
		if (request.getStartDate() != null && !request.getStartDate().isEmpty()) {
			LocalDate localDate = LocalDate.parse(request.getStartDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			entity.setPlanStartDate(localDate);
		}
		if (request.getEndDate() != null && !request.getEndDate().isEmpty()) {
			LocalDate localDate = LocalDate.parse(request.getEndDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			entity.setPlanEndDate(localDate);
		}

		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws IOException {
		List<CitizenPlan> records = planRepo.findAll();

		// Create Excel Workbook
		Workbook workbook = new HSSFWorkbook();
		// Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("plans-data");
		Row headerRow = sheet.createRow(0);

		// Define Column Headers
		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Citizen Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benefit Amount");

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		int dataRowIndex = 1;

		for (CitizenPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);

			dataRow.createCell(0).setCellValue(plan.getCitizenId());
			dataRow.createCell(1).setCellValue(plan.getCitizenName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());

			// Convert LocalDate to String for Excel
			String startDateStr = (plan.getPlanStartDate() != null) ? plan.getPlanStartDate().format(formatter) : "";
			dataRow.createCell(4).setCellValue(startDateStr);

			String endDateStr = (plan.getPlanEndDate() != null) ? plan.getPlanEndDate().format(formatter) : "";
			dataRow.createCell(5).setCellValue(endDateStr);

			if (null != plan.getBenefitAmt()) {
				dataRow.createCell(6).setCellValue(plan.getBenefitAmt());
			} else {
				dataRow.createCell(6).setCellValue("N/A");

			}
			dataRowIndex++;
		}

		// Set Response Headers
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "attachment; filename=plans-data.xls");

		// Write to Output Stream and Close Resources
		try (ServletOutputStream outputStream = response.getOutputStream()) {
			workbook.write(outputStream);
		}
		workbook.close();

		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {

		Document document = new Document(PageSize.A4);

		PdfWriter.getInstance(document, response.getOutputStream());
		document.open();
		// Creating font
		// Setting font style and size
		Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTitle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Citizen Plans", fontTitle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);

		


		PdfPTable table = new PdfPTable(6);
		table.setSpacingBefore(5);
		
		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		
		  List<CitizenPlan> plans = planRepo.findAll();
		  for(CitizenPlan plan : plans) {
				table.addCell(String.valueOf(plan.getCitizenId()));
				table.addCell(plan.getCitizenName());
				table.addCell(plan.getPlanName());
				table.addCell(plan.getPlanStatus());
				table.addCell(plan.getPlanStartDate()+ "");
				table.addCell(plan.getPlanEndDate()+ "");
		  }
		
		document.add(table);
		document.close();

		return true;
	}
}
