<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Placement Provider Policies & Insurance (UK only)</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <script src="../../../js/helperScript.js"></script>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">

</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">Placement Provider : Policies & Insurance (UK only)</h2>
<div class="flex-row">
<form:form method="post" modelAttribute="policiesuk_form" action="/public/addPoliciesUk" >
    <input type="hidden" path="id" name="id" value=${id}>

    <div>


        <form:label path="">
        a.	UK providers only: Does your organisation hold Public Liability Insurance or equivalent?<br>

        Equivalent within the UK may refer to self-insurance or crown indemnity insurance (NHS).


        </form:label><br>
        <form:select path="publicLiabilityIns" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYesPL')">
            <form:option value="1">Yes</form:option>
            <form:option value="0">No</form:option>
            <form:option value="2">N/A (Crown/NHS Indemnity)</form:option>
        </form:select><br>

        <div class="AppearYesPL" style="display: none" >
        <form:label path="">If yes, please confirm:</form:label><br>

        <form:label path="PlNameProvider">a. Name of provider:</form:label>
        <form:input path="PlNameProvider"/>

        <form:label path="PlExpiry">b. Expiry date:</form:label><br>
        <form:input type="date" path="PlExpiry" value="2023-02-01"/><br>
    </div><br>

        <form:label path="PlNo">If no, what will happen if a member of the public makes a claim:</form:label><br>
        <form:textarea path="PlNo"></form:textarea><br>




            <form:label path="">
b.	UK providers only: Does your organisation hold Employer's Liability Insurance or equivalent?<br>

This is usually a legal requirement for employing a placement student – for more information see <a href="https://gov.uk"> gov.uk.</a>


            </form:label><br>

            <form:select path="employerLiabilityIns" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYesEL')">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No</form:option>
            </form:select><br>

    <div class="AppearYesEL" style="display: none" >
            <form:label path="">If yes, please confirm:</form:label><br>

        <form:label path="ElNameProvider">a. Name of provider:</form:label>
        <form:input path="ElNameProvider"/>

        <form:label path="ElExpiry">b. Expiry date:</form:label><br>
        <form:input type="date" path="ElExpiry" value="2023-02-01"/><br>

    </div><br>

        <form:label path="ElNo">If no, what will happen if a member of the public makes a claim:</form:label><br>
        <form:textarea path="ElNo"></form:textarea><br>



            <form:label path="">
            c.	UK providers only: Does your organisation hold Professional Indemnity Insurance or equivalent?<br>

            This insurance is only applicable if during the placement a student may provide <br>
                advice, designs, or professional services to the public or other businesses.

            </form:label><br>


            <form:select path="proIndemIns" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYesPro')">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No, but the placement student will provide advice, designs, <br> or professional services to people outside the business.</form:option>
                <form:option value="2">No, this insurance is not applicable to the role/company.</form:option>
            </form:select><br>

    <div class="AppearYesPro" style="display: none" >
        <form:label path="">If yes, please confirm:</form:label>

        <form:label path="proNameProvider">a. Name of provider:</form:label>
        <form:input path="proNameProvider"/>

        <form:label path="proExpiry">b. Expiry date:</form:label><br>
        <form:input type="date" path="proExpiry" value="2023-02-01"/><br>

    </div><br>
        <input type="submit" value="Submit">

    </div>

</form:form>
</div>
</body>

</html>
