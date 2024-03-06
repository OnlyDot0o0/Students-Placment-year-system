<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Placement Provider University Access</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <script src="../../../js/helperScript.js"></script>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
</head>
<body>

<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">Placement Provider : University Access</h2>
<div class="flex-row">
<form:form method="post" modelAttribute="uniAccess_form" action="/public/addUniAccess" >
    <input type="hidden" path="id" name="id" value=${id}>

    <div>

            <form:label path="">
a.	Will staff from the University be able to undertake site visits during the placement <br>
                as required in consultation with appropriate staff at your organisation?
            </form:label><br>
            <form:select path="visits" onchange="manageOther('0' , this.options[this.selectedIndex].value, 'AppearNO')">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No</form:option>
            </form:select><br>

        <div class="AppearNO" style="display: none" >
        <form:label path="">If No, please provide reasons.</form:label><br>
            <form:textarea path="visitsNo"></form:textarea><br>

        </div><br>


            <form:label path="">
b.	Are there any issues relating to confidentiality or disclosure which the University <br>
                will need to take into account in its procedures for assessing work undertaken by students on placement in your organisation?
            </form:label><br>
            <form:select path="Issues_Conf"  onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYes')">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No</form:option>
            </form:select><br>

        <div class="AppearYes" style="display: none" >
            <form:label path="">If Yes, please provide details.</form:label><br>
            <form:textarea path="issuesYes"></form:textarea><br>
        </div><br>
        <input type="submit" value="Submit">

    </div>

</form:form>
</div>
</body>

</html>
