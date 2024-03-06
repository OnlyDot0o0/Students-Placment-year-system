<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Placement Provider Other Factors</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <script src="../../../js/helperScript.js"></script>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">Placement Provider : Other Factors</h2>
<div class="flex-row">
<form:form method="post" modelAttribute="factors_form" action="/public/addFactors" >
    <input type="hidden" path="id" name="id" value=${id}>

    <div>


        <form:label path="">

            a.Does the role involve working from sites other than the main address <br>
              (the address provided in section 1)

        </form:label>
        <form:select path="travelSites"  onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYes')">

            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select>
        <form:textarea cssClass="AppearYes" cssStyle="display: none"  path="travelSitesYes"></form:textarea><br>

        <form:label path="">
            b.Does this placement require any travel outside of the UK?<br>



            Please note: If a student is travelling overseas at the Placement Providers request, <br>
            (as part of the job description) then the university is not responsible for the travel insurance <br>
            and it is the Placement Provider responsibility to risk assess the travel.<br>
            If the student is travelling overseas to attend the placement, <br>
            then the responsibility is with university.

        </form:label>
        <form:select path="travelReqOverseas">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select><br>

        <form:label path="">
            c.Does the organisation's main location for the student present any risks?<br>
            For example, this might include civil disorder, crime, <br>
            environmental disasters, infectious disease, or poor healthcare access.

        </form:label><br>
        <form:select path="locationRisk" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYesloc')">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select><br>

        <form:textarea cssClass="AppearYesloc" cssStyle="display: none"  path="locationRiskYes"></form:textarea><br>

        <form:label path="">
            d.Is the student required to take precautionary measures to undertake the placement?<br>

            For example, this might include vaccinations, PPE, <br>
            medical or dietary advice, or specific living arrangements.

        </form:label><br>

        <form:select path="healthPrecautionary" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYeshealth')">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select><br>
        <form:textarea cssClass="AppearYeshealth" cssStyle="display: none"  path="healthPrecautionaryYes"></form:textarea><br>


        <form:label path="">
            e.If required, are you able to support students with any personal factors that may affect their placement?<br>



            For example, this might include making reasonable adjustments for physical or mental health conditions or disabilities.

        </form:label><br>
        <form:select path="persoFactors">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
        </form:select><br>








        <input type="submit" value="Submit">

    </div>

</form:form>
</div>
</body>

</html>
