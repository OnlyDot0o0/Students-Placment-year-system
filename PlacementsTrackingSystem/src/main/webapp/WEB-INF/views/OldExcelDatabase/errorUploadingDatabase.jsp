<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--By Maryam - Jsp error pages for reading old Excel Master Tracker Database System--%>
<HTML>
<head>
<header>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Error with database upload</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">


</header>
<style>
    .button{
        border: 0;
        border-radius: 0px;
        box-shadow: none;
        background-color:#e4042c;
        width: 70%;
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
</head>
<body>
<div class="bg-logo">
    <img src="../../../css/uniLogo.png">
</div>

<div class="thx-bg">

    <div class="flex-column">

        <div style="width: 50%; margin: 0 auto; text-align: center;">

        <h3><b>Database upload process could not be completed</b></h3>
        <p>${errorMessage}</p>   <%--Depending on the error catched in the controller, a custom error message is displayed --%>
        <input type="button" class="button" onclick="location.href='/uploadDatabase';" value="Return back" /> <%--Redirects user back to the page to upload the file for database conversion --%>
        </div>
    </div>


</div>


</body>
</HTML>
