<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!--Student form section 1 form -->
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <title>Student Form</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="../../../css/landing.css">
    <link rel="stylesheet" href="../../../css/FormCSS.css" >

</head>
<body>
<div class="bar"> <img src="../../../css/uniLogo.png"></div>


    <h2 class="title" >1. Student Details</h2>

<div class="flex-row">
<form:form method="post" modelAttribute="student_form" action="/public/addStudent" >

        <form:label path="firstName">a. First Name</form:label>
        <form:input type="text" path="firstName"/>
        <form:errors cssClass="warning-class" path="firstName"/> <br>


        <form:label path="surname">b. Surname</form:label>
        <form:input path="surname"/>
        <form:errors cssClass="warning-class" path="surname"/> <br>


        <form:label path="studentNumber">c. Student Number</form:label>
        <form:input path="studentNumber"/>
        <form:errors cssClass="warning-class" path="studentNumber"/> <br>

        <form:label path="studentType">d. Student Type</form:label>
        <form:select path="studentType">
            <form:option value="Undergraduate">Undergraduate</form:option>
            <form:option value="Postgraduate">Postgraduate</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="studentType"/> <br>
    <br>
    <form:label path="yearOfStudy">d. Year of Study</form:label>
    <form:select path="yearOfStudy">
        <form:option value="Gap Year">Gap Year</form:option>
        <form:option value="Year 1">Year 1</form:option>
        <form:option value="Year 2">Year 2</form:option>
        <form:option value="Year 3">Year 3</form:option>
        <form:option value="Year 4">Year 4</form:option>
        <form:option value="Year 5">Year 5</form:option>
        <form:option value="Year 6">Year 6</form:option>
        <form:option value="Year 7">Year 7</form:option>
    </form:select>
    <form:errors cssClass="warning-class" path="yearOfStudy"/> <br>


    <form:label path="uniEmailAddress">e. Email Address</form:label>
        <form:input path="uniEmailAddress"/>
        <form:errors cssClass="warning-class" path="uniEmailAddress"/> <br>

        <form:label path="programme">f. Programme of Study</form:label>
        <form:input path="programme"/>
        <form:errors cssClass="warning-class" path="programme"/> <br>

        <form:label path="departmentOrSchool">g. School/Department</form:label>
        <form:select path="departmentOrSchool">
            <form:option value="Allied Health">Allied Health</form:option>
            <form:option value="Archaeology and Ancient History">Archaeology and Ancient History</form:option>
            <form:option value="Biochemistry">Biochemistry</form:option>
            <form:option value="Biological Sciences">Biological Sciences</form:option>
            <form:option value="Biology">Biology</form:option>
            <form:option value="Cancer Studies & Molecular Medicine">Cancer Studies & Molecular Medicine</form:option>
            <form:option value="Cardiovascular Sciences">Cardiovascular Sciences</form:option>
            <form:option value="Cell Physiology & Pharmacology">Cell Physiology & Pharmacology</form:option>
            <form:option value="Centre for Labour Market Studies at the School of Management">Centre for Labour Market Studies at the School of Management</form:option>
            <form:option value="Chemistry">Chemistry</form:option>
            <form:option value="Criminology">Criminology</form:option>
            <form:option value="Economics">Economics</form:option>
            <form:option value="Education">Education</form:option>
            <form:option value="Engineering">Engineering</form:option>
            <form:option value="English">English</form:option>
            <form:option value="English Language Teaching Unit">English Language Teaching Unit</form:option>
            <form:option value="Genetics">Genetics</form:option>
            <form:option value="Geography">Geography</form:option>
            <form:option value="Geology">Geology</form:option>
            <form:option value="Health Sciences">Health Sciences</form:option>
            <form:option value="History">History</form:option>
            <form:option value="History of Art and Film">History of Art and Film</form:option>
            <form:option value="Infection, Immunity and Inflammation">Infection, Immunity and Inflammation</form:option>
            <form:option value="Computer Science">Computer Science</form:option>
            <form:option value="Law">Law</form:option>
            <form:option value="Lifelong Learning">Lifelong Learning</form:option>
            <form:option value="Management">Management</form:option>
            <form:option value="Mathematics">Mathematics</form:option>
            <form:option value="Media and Communication">Media and Communication</form:option>
            <form:option value="Medical and Social Care Education">Medical and Social Care Education</form:option>
            <form:option value="Medical School">Medical School</form:option>
            <form:option value="Modern Languages">Modern Languages</form:option>
            <form:option value="Molecular and Cell Biology">Molecular and Cell Biology</form:option>
            <form:option value="MRC Toxicology">MRC Toxicology</form:option>
            <form:option value="Museum Studies">Museum Studies</form:option>
            <form:option value="Neuroscience, Psychology and Behaviour">Neuroscience, Psychology and Behaviour</form:option>
            <form:option value="Politics and International Relations">Politics and International Relations</form:option>
            <form:option value="Psychology">Psychology</form:option>
            <form:option value="Sociology">Sociology</form:option>
        </form:select><br>
        <form:errors cssClass="warning-class" path="departmentOrSchool"/> <br>

        <form:label path="telephoneNumber">h. Contact Telephone Number</form:label>
        <form:input  pattern="[0-9]{9}" path="telephoneNumber"/>
        <form:errors cssClass="warning-class" path="telephoneNumber"/><br>

        <form:label path="studentStatus">i. Are you an international student with a Student Visa?</form:label>
        <form:select path="studentStatus">
            <form:option value="International">Yes</form:option>
            <form:option value="Home">No</form:option>
        </form:select><br>
        <form:errors cssClass="warning-class" path="studentStatus"/> <br>


        <form:label path="visaDuration">j. Does your Student Visa duration account for your placement?</form:label>
        <form:select path="visaDuration">
        <form:option value="true">Yes</form:option>
        <form:option value="false">No</form:option>
        </form:select>
        <form:errors cssClass="warning-class" path="visaDuration"/> <br>

        <input type="submit" value="Submit">

    </div>
</form:form>

</body>
<div id="help" ><a href="/help" class="glyphicon glyphicon-question-sign"></a></div>

</html>