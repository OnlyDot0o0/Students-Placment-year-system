<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Risk assessment</title>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <meta content="width=device-width, initial-scale=1" name="viewport" />
    <script src="../../js/helperScript.js"></script>
    <link rel="stylesheet" href="../../css/RiskForm.css">
    <link rel="stylesheet" href="../../css/landing.css">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">

</head>
<body>

<nav class="navbar navbar-dark  navbar-expand navbar-static-top ">
    <div class="container-fluid">

        <div class="navbar-header col-xs-6">
            <span><img  class=navbar-brand" src="../../../css/uniLogo.png"></span>
        </div>

        <ul  class="nav navbar-nav navbar-text center">
            <li ><span><h3 class=" navbar-text">Risk Assessment Form</h3></span></li>
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


            <li><a href="/report">Statistical Report</a></li>

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Access Forms
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/public/newStudentUpload">Student Form</a></li>
                    <li><a href="/public/newCompanyUpload">Placement Provider Form</a></li>
                    <li><a href="/newForm">Risk Assessment Form</a></li>
                    <li><a href="/flagged">Flagged Form</a></li>
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

    <div class="panel-body"> <button class="option" onclick="goTo('/report')" style="width: 100%;">Statistical Report</button>


    </div>


    <div class="panel-body"> <button class="option" data-toggle="collapse" href="#collapse2" style="width: 100%;">Access Forms</button></div>



    <div id="collapse2" class="panel-collapse collapse">

        <div class="panel-body"> <button class="option" onclick="goTo('/public/newStudentUpload')" href="/public/newStudentUpload" style="width: 100%;">Student Form</button></div>

        <div class="panel-body"> <button class="option" onclick="goTo('/public/newCompanyUpload')" href="/public/newCompanyUpload" style="width: 100%;">Placement Provider Form</button></div>

        <div class="panel-body"> <button class="option" onclick="goTo('/newForm')" href="/newForm" style="width: 100%;">Risk Assesssment Form</button></div>

        <div class="panel-body"> <button class="option" onclick="goTo('/flagged')" href="/flagged" style="width: 100%;">Flagged Forms</button></div>

    </div>


    <div class="panel-body"><button class="option"  style="width: 100%;" onclick=" return logOut()"><span class="glyphicon glyphicon-log-out"></span> LogOut</button></div>
</div>

</div>




<div class="flex-row">
    <div>


<form:form method ="post"  modelAttribute="form1" action="/addForm">
    <h3>1.Student Information</h3>
        <form:label path="StudentName">a.Student Name</form:label>
        <form:input path="StudentName" type="text" id="StudentName"/>
        <form:errors cssClass="warning-class" path="StudentName"/>
        <br><br>

    <h3>2.Placement Provider Information</h3>
        <form:label path="Organisation"> a.Name of Organisation</form:label>
        <form:input path="Organisation" type="text" id="Organisation" size="50"/>
        <form:errors cssClass="warning-class" path="Organisation"/>
        <br><br>


        <form:label path="Impact_on_reputation" >b.Assess the likely impact to the University&#39;s reputation and integrity.</form:label>

            <div class="form-check form-check-inline">
                <form:radiobutton path="Impact_on_reputation" value="L" id="2b_L"/>
                <label class="form-check-label" for="2b_L">Low</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="Impact_on_reputation" value="M" id="2b_M"/>
                <label class="form-check-label" for="2b_M">Medium</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="Impact_on_reputation" value="H" id="2b_H"/>
                <label class="form-check-label" for="2b_H">High</label>
                <br>
                <form:errors cssClass="warning-class" path = "Impact_on_reputation"/>
            </div>

    <br><br>

    <h3>3. Information Match</h3>
        <form:label path="Information_match" > a.Is the &#39;Student Name&#39;&#44 &#39;EmployerName&#39; and &#39;Address where the placement will be based&#39; on the Authorisation Request Form and Placement Provider Form the same on both forms? </form:label>

            <div class="form-check form-check-inline">
             <form:radiobutton path="Information_match" value="Y" id="3a_Y"/>
                <label class="form-check-label" for="3a_Y">Yes</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="Information_match" value="N" id="3a_N"/>
                <label class="form-check-label" for="3a_N">No</label>
                <br>
                <form:errors cssClass="warning-class" path="Information_match"/>
            </div>

    <br><br>

        <h3>4.Placement Role Information</h3>
        <form:label path="FulfilledDuration" >a.Does the placement role meet the minimum requirements for duration and hours needed as part of the degree programme?</form:label>

            <div class="form-check form-check-inline">
                <form:radiobutton path="FulfilledDuration" value="Y" id="4a_Y"/>
                <label class="form-check-label" for="4a_Y">Yes</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="FulfilledDuration" value="N" id="4a_N"/>
                <label class="form-check-label" for="4a_N">No</label>
                <br>
                <form:errors cssClass="warning-class" path = "FulfilledDuration"/>
            </div>

    <br><br>

        <form:label path="Fulfilled_AcademicRequirement" >b.Does the student meet the minimum academic requirements to go on placement?</form:label>

            <div class="form-check form-check-inline">
                <form:radiobutton path="Fulfilled_AcademicRequirement" value="Y" id="4b_Y"/>
                <label class="form-check-label" for="4b_Y">Yes</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="Fulfilled_AcademicRequirement" value="N" id="4b_N"/>
                <label class="form-check-label" for="4b_N">No</label>
                <br>
                <form:errors cssClass="warning-class" path = "Fulfilled_AcademicRequirement"/>
            </div>

    <br><br>

        <form:label path="ConfirmedResponsibility" >c.Has the placement provider confirmed that they will comply with the placement provider responsibilities?</form:label>

            <div class="form-check form-check-inline">
                <form:radiobutton path="ConfirmedResponsibility" value="Y" id="4c_Y"/>
                <label class="form-check-label" for="4c_Y">Yes</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="ConfirmedResponsibility" value="N" id="4c_N"/>
                <label class="form-check-label" for="4c_N">No</label>
                <br>
                <form:errors cssClass="warning-class" path = "ConfirmedResponsibility"/>
            </div>

    <br><br>

        <form:label path="ApprovedProvider" >d.Do you have reasonable confidence that the proposed Placement Provider is an appropriate partner to allow students to meet the overall learning outcomes of the placement?</form:label>

            <div class="form-check form-check-inline">
                <form:radiobutton path="ApprovedProvider" value="Y" id="4d_Y"/>

                <label class="form-check-label" for="4d_Y">Yes</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="ApprovedProvider" value="N" id="4d_N"/>
                <label class="form-check-label" for="4d_N">No</label>
                <br>
                <form:errors cssClass="warning-class" path = "ApprovedProvider"/>
            </div>

    <br><br>

        <form:label path="VisaNeeded" >e.Does the student have a Student visa?<br>Check the Placement Management Tracking Tool if you doubt the student&#39;s declaration</form:label>

            <div class="form-check form-check-inline">
                <form:radiobutton path="VisaNeeded" value="Y" id="4e_Y"/>
                <label class="form-check-label" for="4e_Y">Yes</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="VisaNeeded" value="N" id="4e_N"/>
                <label class="form-check-label" for="4e_N">No</label>
                <br>
                <form:errors cssClass="warning-class" path = "VisaNeeded"/>
                <br>
            </div>

        Check the Placement Management Tracking Tool is you doubt the student's declaration<br><br>
        <form:label path="VisaStartDate" >f.Does the placement role start date&#44; end date and duration comply with the Student VISA?<br>Check the Placement Management Tracking Tool if you doubt the student&#39;s declaration</form:label>

            <div class="form-check form-check-inline">
                <form:radiobutton path="VisaStartDate" value="Y" id="4f_Y"/>
                <label class="form-check-label" for="4f_Y">Yes</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="VisaStartDate" value="N" id="4f_N"/>
                <label class="form-check-label" for="4f_N">No</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="VisaStartDate" value="NA" id="4f_NA"/>
                <label class="form-check-label" for="4f_NA">N/A</label>
                <br>
                <form:errors cssClass="warning-class" path = "VisaStartDate"/>
            </div>
     <br>
    Check the Placement Management Tracking Tool is you doubt the student's declaration
    <br><br>
        <h3>5.Work Factors</h3>
        <form:label path="CompanyEnvironment" >a.Assess the organisations working conditions and environment for the placement role.</form:label>

            <div class="form-check form-check-inline">
                <form:radiobutton path="CompanyEnvironment" value="L" id="5a_L"/>
                <label class="form-check-label" for="5a_L">Low</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="CompanyEnvironment" value="M" id="5a_M"/>
                <label class="form-check-label" for="5a_M">Medium</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="CompanyEnvironment" value="H" id="5a_H"/>
                <label class="form-check-label" for="5a_H">High</label>
                <br>
                <form:errors cssClass="warning-class" path = "CompanyEnvironment"/>
            </div>

    <br><br>

        <form:label path="StudentTraining" >b.Will the student be provided with appropriate training to undertake tasks?</form:label>

            <div class="form-check form-check-inline">
                <form:radiobutton path="StudentTraining" value="Y" id="5b_Y"/>
                <label class="form-check-label" for="5b_Y">Yes</label>
            </div>
            <div class="form-check form-check-inline">
                <form:radiobutton path="StudentTraining" value="N" id="5b_N"/>
                <label class="form-check-label" for="5b_N">No</label>
                <br>
                <form:errors cssClass="warning-class" path = "StudentTraining"/>
            </div>

    <br>
    <br>

    <form:label path="RemoteWorking" >c.Assess the likelihood of the student to be working from home.</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="RemoteWorking" value="L" id="5c_L"/>
            <label class="form-check-label" for="5c_L">Low</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="RemoteWorking" value="M" id="5c_M"/>
            <label class="form-check-label" for="5c_M">Medium</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="RemoteWorking" value="H" id="5c_H"/>
            <label class="form-check-label" for="5c_H">High</label>
            <br>
            <form:errors cssClass="warning-class" path = "RemoteWorking"/>
        </div>

    <br>
    <br>

    <form:label path="InternationalRemote" >d.If the job involves international remote working&#44; assess the legitimacy of the role.</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="InternationalRemote" value="L" id="5d_L"/>
            <label class="form-check-label" for="5d_L">Low</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="InternationalRemote" value="M" id="5d_M"/>
            <label class="form-check-label" for="5d_M">Medium</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="InternationalRemote" value="H" id="5d_H"/>
            <label class="form-check-label" for="5d_H">High</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="InternationalRemote" value="NA" id="5d_NA"/>
            <label class="form-check-label" for="5d_NA">N/A</label>
            <br>
            <form:errors cssClass="warning-class" path = "InternationalRemote"/>
        </div>

    <br><br>

    <h3>6.Travel and transport facilities</h3>
    <form:label path="TravelIssues" >a.Assess the likelihood of the student having significant travel issues to and from the place of work.</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="TravelIssues" value="L" id="6a_L"/>
            <label class="form-check-label" for="6a_L">Low</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="TravelIssues" value="M" id="6a_M"/>
            <label class="form-check-label" for="6a_M">Medium</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="TravelIssues" value="H" id="6a_H"/>
            <label class="form-check-label" for="6a_H">High</label>
            <br>
            <form:errors cssClass="warning-class" path = "TravelIssues"/>
        </div>

    <br><br>

    <form:label path="MultiSites" >b.Assess the likelihood that the student will be required to work across multiple sites other than the main Placement Provider address in section 2.</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="MultiSites" value="L" id="6b_L"/>
            <label class="form-check-label" for="6b_L">Low</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="MultiSites" value="M" id="6b_M"/>
            <label class="form-check-label" for="6b_M">Medium</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="MultiSites" value="H" id="6b_H"/>
            <label class="form-check-label" for="6b_H">High</label>
            <br>
            <form:errors cssClass="warning-class" path = "MultiSites"/>
        </div>

    <br><br>

    <h3>7.Location and Regional Factors</h3>
    <form:label path="PlacementLocation" >a.Assess the likelihood that the location of the main Placement Provider address in section 2 has any risks.</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="PlacementLocation" value="L" id="7a_L"/>
            <label class="form-check-label" for="7a_L">Low</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="PlacementLocation" value="M" id="7a_M"/>
            <label class="form-check-label" for="7a_M">Medium</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="PlacementLocation" value="H" id="7a_H"/>
            <label class="form-check-label" for="7a_H">High</label>
            <br>
            <form:errors cssClass="warning-class" path = "PlacementLocation"/>
        </div>

    <br><br>

    <form:label path="StudentAccommodation" >b.Assess the risk of the student having <strong>inappropriate</strong> accommodation arrangements when on placement?</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="StudentAccommodation" value="L" id="7b_L"/>
            <label class="form-check-label" for="7b_L">Low</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="StudentAccommodation" value="M" id="7b_M"/>
            <label class="form-check-label" for="7b_M">Medium</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="StudentAccommodation" value="H" id="7b_H"/>
            <label class="form-check-label" for="7b_H">High</label>
            <br>
            <form:errors cssClass="warning-class" path = "StudentAccommodation"/>
        </div>

    <br><br>

    <h3>8.Health and Environmental Factors</h3>
    <form:label path="Precautionary" >a.Assess the likelihood of the student requiring to undertake precautionary measures to undertake the placement?</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="Precautionary" value="L" id="8a_L"/>
            <label class="form-check-label" for="8a_L">Low</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="Precautionary" value="M" id="8a_M"/>
            <label class="form-check-label" for="8a_M">Medium</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="Precautionary" value="H" id="8a_H"/>
            <label class="form-check-label" for="8a_H">High</label>
            <br>
            <form:errors cssClass="warning-class" path = "Precautionary"/>
        </div>

    <br><br>

    <h3>9.Personal Factors</h3>
    <form:label path="PersonalFactors" class="">a.Assess the likelihood of any of the students&#39; personal factors having any implications on undertaking the placement?</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="PersonalFactors" value="L" id="9a_L"/>
            <label class="form-check-label" for="9a_L">Low</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="PersonalFactors" value="M" id="9a_M"/>
            <label class="form-check-label" for="9a_M">Medium</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="PersonalFactors" value="H" id="9a_H"/>
            <label class="form-check-label" for="9a_H">High</label>
            <br>
            <form:errors cssClass="warning-class" path = "PersonalFactors"/>
        </div>

    <br><br>

    <h3>10.Policies and Insurance </h3> <p>(See Section 10 and 11 of Placement Provider form) </p>
    <form:label path="PublicLiabilityInsurance" >a.Does the Placement Provider have in place public liability insurance (or equivalent) to cover students on placement?</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="PublicLiabilityInsurance" value="Y" id="10a_Y"/>
            <label class="form-check-label" for="10a_Y">Yes</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="PublicLiabilityInsurance" value="N" id="10a_N"/>
            <label class="form-check-label" for="10a_N">No</label>
            <br>
            <form:errors cssClass="warning-class" path = "PublicLiabilityInsurance"/>
        </div>

    <br><br>

   <form:label path="EmployLiabilityInsurance" class="">b.Does the Placement Provider have in place employer&#39;s liability insurance (or equivalent) to cover students on placement?</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="EmployLiabilityInsurance" value="Y" id="10b_Y"/>
            <label class="form-check-label" for="10b_Y">Yes</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="EmployLiabilityInsurance" value="N" id="10b_N"/>
            <label class="form-check-label" for="10b_N">No</label>
            <br>
            <form:errors cssClass="warning-class" path = "EmployLiabilityInsurance"/>
        </div>

    <br><br>

    <form:label path="ProfessionalInsurance" class="">c.If applicable to the placement role&#44; does the Placement Provider hold Professional Indemnity Insurance (or equivalent) that would cover the student?</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="ProfessionalInsurance" value="Y" id="10c_Y"/>
            <label class="form-check-label" for="10c_Y">Yes</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="ProfessionalInsurance" value="N" id="10c_N"/>
            <label class="form-check-label" for="10c_N">No</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="ProfessionalInsurance" value="Not" id="10c_Not"/>
            <label class="form-check-label" for="10c_Not">Not applicable</label>
            <br>
            <form:errors cssClass="warning-class" path = "ProfessionalInsurance"/>
        </div>

    <br><br>

    <form:label path="SafetyPolicy" class="">d.Does the Placement Provider have in place an appropriate Health and Safety Policy at the location(s) where the student is to work?</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="SafetyPolicy" value="Y" id="10d_Y"/>
            <label class="form-check-label" for="10d_Y">Yes</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="SafetyPolicy" value="N" id="10d_N"/>
            <label class="form-check-label" for="10d_N">No</label>
            <br>
            <form:errors cssClass="warning-class" path = "SafetyPolicy"/>
        </div>

    <br><br>

    <h3>11.University Access and Support</h3>
    <form:label path="UniVisit" class="">a.Does the Placement Provider have any objections to the University undertaking site visits to support the student?</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="UniVisit" value="Y" id="11a_Y"/>
            <label class="form-check-label" for="11a_Y">Yes</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="UniVisit" value="N" id="11a_N"/>
            <label class="form-check-label" for="11a_N">No</label>
        </div>

    <br><br>

    <form:label path="Confidentiality" class="">b.Does the Placement Provider have any issues relating to confidentiality or disclosure which the University will need to consider?</form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="Confidentiality" value="Y" id="11b_Y"/>
            <label class="form-check-label" for="11b_Y">Yes</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="Confidentiality" value="N" id="11b_N"/>
            <label class="form-check-label" for="11b_N">No</label>
        </div>
        <form:errors cssClass="warning-class" path = "Confidentiality"/>

    <br><br>

    <h3>12.Placement Tutor Declaration and Signature (All Placements)</h3>
    <form:label path="PlacementDecision" class=""><strong>I have assessed the information provided in the Authorisation Request Form and the Placement Provider Form and have made the following decision:</strong></form:label>

        <div class="form-check form-check-inline">
            <form:radiobutton path="PlacementDecision" value="authorised" id="12_authorised"/>
            <label class="form-check-label" for="12_authorised">Placement request authorised</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="PlacementDecision" value="hold" id="12_hold"/>
            <label class="form-check-label" for="12_hold">Placement request on hold until further information is provided (please provide reasons below)</label>
        </div>
        <div class="form-check form-check-inline">
            <form:radiobutton path="PlacementDecision" value="rejected" id="12_rejected"/>
            <label class="form-check-label" for="12_rejected">Placement request rejected (please provide reasons below)</label>
        </div>
        <form:errors cssClass="warning-class" path = "PlacementDecision"/>

    <br><br>
    <strong> <form:label path="DecisionReason">Reasons for decision</form:label></strong>
    <form:input path="DecisionReason" type="text"/>
    <form:errors cssClass="warning-class" path = "DecisionReason"/>
    <br><br>

    <strong><form:label path="TutorName">Name of tutor:</form:label></strong>
    <form:input path="TutorName" type="text" id="TutorName" size="50"/>
    <form:errors cssClass="warning-class" path = "TutorName"/>
    <br>

    <br>
    <strong><form:label path="Sign">Placement Tutor Signature</form:label></strong>
    <form:input path="Sign" type="text" id="Sign"  size="50"/>
    <form:errors cssClass="warning-class" path = "Sign"/>

    <br><br>

    <strong><form:label path="TutorDate">Date:</form:label></strong>
    <form:input type="date" path="TutorDate" value="2025-08-30"/>
    <form:errors cssClass="warning-class" path = "TutorDate"/>

    <br><br>

    <strong><form:label path="PlacementSupervisor">Allocated Placement Supervisor</form:label></strong>
    <form:input path="PlacementSupervisor" type="text" id="PlacementSupervisor"  size="50"/>
    <form:errors cssClass="warning-class" path = "PlacementSupervisor"/>
    <br><br>
    <h3>13.Overseas Placements Only</h3>
        <h3>  College Director of Operations Sign Off(or delegated authority)</h3>
<br><br>
    <strong><form:label path="SecondSignature">College Director of Operations Signature</form:label></strong>
    <form:input path="SecondSignature" type="text" id="SecondSignature"  size="50"/>

    <br><br>

    <strong><form:label path="PlacementDate">Date:</form:label></strong>
    <form:input type="date" path="PlacementDate"/>
    <br><br>
    <p>Please review the students Travel Risk Assessment prior to approval. Details of concern are details on the <a href="https://uniofleicester.sharepoint.com/sites/Insurance/SitePages/Staff-Student-Overseas-Travel.aspx">Overseas Travel Page</a></p>
    <p>Please share the outcome of this decision with your Programme Administration Team,to inform the student and other teams of the outcome</p>
<input type="submit">
</div>
</form:form>
</body>
</html>
