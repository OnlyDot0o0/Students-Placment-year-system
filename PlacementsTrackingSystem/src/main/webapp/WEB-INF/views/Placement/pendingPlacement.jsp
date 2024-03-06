<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Pending Applications</title>
    <link rel="stylesheet" href="../../../css/RiskForm.css">
    <link rel="stylesheet" href="../../../css/landing.css">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <script src="../../../js/helperScript.js"></script>
    <script src="../../../js/helperScript.js"></script>

</head>
<body>

<nav class="navbar navbar-dark  navbar-expand navbar-static-top ">
    <div class="container-fluid">

        <div class="navbar-header col-xs-6">
            <span><img  class=navbar-brand" src="../../../css/uniLogo.png"></span>
        </div>

        <ul  class="nav navbar-nav navbar-text center">
            <li ><span><h3 class=" navbar-text">Pending Placements</h3></span></li>
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
<div class="flex-row">
                <table class="table table-bordered table-hover table-md" style=" width: 80vw; margin: 0px">
                    <thead>
                    <tr>
                        <th class="text-center" scope="col">Student</th>
                        <th class="text-center" scope="col">Company</th>
                        <th class="text-center" scope="col">Status</th>
                        <th class="text-center" scope="col">Reason</th>
                        <th class="text-center" scope="col">Contact</th>

                    </tr>
                    </thead>
                    <tbody style="text-align: center;">
                    <c:forEach var="pending" items="${pendingPlacements}">
                        <tr>
                            <td>
                                <a href="/students/${pending.student.studentNumber}">${pending.student.firstName} ${pending.student.surname}</a>
                            </td>
                            <td>${pending.company.organisationName}</td>
                            <td>
                                <div class="btns-status">
                                <button class="approve" onclick="AddDescriptionToStatus(1, 'description-${pending.id}', ${pending.student.studentNumber},${pending.company.id}, ${pending.id})">
                                    Approve
                                </button>
                                <button class="flag" onclick="AddDescriptionToStatus(2, 'description-${pending.id}', ${pending.student.studentNumber},${pending.company.id}, ${pending.id})">
                                    Flag
                                </button>
                                <button class="reject" onclick="AddDescriptionToStatus(3, 'description-${pending.id}', ${pending.student.studentNumber},${pending.company.id}, ${pending.id})">
                                    Reject
                                </button>
                                </div>
                            </td>
                            <td class="description"> <input  class="description" id="description-${pending.id}"name="description"/></td>
                        <td>
                            <div class="btns-status">
                                <button type="button" class="contact" onclick="location.href='/contactStudent?studentID=${pending.student.studentNumber}';" value="Contact Student" >Contact Student</button>
                                <button type="button" class="contact" onclick="location.href='/contactCompany?studentID=${pending.student.studentNumber}';" value="Contact Company" />Contact Company</button>
                            </div>
                        </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>

</div>
<div id="help" ><a href="/help" class="glyphicon glyphicon-question-sign"></a></div>
</body>
</html>