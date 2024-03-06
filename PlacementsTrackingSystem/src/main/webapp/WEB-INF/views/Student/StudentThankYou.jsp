<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<HTML>

<header>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Thank you</title>
    <link rel="stylesheet" href="../../css/FormCSS.css">


</header>

<body>
<div class="bg-logo">
    <img src="../../css/uniLogo.png">
</div>

<div class="thx-bg">

    <div class="flex-column">


        <h1>Thank you for your submission !</h1>
        <h4>Your unique ID is ${uniqueID}.  Please keep it in a safe place.</h4>
        <h5>To check the application status go to <a href="http://localhost:8080/public/ApplicationStatusForm">http://localhost:8080/public/ApplicationStatusForm</a> and use your unique ID.</h5>

    </div>


</div>


</body>
</HTML>
