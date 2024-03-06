<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Placement Role Details</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>

<h2 class="title" >Placement Role Details</h2>
<div class="flex-row">
    <div>
<form:form method="post" modelAttribute="ppfrole_form" action="/public/addPPFRole" >
    <input type="hidden" path="id" name="id" value=${id}>
 <h2>Placement Role Details</h2>
    <div>

        <form:label path="ppfStudentName">a. The University of Leicester student's name</form:label>
        <form:input path="ppfStudentName"/>
        <form:errors cssClass="warning-class" path="ppfStudentName"/> <br>

        <form:label path="roleTitle">b. Role Title</form:label>
        <form:input path="roleTitle"/>
        <form:errors cssClass="warning-class" path="roleTitle"/> <br>

        <form:label path="roleStartDate">c. Role Start date<br>
            i. Indicate the proposed start date or month of your placement
            <br>
            ii. This information can be updated nearer the time when you have an exact date</form:label>
        <form:input  type="date" value="2022-07-25" path="roleStartDate"/>
        <form:errors cssClass="warning-class" path="roleStartDate"/> <br>

        <form:label path="roleEndDate">d. Role End date (expected month if unknown)</form:label>
        <form:input type="date" value="2025-08-30" path="roleEndDate"/>
        <form:errors cssClass="warning-class" path="roleEndDate"/> <br>

        <form:label path="workingHoursWeek">e. Working hours per week</form:label>
        <form:input type="number" step="0.01" path="workingHoursWeek"/>

        <form:errors cssClass="warning-class" path="workingHoursWeek"/><br>

        <form:label path="probationPeriod">f. Does the student's role include a probation period?</form:label>
        <form:select path="probationPeriod">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="probationPeriod"/> <br>

        <form:label path="probationAssessment">If yes, please provide information on how the probation period will be assessed: </form:label>
        <form:input path="probationAssessment"/>
        <form:errors cssClass="warning-class" path="probationAssessment"/> <br>

        <input type="submit" value="Submit">

    </div>

</form:form>

</body>

</html>
