<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--By Maryam. The jsp shown when "/contactStudent" is opened -->
<!DOCTYPE html>
<html>
<head>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Contact Student</title>
    <style>
        .button{
            border: 0;
            border-radius: 0px;
            box-shadow: none;
            background-color:#e4042c;
            width: 100%;
            display: inline-block;
            padding:1rem;
            margin: 1rem;
            height: 4em;
            color: white;
        }
        .button:hover{
            background-color: #6e0113;
            cursor: pointer;
        }
    </style>
    <link rel="stylesheet" href="../../../css/RiskForm.css">
</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h1 class="title">Contact Student</h1>
<div class="flex-row">
    <div>
        <!--The form to enter the email address of the recipient, the subject
         of the email, the body of the email. Includes a submit button which directs
         the user to the /contactLoading method, and a Go to... button, to return
         the user back to the pending placements stage (still waiting for those to finish that
         story so I can modify mine)
         Includes prefilled email content to help draft the email for the user-->
        <form:form action="/contactLoading" modelAttribute="contact">


        <form:label path="emailTo">Email to</form:label>
            <form:input path="emailTo" value="${student.uniEmailAddress}"/>

        <form:label path="Subject">Subject</form:label>
            <form:input path="Subject" value="Additional data request - ${student.firstName} ${student.surname} "/>

        <form:label path="Body">Body</form:label>



        <textarea style="min-height:15em" name="Body">Hi, hope you are doing well. I am part of the Placement Team at the University of Leicester and am gathering the details to authorise your placement with "${company.organisationName}".
Could you please provide the following details:


Sincerely,
${accountName.given_name}</textarea>


        <div style="width: 100%">
            <label>*Pressing <b>"Submit"</b> will open your default email client where you will be able to send the email</label>
            <br>
            <input style="width: 100%; cursor: pointer" type="submit"/>
            <input type="button" class="button" onclick="location.href='/pendingPlacements';" value="Return back to Pending Placements table" />
        </div>
        </form:form>
</body>
</html>
