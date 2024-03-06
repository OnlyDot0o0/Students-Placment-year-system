package com.group14.placementtrackingsystem.controllerUpload;

import com.group14.placementtrackingsystem.PlacementTrackingSystemApplication;
import com.group14.placementtrackingsystem.model.*;
import com.group14.placementtrackingsystem.repository.*;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.IBodyElement;
import java.io.FileInputStream;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.util.Date;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import static com.group14.placementtrackingsystem.controllerUpload.UploadHelperMethods.*;
@Controller
@RequestMapping("/public")
public class companyUploadController {

    @Autowired
    private StudentRepository StudentRepo;
    @Autowired
    public PPFDeclarationRepo declarationRepo;
    @Autowired
    public PPFFactorsRepo factorsRepo;
    @Autowired
    public PPFHealthRepo healthRepo;
    @Autowired
    public PPFPNamedContactRepo namedContactRepo;
    @Autowired
    public PPFPoliciesInsurenceOverseasRepo policiesOverseasRepo;
    @Autowired
    public PPFPoliciesInsurenceUkRepo policiesUkRepo;
    @Autowired
    public PPFProviderDetailsRepo companyRepo;
    @Autowired
    public PPFUniAccessRepo uniAccessRepo;
    @Autowired
    public PPFWorkFactorsRepo workFactorsRepo;

    @Autowired
    public RoleRepository roleRepo;
    @Autowired
    private ServletContext context;

    @RequestMapping("/newCompanyUpload")
    public String newStudentUpload() {
        return "/UploadForm/uploadCompany";
    }

    @RequestMapping("/addCompanyUpload")
    public ResponseEntity companyUpload(@RequestParam("file") MultipartFile file, Model model) {
        File storedFile = null;
        try {
            String filename = file.getOriginalFilename();
            storedFile = new File(filename);
            //writing to a file
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
            Date date = new Date();
            storedFile.createNewFile();

            // Creating an array of bytes to store the content of the file
            byte[] FileReadBytes = file.getBytes();
            // Get the new path for the file
            Path newFileLocation = Paths.get(context.getRealPath("StoredForms//CompanyUploadedForms") +"/Company_"+formatter.format(date)+".docx" );
            // Write the stored array of byte to the new path
            Files.write(newFileLocation, FileReadBytes);
            //ENDING
            // To include - Save the file to a directory
            FileInputStream fileInputStream = (FileInputStream) file.getInputStream();
            XWPFDocument document = new XWPFDocument(fileInputStream);
            List<XWPFTable> tables = document.getTables();
            ResponseEntity companyResponce  = this.handleStoring(tables, model, newFileLocation);
            fileInputStream.close();
            storedFile.delete();

//            return ResponseEntity.ok("File Received");
            return  companyResponce;
        } catch (Exception e) {
            System.out.println("Something went wrong whilst uploading a file \n " + e.fillInStackTrace().getMessage());
            storedFile.delete();
            return ResponseEntity.badRequest().body("File NOT Received!");
        }
    }


    /**
     * The function handles the processing of the file including reading data, processing data and calling private methods.
     *
     * @param tables a list of tables in the work document.
     **/
    private ResponseEntity handleStoring(List<XWPFTable> tables, Model model, Path filePath) {


        // Temporary type holder used for processing.
        String tempHolderString = "";
        Boolean tempHolderBoolean = false;

        // Filling all fields as given in the docx form.
        try {
            //FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/webapp/StoredForms/CompanyUploadedForms/");
            FileInputStream fis = new FileInputStream(filePath.toString());

            XWPFDocument xdoc = new XWPFDocument(OPCPackage.open(fis));
            Iterator<IBodyElement> bodyElementIterator = xdoc.getBodyElementsIterator();
            while (bodyElementIterator.hasNext()) {
                IBodyElement element = bodyElementIterator.next();

                if ("TABLE".equalsIgnoreCase(element.getElementType().name())) {
                    List<Integer> HeaderIndecies = Arrays.asList(0, 6, 8, 13, 20, 25, 28, 30, 32, 34, 38, 42, 46, 49);
                    List<XWPFTable> tableList = element.getBody().getTables();
                    XWPFTable table1 = tableList.get(0); //GETS THE FIRST TABLE.
                    List<XWPFTableRow> rows = table1.getRows();
                    PPFPlacementProviderDetails placement_provider_details = new PPFPlacementProviderDetails();
                    placement_provider_details.setOrganisationName(rows.get(HeaderIndecies.get(0) + 1).getCell(1).getText().strip().toString());
                    placement_provider_details.setPlacementAddress(table1.getRow(HeaderIndecies.get(0) + 2).getCell(1).getText().strip().toString());
                    placement_provider_details.setPostCode(table1.getRow(HeaderIndecies.get(0) + 3).getCell(1).getText().strip().toString());
                    placement_provider_details.setWebAddress(table1.getRow(HeaderIndecies.get(0) + 4).getCell(1).getText().strip().toString());
                    placement_provider_details.setEngagesRegulatedActivities(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(0) + 5).getCell(1).getText().strip().toString())); //TO FIX THAT FETCH FROM 5
                    placement_provider_details.setEngagesRegulatedActivitiesYes(UploadHelperMethods.getExplanation(table1.getRow(HeaderIndecies.get(0) + 5).getCell(1).getText().strip().toString()));//TO FIX THAT FETCH AND SPLIT FROM 5



                    PPFPlacementProviderNamedContact namedContact = new PPFPlacementProviderNamedContact();
                    //STUDENT NAME SEPARATION, FIRST NAME AND LAST NAME FROM FORM.
                    String[] form_student_fullname = table1.getRow(HeaderIndecies.get(1) + 1).getCell(1).getText().toString().strip().split(" ");
                    String form_student_firstname = form_student_fullname[0].strip();
                    String form_student_surname = form_student_fullname[1].strip();
//                    //PLACEMENT Student SECTION FROM HEADER 6+1. (1)+1.

                    Student s = StudentRepo.findByFirstNameAndSurname(form_student_firstname, form_student_surname);
                    namedContact.setStudent(s); //RETURN FIRST FOUND STUDENT

                    //NAMED CONTACT SECTION (2)
                    namedContact.setCompany(placement_provider_details);
                    namedContact.setName(UploadHelperMethods.replace(table1.getRow(HeaderIndecies.get(2) + 1).getCell(1).getText().strip().toString()));
                    namedContact.setJobTitle(UploadHelperMethods.replace(table1.getRow(HeaderIndecies.get(2) + 2).getCell(1).getText().strip().toString()));
                    namedContact.setEmail(UploadHelperMethods.replace(table1.getRow(HeaderIndecies.get(2) + 3).getCell(1).getText().strip().toString()));

                    namedContact.setTelNumber(UploadHelperMethods.replace(table1.getRow(HeaderIndecies.get(2) + 4).getCell(1).getText().strip().toString()));
//                    //(3)
                    Role role = new Role();
                    role.setCompany(placement_provider_details);
                    role.setRoleTitle(UploadHelperMethods.replace(table1.getRow(HeaderIndecies.get(3)+1).getCell(1).getText().toString()));
                    role.setRoleStartDate(UploadHelperMethods.getDate(table1.getRow(HeaderIndecies.get(3)+2).getCell(1).getText().toString()));
                    role.setRoleEndDate(UploadHelperMethods.getDate(table1.getRow(HeaderIndecies.get(3)+3).getCell(1).getText().toString()));
                    role.setWorkingHoursWeek(UploadHelperMethods.getFloatFromString(table1.getRow(HeaderIndecies.get(3)+4).getCell(1).getText().toString()));
                    role.setProbationPeriod(UploadHelperMethods.getBooleanIntStateFromString(table1.getRow(HeaderIndecies.get(3)+5).getCell(1).getText().toString())==0); //BOOLEAN
                    role.setProbationAssessment(UploadHelperMethods.getExplanation(table1.getRow(HeaderIndecies.get(3)+5).getCell(1).getText().toString())); //EXPLANATION OF ABOVE
                    role.setAchievement(UploadHelperMethods.replace(table1.getRow(HeaderIndecies.get(3)+6).getCell(1).getText().toString()));
                    role.setStudent(s);

                    //(4)
                  PPFWorkFactors work_factors = new PPFWorkFactors();
                    work_factors.setCompany(placement_provider_details);
                  work_factors.setExposeToHazard(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(4)+1).getCell(1).getText().toString()));

                  work_factors.setExposeToHazardYes(UploadHelperMethods.getExplanation(table1.getRow(HeaderIndecies.get(4)+1).getCell(1).getText().toString()));
                  work_factors.setTrainingReq(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(4)+2).getCell(1).getText().toString()));
                  work_factors.setTrainingReqYes(UploadHelperMethods.getExplanation(table1.getRow(HeaderIndecies.get(4)+2).getCell(1).getText().toString()));
                  work_factors.setRemoteWork(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(4)+3).getCell(1).getText().toString()));
                  work_factors.setRemoteWorkYes(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(4)+3).getCell(1).getText().toString()));
                  work_factors.setRemoteWorkYesSupport(UploadHelperMethods.replace(table1.getRow(HeaderIndecies.get(4)+4).getCell(1).getText().toString()));

                  //                    //(5)
                  PPFFactors factors = new PPFFactors();
                  factors.setCompany(placement_provider_details);

                  factors.setTravelSites(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(5)+1).getCell(1).getText().toString()));
                  factors.setTravelSitesYes(UploadHelperMethods.getExplanation(table1.getRow(HeaderIndecies.get(5)+1).getCell(1).getText().toString()));
                  factors.setTravelReqOverseas(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(5)+2).getCell(1).getText().toString()));
//                  //(7?)
                  factors.setHealthPrecautionary(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(7)+1).getCell(1).getText().toString()));
                  factors.setHealthPrecautionaryYes(UploadHelperMethods.getExplanation(table1.getRow(HeaderIndecies.get(7)+1).getCell(1).getText().toString()));
                  factors.setPersoFactors((UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(8)+1).getCell(1).getText().toString())));
//                    // CONTINUED FROM 5 (6)
                  factors.setLocationRisk(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(6)+1).getCell(1).getText().toString()));
                  factors.setLocationRiskYes(UploadHelperMethods.getExplanation(table1.getRow(HeaderIndecies.get(6)+1).getCell(1).getText().toString()));
//                    //(9)
                  PPFPoliciesAndInsuranceUK ukPolicices = new PPFPoliciesAndInsuranceUK();
                  ukPolicices.setCompany(placement_provider_details);

                  ukPolicices.setPublicLiabilityIns(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(9)+1).getCell(1).getText().toString()));
                  ukPolicices.setPlNameProvider(UploadHelperMethods.getName(table1.getRow(HeaderIndecies.get(9)+1).getCell(1).getText().toString()));
                  ukPolicices.setPlExpiry(getDate(table1.getRow(HeaderIndecies.get(9)+1).getCell(1).getText().toString()));
                  ukPolicices.setPlNo(UploadHelperMethods.getExplanation(table1.getRow(HeaderIndecies.get(9)+1).getCell(1).getText().toString()));
                  ukPolicices.setEmployerLiabilityIns(UploadHelperMethods.getByteFromString(table1.getRow(HeaderIndecies.get(9)+2).getCell(1).getText().toString()));
                  ukPolicices.setElNameProvider(UploadHelperMethods.getName(rows.get(HeaderIndecies.get(9)+2).getCell(1).getText().toString()));
                  ukPolicices.setElExpiry(getDate(rows.get(HeaderIndecies.get(9)+2).getCell(1).getText().toString()));
                  ukPolicices.setElNo(UploadHelperMethods.getExplanation(rows.get(HeaderIndecies.get(9)+2).getCell(1).getText().toString()));
                  ukPolicices.setProIndemIns(UploadHelperMethods.getByteFromString(rows.get(HeaderIndecies.get(9)+3).getCell(1).getText().toString()));
                  ukPolicices.setProNameProvider(UploadHelperMethods.getName(rows.get(HeaderIndecies.get(9)+3).getCell(1).getText().toString()));
                  ukPolicices.setProExpiry(getDate(rows.get(HeaderIndecies.get(9)+3).getCell(1).getText().toString()));
//                    //(10)
                  PPFPoliciesAndInsuranceOVERSEAS overseasPolices = new PPFPoliciesAndInsuranceOVERSEAS();

                  overseasPolices.setCompany(placement_provider_details);
                  overseasPolices.setLiabilityIns(UploadHelperMethods.getByteFromString(rows.get(HeaderIndecies.get(10)+1).getCell(1).getText().toString()));
                  overseasPolices.setLiNameProvider(UploadHelperMethods.getName(rows.get(HeaderIndecies.get(10)+1).getCell(1).getText().toString()));

                  overseasPolices.setLiExpiry(getDate(rows.get(HeaderIndecies.get(10)+1).getCell(1).getText().toString()));
                  overseasPolices.setRoleIns(UploadHelperMethods.getByteFromString(rows.get(HeaderIndecies.get(10)+2).getCell(1).getText().toString()));
                  overseasPolices.setRoleInsProviderName(UploadHelperMethods.getName(rows.get(HeaderIndecies.get(10)+2).getCell(1).getText().toString()));
                  overseasPolices.setRoleInsExpiry(getDate(rows.get(HeaderIndecies.get(10)+2).getCell(1).getText().toString()));
                  overseasPolices.setCompCosts(UploadHelperMethods.getByteFromString(rows.get(HeaderIndecies.get(10)+3).getCell(1).getText().toString()));
                  overseasPolices.setCompCostsProviderName(UploadHelperMethods.getName(rows.get(HeaderIndecies.get(10)+3).getCell(1).getText().toString()));
                  overseasPolices.setCompCostsExpiry(getDate(rows.get(HeaderIndecies.get(10)+3).getCell(1).getText().toString()));
//                    //(11)
                  PPFhealth health = new PPFhealth();

                  health.setCompany(placement_provider_details);
                  health.sethSTrain(UploadHelperMethods.getByteFromString(rows.get(HeaderIndecies.get(11)+1).getCell(1).getText().toString()));
                  health.setRecRepAcc(UploadHelperMethods.getByteFromString(rows.get(HeaderIndecies.get(11)+2).getCell(1).getText().toString()));
                  health.setWrittenHS(UploadHelperMethods.getByteFromString(rows.get(HeaderIndecies.get(11)+3).getCell(1).getText().toString()));
//                    //(12)
                  PPFUniAccess access = new PPFUniAccess();
                  access.setCompany(placement_provider_details);
                  access.setIssues_Conf(UploadHelperMethods.getByteFromString(rows.get(HeaderIndecies.get(12)+1).getCell(1).getText().toString()));
                  access.setIssuesYes(UploadHelperMethods.getExplanation(rows.get(HeaderIndecies.get(12)+1).getCell(1).getText().toString()));
                  access.setVisits(UploadHelperMethods.getByteFromString(rows.get(HeaderIndecies.get(12)+2).getCell(1).getText().toString()));
                  access.setVisitsNo(UploadHelperMethods.getExplanation(rows.get(HeaderIndecies.get(12)+2).getCell(1).getText().toString()));

//                    //13
                    PPFDeclaration declaration = new PPFDeclaration();
                    declaration.setName(UploadHelperMethods.replace(rows.get(HeaderIndecies.get(13)+2).getCell(1).getText().toString()));
                    declaration.setJobTitle(UploadHelperMethods.replace(rows.get(HeaderIndecies.get(13)+3).getCell(1).getText().toString()));
                    declaration.setSignature(UploadHelperMethods.replace(rows.get(HeaderIndecies.get(13)+4).getCell(1).getText().toString()));
                    declaration.setDate(getDate(rows.get(HeaderIndecies.get(13)+5).getCell(1).getText().toString()));
                    declaration.setCompany(placement_provider_details);

                    placement_provider_details = companyRepo.save(placement_provider_details);

                    namedContactRepo.save(namedContact);
                    placement_provider_details.getNamedContactList().add(namedContact);

                    workFactorsRepo.save(work_factors);
                    placement_provider_details.setWorkFactors(work_factors);

                    factorsRepo.save(factors);
                    placement_provider_details.setFactor(factors);

                    policiesUkRepo.save(ukPolicices);
                    placement_provider_details.setPolciesInsUk(ukPolicices);

                    policiesOverseasRepo.save(overseasPolices);
                    placement_provider_details.setPolciesInsOverseas(overseasPolices);

                    healthRepo.save(health);
                    placement_provider_details.setHealth(health);

                    uniAccessRepo.save(access);
                    placement_provider_details.setUniAccess(access);

                    declaration= declarationRepo.save(declaration);
                    placement_provider_details.setDeclaration(declaration);

                    roleRepo.save(role);
                    placement_provider_details.setRole(role);

                    placement_provider_details = companyRepo.save(placement_provider_details);

                }

            }
        } catch (Exception e) {
            System.out.println("An error has occurred whilst processing the inputs \n" + e.getMessage());
            throw new RuntimeException(e);

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok("File has been uploaded");


    }


}
