package com.group14.placementtrackingsystem.controllerUpload;

import com.group14.placementtrackingsystem.PlacementTrackingSystemApplication;
import com.group14.placementtrackingsystem.model.*;
import com.group14.placementtrackingsystem.repository.*;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.*;
import static com.group14.placementtrackingsystem.controllerUpload.UploadHelperMethods.*;


@Controller
@RequestMapping("/public")
public class StudentUploadController {

    @Autowired
    private StudentRepository StuRepo;
    @Autowired
    private HealthEnvironmentalFactorsRepository HealthRepo;
    @Autowired
    private RoleRepository RoleRepo;
    @Autowired
    private PPFWorkFactorsRepo WorkFactorRepo;
    @Autowired
    private TransportTravelFactorsRepository TransportRepo;
    @Autowired
    private LocationRegionalFactorsRepository LocationRepo;
    @Autowired
    private PersonalFactorsRepository PersonalFactorRepo;
    @Autowired
    private PolicyAndInsuranceRepository PolicyInsuranceRepo;
    @Autowired
    private PPFProviderDetailsRepo providerDetailsRepo;
    @Autowired
    private PPFPNamedContactRepo namedContactRepo;

    @Autowired
    private PlacementRepository PlacementRepo;


    @RequestMapping("/newStudentUpload")
    public String newStudentUpload() {
        return "/UploadForm/StudentUploadForm";
    }
    @Autowired
    private ServletContext context;

    /**
     * This controller method handles the upload of the file
     * @author aamd1
     * @param file the upload file
     * **/
    @RequestMapping("/addStudentUpload")
    public ResponseEntity addStudentUpload(@RequestParam("file") MultipartFile file) {
        try {
            String filename = file.getOriginalFilename();

            // To include - Save the file to a directory
            FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
            XWPFDocument document = new XWPFDocument(fileInputStream);
            List<XWPFTable> tables = document.getTables();

            ResponseEntity response = this.handleStoring(tables);
            File storedFile = new File(processString(tables.get(0).getRows(),0,3)+".docx");
            try{
                // Extracting the student number to be used in the student file name string.
                String FileNewName=  processString(tables.get(0).getRows(),0,3)+"_"+LocalDate.now();

                storedFile.createNewFile();

                // Creating an array of bytes to store the content of the file
                byte[] FileReadBytes = file.getBytes();
                // Get the new path for the file
                Path newFileLocation = Paths.get(context.getRealPath("StoredForms//StudentUploadedForms") +"/Student_"+FileNewName+".docx" );
                // Write the stored array of byte to the new path
                Files.write(newFileLocation, FileReadBytes);
                // Delete the temporary file
                storedFile.delete();
            }
            catch (Exception e){
                System.out.println("File could not be saved!");
                storedFile.delete();
            }
            fileInputStream.close();
            return response;
        }
        catch (Exception e){
            System.out.println("Something went wrong whilst uploading a file \n "+ e.fillInStackTrace().getMessage());
            return  ResponseEntity.badRequest().body("File NOT Received!");
        }
    }


    /**
     * The function handles the processing of the file including reading data, processing data and calling private methods.
     * @param tables a list of tables in the work document.
     * **/
    private ResponseEntity handleStoring(List<XWPFTable> tables){
        List<Integer> sectionHeaderIndecies = Arrays.asList(0, 10, 19, 29, 33, 39, 43, 49, 51);
        List<XWPFTableRow> rows;
        rows=tables.get(0).getRows();

        // Temporary type holder used for processing.
        String tempHolderString= "";
        Boolean tempHolderBoolean = false;

        // Response String
        String response ="";

        // Filling all fields as given in the docx form.
        try {

            Student student = new Student();
            student.setFirstName(processString(rows, 0,1));
            student.setSurname(processString(rows,0,2));
            student.setStudentNumber(processString(rows,0,3));
            student.setUniEmailAddress(processString(rows,0,4));
            student.setProgramme(processString(rows,0,5));
            student.setDepartmentOrSchool(processString(rows,0,6));
            student.setTelephoneNumber(processString(rows,0,7));
            tempHolderString =processString(rows,0,8);
            tempHolderString =tempHolderString.substring(0, tempHolderString.lastIndexOf("If no")).replace(" ", "").strip().toLowerCase();
            if (tempHolderString.equals("yes")){
                tempHolderString = "International";
            }
            else if (tempHolderString.equals("no")){
                tempHolderString = "Home";
            }
            else{
                tempHolderString = "";
            }
            student.setStudentStatus(tempHolderString);


            tempHolderString =processString(rows,0,9);
            tempHolderString =tempHolderString.substring(0, tempHolderString.lastIndexOf("If no")).replace(" ", "").strip().toLowerCase();
            if (tempHolderString.equals("yes")){
                tempHolderBoolean = true;
            }
            student.setVisaDuration(tempHolderBoolean);
            student= StuRepo.save(student);


            PPFPlacementProviderDetails placementProviderDetails = new PPFPlacementProviderDetails();
            placementProviderDetails.setOrganisationName(processString(rows,1,1));
            placementProviderDetails.setPlacementAddress(processString(rows,1,2));
            placementProviderDetails.setPostCode(processString(rows,1,3));
            placementProviderDetails.setWebAddress(processString(rows,1,4));
            placementProviderDetails.setStudent(student);
            placementProviderDetails = providerDetailsRepo.save(placementProviderDetails);

            PPFPlacementProviderNamedContact placementProviderNamedContact = new PPFPlacementProviderNamedContact();
            placementProviderNamedContact.setName(processString(rows,1,5));
            placementProviderNamedContact.setJobTitle(processString(rows,1,6));
            placementProviderNamedContact.setEmail(processString(rows,1,7));
            placementProviderNamedContact.setTelNumber(processString(rows,1,8));
            placementProviderNamedContact.setStudent(student);
            placementProviderNamedContact= namedContactRepo.save(placementProviderNamedContact);


            Role role = new Role();
            role.setRoleTitle(processString(rows,2,1));
            role.setRoleStartDate(getDate(rows.get(sectionHeaderIndecies.get(2)+2).getTableCells().get(1).getText()));

            role.setRoleEndDate(getDate(rows.get(sectionHeaderIndecies.get(2)+3).getTableCells().get(1).getText()));
            role.setWorkingHoursWeek(getFloatFromString(rows.get(sectionHeaderIndecies.get(2)+4).getTableCells().get(1).getText()));

            tempHolderString = rows.get(sectionHeaderIndecies.get(2)+5).getTableCells().get(1).getText();
            role.setProbationPeriod(getBooleanIntStateFromString(tempHolderString)==0);

            if(getIntFromString(tempHolderString)!=999999999) {
                // Checking if there exists a number inside the text field
                tempHolderString = tempHolderString.substring(tempHolderString.lastIndexOf(String.valueOf(getIntFromString(tempHolderString))));
                role.setProbationLength(tempHolderString.substring(tempHolderString.lastIndexOf(String.valueOf(getIntFromString(tempHolderString)))).strip());

            }

            role.setAnnualSalary(getIntFromString(rows.get(sectionHeaderIndecies.get(2)+6).getTableCells().get(1).getText()));

            tempHolderString = rows.get(sectionHeaderIndecies.get(2)+7).getTableCells().get(1).getText();
            role.setRoleSource(getOptionFromList(tempHolderString, PlacementTrackingSystemApplication.roleSources));
            role.setRoleSource(role.getRoleSource() + ", "+tempHolderString.substring(tempHolderString.lastIndexOf(":")+1).replace(" ", "").strip());
            role.setProviderInformedDegree(getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(2)+8).getTableCells().get(1).getText())==0);
            role.setRoleDescription(processString(rows,2,9));
            role.setStudent(student);
            role = RoleRepo.save(role);

            PPFWorkFactors workFactors = new PPFWorkFactors();
            workFactors.setRemoteWorkYes((byte) (getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(3)+1).getTableCells().get(1).getText())==0? 1:0) );
            workFactors.setRemoteWorkYesSupport(processString(rows,3,2));
            workFactors.setRomoteWorkYesReason(processString(rows,3,3));
            workFactors.setStudent(student);
            workFactors = WorkFactorRepo.save(workFactors);




            TransportTravelFactors transportTravelFactors = new TransportTravelFactors();

            tempHolderString = rows.get(sectionHeaderIndecies.get(4)+1).getTableCells().get(1).getText();
            transportTravelFactors.setTransportMethods(getMultiOptionFromList(tempHolderString, PlacementTrackingSystemApplication.transportMode));
            if(transportTravelFactors.getTransportMethods().contains("Other")) {
                transportTravelFactors.setTransportMethods(transportTravelFactors.getTransportMethods() + tempHolderString.substring(tempHolderString.lastIndexOf(":") + 1).replace(" ", "").strip());
            }
            tempHolderString = rows.get(sectionHeaderIndecies.get(4)+2).getTableCells().get(1).getText();
            transportTravelFactors.setWorkLocationConfirmed(getBooleanIntStateFromString(tempHolderString)==0);
            transportTravelFactors.setWorkLocationConfirmedFurtherDetails(tempHolderString.substring(tempHolderString.lastIndexOf(":")+1).replace(" ", "").strip());
            transportTravelFactors.setConfirmedWorkLocation(getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(4)+3).getTableCells().get(1).getText()));
            transportTravelFactors.setOverseasPlacement(getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(4)+4).getTableCells().get(1).getText())==0);
            transportTravelFactors.setOverseasTravelGuidance(getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(4)+5).getTableCells().get(1).getText())==0);
            transportTravelFactors.setStudent(student);
            transportTravelFactors = TransportRepo.save(transportTravelFactors);





            LocationRegionalFactors locationRegionalFactors = new LocationRegionalFactors();
            tempHolderString = rows.get(sectionHeaderIndecies.get(5)+1).getTableCells().get(1).getText();
            locationRegionalFactors.setAccommodationArrangements(PlacementTrackingSystemApplication.accommodationOptions[getBooleanIntStateFromString(tempHolderString)]);
            if(locationRegionalFactors.getAccommodationArrangements().contains("Other")) {
                locationRegionalFactors.setAccommodationArrangements(locationRegionalFactors.getAccommodationArrangements() + ", " + tempHolderString.substring(tempHolderString.lastIndexOf(":") + 1).replace(" ", "").strip());
            }
            locationRegionalFactors.setFcdoInfo(getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(5)+2).getTableCells().get(1).getText())==0);

            tempHolderString = rows.get(sectionHeaderIndecies.get(5)+3).getTableCells().get(1).getText();
            locationRegionalFactors.setRiskAware(getBooleanIntStateFromString(tempHolderString));
            locationRegionalFactors.setRiskDescription(tempHolderString.substring(tempHolderString.lastIndexOf(":")+1).replace(" ", "").strip());
            locationRegionalFactors.setStudent(student);
            locationRegionalFactors = LocationRepo.save(locationRegionalFactors);




            HealthEnvironmentalFactors healthEnvironmentalFactors = new HealthEnvironmentalFactors();
            tempHolderString = rows.get(sectionHeaderIndecies.get(6)+1).getTableCells().get(1).getText();
            healthEnvironmentalFactors.setPrecautionaryMeasuresAware(getBooleanIntStateFromString(tempHolderString)==0);
            healthEnvironmentalFactors.setPrecautionaryMeasuresDescription(tempHolderString.substring(tempHolderString.lastIndexOf(":")+1).replace(" ", "").strip());
            healthEnvironmentalFactors.setSafezoneDownloaded(getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(6)+2).getTableCells().get(1).getText())==0);
            healthEnvironmentalFactors.setGliCard(getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(6)+3).getTableCells().get(1).getText()));
            healthEnvironmentalFactors.setStudent(student);
            healthEnvironmentalFactors = HealthRepo.save(healthEnvironmentalFactors);



            PersonalFactors personalFactors = new PersonalFactors();
            personalFactors.setEmployerDisabilityAdjustments(getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(6)+5).getTableCells().get(1).getText()));
            personalFactors.setStudent(student);
            personalFactors= PersonalFactorRepo.save(personalFactors);
            PolicyAndInsurance policyAndInsurance = new PolicyAndInsurance();
            policyAndInsurance.setStudentTravelApplication(getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(7)+1).getTableCells().get(1).getText())==0);
            policyAndInsurance.setRiskAssessmentEscalation(getBooleanIntStateFromString(rows.get(sectionHeaderIndecies.get(7    )+2).getTableCells().get(1).getText())==0);
            policyAndInsurance.setStudent(student);
            policyAndInsurance = PolicyInsuranceRepo.save(policyAndInsurance);



            // Override the old rows list
            rows = tables.get(1).getRows();
            if(processString(rows,0,2).equals("") ||
                    processString(rows,0,3).equals("") ||
                    processString(rows,0,4).equals("")){
                System.out.println("The file is not find!");
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
/*
creating a new Placement object and setting its properties using the values provided.
Then it saves the new Placement object to the database using the PlacementRepo repository's save() metho so that it creates a new placement entry in the system
 */
            Placement placement = new Placement();
            placement.setStudent(student);
            placement.setCompany(placementProviderDetails);
            placement.setRole(role);
            placement.setProviderNamedContact(placementProviderNamedContact);
            placement.setWorkFactors(workFactors);
            placement.setHealthEnvironmentalFactors(healthEnvironmentalFactors);
            placement.setTransportTravelFactors(transportTravelFactors);
            placement.setLocationRegionalFactors(locationRegionalFactors);
            placement.setPersonalFactors(personalFactors);
            placement.setPolicyAndInsurance(policyAndInsurance);

            placement = PlacementRepo.save(placement);
            response += "File has been uploaded-"+placement.getId();
        }
        catch (Exception e ){
            System.out.println("An error has occurred whilst processing the inputs \n"+ e.getMessage());
            throw new RuntimeException(e);

        }
        return new ResponseEntity<>(response, HttpStatus.OK);

    }




}