<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <title>Personal Factors Section </title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">


</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>


<h2 class="title" >8. Personal Factors Section</h2>
<div class="flex-row">
    <div>
<form:form method="post" modelAttribute="personalFactors_form" action="/public/addPersonalFactor_form" >
    <input type="hidden" path="id" name="id" value=${student_id}>

    <!-- Part of the PPFF factors table -->
    <h2>8. Personal Factors Section</h2>
    <div>

        <form:label path="employerDisabilityAdjustments">
            a. Have you considered any adjustments with your employer that may
            be required for you to carry out the role relating to any disability
            or health condition?<br>

        </form:label>
<%--        personalFactors--%>
        <form:select path="employerDisabilityAdjustments">
            <form:option value="1">Yes</form:option>
            <form:option value="2">No</form:option>
            <form:option value="3">N/A</form:option>
        </form:select>

        <form:label path="employerDisabilityAdjustments">

        If you are unsure about this subject, then we
        recommend you reach out through the AccessAbility Centre (https://le.ac.uk/accessability-centre)
        </form:label>
        <form:errors cssClass="warning-class" path="employerDisabilityAdjustments"/>
        <br>

<%--        <form:label path="placementAddress">b. Address where the placement will be based</form:label>--%>
<%--        <form:input path="placementAddress"/>--%>

<%--        <form:label path="postcode">c. Postcode</form:label>--%>
<%--        <form:input path="postcode"/>--%>

<%--        <form:label path="webAddress">d. Web Address</form:label>--%>
<%--        <form:input path="webAddress"/>--%>
        <br>
        <input type="submit" value="Submit">

    </div>

</form:form>

</body>

</html>