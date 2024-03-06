<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <title>Work Factors Section</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">

</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>


<h2 class="title" >4. Work Factors</h2>
<div class="flex-row">

    <form:form method="post" modelAttribute="workFactor_form" action="/public/addWork_form" >
    <input type="hidden" path="id" name="id" value=${student_id}>

    <h2>4. Work Factors Section</h2>


    <form:label path="remoteWork">
        Does this role involve working
        from home/remotely? (This includes hybrid working)
    </form:label>
    <form:select path="remoteWork">
        <form:option value="1">Yes</form:option>
        <form:option value="0">No</form:option>
    </form:select>
    <form:errors cssClass="warning-class" path="remoteWork"/> <br>


    <form:label path="remoteWorkYesSupport">
        b. Please provide an overview of how you will work remotely.
        This should include how often you will work remotely each week
    </form:label>
    <form:input path="remoteWorkYesSupport"/>
    <form:errors cssClass="warning-class" path="remoteWorkYesSupport"/> <br>

    <form:label path="romoteWorkYesReason">
        c. Why does this role involve working from home?
    </form:label>
    <form:input path="romoteWorkYesReason"/>
    <form:errors cssClass="warning-class" path="romoteWorkYesReason"/> <br>



    <input type="submit" value="Submit">

</div>

</form:form>

</body>

</html>