package in.asadit.service;

import java.util.List;

import in.asadit.entity.CitizenPlan;
import in.asadit.request.SearchRequest;

public interface ReportServices {
	
	public List<String> getPlanNames();
	
	public List<String> getPlanStatuses();
	
	public List<CitizenPlan> search(SearchRequest request);
	
	public boolean exportExcel();
	
	public boolean exportPdf();

}
