<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <title>Placement Provider Details Section A</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">

</head>
<body>
<div class="bar"><img src="../../../css/uniLogo.png" ></div>


<h2 class="title" >2a. Placement Provider Details Section</h2>
<div class="flex-row">
    <form:form method="post" modelAttribute="placementA_form" action="/public/addPlacementA_form" >
        <input type="hidden" path="id" name="id" value=${student_id}>


        <form:label path="organisationName">a. Name of Organisation</form:label>
        <form:input path="organisationName"/>
        <form:errors cssClass="warning-class" path="organisationName"/> <br>

        <form:label path="placementAddress">b. Address where the placement will be based</form:label>
        <form:input path="placementAddress"/>
        <form:errors cssClass="warning-class" path="placementAddress"/> <br>


        <form:label path="postCode">c. Postcode</form:label>
        <form:input path="postCode"/>
        <form:errors cssClass="warning-class" path="postCode"/> <br>

        <form:label path="webAddress">d. Web Address</form:label>
        <form:input path="webAddress"/>
        <form:errors cssClass="warning-class" path="webAddress"/> <br>

        <input type="submit" value="Submit">



    </form:form>
</div>

</body>

</html>