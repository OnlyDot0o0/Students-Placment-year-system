<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Placement Provider details</title>
    <script src="../../../js/helperScript.js"></script>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../../css/landing.css">
    <link rel="stylesheet" href="../../../css/FormCSS.css">

</head>
<body>

<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">Placement Provider : Details</h2>
<div class="flex-row">
<form:form method="post" modelAttribute="providerDetails_form" action="/public/addProviderDetails" >
    <input type="hidden" path="id" name="id" value=${providerDetails_form.getId()}>


    <div>

        <form:label path="organisationName">a. Name of Organisation  : <form:errors class="errors" path="organisationName"/></form:label>
        <form:input path="organisationName"/>

        <br>
        <form:label path="placementAddress">b. Address where the placement will be based : <form:errors class="errors" path="placementAddress"/></form:label>
        <form:input path="placementAddress"/>

        <br>
        <form:label path="postCode">c. Postcode :  <form:errors class="errors" path="postCode"/></form:label>
        <form:input path="postCode"/>


        <br>
        <form:label path="webAddress">d. Web Address : <form:errors class="errors" path="webAddress"/></form:label>
        <form:input path="webAddress"/>

        <br>
        <form:label path="">
            e. Does your organisation undertake any activity in the following areas:<br>

            -Environmental damage<br>

            -Manufacture and sale of armaments<br>

            -Manufacture and sale of tobacco products<br>

            -Activities abroad which would be considered illegal in the UK<br>

            -The causing of harm or injury to third parties<br>

            -Gambling/gaming involving money at risk<br>


        </form:label>

        <form:select class="selectYes" path="engagesRegulatedActivities" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYes')">

            <form:option value="1">Yes</form:option>

            <form:option value="0">No</form:option>
            <form:option value="2">Unsure</form:option>
        </form:select>
        <br>

        <form:textarea class="AppearYes" cssStyle="display: none" path="engagesRegulatedActivitiesYes" placeholder="Please explain further here"></form:textarea>
        

        <input type="submit" value="Submit">

    </div>

</form:form>
</div>

</body>
<div id="help" ><a href="/help" class="glyphicon glyphicon-question-sign"></a></div>

</html>
