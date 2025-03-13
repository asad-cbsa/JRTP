package in.asadit.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import in.asadit.entity.CitizenPlan;
import in.asadit.repo.CitizenPlanRepository;
import in.asadit.request.SearchRequest;

@Service
public class ReportServiceImpl implements ReportServices {

	@Autowired
	private CitizenPlanRepository planRepo;

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
		// TODO Auto-generated method stub

		CitizenPlan entity = new CitizenPlan();
		if(null!=request.getPlanName() && ! "".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		if(null!=request.getPlanStatus() && ! "".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		if(null!=request.getGender() && ! "".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel() {
		// Placeholder implementation
		// Add logic to export data to an Excel file
		return true;
	}

	@Override
	public boolean exportPdf() {
		// Placeholder implementation
		// Add logic to export data to a PDF file
		return true;
	}
}
