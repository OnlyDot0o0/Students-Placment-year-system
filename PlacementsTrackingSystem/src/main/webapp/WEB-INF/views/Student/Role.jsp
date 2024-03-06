<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <meta charset="UTF-8">
    <title>Placement Role Details</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>

<h2 class="title" >3. Placement Role Details</h2>
<div class="flex-row">
    <div>
<form:form method="post" modelAttribute="role_form" action="/public/addRole_form" >
    <input type="hidden" path="id" name="id" value=${student_id}>
 <h2>3. Placement Role Details</h2>
    <div>
        <form:label path="roleTitle">a. Role Title</form:label>
        <form:input path="roleTitle"/>
        <form:errors cssClass="warning-class" path="roleTitle"/> <br>

        <form:label path="roleStartDate">b. Role Start date<br>
            i. Indicate the proposed start date or month of your placement
            <br>
            ii. This information can be updated nearer the time when you have an exact date</form:label>
        <form:input  type="date" value="2022-07-25" path="roleStartDate"/>
        <form:errors cssClass="warning-class" path="roleStartDate"/> <br>

        <form:label path="roleEndDate">c. Role End date (expected month if unknown)</form:label>
        <form:input type="date" value="2025-08-30" path="roleEndDate"/>
        <form:errors cssClass="warning-class" path="roleEndDate"/> <br>

        <form:label path="workingHoursWeek">d. Working hours per week</form:label>
        <form:input type="number" step="0.01" path="workingHoursWeek"/>
        <form:errors cssClass="warning-class" path="workingHoursWeek"/><br>

        <form:label path="probationPeriod">e. Does your role include a probation period?</form:label>
        <form:select path="probationPeriod">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="probationPeriod"/> <br>

        <form:label path="probationLength">If yes, please confirm length of your probation period below:</form:label>
        <form:input path="probationLength"/>
        <form:errors cssClass="warning-class" path="probationLength"/> <br>

        <form:label path="annualSalary">f. What is your salary for the placement? (per year) </form:label>
        <form:input path="annualSalary"/>
        <form:errors cssClass="warning-class" path="annualSalary"/> <br>

        <form:label path="roleSource">g. How did you source this role?  </form:label>
        <form:select path="roleSource">
            <form:option value="MyCareers">MyCareers</form:option>
            <form:option value="Placements Bulletin">Placements Bulletin</form:option>
            <form:option value="School Staff">School Staff</form:option>
            <form:option value="Fellow Student">Fellow Student</form:option>
            <form:option value="Festival of Careers">Festival of Careers</form:option>
            <form:option value="Other employer event at the university">Other employer event at the university</form:option>
            <form:option value="Jobs Board (Prospects etc.)">Jobs Board (Prospects etc.)</form:option>
            <form:option value="LinkedIn">LinkedIn</form:option>
            <form:option value="Family/friend outside the university">Family/friend outside the university</form:option>
            <form:option value="Other (Please Specify)">Other (Please Specify)</form:option>
            <!-- There is "if others, please specify" Could create an attribute for this in the model class to make simpler" -->
        </form:select>
        <form:errors cssClass="warning-class" path="roleSource"/> <br>


        <form:label path="providerInformedDegree">h. Have you informed the Placement Provider that this placement forms part of your degree programme</form:label>
        <form:select path="providerInformedDegree">
            <form:option value="true">Yes</form:option>
            <form:option value="false">No</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="providerInformedDegree"/> <br>

        <form:label path="roleDescription">i. Please provide a role description for your placement. Alternatively, please attach a role description to your email submitting this form.<br> If you do not have this, please contact the Placement Provider to receive a Role Description before submitting this form.</form:label>
        <form:input path="roleDescription"/>
        <form:errors cssClass="warning-class" path="roleDescription"/> <br>


        <input type="submit" value="Submit">

    </div>

</form:form>

</body>

</html>