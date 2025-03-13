package in.asadit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import in.asadit.entity.CitizenPlan;
import in.asadit.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private CitizenPlanRepository repo;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("DataLoader running...");

        repo.deleteAll();
        // Cash Plan Data
        CitizenPlan c1 = new CitizenPlan();
        c1.setCitizenName("John");
        c1.setGender("Male");
        c1.setPlanName("Cash");
        c1.setPlanStatus("Approved");
        c1.setPlanStartDate(LocalDate.now());
        c1.setPlanEndDate(LocalDate.now().plusMonths(6));
        c1.setBenefitAmt(5000.00);
        c1.setDenialReason(null); // Explicitly set to null
        c1.setTerminatedDate(null);
        c1.setTerminationRsn(null);

        CitizenPlan c2 = new CitizenPlan();
        c2.setCitizenName("Smith");
        c2.setGender("Male");
        c2.setPlanName("Cash");
        c2.setPlanStatus("Denied");
        c2.setDenialReason("Rental Income");
        c2.setPlanStartDate(null); // Explicitly set to null
        c2.setPlanEndDate(null);
        c2.setBenefitAmt(null);
        c2.setTerminatedDate(null);
        c2.setTerminationRsn(null);

        CitizenPlan c3 = new CitizenPlan();
        c3.setCitizenName("Cathy");
        c3.setGender("Fe-Male");
        c3.setPlanName("Cash");
        c3.setPlanStatus("Terminated");
        c3.setPlanStartDate(LocalDate.now().minusMonths(4));
        c3.setPlanEndDate(LocalDate.now().plusMonths(6));
        c3.setBenefitAmt(5000.00);
        c3.setTerminatedDate(LocalDate.now());
        c3.setTerminationRsn("Employed");

        // Food Plan Data
        CitizenPlan c4 = new CitizenPlan();
        c4.setCitizenName("David");
        c4.setGender("Male");
        c4.setPlanName("Food");
        c4.setPlanStatus("Approved");
        c4.setPlanStartDate(LocalDate.now());
        c4.setPlanEndDate(LocalDate.now().plusMonths(6));
        c4.setBenefitAmt(4000.00);
        c4.setDenialReason(null);
        c4.setTerminatedDate(null);
        c4.setTerminationRsn(null);

        CitizenPlan c5 = new CitizenPlan();
        c5.setCitizenName("Robert");
        c5.setGender("Male");
        c5.setPlanName("Food");
        c5.setPlanStatus("Denied");
        c5.setDenialReason("Property Income");
        c5.setPlanStartDate(null);
        c5.setPlanEndDate(null);
        c5.setBenefitAmt(null);
        c5.setTerminatedDate(null);
        c5.setTerminationRsn(null);

        CitizenPlan c6 = new CitizenPlan();
        c6.setCitizenName("Orlen");
        c6.setGender("Fe-Male");
        c6.setPlanName("Food");
        c6.setPlanStatus("Terminated");
        c6.setPlanStartDate(LocalDate.now().minusMonths(4));
        c6.setPlanEndDate(LocalDate.now().plusMonths(6));
        c6.setBenefitAmt(5000.00);
        c6.setTerminatedDate(LocalDate.now());
        c6.setTerminationRsn("Employed");

        // Medical Plan Data
        CitizenPlan c7 = new CitizenPlan();
        c7.setCitizenName("Charles");
        c7.setGender("Male");
        c7.setPlanName("Medical");
        c7.setPlanStatus("Approved");
        c7.setPlanStartDate(LocalDate.now());
        c7.setPlanEndDate(LocalDate.now().plusMonths(6));
        c7.setBenefitAmt(4000.00);
        c7.setDenialReason(null);
        c7.setTerminatedDate(null);
        c7.setTerminationRsn(null);

        CitizenPlan c8 = new CitizenPlan();
        c8.setCitizenName("Buttler");
        c8.setGender("Male");
        c8.setPlanName("Medical");
        c8.setPlanStatus("Denied");
        c8.setDenialReason("Property Income");
        c8.setPlanStartDate(null);
        c8.setPlanEndDate(null);
        c8.setBenefitAmt(null);
        c8.setTerminatedDate(null);
        c8.setTerminationRsn(null);

        CitizenPlan c9 = new CitizenPlan();
        c9.setCitizenName("Neel");
        c9.setGender("Fe-Male");
        c9.setPlanName("Medical");
        c9.setPlanStatus("Terminated");
        c9.setPlanStartDate(LocalDate.now().minusMonths(4));
        c9.setPlanEndDate(LocalDate.now().plusMonths(6));
        c9.setBenefitAmt(5000.00);
        c9.setTerminatedDate(LocalDate.now());
        c9.setTerminationRsn("Govt Job");

        // Employment Plan Data
        CitizenPlan c10 = new CitizenPlan();
        c10.setCitizenName("Steve");
        c10.setGender("Male");
        c10.setPlanName("Employment");
        c10.setPlanStatus("Approved");
        c10.setPlanStartDate(LocalDate.now());
        c10.setPlanEndDate(LocalDate.now().plusMonths(6));
        c10.setBenefitAmt(4000.00);
        c10.setDenialReason(null);
        c10.setTerminatedDate(null);
        c10.setTerminationRsn(null);

        CitizenPlan c11 = new CitizenPlan();
        c11.setCitizenName("Moris");
        c11.setGender("Male");
        c11.setPlanName("Employment");
        c11.setPlanStatus("Denied");
        c11.setDenialReason("Property Income");
        c11.setPlanStartDate(null);
        c11.setPlanEndDate(null);
        c11.setBenefitAmt(null);
        c11.setTerminatedDate(null);
        c11.setTerminationRsn(null);

        CitizenPlan c12 = new CitizenPlan();
        c12.setCitizenName("Gibs");
        c12.setGender("Fe-Male");
        c12.setPlanName("Employment");
        c12.setPlanStatus("Terminated");
        c12.setPlanStartDate(LocalDate.now().minusMonths(4));
        c12.setPlanEndDate(LocalDate.now().plusMonths(6));
        c12.setBenefitAmt(5000.00);
        c12.setTerminatedDate(LocalDate.now());
        c12.setTerminationRsn("Govt Job");

        // Save all objects to the database
        List<CitizenPlan> list = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12);
        repo.saveAll(list);

        System.out.println("Data loaded successfully!");
    }
}