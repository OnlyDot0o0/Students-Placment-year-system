<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Placement Provider Named Contact</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
</head>

<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">Placement Provider : Named Contact</h2>
<div class="flex-row">
<form:form method="post" modelAttribute="namedContact_form" action="/public/addContact" >

    <input type="hidden" path="id" name="id" value=${id}>


    <div>

        <form:label path="name">a. Name of main contact : <form:errors class="errors" path="name"/> <br>



            Please note: This person will need to be accessible <br>
            as the University will be in touch via email or telephone throughout the placement.) :</form:label>
        <form:input path="name"/>

        <br>

        <form:label path="jobTitle">b. Contact Job Title  : <form:errors class="errors" path="jobTitle"/></form:label>
        <form:input path="jobTitle"/>

        <br>

        <form:label path="email">c. Contact Email : <form:errors class="errors" path="email"/></form:label>
        <form:input type="email" path="email"/>

        <br>

        <form:label path="telNumber">d. Contact Telephone Number : <form:errors class="errors" path="telNumber"/></form:label>
        <form:input path="telNumber"/>

        <br>

        <input type="submit" value="Submit">

    </div>

</form:form>
</div>
</body>

</html>
