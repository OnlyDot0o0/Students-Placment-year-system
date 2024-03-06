<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Placement Provider Work Factors</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <script src="../../../js/helperScript.js"></script>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">Placement Provider : Work Factors</h2>
<div class="flex-row">
<form:form method="post" modelAttribute="workFactors_form" action="/public/addWorkFactors" >
    <input type="hidden" path="id" name="id" value=${id}>

    <div>

        <form:label path="">
            a.Will the nature of the work undertaken by the student expose them to any hazards or risks?<br>



            For example this might include operating machinery, <br>
            working with hazardous materials, or supporting vulnerable children or adults.


        </form:label><br>
        <form:select path="exposeToHazard" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYes')">

            <form:option value="1">Yes</form:option>

            <form:option value="0">No</form:option>

        </form:select><br>

        <form:textarea cssClass="AppearYes" cssStyle="display: none"  path="exposeToHazardYes"></form:textarea><br>



        <form:label path="">
            b.Does the student need any specific training for the role or to undertake tasks?

        </form:label>
        <form:select path="trainingReq" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYesTrain')">

            <form:option value="1">Yes</form:option>

            <form:option value="0">No</form:option>

        </form:select><br>

        <form:textarea cssClass="AppearYesTrain" cssStyle="display: none"  path="trainingReqYes"></form:textarea><br>



        <form:label path="">
            c.Does the role involve the student working from their home?

        </form:label>
        <form:select path="remoteWork" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYesRemote')">

            <form:option value="1">Yes</form:option>

            <form:option value="0">No</form:option>

        </form:select><br>


        <div class="AppearYesRemote" style="display: none">
            <form:select path="remoteWorkYes" >

                <form:option value="1">Permanently  </form:option>

                <form:option value="0">Hybrid working e.g. two days in office, three days working from home  </form:option>
                <form:option value="2">Fully Remote </form:option>
            </form:select><br>

            <form:textarea   path="remoteWorkYesSupport"></form:textarea>

        </div>

        <input type="submit" value="Submit">

    </div>

</form:form>
</div>
</body>

</html>
