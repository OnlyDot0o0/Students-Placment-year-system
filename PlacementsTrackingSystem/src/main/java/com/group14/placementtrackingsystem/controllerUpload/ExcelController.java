package com.group14.placementtrackingsystem.controllerUpload;
/*
Created by Maryam to handle the old Excel Master Tracker Database conversion to our new database in the system
 */
import com.group14.placementtrackingsystem.model.*;
import com.group14.placementtrackingsystem.repository.*;
import org.apache.poi.EmptyFileException;
import org.apache.poi.openxml4j.exceptions.NotOfficeXmlFileException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

@Controller
public class ExcelController {

    //Autowired repositories to access the rest of the system database
    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private TransportTravelFactorsRepository transportTravelFactorsRepo;

    @Autowired
    private PPFProviderDetailsRepo PPFPlacementProviderDetailsRepo;

    @Autowired
    private PPFPNamedContactRepo placementProviderContactRepo;

    @Autowired
    private DatesofFormCompletionRepository datesRepo;

    @Autowired
    private RoleRepository roleRepo;

    @Autowired
    private RiskRepository riskRepo;

    @Autowired
    private MonitoringAndEvaluationRepository monitorAndEvalRepo;

    @Autowired
    private StudentFinanceTeamRepository stuFinanceRepo;

    @Autowired
    private BlackboardAdminRepository bbAdminRepo;



    /**
     * @return the jsp file location for uploading the Excel database to
     * @author Maryam (@mzg1)
     */
    @GetMapping("/uploadDatabase")
    public String uploadDatabase(){
        return "/OldExcelDatabase/uploadData";

    }

    /**
     * This method uploads the Postgraduate Database sheet found in the Excel Master Tracker
     * Document, and stores all the cell details to this new database system
     *
     * @param file          The upload file
     * @param model         The controller's model

     * @return The jsp file location for the success page for complete upload, or the jsp file location for error page if errors encountered
     * @author Maryam (@mzg1)
     */
    public String readExcelPostgraduate (MultipartFile file, Model model) {
        try{
            String databaseSheet="Postgraduate";
            InputStream inputStream = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(3); //Undergraduate database
            int numRowsToSkip = 4; // Skipped over the headers and column names (as the widths of cells taken is too wrong)

            Iterator<Row> rowIterator = sheet.iterator();
            for (int i = 0; i < numRowsToSkip; i++) { //skips over first 4 rows
                if (rowIterator.hasNext()) {
                    rowIterator.next();
                } else {                            //if there are not enough rows to skip
                    workbook.close();
                    inputStream.close();
                    return null;
                }
            }

            int currentRowNum=4; //Data rows start at row 5
            while (rowIterator.hasNext()) {         //starts from data rows
                currentRowNum+=1;
                Row row = rowIterator.next();
                int currentCellNum=0;
                try {
                    //Checks that there actually is a student number (as it is a core id) to see if it is a sufficient row to read
                    if (row.getCell(2) == null || row.getCell(2).getCellType() == CellType.BLANK) {
                        break;
                    }

                    //STUDENT DETAILS

                    Student student = new Student();

                    //Student Number
                    Cell cell3 = row.getCell(2);
                   
                    currentCellNum=3;
                    student.setStudentNumber(cell3.getStringCellValue());

                    //Student First Name
                    Cell cell1 = row.getCell(0);
                   
                    currentCellNum=1;
                    student.setFirstName(cell1.getStringCellValue());

                    //Student surname
                    Cell cell2 = row.getCell(1);
                   
                    currentCellNum=2;
                    student.setSurname(cell2.getStringCellValue());

                    //Student UoL email address
                    Cell cell4 = row.getCell(3);
                   
                    currentCellNum=4;
                    student.setUniEmailAddress(cell4.getStringCellValue());

                    //Student Type
                    Cell cell5 = row.getCell(4);
                   
                    currentCellNum=5;
                    if (cell5.getStringCellValue() == "UG") {
                        student.setStudentType("Undergraduate");
                    } else if (cell5.getStringCellValue() == "PG") {
                        student.setStudentType("Postgraduate");
                    } else {
                        student.setStudentType(cell5.getStringCellValue());
                    }

                    //School/Department
                    Cell cell6 = row.getCell(5);
                   
                    currentCellNum=6;
                    student.setDepartmentOrSchool(cell6.getStringCellValue());

                    //Year of Study
                    Cell cell7 = row.getCell(6);
                   
                    currentCellNum=7;
                    student.setYearOfStudy(cell7.getStringCellValue());

                    //Programme
                    Cell cell8 = row.getCell(7);
                   
                    currentCellNum=8;
                    student.setProgramme(cell8.getStringCellValue());

                    //Mode of Transport - TransportTravelFactors
                    Cell cell9 = row.getCell(8);
                   
                    currentCellNum=9;
                    TransportTravelFactors travelFactors = new TransportTravelFactors();
                    travelFactors.setStudent(student);
                    travelFactors.setTransportMethods(cell9.getStringCellValue());


                    //Home or international student
                    Cell cell10 = row.getCell(9);
                   
                    currentCellNum=10;
                    student.setStudentStatus(String.valueOf(row.getCell(9))); //Used this as there was cell reading problem

                    //Is a Course TFR Req'd? (course transfer)
                    Cell cell11 = row.getCell(10);
                   
                    currentCellNum=11;
                    if (cell11.getStringCellValue() == "Yes") {
                        student.setCourseTransferRequired(Boolean.TRUE);
                    } else {
                        student.setCourseTransferRequired(Boolean.FALSE);
                    }

                    //Additional Notes
                    Cell cell12 = row.getCell(11);
                   
                    currentCellNum=12;
                    student.setAdditionalNotes(cell12.getStringCellValue());


                    //PLACEMENT PROVIDER DETAILS SECTION
                    PPFPlacementProviderDetails placementProviderDetails = new PPFPlacementProviderDetails();
                    placementProviderDetails.setStudent(student);

                    //Placement Provider Name
                    Cell cell13 = row.getCell(12);
                   
                    currentCellNum=13;
                    placementProviderDetails.setOrganisationName(cell13.getStringCellValue());

                    //Placement Address - Number and Road
                    Cell cell14 = row.getCell(13);
                   
                    currentCellNum=14;
                    //This assignment of cell is with cell17

                    //Placement Postcode
                    Cell cell15 = row.getCell(14);
                   
                    currentCellNum=15;
                    placementProviderDetails.setPostCode(cell15.getStringCellValue());

                    //Placement city
                    Cell cell16 = row.getCell(15);
                   
                    currentCellNum=16;
                    //This assignment of cell is with cell17

                    //Placement Country
                    Cell cell17 = row.getCell(16);
                   
                    currentCellNum=17;
                    placementProviderDetails.setPlacementAddress(
                            cell14.getStringCellValue() + " " +
                                    cell16.getStringCellValue() + " " +
                                    cell17.getStringCellValue()
                    );

                    //Placement Contact Name
                    PPFPlacementProviderNamedContact placementContact = new PPFPlacementProviderNamedContact();
                    placementContact.setStudent(student);
                    placementContact.setCompany(placementProviderDetails);

                    Cell cell18 = row.getCell(17);
                   
                    currentCellNum=18;
                    placementContact.setName(cell18.getStringCellValue());

                    //Placement Contact Telephone Number
                    Cell cell19 = row.getCell(18);
                   
                    currentCellNum=19;
                    if (cell19.getCellType() == CellType.STRING) {
                        placementContact.setTelNumber(cell19.getStringCellValue());
                    } else if (cell19.getCellType() == CellType.NUMERIC) {
                        placementContact.setTelNumber(String.valueOf(cell19.getNumericCellValue()));
                    }

                    //Placement Contact Email
                    Cell cell20 = row.getCell(19);
                   
                    currentCellNum=20;
                    placementContact.setEmail(cell20.getStringCellValue());

                    //PLACEMENT APPROVAL SECTION

                    //Date of authorisation request form received
                    DatesOfFormCompletions dates = new DatesOfFormCompletions();
                    dates.setStudent(student);
                    dates.setCompany(placementProviderDetails);

                    Cell cell21 = row.getCell(20);
                   
                    currentCellNum=21;
                    //Had to handle a lot with dates, as it is very hard. Especially as java.util and java.sql are not compatible
                    java.util.Date utilDate = cell21.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell21.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell21.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                dates.setStudentAuthorisationRequestFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell21);
                            if (!cellValue.isEmpty()) {
                                dates.setStudentAuthorisationRequestFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        dates.setStudentAuthorisationRequestFormReceived(sqlDate);
                    }

                    //Date of Placement Provider Form Received
                    Cell cell22 = row.getCell(21);
                   
                    currentCellNum=22;
                    utilDate = cell22.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell22.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell22.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                dates.setProviderFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell22);
                            if (!cellValue.isEmpty()) {
                                dates.setProviderFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        dates.setProviderFormReceived(sqlDate);
                    }

                    //Date of Placement Assessment Form Received
                    Cell cell23 = row.getCell(22);
                   
                    currentCellNum=23;
                    utilDate = cell23.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell23.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell23.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                dates.setAssessmentFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell23);
                            if (!cellValue.isEmpty()) {
                                dates.setAssessmentFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        dates.setAssessmentFormReceived(sqlDate);
                    }

                    //Placement Job Title
                    Role role = new Role();
                    role.setStudent(student);
                    role.setCompany(placementProviderDetails);

                    Cell cell24 = row.getCell(23);
                   
                    currentCellNum=24;
                    role.setRoleTitle(cell24.getStringCellValue());

                    //placement salary (annual) £
                    Cell cell25 = row.getCell(24);
                   
                    currentCellNum=25;
                    role.setAnnualSalaryRange(cell25.getStringCellValue());

                    //placement start date
                    Cell cell26 = row.getCell(25);
                   
                    currentCellNum=26;
                    utilDate = cell26.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell26.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell26.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                role.setRoleStartDate(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell26);
                            if (!cellValue.isEmpty()) {
                                role.setRoleStartDate(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        role.setRoleStartDate(sqlDate);
                    }

                    //placement end date
                    Cell cell27 = row.getCell(26);
                   
                    currentCellNum=27;
                    utilDate = cell27.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell27.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell27.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                role.setRoleEndDate(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell27);
                            if (!cellValue.isEmpty()) {
                                role.setRoleEndDate(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        role.setRoleEndDate(sqlDate);
                    }

                    //Name of placement tutor completing placement assessment
                    RiskForm riskForm = new RiskForm();
                    dates.setRiskForm(riskForm);

                    Cell cell28 = row.getCell(27);
                   
                    currentCellNum=28;
                    riskForm.setStudent(student);
                    riskForm.setTutorName(cell28.getStringCellValue());

                    //Does the student have a Student Visa
                    Cell cell29 = row.getCell(28);
                   
                    currentCellNum=29;
                    student.setStudentStatus(cell29.getStringCellValue());

                    //Does the student visa include a placement?
                    Cell cell30 = row.getCell(29);
                   
                    currentCellNum=30;
                    if (cell30.getStringCellValue() == "No" || cell30.getStringCellValue() == "N/A") {
                        student.setVisaDuration(Boolean.FALSE);
                    } else if (cell30.getStringCellValue() == "Yes") {
                        student.setVisaDuration(Boolean.TRUE);
                    }

                    //SIAC Notes The University’s Student Immigration Advice and Compliance team (SIAC)
                    Cell cell31 = row.getCell(30);
                   
                    currentCellNum=31;
                    riskForm.setSiacNotes(cell31.getStringCellValue());

                    //Decision of Placement assessment
                    Cell cell32 = row.getCell(31);
                   
                    currentCellNum=32;
                    riskForm.setPlacementDecision(cell32.getStringCellValue());

                    //Date of authorisation email sent //here is assuming that the email is sent straight after risk form is completed
                    Cell cell33 = row.getCell(32);
                   
                    currentCellNum=33;
                    utilDate = cell33.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell33.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell33.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                riskForm.setPlacementDate(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell33);
                            if (!cellValue.isEmpty()) {
                                riskForm.setPlacementDate(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        riskForm.setPlacementDate(sqlDate);
                    }


                    //Date of placement briefing attended //only added to model class, not form
                    Cell cell34 = row.getCell(33);
                   
                    currentCellNum=34;
                    utilDate = cell34.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell34.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell34.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                riskForm.setPlacementBriefing(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell34);
                            if (!cellValue.isEmpty()) {
                                riskForm.setPlacementBriefing(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        riskForm.setPlacementBriefing(sqlDate);
                    }

                    //Insurance issued (only required for overseas placement)
                    Cell cell35 = row.getCell(34);
                   
                    currentCellNum=35;
                    riskForm.setInsuranceIssued(cell35.getStringCellValue());

                    //MONITORING AND EVALUATION SECTION
                    MonitoringAndEvaluation monitoringAndEvaluation = new MonitoringAndEvaluation();
                    monitoringAndEvaluation.setStudent(student);
                    monitoringAndEvaluation.setCompany(placementProviderDetails);

                    //dateOfPlacementProviderStartCheck
                    Cell cell36 = row.getCell(35);
                   
                    currentCellNum=36;
                    utilDate = cell36.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell36.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell36.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementProviderStartCheck(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell36);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementProviderStartCheck(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfPlacementProviderStartCheck(sqlDate);
                    }


                    //dateOfPlacementStudentStartCheck
                    Cell cell37 = row.getCell(36);
                   
                    currentCellNum=37;
                    utilDate = cell37.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell37.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell37.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementStudentStartCheck(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell37);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementStudentStartCheck(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfPlacementStudentStartCheck(sqlDate);
                    }

                    //studentResidentialAddressWhileOnPlacement
                    Cell cell38 = row.getCell(37);
                   
                    currentCellNum=38;
                    monitoringAndEvaluation.setStudentResidentialAddressWhileOnPlacement(cell38.getStringCellValue());

                    //studentWorkEmail
                    Cell cell39 = row.getCell(38);
                   
                    currentCellNum=39;
                    monitoringAndEvaluation.setStudentWorkEmail(cell39.getStringCellValue());

                    //dateOfMostRecentMonthlyReflectiveJournal
                    Cell cell40 = row.getCell(39);
                   
                    currentCellNum=40;
                    utilDate = cell40.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell40.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell40.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfMostRecentMonthlyReflectiveJournal(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell40);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfMostRecentMonthlyReflectiveJournal(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfMostRecentMonthlyReflectiveJournal(sqlDate);
                    }

                    //dateThatStudentVisaEscalationProcessStartedWithComplianceTeam
                    Cell cell41 = row.getCell(40);
                   
                    currentCellNum=41;
                    utilDate = cell41.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell41.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell41.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfStudentVisaEscalation(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell41);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfStudentVisaEscalation(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfStudentVisaEscalation(sqlDate);
                    }

                    //Date that SIAC reported the placement details to UKVI
                    Cell cell42 = row.getCell(41);
                   
                    currentCellNum=42;
                    CellType cellType1 = cell42.getCellType();
                    String cellValue1;
                    if (cellType1 == CellType.STRING) {
                        cellValue1 = cell42.getStringCellValue();
                    }
                    else if (cellType1==CellType.NUMERIC){
                        cellValue1 = String.valueOf(cell42.getNumericCellValue());
                    }
                    else{
                        cellValue1= String.valueOf(cell42.getDateCellValue());
                    }
                    monitoringAndEvaluation.setDateOfSIACReportingToUKVI(cellValue1); //Is a string as there is no validation for it in excel old database


                    //dateOfFirstPlacementVisitCompleted
                    Cell cell43 = row.getCell(42);
                   
                    currentCellNum=43;
                    utilDate = cell43.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell43.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell43.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfFirstPlacementVisitCompleted(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell43);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfFirstPlacementVisitCompleted(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfFirstPlacementVisitCompleted(sqlDate);
                    }


                    //dateOfSecondPlacementVisitCompleted
                    Cell cell44 = row.getCell(43);
                   
                    currentCellNum=44;
                    utilDate = cell44.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell44.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell44.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfSecondPlacementVisitCompleted(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell44);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfSecondPlacementVisitCompleted(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfSecondPlacementVisitCompleted(sqlDate);
                    }

                    //dateOfPlacementProviderEvaluationFormReceived
                    Cell cell45 = row.getCell(44);
                   
                    currentCellNum=45;
                    utilDate = cell45.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell45.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell45.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementProviderEvaluationFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell45);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementProviderEvaluationFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfPlacementProviderEvaluationFormReceived(sqlDate);
                    }

                    //dateOfPlacementStudentEvaluationFormReceived
                    Cell cell46 = row.getCell(45);
                   
                    currentCellNum=46;
                    utilDate = cell46.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell46.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell46.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementStudentEvaluationFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell46);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementStudentEvaluationFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfPlacementStudentEvaluationFormReceived(sqlDate);
                    }

                    //placementEndReason
                    Cell cell47 = row.getCell(46);
                   
                    currentCellNum=47;
                    monitoringAndEvaluation.setPlacementEndReason(cell47.getStringCellValue());

                    //Different from Undergraduate section now

                    //MSc Project Start Date (if a requirement of the degree programme)
                    Cell cell48 = row.getCell(47);
                   
                    currentCellNum=48;
                    utilDate = cell48.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell48.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell48.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setMScProjectStartDate(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell48);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setMScProjectStartDate(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setMScProjectStartDate(sqlDate);
                    }

                    //Estimated date of MSc Project Completion (if a requirement of the degree programme)
                    Cell cell49 = row.getCell(48);
                   
                    currentCellNum=49;
                    utilDate = cell49.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell49.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell49.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setEstimatedDateOfMScProjectCompletion(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell49);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setEstimatedDateOfMScProjectCompletion(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setEstimatedDateOfMScProjectCompletion(sqlDate);
                    }

                    //END
                    //MISCELLANEOUS ITEMS

                    //StudentFinanceTeamNotes
                    StudentFinanceTeam studentFinanceTeam = new StudentFinanceTeam();
                    studentFinanceTeam.setStudent(student);
                    Cell cell51 = row.getCell(50);
                   
                    currentCellNum=51;
                    studentFinanceTeam.setStudentFinanceTeamNotes(cell51.getStringCellValue());

                    //BLACKBOARD ADMIN SECTION

                    //Added to on-placement BB module?
                    BlackboardAdmin bb = new BlackboardAdmin();
                    bb.setStudent(student);
                    bb.setMonitoringAndEvaluation(monitoringAndEvaluation);
                    Cell cell52 = row.getCell(51);
                   
                    currentCellNum=52;
                    bb.setOn_placementModule(cell52.getStringCellValue());

                    //Added to BB group?
                    Cell cell53 = row.getCell(52);
                   
                    currentCellNum=53;
                    bb.setOn_placementGroup(cell53.getStringCellValue());

                    //Sent Email to student about changes
                    Cell cell54 = row.getCell(53);
                   
                    currentCellNum=54;
                    bb.setStudentEmailed(cell54.getStringCellValue());

                    studentRepo.save(student);
                    riskRepo.save(riskForm);
                    transportTravelFactorsRepo.save(travelFactors);
                    PPFPlacementProviderDetailsRepo.save(placementProviderDetails);
                    placementProviderContactRepo.save(placementContact);
                    datesRepo.save(dates);
                    roleRepo.save(role);

                    monitorAndEvalRepo.save(monitoringAndEvaluation);
                    stuFinanceRepo.save(studentFinanceTeam);
                    bbAdminRepo.save(bb);

                   
                    workbook.close();
                    inputStream.close();
                   


                    //POSTGRADUATE DATABASE READ
                    //------------------------------------------------------------------------------------
                    //------------------------------------------------------------------------------------
                } catch (IllegalStateException e){
                    Map<Integer, String> dict = new HashMap<>();
                    dict.put(0, "Before 1st cell is read");
                    dict.put(1, "A");
                    dict.put(2, "B");
                    dict.put(3, "C");
                    dict.put(4, "D");
                    dict.put(5, "E");
                    dict.put(6, "F");
                    dict.put(7, "G");
                    dict.put(8, "H");
                    dict.put(9, "I");
                    dict.put(10, "J");
                    dict.put(11, "K");
                    dict.put(12, "L");
                    dict.put(13, "M");
                    dict.put(14, "N");
                    dict.put(15, "O");
                    dict.put(16, "P");
                    dict.put(17, "Q");
                    dict.put(18, "R");
                    dict.put(19, "S");
                    dict.put(20, "T");
                    dict.put(21, "U");
                    dict.put(22, "V");
                    dict.put(23, "W");
                    dict.put(24, "X");
                    dict.put(25, "Y");
                    dict.put(26, "Z");
                    dict.put(27, "AA");
                    dict.put(28, "AB");
                    dict.put(29, "AC");
                    dict.put(30, "AD");
                    dict.put(31, "AE");
                    dict.put(32, "AF");
                    dict.put(33, "AG");
                    dict.put(34, "AH");
                    dict.put(35, "AI");
                    dict.put(36, "AJ");
                    dict.put(37, "AK");
                    dict.put(38, "AL");
                    dict.put(39, "AM");
                    dict.put(40, "AN");
                    dict.put(41, "AO");
                    dict.put(42, "AP");
                    dict.put(43, "AQ");
                    dict.put(44, "AR");
                    dict.put(45, "AS");
                    dict.put(46, "AT");
                    dict.put(47, "AU");
                    dict.put(48, "AV");
                    dict.put(49, "AW");
                    dict.put(50, "AX");
                    dict.put(51, "AY");
                    dict.put(52, "AZ");
                    dict.put(53, "BA");
                    dict.put(54, "BB");


                    String errorMessage = "A problem happened whilst reading cell "+dict.get(currentCellNum)+" (Column " + currentCellNum + ") on Row "+currentRowNum +" of the old Excel database, in the sheet for "+databaseSheet+ " details. Please check and make sure the cell value is the correct data type and inputted correctly in the Excel database, and try again.\nIf the problem persists, please contact the IT admin";
                    model.addAttribute("errorMessage", errorMessage);
                    workbook.close();
                    inputStream.close();
                    return "/OldExcelDatabase/errorUploadingDatabase";

                }
            }
//
        }
        catch (NotOfficeXmlFileException e){
            String errorMessage = "Invalid file type/format has been uploaded. Please check it is the Excel master tracker database and try again. If problem persists, please contact the IT admin";
            model.addAttribute("errorMessage", errorMessage);
            return "/OldExcelDatabase/errorUploadingDatabase";
        }
        catch (Exception e){
            //Keeping this console output to help IT admin detect issue
           
//           
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            int lineNumber = e.getStackTrace()[0].getLineNumber();
            String fileName = e.getStackTrace()[0].getFileName();
            String relevantLine = "";

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                for (int i = 1; i < lineNumber; i++) {
                    br.readLine();
                }
                relevantLine = br.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           
            String errorMessage="Something went wrong whilst uploading the file. Please check it is the Excel master tracker database and try again. If problem persists, please contact the IT admin";
            model.addAttribute("errorMessage", errorMessage);
            return "/OldExcelDatabase/errorUploadingDatabase";
        }

        return "/OldExcelDatabase/successfulUpload";
    }

    /**
     * This method uploads the Undergraduate Database sheet found in the Excel Master Tracker
     * Document, and stores all the cell details to this new database system
     *
     * @param file          The upload file
     * @param model         The controller's model

     * @return The method for the Postgraduate upload database method or the jsp file location for error pages if errors encountered
     * @author Maryam (@mzg1)
     */
    public String readExcelUndergraduate (MultipartFile file, Model model) {
        try{
            String databaseSheet="Undergraduate";
            InputStream inputStream = file.getInputStream();
            Workbook workbook = new XSSFWorkbook(inputStream);
            Sheet sheet = workbook.getSheetAt(2); //Undergraduate database
            int numRowsToSkip = 4; // Skipped over the headers and column names (as the widths of cells taken is too wrong)

            Iterator<Row> rowIterator = sheet.iterator();
            for (int i = 0; i < numRowsToSkip; i++) { //skips over first 4 rows
                if (rowIterator.hasNext()) {
                    rowIterator.next();
                } else {                            //if there are not enough rows to skip
                    workbook.close();
                    inputStream.close();
                    return null;
                }
            }

            int currentRowNum=4; //Data rows start at row 5
            while (rowIterator.hasNext()) {         //starts from data rows
                currentRowNum+=1;
                Row row = rowIterator.next();
                int currentCellNum=0;
                try {
                    //Checks that there actually is a student number (as it is a core id) to see if it is a sufficient row to read
                    if (row.getCell(2) == null || row.getCell(2).getCellType() == CellType.BLANK) {
                        break;
                    }

                    //STUDENT DETAILS

                    Student student = new Student();

                    //Student Number
                    Cell cell3 = row.getCell(2);
                   
                    currentCellNum=3;
                    student.setStudentNumber(cell3.getStringCellValue());

                    //Student First Name
                    Cell cell1 = row.getCell(0);
                   
                    currentCellNum=1;
                    student.setFirstName(cell1.getStringCellValue());

                    //Student surname
                    Cell cell2 = row.getCell(1);
                   
                    currentCellNum=2;
                    student.setSurname(cell2.getStringCellValue());

                    //Student UoL email address
                    Cell cell4 = row.getCell(3);
                   
                    currentCellNum=4;
                    student.setUniEmailAddress(cell4.getStringCellValue());

                    //Student Type
                    Cell cell5 = row.getCell(4);
                   
                    currentCellNum=5;
                    if (cell5.getStringCellValue() == "UG") {
                        student.setStudentType("Undergraduate");
                    } else if (cell5.getStringCellValue() == "PG") {
                        student.setStudentType("Postgraduate");
                    } else {
                        student.setStudentType(cell5.getStringCellValue());
                    }

                    //School/Department
                    Cell cell6 = row.getCell(5);
                   
                    currentCellNum=6;
                    student.setDepartmentOrSchool(cell6.getStringCellValue());

                    //Year of Study
                    Cell cell7 = row.getCell(6);
                   
                    currentCellNum=7;
                    student.setYearOfStudy(cell7.getStringCellValue());

                    //Programme
                    Cell cell8 = row.getCell(7);
                   
                    currentCellNum=8;
                    student.setProgramme(cell8.getStringCellValue());

                    //Mode of Transport - TransportTravelFactors
                    Cell cell9 = row.getCell(8);
                   
                    currentCellNum=9;
                    TransportTravelFactors travelFactors = new TransportTravelFactors();
                    travelFactors.setStudent(student);
                    travelFactors.setTransportMethods(cell9.getStringCellValue());


                    //Home or international student
                    Cell cell10 = row.getCell(9);
                   
                    currentCellNum=10;
                    student.setStudentStatus(String.valueOf(row.getCell(9))); //Used this as there was cell reading problem

                    //Is a Course TFR Req'd? (course transfer)
                    Cell cell11 = row.getCell(10);
                   
                    currentCellNum=11;
                    if (cell11.getStringCellValue() == "Yes") {
                        student.setCourseTransferRequired(Boolean.TRUE);
                    } else {
                        student.setCourseTransferRequired(Boolean.FALSE);
                    }

                    //Additional Notes
                    Cell cell12 = row.getCell(11);
                    System.out.println(cell12);
                    currentCellNum=12;
                    student.setAdditionalNotes(cell12.getStringCellValue());


                    //PLACEMENT PROVIDER DETAILS SECTION
                    PPFPlacementProviderDetails placementProviderDetails = new PPFPlacementProviderDetails();
                    placementProviderDetails.setStudent(student);

                    //Placement Provider Name
                    Cell cell13 = row.getCell(12);
                   
                    currentCellNum=13;
                    placementProviderDetails.setOrganisationName(cell13.getStringCellValue());

                    //Placement Address - Number and Road
                    Cell cell14 = row.getCell(13);
                   
                    currentCellNum=14;
                    //This assignment of cell is with cell17

                    //Placement Postcode
                    Cell cell15 = row.getCell(14);
                   
                    currentCellNum=15;
                    placementProviderDetails.setPostCode(cell15.getStringCellValue());

                    //Placement city
                    Cell cell16 = row.getCell(15);
                   
                    currentCellNum=16;
                    //This assignment of cell is with cell17

                    //Placement Country
                    Cell cell17 = row.getCell(16);
                   
                    currentCellNum=17;
                    placementProviderDetails.setPlacementAddress(
                            cell14.getStringCellValue() + " " +
                                    cell16.getStringCellValue() + " " +
                                    cell17.getStringCellValue()
                    );

                    //Placement Contact Name
                    PPFPlacementProviderNamedContact placementContact = new PPFPlacementProviderNamedContact();
                    placementContact.setStudent(student);
                    placementContact.setCompany(placementProviderDetails);

                    Cell cell18 = row.getCell(17);
                   
                    currentCellNum=18;
                    placementContact.setName(cell18.getStringCellValue());

                    //Placement Contact Telephone Number
                    Cell cell19 = row.getCell(18);
                   
                    currentCellNum=19;
                    if (cell19.getCellType() == CellType.STRING) {
                        placementContact.setTelNumber(cell19.getStringCellValue());
                    } else if (cell19.getCellType() == CellType.NUMERIC) {
                        placementContact.setTelNumber(String.valueOf(cell19.getNumericCellValue()));
                    }

                    //Placement Contact Email
                    Cell cell20 = row.getCell(19);
                   
                    currentCellNum=20;
                    placementContact.setEmail(cell20.getStringCellValue());

                    //PLACEMENT APPROVAL SECTION

                    //Date of authorisation request form received
                    DatesOfFormCompletions dates = new DatesOfFormCompletions();
                    dates.setStudent(student);
                    dates.setCompany(placementProviderDetails);

                    Cell cell21 = row.getCell(20);
                   
                    currentCellNum=21;
                    //Had to handle a lot with dates, as it is very hard. Especially as java.util and java.sql are not compatible
                    java.util.Date utilDate = cell21.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell21.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell21.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                dates.setStudentAuthorisationRequestFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell21);
                            if (!cellValue.isEmpty()) {
                                dates.setStudentAuthorisationRequestFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        dates.setStudentAuthorisationRequestFormReceived(sqlDate);
                    }

                    //Date of Placement Provider Form Received
                    Cell cell22 = row.getCell(21);
                   
                    currentCellNum=22;
                    utilDate = cell22.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell22.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell22.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                dates.setProviderFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell22);
                            if (!cellValue.isEmpty()) {
                                dates.setProviderFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        dates.setProviderFormReceived(sqlDate);
                    }

                    //Date of Placement Assessment Form Received
                    Cell cell23 = row.getCell(22);
                   
                    currentCellNum=23;
                    utilDate = cell23.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell23.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell23.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                dates.setAssessmentFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell23);
                            if (!cellValue.isEmpty()) {
                                dates.setAssessmentFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        dates.setAssessmentFormReceived(sqlDate);
                    }

                    //Placement Job Title
                    Role role = new Role();
                    role.setStudent(student);
                    role.setCompany(placementProviderDetails);

                    Cell cell24 = row.getCell(23);
                   
                    currentCellNum=24;
                    role.setRoleTitle(cell24.getStringCellValue());

                    //placement salary (annual) £
                    Cell cell25 = row.getCell(24);
                   
                    currentCellNum=25;
                    role.setAnnualSalaryRange(cell25.getStringCellValue());

                    //placement start date
                    Cell cell26 = row.getCell(25);
                   
                    currentCellNum=26;
                    utilDate = cell26.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell26.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell26.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                role.setRoleStartDate(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell26);
                            if (!cellValue.isEmpty()) {
                                role.setRoleStartDate(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        role.setRoleStartDate(sqlDate);
                    }

                    //placement end date
                    Cell cell27 = row.getCell(26);
                   
                    currentCellNum=27;
                    utilDate = cell27.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell27.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell27.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                role.setRoleEndDate(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell27);
                            if (!cellValue.isEmpty()) {
                                role.setRoleEndDate(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        role.setRoleEndDate(sqlDate);
                    }

                    //Name of placement tutor completing placement assessment
                    RiskForm riskForm = new RiskForm();
                    dates.setRiskForm(riskForm);

                    Cell cell28 = row.getCell(27);
                   
                    currentCellNum=28;
                    riskForm.setStudent(student);
                    riskForm.setTutorName(cell28.getStringCellValue());

                    //Does the student have a Student Visa
                    Cell cell29 = row.getCell(28);
                   
                    currentCellNum=29;
                    student.setStudentStatus(cell29.getStringCellValue());

                    //Does the student visa include a placement?
                    Cell cell30 = row.getCell(29);
                   
                    currentCellNum=30;
                    if (cell30.getStringCellValue() == "No" || cell30.getStringCellValue() == "N/A") {
                        student.setVisaDuration(Boolean.FALSE);
                    } else if (cell30.getStringCellValue() == "Yes") {
                        student.setVisaDuration(Boolean.TRUE);
                    }

                    //SIAC Notes The University’s Student Immigration Advice and Compliance team (SIAC)
                    Cell cell31 = row.getCell(30);
                   
                    currentCellNum=31;
                    riskForm.setSiacNotes(cell31.getStringCellValue());

                    //Decision of Placement assessment
                    Cell cell32 = row.getCell(31);
                   
                    currentCellNum=32;
                    riskForm.setPlacementDecision(cell32.getStringCellValue());

                    //Date of authorisation email sent //here is assuming that the email is sent straight after risk form is completed
                    Cell cell33 = row.getCell(32);
                   
                    currentCellNum=33;
                    utilDate = cell33.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell33.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell33.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                riskForm.setPlacementDate(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell33);
                            if (!cellValue.isEmpty()) {
                                riskForm.setPlacementDate(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        riskForm.setPlacementDate(sqlDate);
                    }


                    //Date of placement briefing attended //only added to model class, not form
                    Cell cell34 = row.getCell(33);
                   
                    currentCellNum=34;
                    utilDate = cell34.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell34.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell34.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                riskForm.setPlacementBriefing(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell34);
                            if (!cellValue.isEmpty()) {
                                riskForm.setPlacementBriefing(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        riskForm.setPlacementBriefing(sqlDate);
                    }

                    //Insurance issued (only required for overseas placement)
                    Cell cell35 = row.getCell(34);
                   
                    currentCellNum=35;
                    riskForm.setInsuranceIssued(cell35.getStringCellValue());

                    //MONITORING AND EVALUATION SECTION
                    MonitoringAndEvaluation monitoringAndEvaluation = new MonitoringAndEvaluation();
                    monitoringAndEvaluation.setStudent(student);
                    monitoringAndEvaluation.setCompany(placementProviderDetails);

                    //dateOfPlacementProviderStartCheck
                    Cell cell36 = row.getCell(35);
                   
                    currentCellNum=36;
                    utilDate = cell36.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell36.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell36.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementProviderStartCheck(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell36);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementProviderStartCheck(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfPlacementProviderStartCheck(sqlDate);
                    }


                    //dateOfPlacementStudentStartCheck
                    Cell cell37 = row.getCell(36);
                   
                    currentCellNum=37;
                    utilDate = cell37.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell37.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell37.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementStudentStartCheck(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell37);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementStudentStartCheck(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfPlacementStudentStartCheck(sqlDate);
                    }

                    //studentResidentialAddressWhileOnPlacement
                    Cell cell38 = row.getCell(37);
                   
                    currentCellNum=38;
                    monitoringAndEvaluation.setStudentResidentialAddressWhileOnPlacement(cell38.getStringCellValue());

                    //studentWorkEmail
                    Cell cell39 = row.getCell(38);
                   
                    currentCellNum=39;
                    monitoringAndEvaluation.setStudentWorkEmail(cell39.getStringCellValue());

                    //dateOfMostRecentMonthlyReflectiveJournal
                    Cell cell40 = row.getCell(39);
                   
                    currentCellNum=40;
                    utilDate = cell40.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell40.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell40.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfMostRecentMonthlyReflectiveJournal(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell40);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfMostRecentMonthlyReflectiveJournal(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfMostRecentMonthlyReflectiveJournal(sqlDate);
                    }

                    //dateThatStudentVisaEscalationProcessStartedWithComplianceTeam
                    Cell cell41 = row.getCell(40);
                   
                    currentCellNum=41;
                    utilDate = cell41.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell41.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell41.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfStudentVisaEscalation(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell41);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfStudentVisaEscalation(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfStudentVisaEscalation(sqlDate);
                    }

                    //Date that SIAC reported the placement details to UKVI
                    Cell cell42 = row.getCell(41);
                   
                    currentCellNum=42;
                    CellType cellType1 = cell42.getCellType();
                    String cellValue1;
                    if (cellType1 == CellType.STRING) {
                        cellValue1 = cell42.getStringCellValue();
                    }
                    else if (cellType1==CellType.NUMERIC){
                        cellValue1 = String.valueOf(cell42.getNumericCellValue());
                    }
                    else{
                        cellValue1= String.valueOf(cell42.getDateCellValue());
                    }
                    monitoringAndEvaluation.setDateOfSIACReportingToUKVI(cellValue1); //Is a string as there is no validation for it in excel old database


                    //dateOfFirstPlacementVisitCompleted
                    Cell cell43 = row.getCell(42);
                   
                    currentCellNum=43;
                    utilDate = cell43.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell43.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell43.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfFirstPlacementVisitCompleted(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell43);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfFirstPlacementVisitCompleted(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfFirstPlacementVisitCompleted(sqlDate);
                    }


                    //dateOfSecondPlacementVisitCompleted
                    Cell cell44 = row.getCell(43);
                   
                    currentCellNum=44;
                    utilDate = cell44.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell44.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell44.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfSecondPlacementVisitCompleted(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell44);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfSecondPlacementVisitCompleted(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfSecondPlacementVisitCompleted(sqlDate);
                    }

                    //dateOfPlacementProviderEvaluationFormReceived
                    Cell cell45 = row.getCell(44);
                   
                    currentCellNum=45;
                    utilDate = cell45.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell45.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell45.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementProviderEvaluationFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell45);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementProviderEvaluationFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfPlacementProviderEvaluationFormReceived(sqlDate);
                    }

                    //dateOfPlacementStudentEvaluationFormReceived
                    Cell cell46 = row.getCell(45);
                   
                    currentCellNum=46;
                    utilDate = cell46.getDateCellValue();
                    if (utilDate == null) {                                               //Deals with nullPointerException
                        CellType cellType = cell46.getCellType();
                        if (cellType == CellType.STRING) {
                            String cellValue = cell46.getStringCellValue();
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementStudentEvaluationFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        } else {
                            DataFormatter dataFormatter = new DataFormatter();             //Helps also deal with empty cells
                            String cellValue = dataFormatter.formatCellValue(cell46);
                            if (!cellValue.isEmpty()) {
                                monitoringAndEvaluation.setDateOfPlacementStudentEvaluationFormReceived(java.sql.Date.valueOf(cellValue));
                            }
                        }
                    } else {
                        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                        monitoringAndEvaluation.setDateOfPlacementStudentEvaluationFormReceived(sqlDate);
                    }

                    //placementEndReason
                    Cell cell47 = row.getCell(46);
                   
                    currentCellNum=47;
                    monitoringAndEvaluation.setPlacementEndReason(cell47.getStringCellValue());

                    //END
                    //MISCELLANEOUS ITEMS

                    //StudentFinanceTeamNotes
                    StudentFinanceTeam studentFinanceTeam = new StudentFinanceTeam();
                    studentFinanceTeam.setStudent(student);
                    Cell cell49 = row.getCell(48);
                   
                    currentCellNum=49;
                    studentFinanceTeam.setStudentFinanceTeamNotes(cell49.getStringCellValue());

                    //BLACKBOARD ADMIN SECTION

                    //Added to on-placement BB module?
                    BlackboardAdmin bb = new BlackboardAdmin();
                    bb.setStudent(student);
                    bb.setMonitoringAndEvaluation(monitoringAndEvaluation);
                    Cell cell50 = row.getCell(49);
                   
                    currentCellNum=50;
                    bb.setOn_placementModule(cell50.getStringCellValue());

                    //Added to BB group?
                    Cell cell51 = row.getCell(50);
                   
                    currentCellNum=51;
                    bb.setOn_placementGroup(cell51.getStringCellValue());

                    //Sent Email to student about changes
                    Cell cell52 = row.getCell(51);
                   
                    currentCellNum=52;
                    bb.setStudentEmailed(cell52.getStringCellValue());


                    studentRepo.save(student);
                    riskRepo.save(riskForm);
                    transportTravelFactorsRepo.save(travelFactors);
                    PPFPlacementProviderDetailsRepo.save(placementProviderDetails);
                    placementProviderContactRepo.save(placementContact);
                    datesRepo.save(dates);
                    roleRepo.save(role);

                    monitorAndEvalRepo.save(monitoringAndEvaluation);
                    stuFinanceRepo.save(studentFinanceTeam);
                    bbAdminRepo.save(bb);

                   
                    workbook.close();
                    inputStream.close();
                   


                    //UNDERGRADUATE DATABASE READ
                    //------------------------------------------------------------------------------------
                    //------------------------------------------------------------------------------------
                } catch (IllegalStateException e){
                    Map<Integer, String> dict = new HashMap<>();
                    dict.put(0, "Before 1st cell is read");
                    dict.put(1, "A");
                    dict.put(2, "B");
                    dict.put(3, "C");
                    dict.put(4, "D");
                    dict.put(5, "E");
                    dict.put(6, "F");
                    dict.put(7, "G");
                    dict.put(8, "H");
                    dict.put(9, "I");
                    dict.put(10, "J");
                    dict.put(11, "K");
                    dict.put(12, "L");
                    dict.put(13, "M");
                    dict.put(14, "N");
                    dict.put(15, "O");
                    dict.put(16, "P");
                    dict.put(17, "Q");
                    dict.put(18, "R");
                    dict.put(19, "S");
                    dict.put(20, "T");
                    dict.put(21, "U");
                    dict.put(22, "V");
                    dict.put(23, "W");
                    dict.put(24, "X");
                    dict.put(25, "Y");
                    dict.put(26, "Z");
                    dict.put(27, "AA");
                    dict.put(28, "AB");
                    dict.put(29, "AC");
                    dict.put(30, "AD");
                    dict.put(31, "AE");
                    dict.put(32, "AF");
                    dict.put(33, "AG");
                    dict.put(34, "AH");
                    dict.put(35, "AI");
                    dict.put(36, "AJ");
                    dict.put(37, "AK");
                    dict.put(38, "AL");
                    dict.put(39, "AM");
                    dict.put(40, "AN");
                    dict.put(41, "AO");
                    dict.put(42, "AP");
                    dict.put(43, "AQ");
                    dict.put(44, "AR");
                    dict.put(45, "AS");
                    dict.put(46, "AT");
                    dict.put(47, "AU");
                    dict.put(48, "AV");
                    dict.put(49, "AW");
                    dict.put(50, "AX");
                    dict.put(51, "AY");
                    dict.put(52, "AZ");
                    dict.put(53, "BA");
                    dict.put(54, "BB");


                    String errorMessage = "A problem happened whilst reading cell "+dict.get(currentCellNum)+" (Column " + currentCellNum + ") on Row "+currentRowNum +" of the old Excel database, in the sheet for "+databaseSheet+ " details. Please check and make sure the cell value is the correct data type and inputted correctly in the Excel database, and try again.\nIf the problem persists, please contact the IT admin";
                    model.addAttribute("errorMessage", errorMessage);
                    workbook.close();
                    inputStream.close();
                    return "/OldExcelDatabase/errorUploadingDatabase";

                }
            }
//
        }
        catch (NotOfficeXmlFileException e){
            String errorMessage = "Invalid file type/format has been uploaded. Please check it is the Excel master tracker database and try again. If problem persists, please contact the IT admin";
            model.addAttribute("errorMessage", errorMessage);
            return "/OldExcelDatabase/errorUploadingDatabase";
        }

        catch (EmptyFileException e){
            String errorMessage = "Please upload a file";
            model.addAttribute("errorMessage", errorMessage);
            return "/OldExcelDatabase/errorUploadingDatabase";}

        catch (Exception e){
            //Keeping this console output to help IT admin detect issue
           
//           
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            String stackTrace = sw.toString();
            int lineNumber = e.getStackTrace()[0].getLineNumber();
            String fileName = e.getStackTrace()[0].getFileName();
            String relevantLine = "";

            try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                for (int i = 1; i < lineNumber; i++) {
                    br.readLine();
                }
                relevantLine = br.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
           
            String errorMessage="Something went wrong whilst uploading the file. Please check it is the Excel master tracker database and try again. If problem persists, please contact the IT admin";
            model.addAttribute("errorMessage", errorMessage);
            return "/OldExcelDatabase/errorUploadingDatabase";
        }

        return this.readExcelPostgraduate(file, model);
    }





    /**
     * This method processes the other methods (Undergraduate reading and Postgraduate reading) involved for uploading the database details
     *
     * @param file          The upload file
     * @param model         The controller's model

     * @return The reading of the undergraduate database method, which leads onto
     * the postgraduate database method, and then the success jsp page (or error jsp page if errors encountered)
     *
     * @author Maryam (@mzg1)
     */
    @PostMapping("/read-excel")
    public String readExcel(Model model, @RequestParam("file")MultipartFile file) throws IOException {
        return this.readExcelUndergraduate(file, model);
    }


}