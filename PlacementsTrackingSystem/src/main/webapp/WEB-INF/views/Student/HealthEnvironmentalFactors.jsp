<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <title>Student Form</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>


<h2 class="title" >7. Health and Environmental Factors</h2>
<div class="flex-row">
    <div>

<form:form method="post" modelAttribute="health_form" action="/public/addHealth_form" >
    <input type="hidden" path="id" name="id" value=${student_id}>

        <form:label path="precautionaryMeasuresAware">a. Are you aware of any precautionary measures you are required to undertake before, during, or after the placement?<br> For example: vaccinations, PPE, medical or dietary advice, living arrangements. </form:label>
        <form:select path="precautionaryMeasuresAware">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="precautionaryMeasuresAware"/> <br>

        <form:label path="precautionaryMeasuresDescription">If yes, please provide details below of the precautionary measures</form:label>
        <form:input path="precautionaryMeasuresDescription"/>
        <form:errors cssClass="warning-class" path="precautionaryMeasuresDescription"/><br>

        <form:label path="safezoneDownloaded">b. Have you downloaded the "SafeZone" app using your university credentials?</form:label>
        <form:select path="safezoneDownloaded">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="safezoneDownloaded"/> <br>

        <form:label path="gliCard">c. Overseas Placement. Have you applied for your Global Health Insurance Card? </form:label>
        <form:select path="gliCard">
            <form:option value="1">Yes</form:option>
            <form:option value="2">No</form:option>
            <form:option value="3">N/A (country not in the EU)</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="safezoneDownloaded"/><br>

        <input type="submit" value="Submit">

    </div>
</div>

</form:form>

</body>

</html>