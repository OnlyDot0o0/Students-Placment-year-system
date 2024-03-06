<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <title>Placement Provider Details Section B</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">

</head>
<body>

<div class="bar"> <img src="../../../css/uniLogo.png"></div>


<h2 class="title" >2b. Placement Provider Details Section</h2>
<div class="flex-row">
    <div>
        <form:form method="post" modelAttribute="namedContact_form" action="/public/addContact_form" >
        <!-- ID, Organisation_name, Placement_address,
         Postcode, Webaddress, engages_regulated_activities, engages_regulated_activities_YES -->
        <input type="hidden" path="id" name="id" value=${student_id}>

        <!-- Contact details section -->
        <form:label path="name">e. Contact Name</form:label>
        <form:input path="name"/>
        <form:errors cssClass="warning-class" path="name"/> <br>

        <form:label path="jobTitle">f. Contact Job Title</form:label>
        <form:input path="jobTitle"/>
        <form:errors cssClass="warning-class" path="jobTitle"/> <br>

        <form:label path="email">g. Contact Email</form:label>
        <form:input path="email"/>
        <form:errors cssClass="warning-class" path="email"/> <br>

        <form:label path="telNumber">h. Contact Telephone Number</form:label>
        <form:input path="telNumber"/>
        <form:errors cssClass="warning-class" path="telNumber"/> <br>

        <input type="submit" value="Submit">

    </div>

    </form:form>

</body>

</html>