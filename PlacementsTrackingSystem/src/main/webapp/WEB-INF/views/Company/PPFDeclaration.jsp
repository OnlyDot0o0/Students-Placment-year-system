<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Placement Provider Declaration</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">Placement Provider : Declaration</h2>
<div class="flex-row">
<form:form method="post" modelAttribute="declaration_form" action="/public/addDeclaration" >
    <input type="hidden" path="id" name="id" value=${id}>

    <div>

        <form:label path="name">Name : <form:errors class="errors" path="name"/></form:label>
        <form:input path="name"/>


        <form:label path="jobTitle">Job Title : <form:errors class="errors" path="jobTitle"/></form:label>
        <form:input path="jobTitle"/>



        <form:label path="date">Date :</form:label><br>
        <form:input type="date" path="date" value="2023-02-02"/><br>

        <form:label path="signature">Signature : <form:errors class="errors" path="signature"/></form:label>
        <form:input path="signature"/>


        <input type="submit" value="Submit">

    </div>

</form:form>
</div>
</body>

</html>
