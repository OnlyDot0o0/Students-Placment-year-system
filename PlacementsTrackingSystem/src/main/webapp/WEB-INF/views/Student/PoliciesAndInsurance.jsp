<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <title>Policies and Insurance</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">

</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>


<h2 class="title" >9. Policies and Insurance (Overseas Placement)</h2>
<div class="flex-row">
    <div style="max-width: 50%">

        <form:form method="post" modelAttribute="policyInsurance_form" action="/public/addPolicy_form" >
        <input type="hidden" path="id" name="id" value=${student_id}>

        <div>

            <form:label path="studentTravelApplication">a.Overseas Placement. Are you aware that you must submit a Student Travel Application Form once your placement has been approved? If no, please complete this <a href="https://uniofleicester.sharepoint.com/sites/Insurance/SitePages/Staff-Student-Overseas-Travel.aspx">form</a> :  </form:label>
            <form:select path="studentTravelApplication">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No</form:option>
            </form:select>
            <form:errors cssClass="warning-class" path="studentTravelApplication"/> <br>

            <form:label path="riskAssessmentEscalation">b. Overseas Placement. Is your country of work listed as one that require risk assessment escalation?  </form:label>
            <form:select path="riskAssessmentEscalation">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No</form:option>
            </form:select>
            <form:errors cssClass="warning-class" path="riskAssessmentEscalation"/> <br>


            <input type="submit" value="Submit">

        </div>

        </form:form>
    </div>
</div>
</body>

</html>