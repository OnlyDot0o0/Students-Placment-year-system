<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Placement Provider Health & Safety</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <script src="../../../js/helperScript.js"></script>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">Placement Provider : Health & Safety</h2>
<div class="flex-row">
<form:form method="post" modelAttribute="health_form" action="/public/addHealth" >
    <input type="hidden" path="id" name="id" value=${id}>

    <div>

            <form:label path="">
a.	Does the organisation have a procedure for recording and reporting accidents/incidents?
            </form:label><br>
            <form:select path="recRepAcc">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No</form:option>
            </form:select><br>

                <form:label path="">
b.	Does the organisation have a written health and safety policy?
            </form:label><br>
            <form:select path="writtenHS">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No</form:option>
            </form:select><br>


            <form:label path="">
c.	Does the organisation provide health and safety training for new employees?
            </form:label><br>
            <form:select path="hSTrain">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No</form:option>
            </form:select><br>




        <input type="submit" value="Submit">

    </div>

</form:form>
</div>
</body>

</html>
