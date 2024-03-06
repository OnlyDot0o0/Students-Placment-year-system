<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <title> Transport and Travel Factors</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">

    <script src="../../../js/helperScript.js"></script>
</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>


<h2 class="title" >5. Transport and Travel Factors</h2>
<div class="flex-row">
    <div>
<form:form method="post" modelAttribute="transportFactor_form" action="/public/addTransport_form" >
    <input type="hidden" path="id" name="id" value=${student_id}>

    <h2>5. Transport and Travel Factors</h2>
    <div>
        <form:label path="transportMethods">a. How will you travel to and from the placement and residence?<br> If you do not know this, please put what you are planning to do.</form:label><br>
        <form:select  multiple="true" multiple_size="2"  path="transportMethods"  onchange="manageOther('Other',this.options[this.selectedIndex].value, 'transport_other')">
            <form:option  value="Own vehicle">Own vehicle</form:option>
            <form:option  value="Public transport (bus, taxi)">Public transport (bus, taxi)</form:option>
            <form:option  value="Walking">Walking</form:option>
            <form:option  value="Cycle">Cycle</form:option>
            <form:option  value="Other">Other</form:option>
        </form:select>

        <form:input  cssClass="transport_other" cssStyle="display: none" path="transportMethods"/>
        <form:errors cssClass="warning-class" path="transportMethods"/> <br>

        <form:label path="workLocationConfirmed">b. Does this role involve working at a location different to the Placement Provider's address that you have given in section 2?</form:label>
        <form:select path="workLocationConfirmed">
        <form:option value="1">Yes</form:option>
        <form:option value="0">No</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="workLocationConfirmed"/> <br>

        <form:label path="workLocationConfirmedFurtherDetails">c. If you answered Yes in the above question, please provide details below</form:label>
        <form:input path="workLocationConfirmedFurtherDetails"/>
        <form:errors cssClass="warning-class" path="workLocationConfirmedFurtherDetails"/> <br>

        <form:label path="confirmedWorkLocation">d. Does your placement require travel overseas? Please Note: If you are travelling overseas at the Placement Providers request then the university is not responsible for the travel insurance and it is your employer's responsibility to risk assess the travel. If you are travelling overseas to attend the placement, then the responsibility is with the university.</form:label>
        <form:select path="confirmedWorkLocation">
            <form:option value="1">Yes</form:option>
            <form:option value="2">No</form:option>
            <form:option value="3">Don't Know</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="confirmedWorkLocation"/> <br>

        <form:label path="overseasPlacement">e. Overseas Placement. Have you read the overseas travel guidance?</form:label>
        <form:select path="overseasPlacement">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="overseasPlacement"/> <br>

        <form:label path="overseasTravelGuidance">f. Overseas Placement. Have you considered how you will travel to your country of work and financing this?</form:label>
        <form:select path="overseasTravelGuidance">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="overseasTravelGuidance"/> <br>
        <input type="submit" value="Submit">


    </div>

</form:form>

</body>

</html>