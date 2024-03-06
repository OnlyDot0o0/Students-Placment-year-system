<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <meta charset="UTF-8">
    <title>Import Old Database</title>


    <link rel="stylesheet" href="../../../css/landing.css">
    <link rel="stylesheet" href="../../../css/RiskForm.css">
    <link rel="stylesheet" href="../../../css/dbUpload.css">
    <script src="../../../js/OnPlacement.js"></script>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <script src="../../../js/helperScript.js"></script>
    <script>
        $(document).ready(function() {
            $('#submit-btn').click(function() {
                $(this).css('cursor', 'progress');
            });
        });
    </script>
</head>
<body>

<nav class="navbar navbar-dark  navbar-expand navbar-static-top ">
    <div class="container-fluid">

        <div class="navbar-header col-xs-6">
            <span><img  class=navbar-brand" src="../../../css/uniLogo.png"></span>
        </div>

        <ul  class="nav navbar-nav navbar-text center">
            <li ><span><h3 class=" navbar-text">Import Old Database</h3></span></li>
        </ul>

        <ul class="nav navbar-nav navbar-right navbar-text menu" >
            <li><a href="javascript:;" onclick=" return logOut()"><span class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
        </ul>


        <ul class="nav navbar-nav navbar-right links navbar-text menu">

            <li class="active dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Access Placements
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/pendingPlacements">Pending Placements</a></li>
                    <li><a href="/internal">Currently on Placements</a></li>
                </ul>
            </li>


            <li><a href="/report">Statistical Report</a></li>

            <li class="dropdown">
                <a class="dropdown-toggle" data-toggle="dropdown" href="#">Access Forms
                    <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="/public/newStudentUpload">Student Form</a></li>
                    <li><a href="/public/newCompanyUpload">Placement Provider Form</a></li>
                    <li><a href="/newForm">Risk Assessment Form</a></li>
                    <li><a href="/flagged">Flagged Form</a></li>
                </ul>
            </li>

        </ul>
        <ul class="nav navbar-nav col-md-1 navbar-right ham " >
            <li ><a data-toggle="collapse" href="#collapse1"><span class="glyphicon glyphicon-menu-hamburger"></span></a></li>

        </ul>





    </div>
</nav>

<div id="collapse1" class="panel-collapse collapse">



    <div class="panel-body"> <button class="option" data-toggle="collapse" href="#collapsePlacements" style="width: 100%;">Access Placements</button></div>


    <div id="collapsePlacements" class="panel-collapse collapse">

        <div class="panel-body"> <button class="option"onclick="goTo('/internal')" style="width: 100%;">Currently on Placements</button></div>

        <div class="panel-body"> <button class="option" onclick="goTo('/pendingPlacements')" style="width: 100%;">Pending Placements</button></div>



    </div>

    <div class="panel-body"> <button class="option" onclick="goTo('/report')" style="width: 100%;">Statistical Report</button>


    </div>


    <div class="panel-body"> <button class="option" data-toggle="collapse" href="#collapse2" style="width: 100%;">Access Forms</button></div>



    <div id="collapse2" class="panel-collapse collapse">

        <div class="panel-body"> <button class="option" onclick="goTo('/public/newStudentUpload')" href="/public/newStudentUpload" style="width: 100%;">Student Form</button></div>

        <div class="panel-body"> <button class="option" onclick="goTo('/public/newCompanyUpload')" href="/public/newCompanyUpload" style="width: 100%;">Placement Provider Form</button></div>

        <div class="panel-body"> <button class="option" onclick="goTo('/newForm')" href="/newForm" style="width: 100%;">Risk Assesssment Form</button></div>

        <div class="panel-body"> <button class="option" onclick="goTo('/flagged')" href="/flagged" style="width: 100%;">Flagged Forms</button></div>
    </div>


    <div class="panel-body"><button class="option"  style="width: 100%;" onclick=" return logOut()"><span class="glyphicon glyphicon-log-out"></span> LogOut</button></div>
</div>

</div>



<form:form action="/read-excel" method='post' modelAttribute="file" enctype="multipart/form-data">
    <div class="upload-cont">

        <div class="upload-cont-col">

            <h2>Transfer all data from old database Excel file to this new system</h2>
            <br>
            <br>


            <p class="txt">Upload your csv file via the browse button and simply press upload</p>
            <div class="browse-flex">
                <div class="browse-size">
                <input id="SelectedFiles"  name="file" type="file" multiple/>
                <label for="SelectedFiles" class="browse "><span class="glyphicon glyphicon-upload"></span> Browse files</label>
                <p class="warning-class NoFileSelected" style="display: none">Please select a file!</p>
<%--                <input type="submit" value="Submit" name="Submit"/>--%>
                    <input type="submit" value="Submit" name="Submit" id="submit-btn" />

                </div>
            </div>

        </div>

    </div>

</form:form>
<div id="help" ><a href="/help" class="glyphicon glyphicon-question-sign"></a></div>

</body>
</html>



