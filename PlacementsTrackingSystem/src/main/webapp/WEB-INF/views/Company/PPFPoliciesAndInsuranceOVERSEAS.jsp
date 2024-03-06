<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Placement Provider Policies & Insurance (Overseas Only)</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <script src="../../../js/helperScript.js"></script>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">

</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">Placement Provider : Policies & Insurance (Overseas Only)</h2>
<div class="flex-row">
<form:form method="post" modelAttribute="policiesOverseas_form" action="/public/addPoliciesOverseas" >
    <input type="hidden" path="id" name="id" value=${id}>

    <div>

            <form:label path="">
a.	Non-UK providers only: Would your organisation's insurances cover liability <br>
                if your business is held responsible for injury or damage to a client, contractor, or member of the public?

            </form:label><br>
            <form:select path="liabilityIns" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYes')">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No</form:option>
            </form:select><br>

        <div class="AppearYes" style="display: none" >
            <form:label path="">If yes, please confirm:</form:label><br>

        <form:label path="liNameProvider">a. Name of provider:</form:label>
        <form:input path="liNameProvider"/>

        <form:label path="liExpiry">b. Expiry date:</form:label><br>
        <form:input type="date" path="liExpiry" value="2023-02-01"/><br>

        </div><br>

                    <form:label path="">
b.	Non-UK providers only: Would your organisation's insurances cover liability <br>
                        arising from injury sustained by a student as a result of their duties in the role?
                    </form:label><br>
                    <form:select path="roleIns" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYesRolIns')">
                        <form:option value="1">Yes</form:option>
                        <form:option value="0">No</form:option>
                    </form:select><br>


        <div class="AppearYesRolIns" style="display: none" >
                    <form:label path="">If yes, please confirm:</form:label><br>

                <form:label path="roleInsProviderName">a. Name of provider:</form:label>
                <form:input path="roleInsProviderName"/>

                <form:label path="roleInsExpiry">b. Expiry date:</form:label><br>
                <form:input type="date" path="roleInsExpiry" value="2023-02-01"/><br>

        </div><br>

            <form:label path="">
c.	Non-UK providers only: Would your organisation's insurances cover any legal/compensation costs <br>
                arising from the placement student's advice or professional services?
            </form:label><br>
            <form:select path="compCosts" onchange="manageOther('1' , this.options[this.selectedIndex].value, 'AppearYesCostIns')">
                <form:option value="1">Yes</form:option>
                <form:option value="0">No, but the student will be providing external advice or professional services in their role.</form:option>
                <form:option value="2">No, but the student will not be providing any external advice or professional services.</form:option>
            </form:select><br>

        <div class="AppearYesCostIns" style="display: none" >
            <form:label path="">If yes, please confirm:</form:label><br>

        <form:label path="compCostsProviderName">a. Name of provider:</form:label>
        <form:input path="compCostsProviderName"/>

        <form:label path="compCostsExpiry">b. Expiry date:</form:label><br>
        <form:input type="date" path="compCostsExpiry" value="2023-02-01"/><br>
        </div><br>





        <input type="submit" value="Submit">

    </div>

</form:form>
</div>
</body>

</html>
