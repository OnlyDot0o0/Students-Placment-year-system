package com.group14.placementtrackingsystem.reportController;

import com.group14.placementtrackingsystem.model.*;
import com.group14.placementtrackingsystem.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;




//This class: Used to handle the backend of the report extraction. Final amendments by Chia.
@Controller
public class reportController {

    @Autowired
    PlacementRepository placementRepo;
    @Autowired
    StudentRepository studentRepo;
    @Autowired
    PPFProviderDetailsRepo theCompany;

    @Autowired
    TransportTravelFactorsRepository travelFactors;
    @Autowired
    PPFWorkFactorsRepo workFactors;
    @Autowired
    RoleRepository roleCompany;

    @RequestMapping("/report")
    public String report(@RequestParam(required = false) String sal, @RequestParam(required = false) String dep, @RequestParam(required = false) String std, @RequestParam(required = false) String src, @RequestParam(required = false) Integer location, @RequestParam(required = false) Integer studentType, @RequestParam(required = false) Integer workStyle, Model model) {


        //filter UK/OVERSEAS.
        List<Student> HomeStudents = studentRepo.findAllByStudentStatus("Home");
        List<Student> InternationalStudents = studentRepo.findAllByStudentStatus("International");

        List<TransportTravelFactors> UKPlacement = travelFactors.findAllByOverseasPlacementEquals(false);
        List<Student> UKPlacementStudents = new ArrayList<>();
        for (TransportTravelFactors T : UKPlacement
        ) {
            UKPlacementStudents.add(T.getStudent());
        }

        //OVERSEAS PLACEMENT STUDENTS.
        List<TransportTravelFactors> OverseasPlacement = travelFactors.findAllByOverseasPlacementEquals(true);
        List<Student> OverseasPlacementStudents = new ArrayList<>();
        for (TransportTravelFactors T : OverseasPlacement
        ) {
            OverseasPlacementStudents.add(T.getStudent());
        }

        //REMOTE OR HYBRID STUDENTS.
        List<PPFWorkFactors> RemoteOrHybrid = workFactors.findAllByRemoteWorkEquals((byte) 1);
        List<Student> RemoteOrHybridStudents = new ArrayList<>();
        for (PPFWorkFactors W : RemoteOrHybrid
        ) {
            RemoteOrHybridStudents.add(W.getStudent());
        }

        // IN OFFICE STUDENTS.
        List<PPFWorkFactors> InOfficeOnly = workFactors.findAllByRemoteWorkEquals((byte) 0);
        List<Student> InOfficeOnlyStudents = new ArrayList<>();
        for (PPFWorkFactors W : InOfficeOnly
        ) {
            InOfficeOnlyStudents.add(W.getStudent());
        }


        //ADD ALL STUDENTS THEN ELIMINATE ACCORDINGLY!  - FILTERING
        List<Student> AllSTUDENTS = studentRepo.findAll();



        if (location != null) {

            if (location == 2) { //2 is the value of the dropdown menu for UK Only Placement
//            ONLY KEEP STUDENTS IF THEY ARE IN THE UK PLACEMENT.
                AllSTUDENTS = AllSTUDENTS.stream().filter(student -> UKPlacementStudents.contains(student)).collect(Collectors.toList());
            } else if (location == 3) { //3 is the value of the dropdown menu for Overseas Only Placement
                AllSTUDENTS = AllSTUDENTS.stream().filter(student -> OverseasPlacementStudents.contains(student)).collect(Collectors.toList());
            } else { //anything else would return ALL types of placements.
                AllSTUDENTS = AllSTUDENTS.stream().filter(student -> OverseasPlacementStudents.contains(student) || UKPlacementStudents.contains(student)).collect(Collectors.toList());
            }
        }
        if (studentType != null) {
            if (studentType == 2) { //STUDENT TYPE: HOME
                AllSTUDENTS = AllSTUDENTS.stream().filter(student -> HomeStudents.contains(student)).collect(Collectors.toList());
            } else if (studentType == 3) { //STUDENT TYPE: INTERNATIONAL
                AllSTUDENTS = AllSTUDENTS.stream().filter(student -> InternationalStudents.contains(student)).collect(Collectors.toList());

            } else //BOTH student types.
            {
                AllSTUDENTS = AllSTUDENTS.stream().filter(student -> HomeStudents.contains(student) || InternationalStudents.contains(student)).collect(Collectors.toList());
            }
        }
        if (workStyle != null) {
            if (workStyle == 2) {
                AllSTUDENTS = AllSTUDENTS.stream().filter(student -> RemoteOrHybridStudents.contains(student)).collect(Collectors.toList());
            } else if (workStyle == 3) {
                AllSTUDENTS = AllSTUDENTS.stream().filter(student -> InOfficeOnlyStudents.contains(student)).collect(Collectors.toList());
            } else {
                    AllSTUDENTS = AllSTUDENTS.stream().filter(student -> RemoteOrHybridStudents.contains(student) || InOfficeOnlyStudents.contains(student)).collect(Collectors.toList());
            }
        }

        for (Student fff: AllSTUDENTS
        ) {

        }






        if (std != null) { // STUDENT TYPE: HOME OR INTERNATIONAL - DISPLAYING WHEN CLIENT CLICKS.
            List<PPFPlacementProviderDetails> companies = new ArrayList<>();
            ArrayList<ArrayList> stdPerComp = new ArrayList<>();


            for (Placement placement : placementRepo.findAll()
            ) {
                if (!companies.contains(placement.getCompany()))
                    companies.add(placement.getCompany());


            }
            int nbrStdComp = 0;
            for (PPFPlacementProviderDetails comp : companies
            ) {
                if (AllSTUDENTS.contains(comp.getStudent())) {
                    ++nbrStdComp;
                }





                ArrayList<String> stdComp = new ArrayList<>();
                if (nbrStdComp == 0) {
                    stdComp.add(String.valueOf("NONE."));
                } else {
                    stdComp.add(String.valueOf(nbrStdComp));
                }

                stdComp.add(comp.getOrganisationName());
                stdPerComp.add(stdComp);


            }


            model.addAttribute("stdPerComps", stdPerComp);
            model.addAttribute("title", "Generated output");
            model.addAttribute("TitleComp", "Company");
            model.addAttribute("TitleStd", "Number of Students");




        }

        if (dep != null) {

            List<String> departments = new ArrayList<>();
            ArrayList<ArrayList> stdPerDep = new ArrayList<>();


            for (Placement placement : placementRepo.findAll()
            ) {
                if (!departments.contains(placement.getStudent().getDepartmentOrSchool()))
                    departments.add(placement.getStudent().getDepartmentOrSchool());
            }


            for (String department : departments
            ) {

                int nbrStdDep = 0;

                for (Student s : AllSTUDENTS
                ) {

                    if (s.getDepartmentOrSchool().equals(department)) {

                        ++nbrStdDep;


                    }


                }


                ArrayList<String> stdDep = new ArrayList<>();
//

                    stdDep.add(String.valueOf(nbrStdDep));

                stdDep.add(department);
                stdPerDep.add(stdDep);


            }


            model.addAttribute("stdPerDep", stdPerDep);
            model.addAttribute("title", "Generated output");
            model.addAttribute("TitleDep", "Company");
            model.addAttribute("TitleStd2", "Number of Students");



        }


        if (sal != null) {
            List<PPFPlacementProviderDetails> companies = new ArrayList<>();
            ArrayList<ArrayList> stdPerComp = new ArrayList<>();


            for (Placement placement : placementRepo.findAll()) {
                if (!companies.contains(placement.getCompany())) companies.add(placement.getCompany());


            }

            for (PPFPlacementProviderDetails comp : companies //SALARY CALCULATION BELOW
            ) {


                ArrayList<String> stdComp = new ArrayList<>();
                int theSalary = 0;
                int nbrStdComp = 0;
                List<Student> SALARYLIST;
                for (Placement placement : placementRepo.findAllByCompany(comp)) {
                    if (AllSTUDENTS.contains(placement.getStudent())) {
                        theSalary += placement.getRole().getAnnualSalary();
                        ++nbrStdComp;
                    }

                }
                if (nbrStdComp == 0) {
                    stdComp.add(String.valueOf("NONE."));
                } else {
                    stdComp.add(String.valueOf((theSalary / nbrStdComp)));
                }

                stdComp.add(comp.getOrganisationName());

                stdPerComp.add(stdComp);


            }

            model.addAttribute("avg_comp_sal", stdPerComp);
            model.addAttribute("title", "Generated output");
            model.addAttribute("TitleComp2", "Company");
            model.addAttribute("TitleSalary", "Average Salary");



        }


        return "Report/DataReport";
    }


}
