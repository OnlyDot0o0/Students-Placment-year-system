<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
</head>

<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>
<h2 class="title">Student Details</h2>
<div class="flex-row">



        <p>First Name: ${student.firstName}<br>
            <br>
            Surname:  ${student.surname}<br>
            <br>
            Student Number: ${student.studentNumber}<br>
            <br>
            Email:  ${student.uniEmailAddress}<br>
            <br>
            Type:  ${student.studentType}<br>
            <br>
            Department:  ${student.departmentOrSchool}<br>
            <br>
            Year of Study:  ${student.yearOfStudy}<br>
            <br>
            Program:  ${student.programme}<br>
            <br>
            Status:  ${student.studentStatus}<br>
            <br>
            Course Transfer Required? :  ${student.courseTransferRequired}<br>
            <br>
            (Additional Notes):  ${student.additionalNotes}<br>
            <br>
            Visa Duration:  ${student.visaDuration}<br>

    <br>

    <form:select path="student.additionalNotes">
        <form:option value="1">Approve</form:option>
        <form:option value="0">Reject</form:option>
        <form:option value="2">Flag</form:option>
    </form:select>




</div>
</body>

</html>
