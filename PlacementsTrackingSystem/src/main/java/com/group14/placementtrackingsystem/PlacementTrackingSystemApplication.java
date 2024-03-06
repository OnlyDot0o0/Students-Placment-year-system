package com.group14.placementtrackingsystem;

import com.group14.placementtrackingsystem.model.*;
import com.group14.placementtrackingsystem.repository.PPFProviderDetailsRepo;
import com.group14.placementtrackingsystem.repository.PPFWorkFactorsRepo;
import com.group14.placementtrackingsystem.repository.PlacementRepository;
import com.group14.placementtrackingsystem.repository.RoleRepository;
import com.group14.placementtrackingsystem.repository.StudentRepository;
import com.group14.placementtrackingsystem.repository.TransportTravelFactorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Calendar;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
//Some imports might be needed for checking the Onplacement based on the main class name


@SpringBootApplication
public class PlacementTrackingSystemApplication implements CommandLineRunner {

	public static String[] annualPlacementSalaryRangeOptions= new String[]{
			"£1 - £5,000",
			"£5,000 - £10,000",
			"£10,000 - £20,000",
			"£20,000 - £30,000",
			"£30,000 +",
			"Hourly wage",
			"Unpaid",
			"Expenses Only",
			"Overseas living wage",
			"Unknown"
	};

	public static String[] roleSources = new String[] {
			"MyCareers",
			"Placements Bulletin",
			"School Staff",
			"Fellow Student",
			"Festival of Careers",
			"Other employer event at the university",
			"Jobs Board (Prospects etc.)",
			"LinkedIn",
			"Family/friend outside the university",
			"Other (Please Specify)"
	};

	public static String[] studentType = new String[] {
			"Undergraduate",
			"Postgraduate"
	};

	public static String[] departmentOrSchool = new String[] { //Taken from excel tracker
			"Allied Health",
			"Archaeology and Ancient History",
			"Biochemistry",
			"Biological Sciences",
			"Biology",
			"Cancer Studies & Molecular Medicine",
			"Cardiovascular Sciences",
			"Cell Physiology & Pharmacology",
			"Centre for Labour Market Studies at the School of Management",
			"Chemistry",
			"Criminology",
			"Economics",
			"Education",
			"Engineering",
			"English",
			"English Language Teaching Unit",
			"Genetics",
			"Geography",
			"Geology",
			"Health Sciences",
			"History",
			"History of Art and Film",
			"Infection, Immunity and Inflammation",
			"Computer Science",
			"Law",
			"Lifelong Learning",
			"Management",
			"Mathematics",
			"Media and Communication",
			"Medical and Social Care Education",
			"Medical School",
			"Modern Languages",
			"Molecular and Cell Biology",
			"MRC Toxicology",
			"Museum Studies",
			"Neuroscience, Psychology and Behaviour",
			"Physics and Astronomy",
			"Politics and International Relations",
			"Psychology",
			"Sociology"
	};

	public static String[] yearOfStudy = new String[] {  //this needs to be changed after checking with client
			"Year 1",
			"Year 2",
			"Year 3",
			"Year 4",
			"Year 5",
			"Year 6",
			"Year 7",
			"Gap Year"
	};

public static String[] accommodationOptions= new String[]{
			"Rent Shared House",
			"Rent Individual House",
			"Live at Home",
			"Other"
	};
	public static String[] transportMode = new String[] {
			"Own vehicle",
			"Public transport (bus, taxi)",
			"Walking",
			"Cycle",
			"Other"
	};

	public static String[] studentStatus = new String[] {
			"Home",
			"International"};


	//Sample data for checking the Onplacement tracking
	@Autowired
	private PlacementRepository placementRepository;
	@Autowired
	private StudentRepository StuRepo;
	@Autowired
	private RoleRepository RoleRepo;
	@Autowired
	private PPFProviderDetailsRepo companyRepo;

	@Autowired
	private PlacementRepository placementRepo;

    @Autowired
    private TransportTravelFactorsRepository ttfRepo;

    @Autowired
    private PPFWorkFactorsRepo WFRepo;

    //TESTING ENDS HERE

    public static void main(String[] args) {
        SpringApplication.run(PlacementTrackingSystemApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Placement s1 = new Placement();
        s1.setRemoteWork("YES");
        Student student1 = new Student();
        student1.setFirstName("Zaina");
        student1.setSurname("Rashid");
        student1.setStudentStatus("Home");
        student1.setStudentNumber("2190876");
        student1.setUniEmailAddress("zr43@student.le.ac.uk");
        student1.setDepartmentOrSchool("Computing and mathematics");
        student1 = StuRepo.save(student1);
        s1.setStudent(student1);
        Role role1 = new Role();
        role1.setRoleTitle("Developer");
        String str = "2023-01-01";
        role1.setRoleStartDate(Date.valueOf(str));
        String str1 = "2023-05-01";
        role1.setRoleEndDate(Date.valueOf(str1));
        role1.setWorkingHoursWeek(23.5F);
        role1.setAnnualSalary(20000);
        role1 = RoleRepo.save(role1);
        s1.setRole(role1);
        PPFPlacementProviderDetails company1 = new PPFPlacementProviderDetails();
        company1.setOrganisationName("IBM");
        company1.setPlacementAddress("LE17HA London Road");
        company1.setStudent(student1);
        company1 = companyRepo.save(company1);
        s1.setCompany(company1);

        s1 = placementRepository.save(s1);

        TransportTravelFactors TTF = new TransportTravelFactors();
        TTF.setId(1);
        TTF.setStudent(student1);
        TTF.setOverseasPlacement(false);
        TTF = ttfRepo.save(TTF);

        PPFWorkFactors WKFCTS = new PPFWorkFactors();
        WKFCTS.setCompany(company1);
        WKFCTS.setStudent(student1);
        WKFCTS.setRemoteWork((byte) 1);
        WFRepo.save(WKFCTS);


    }
}
