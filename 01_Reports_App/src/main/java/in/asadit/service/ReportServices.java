package in.asadit.service;

import java.util.List;
import in.asadit.entity.CitizenPlan;
import in.asadit.request.SearchRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ReportServices {

    List<String> getPlanNames();

    List<String> getPlanStatuses();

    List<CitizenPlan> search(SearchRequest request);

    boolean exportExcel(HttpServletResponse response) throws Exception;

    boolean exportPdf(HttpServletResponse response) throws Exception ;
}
