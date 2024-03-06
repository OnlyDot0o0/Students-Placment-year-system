<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Company Details</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
        <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">  Company Details  </h2>
<div class="flex-row">
        

        <p>Organisation Name: ${company.organisationName}<br>
                <br>
                Placement Address:  ${company.placementAddress}<br>
                <br>
                Postcode:  ${company.postCode}<br>
                <br>
                Website:  ${company.webAddress}<br>
                <br>
                Does it engage regulated activities:  ${company.engagesRegulatedActivities}<br>
                <br>
                Yes it engages Regulated Activities:  ${company.engagesRegulatedActivitiesYes}<br>
                <br>
                Declaration: ${company.declaration}<br>
                <br>
                Factor:  ${company.factor}<br>
                <br>
                Health:  ${company.health}<br>
                <br>
                Policies in Overseas:  ${company.polciesInsOverseas}<br>
                <br>
                UK policies:  ${company.polciesInsUk}<br>
                <br>
                UniAccess:  ${company.uniAccess}<br>
                <br>
                Work factors:  ${company.workFactors}<br>
        <br>
                <input type="submit" value="Approve">
                <input type="submit" value="Reject">
                <input type="submit" value="Flag">



</div>
</body>
</html>
