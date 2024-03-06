<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<%--

1. AVERAGE SALARY OF EACH COMPANY
2. AVERAGE STUDENTS APPLIED TO EACH COMPANY
3. Get all available roles from company
4. Get all companies that offer remote work

--%>


<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <link rel="stylesheet" href="../../../css/report.css">
    <link rel="stylesheet" href="../../../css/landing.css">
    <link rel="stylesheet" href="../../../css/RiskForm.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

    <script src="../../../js/helperScript.js"></script>

    <title>Statistical Report</title>
</head>
<body>
<nav class="navbar navbar-dark  navbar-expand navbar-static-top ">
    <div class="container-fluid">

        <div class="navbar-header col-xs-6">
            <span><img  class=navbar-brand" src="../../../css/uniLogo.png"></span>
        </div>


        <ul  class="nav navbar-nav navbar-text center">
            <li ><span><h3 class=" navbar-text">Statistical Report</h3></span></li>
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


<div class="main-cont-col">

    <div class="main-cont-row">
        <div class="opt-filt-grp-col">
            <form:form method="post" modelAttribute="report" action="/report">
            <div class="options-filters-grp">
                <div class="options sameHeight">
                    <h2>Select what content you want to see</h2>

                    <label for="sala"> <input type="checkbox" id="sala" path="sal" name="sal" value="sal">Average
                        salaries</label>

                    <label for="student"> <input type="checkbox" id="student" path="std" name="std" value="std">Number
                        of students per company</label>



                    <label for="dep"> <input type="checkbox" id="dep" name="dep" path="dep" value="dep">Number of
                        students per Department</label>

                </div>

                <div class="dropdown-div sameHeight">
                    <h2>Filters</h2>

                    <select name="location" id="location">
                        <option value="1">All</option>
                        <option value="2">UK Only</option>
                        <option value="3">Overseas Only</option>

                    </select>

                    <select name="studentType" id="studentType">
                        <option value="1">All</option>
                        <option value="2">Home Students Only</option>
                        <option value="3">International Students Only</option>

                    </select>

                    <select name="workStyle" id="workStyle">
                        <option value="1">All</option>
                        <option value="2">Remote or Hybrid Working Only</option>
                        <option value="3">In Office Only</option>

                    </select>



                </div>
            </div>

            <input type="submit" onclick=show() value="Generate">
        </div>
        </form:form>

    </div>
    <h2 id="outputTitle" style="text-decoration-line: underline">${title}</h2>


    <c:if test="${stdPerComps.size() != null}">
        <h3>Number of Students per Company</h3>
    <table>


            <tr>
                <th> <h4> ${TitleComp}</h4></th>
                <th><h4>${TitleStd}</h4></th>
            </tr>


        <c:forEach var="stdPerComp" items="${stdPerComps}">


            <tr>
                <td>${stdPerComp[1]}</td>
                <td>${stdPerComp[0]}</td>
            </tr>
        </c:forEach>
    </table>

    </c:if>


    <c:if test="${avg_comp_sal.size() != null}">
        <h3>Average Salary per Company</h3>
    <table>

        <tr>
            <th><h4>${TitleComp2}</h4></th>
            <th><h4>${TitleSalary}</h4></th>
        </tr>

        <c:forEach var="salary" items="${avg_comp_sal}">


            <tr>
                <td>${salary[1]}</td>
                <td>${salary[0]}</td>
            </tr>
        </c:forEach>
    </table> <br>
    </c:if>




    <c:if test="${stdPerDep.size() != null}">
        <h3>Number of Students per Department</h3>
    <table>

        <tr>
            <th><h4>${TitleDep}</h4></th>
            <th><h4>${TitleStd2}</h4></th>
        </tr>

        <c:forEach var="stdPerDep" items="${stdPerDep}">


            <tr>
                <td>${stdPerDep[1]}</td>
                <td>${stdPerDep[0]}</td>
            </tr>
        </c:forEach>
    </table>
    </c:if>

</div>
<div id="help" ><a href="/help" class="glyphicon glyphicon-question-sign"></a></div>

</body>
</html>