<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<HTML>
<head>
<header>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Successful database upload</title>
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

        <h3>Old Database has been successfully uploaded to the new system!</h3>
        <input type="button" class="button" onclick="location.href='/';" value="Return to home page" />
        </div>

    </div>

    </div>


</div>


</body>
</HTML>
