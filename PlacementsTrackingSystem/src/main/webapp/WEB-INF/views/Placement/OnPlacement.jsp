<!--
this is the jsp file created by Zaina and Moaz.
this is the file that is called in the Controller class which helps us see the details we want
since the are defined below.
the attributes that will be shown are:
The student's information like their:
Student number, First name, Surname, Email, Department
The role details of the student which are:
The role title, The starting date of the role, The ending date of the role, If his work is remote as well as how much he earns
The comapny details which are:
Name of the organisation and its Address
There is also a search bar which the tutor can use if they need to check if a student is on placement by entering their student number
-->

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <title>Placement Students</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="../../../css/RiskForm.css">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">

</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h1 class="title">On Placement Students</h1>
<div class="flex-row">
<div class="table-responsive" style="padding: 20px;">
    <div class="d-flex justify-content-center">
        <input type="text" id="search" placeholder="Search by Student Number..." style="text-align: center;">
    </div>
    <div class="mb-3 row justify-content-center">
        <div class="col-sm-10">
            <table class="table table-bordered table-hover table-sm" style="table-layout: fixed; width: 100%;">
                <thead>
                <tr>
                    <th class="text-center" scope="col">Student Number</th>
                    <th class="text-center" scope="padding-rightcol">Full Name</th>
                    <th class="text-center" scope="col">Company</th>
                    <th class="text-center" scope="col">Email</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="placement" items="${placements}">
                    <tr>
                        <td><a href="/students/${placement.student.studentNumber}">${placement.student.studentNumber}</a></td>
                        <td>${placement.student.firstName} ${placement.student.surname}</td>
                        <td>${placement.company.organisationName}</td>
                        <td>${placement.student.uniEmailAddress}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
<script src="../../../js/OnPlacement.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
</div>
</body>
</html>
