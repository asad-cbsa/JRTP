package in.asadit.request;


import lombok.Data;

@Data
public class SearchRequest {

	private String planName;
	private String planStatus;
	private String gender;
	private String startDate; // yy-mm--dd default but html dd-mm-yy that's why failed
	private String endDate;
}
