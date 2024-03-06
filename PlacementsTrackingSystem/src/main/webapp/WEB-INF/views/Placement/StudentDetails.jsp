<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Students Details</title>
    <link rel="stylesheet" href="../../../css/landing.css">
    <link rel="stylesheet" href="../../../css/RiskForm.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <link rel="stylesheet" href="../../../css/StudentDetails.css">
    <script src="../../../js/helperScript.js"></script>
</head>
<body>

<nav class="navbar navbar-dark  navbar-expand navbar-static-top ">
    <div class="container-fluid">

        <div class="navbar-header col-xs-6">
            <span><img  class=navbar-brand" src="../../../css/uniLogo.png"></span>
        </div>

        <ul  class="nav navbar-nav navbar-text center">
            <li ><span><h1 class="title">${student.firstName} ${student.surname}'s Details</h1></span>
                </li>
        </ul>

        <ul class="nav navbar-nav navbar-right navbar-text menu" >
            <li><a href="javascript:;" onclick=" return logOut()"><span class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
        </ul>


        <ul class="nav navbar-nav navbar-right links navbar-text menu">

            <li class="active dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Access Placements
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/pendingPlacements">Pending Placements</a></li>
                    <li><a href="/internal">Currently on Placements</a></li>
                </ul>
            </li>


            <li><a href="/report">Report</a></li>

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Access Forms
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/public/newStudentUpload">Student Form</a></li>
                    <li><a href="/public/newCompanyUpload">Placement Provider Form</a></li>
                    <li><a href="/newForm">Risk Assessment Form</a></li>
                </ul>
            </li>

        </ul>
        <ul class="nav navbar-nav col-md-1 navbar-right ham " >
            <li ><a data-toggle="collapse" href="#collapse1"><span class="glyphicon glyphicon-menu-hamburger"></span></a></li>

        </ul>





    </div>
</nav>

<div id="collapse1" class="panel-collapse collapse">



    <div class="panel-body"> <button class="option" data-toggle="collapse" href="#collapsePlacements" style="width: 100%;">Access Placements</button></div>


    <div id="collapsePlacements" class="panel-collapse collapse">

        <div class="panel-body"> <button class="option"onclick="goTo('/internal')" style="width: 100%;">Currently on Placements</button></div>

        <div class="panel-body"> <button class="option" onclick="goTo('/pendingPlacements')" style="width: 100%;">Pending Placements</button></div>



    </div>

    <div class="panel-body"> <button class="option" onclick="goTo('/report')" style="width: 100%;">Report</button>


    </div>


    <div class="panel-body"> <button class="option" data-toggle="collapse" href="#collapse2" style="width: 100%;">Access Forms</button></div>



    <div id="collapse2" class="panel-collapse collapse">

        <div class="panel-body"> <button class="option" onclick="goTo('/public/newStudentUpload')" href="/public/newStudentUpload" style="width: 100%;">Student Form</button></div>

        <div class="panel-body"> <button class="option" onclick="goTo('/public/newCompanyUpload')" href="/public/newCompanyUpload" style="width: 100%;">Placement Provider Form</button></div>

        <div class="panel-body"> <button class="option" onclick="goTo('/newForm')" href="/newForm" style="width: 100%;">Risk Assesssment Form</button></div>

    </div>


    <div class="panel-body"><button class="option"  style="width: 100%;" onclick=" return logOut()"><span class="glyphicon glyphicon-log-out"></span> LogOut</button></div>
</div>

</div>

<div class="details-container">
    <div class="details">
        <h3 class="section-title">Students Details</h3>
        <div class="form-group">
            <label>Student First Name:</label>
            <p>${student.firstName}</p>
        </div>

        <div class="form-group">
            <label>Student Surname:</label>
            <p>${student.surname}</p>
        </div>

        <div class="form-group">
            <label>Student Number:</label>
            <p>${student.studentNumber}</p>
        </div>

        <div class="form-group">
            <label>Email Address:</label>
            <p>${student.uniEmailAddress}</p>
        </div>

        <div class="form-group">
            <label>Programme of Study:</label>
            <p>${student.programme}</p>
        </div>

        <div class="form-group">
            <label>School/Department:</label>
            <p>${student.departmentOrSchool}</p>
        </div>

        <div class="form-group">
            <table>Contact Telephone number:</table>
            <p>${student.telephoneNumber}</p>
        </div>

        <div class="form-group">
            <label>International student with a Student Visa:</label>
            <p>${student.studentStatus}</p>
        </div>

        <div class="form-group">
            <label>Does the Student Visa duration account for the placement?</label>
            <p id="visa-duration-value">${student.visaDuration}</p>
            <script>
                const visaduration = ${student.visaDuration};
            </script>
        </div>
    </div>

    <div class="details">
        <h3 class="section-title">Placement Role Details</h3>

        <div class="form-group">
            <label>Role Title:</label>
            <p>${placement.role.roleTitle}</p>
        </div>

        <div class="form-group">
            <label>Start Date:</label>
            <p>${placement.role.roleStartDate}</p>
        </div>

        <div class="form-group">
            <label>End Date:</label>
            <p>${placement.role.roleEndDate}</p>
        </div>

        <div class="form-group">
            <label>Working hours per week:</label>
            <p>${placement.role.workingHoursWeek}</p>
        </div>

        <div class="form-group">
            <label>Does the role include a probation period?</label>
            <p id="probation-period-value">${placement.role.probationPeriod}</p>
            <script>
                const probationPeriod = ${placement.role.probationPeriod};
            </script>
        </div>

        <div class="form-group">
            <label>Placement Salary:</label>
            <p>${placement.role.annualSalary}</p>
        </div>

        <div class="form-group">
            <label>The role source:</label>
            <p>${placement.role.roleSource}</p>
        </div>

        <div class="form-group">
            <label>Have the student informed the Placement Provider that this placement forms part of the degree programme?</label>
            <p id="provider-informaed-value">${placement.role.providerInformedDegree}</p>
            <script>
                const providerinformed = ${placement.role.providerInformedDegree};
            </script>
        </div>

        <div class="form-group">
            <label>Role description:</label>
            <p>${placement.role.roleDescription}</p>
        </div>

        <div class="form-group">
            <label>Address:</label>
            <p>${placement.company.placementAddress}</p>
        </div>

    </div>

</div>

<div class="details-container">
    <div class="details">
        <h3 class="section-title">Placement Provider Details</h3>
        <div class="form-group">
            <table>Name of Organisation:</table>
            <p>${placement.company.organisationName}</p>
        </div>

        <div class="form-group">
            <table>Address where the placement will be based:</table>
            <p>${placement.company.placementAddress}</p>
        </div>

        <div class="form-group">
            <label>Postcode:</label>
            <p>${placement.company.postCode}</p>
        </div>

        <div class="form-group">
            <label>Web Address:</label>
            <p>${placement.company.webAddress}</p>
        </div>

        <div class="form-group">
            <label>Contact Name:</label>
            <p>${placement.providerNamedContact.name}</p>
        </div>

        <div class="form-group">
            <label>Contact Job Title:</label>
            <p>${placement.providerNamedContact.jobTitle}</p>
        </div>

        <div class="form-group">
            <label>Contact Email:</label>
            <p>${placement.providerNamedContact.email}</p>
        </div>

        <div class="form-group">
            <label>Contact Telephone Number:</label>
            <p>${placement.providerNamedContact.telNumber}</p>
        </div>
    </div>
    <div class="details">
        <h3 class="section-title">Work Factors</h3>
        <div class="form-group">
            <label>Does this role involve working from home/remotely?</label>
            <p id="remote-work-value">${placement.workFactors.remoteWork}</p>
        </div>
        <script>
            const remoteWork = ${placement.workFactors.remoteWork};
        </script>

        <div class="form-group" id="overview-div">
            <label>Overview of how the student will work remotely. This should include how often you will work remotely each week:</label>
            <p>${placement.workFactors.remoteWorkYesSupport}</p>
        </div>

        <div class="form-group" id="why-div">
            <label>Why does this role involve working from home?</label>
            <p>${placement.workFactors.romoteWorkYesReason}</p>
        </div>
    </div>


</div>

<div class="details-container">
    <div class="details">
        <h3 class="section-title">Transport and Travel Factors</h3>
        <div class="form-group">
            <label>How will the student travel to and from the placement and residence?</label>
            <p>${placement.transportTravelFactors.transportMethods}</p>
        </div>

        <div class="form-group">
            <label>Does this role involve working at a location different to the Placement Provider’s address that you have given in section 2?</label>
            <p id="work-location-confirmed-value">${placement.transportTravelFactors.workLocationConfirmed}</p>
            <script>
                const worklocationconfirmed = ${placement.transportTravelFactors.workLocationConfirmed};
            </script>
        </div>

        <div class="form-group">
            <label>Does the student placement require travel overseas?</label>
            <p id="over-seas-value">${placement.transportTravelFactors.overseasPlacement}</p>
            <script>
                const overseaseplacement = ${placement.transportTravelFactors.overseasPlacement};
            </script>
        </div>

        <div class="form-group">
            <label>Has the student read the overseas travel guidance?</label>
            <p id="over-seas-travel-Guide-value">${placement.transportTravelFactors.overseasTravelGuidance}</p>
            <script>
                const overseasTravelGuidance = ${placement.transportTravelFactors.overseasTravelGuidance};
            </script>
        </div>

        <div class="form-group">
            <label>Has the student considered how they will travel to their country of work and financing this?</label>
            <p id="work-location-value">${placement.transportTravelFactors.confirmedWorkLocation}</p>
        </div>
        <script>
            const confirmedWorkLocation = ${placement.transportTravelFactors.confirmedWorkLocation};
        </script>
    </div>

    <div class="details">
        <h3 class="section-title">Location and Regional Factors</h3>
        <div class="form-group">
            <label>What are the student's accommodation arrangements when on placement?</label>
            <p>${placement.locationRegionalFactors.accommodationArrangements}</p>
        </div>

        <div class="form-group">
            <label>Have the student checked the Foreign, Commonwealth and Development Office for information on the country of your placement?</label>
            <p id="fcdo-info-value">${placement.locationRegionalFactors.fcdoInfo}</p>
            <script>
                const fcdoinfo = ${placement.locationRegionalFactors.fcdoInfo};
            </script>
        </div>

        <div class="form-group">
            <label>Is the student aware of any risks at the organisation’s main location?</label>
            <p id="risk-aware-value">${placement.locationRegionalFactors.riskAware}</p>
        </div>
        <script>
            const riskAware = ${placement.locationRegionalFactors.riskAware};
        </script>
    </div>
</div>
<div class="details-container">
    <div class="details">
        <h3 class="section-title">Health and Environmental Factors</h3>
        <div class="form-group">
            <label>Is the student aware of any precautionary measures you are required to undertake before, during, or after the placement?</label>
            <p id="measure-aware-value">${placement.healthEnvironmentalFactors.precautionaryMeasuresAware}</p>
            <script>
                const measureAware = ${placement.healthEnvironmentalFactors.precautionaryMeasuresAware};
            </script>
        </div>

        <div class="form-group">
            <label>Has the student downloaded the “SafeZone” app using your university credentials?</label>
            <p id="safe-zone-value">${placement.healthEnvironmentalFactors.safezoneDownloaded}</p>
            <script>
                const safezone = ${placement.healthEnvironmentalFactors.safezoneDownloaded};
            </script>
        </div>

        <div class="form-group">
            <label>Has the student applied for Global Health Insurance Card?</label>
            <p id="health-card-value">${placement.healthEnvironmentalFactors.gliCard}</p>
        </div>
        <script>
            const gliCard = ${placement.healthEnvironmentalFactors.gliCard};
        </script>
    </div>

    <div class="details">
        <h3 class="section-title">Personal Factors</h3>
        <div class="form-group">
            <label>Has the student considered any adjustments with their employer that may be required for them to carry out the role relating to any disability or health condition?</label>
            <p id="employer-disability-value">${placement.personalFactors.employerDisabilityAdjustments}</p>
        </div>
        <script>
            const employerDisabilityAdjustments = ${placement.personalFactors.employerDisabilityAdjustments};
        </script>
    </div>


    <div class="details">
        <h3 class="section-title">Policies and Insurance (Overseas Placement)</h3>
        <div class="form-group">
            <label>Is the student aware that they must submit a Student Travel Application Form once the placement has been approved?</label>
            <p id="travel-application-value">${placement.policyAndInsurance.studentTravelApplication}</p>
            <script>
                const travelapplication = ${placement.policyAndInsurance.studentTravelApplication};
            </script>
        </div>

        <div class="form-group">
            <label>Is the student's country of work listed as one that require risk assessment escalation?</label>
            <p id="risk-assesment-value">${placement.policyAndInsurance.riskAssessmentEscalation}</p>
            <script>
                const riskassesment = ${placement.policyAndInsurance.riskAssessmentEscalation};
            </script>
        </div>
    </div>
</div>
<script src="../../../js/StudentDetails.js"></script>
</body>
</html>
