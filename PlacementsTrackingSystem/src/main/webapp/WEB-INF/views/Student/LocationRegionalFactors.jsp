<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <title>Location and Regional Factors Section</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <script src="../../../js/helperScript.js"></script>

</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>


<h2 class="title" >6. Location and Regional Factors Section</h2>
<div class="flex-row">
    <div>
<form:form method="post" modelAttribute="locationFactor_form" action="/public/addLocation_form" >
    <input type="hidden" path="id" name="id" value=${student_id}>

    <h2>6. Location and Regional Factors Section</h2>
    <div>

        <form:label path="accommodationArrangements">
            a. What are your accommodation arrangements when on placement?
            If you do not know this, please put what you are planning to do.
        </form:label>
        <form:select items="${accommodationOptions}" cssClass="te" path="accommodationArrangements"  onchange="manageOther('Other' , this.options[this.selectedIndex].value, 'other_input')">
        </form:select>

        <form:input cssClass="other_input" cssStyle="display: none" path="accommodationArrangements"/> <br>
        <form:errors cssClass="warning-class" path="accommodationArrangements"/>
        <br>
        <form:label path="fcdoInfo">
            b. Overseas Placement. Have you checked the Foreign, Commonwealth
            and Development Office (https://www.gov.uk/government/organisations/foreign-commonwealth-development-office) for information on the country of your placement?
        </form:label>
        <form:select path="fcdoInfo">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="fcdoInfo"/>
        <br>

        <form:label path="riskAware">
            c. Overseas Placement. Are you aware of any risks
            at the organisation’s main location
            For example, this might include civil disorder,
            crime, environmental disasters, infectious disease, or
            poor healthcare access (this includes the COVID risk)

            If no, please go back to the question above.
            If yes, please provide further information below.
        </form:label>
        <<form:select path="riskAware">
        <form:option value="1">Yes</form:option>
        <form:option value="0">No</form:option>
        <form:option value="0">N/A</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="riskAware"/>
        <br>

        <form:label path="riskDescription">Please provide further information here: </form:label>
        <form:input path="riskDescription"/>
        <form:errors cssClass="warning-class" path="riskDescription"/>
        <br>
        <input type="submit" value="Submit">

    </div>

</form:form>

</body>

</html>