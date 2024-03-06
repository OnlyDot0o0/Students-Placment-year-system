<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
    <link rel="icon" type="image/x-icon" href="../../../css/uniLogoIcon.png">
    <link rel="stylesheet" href="../../../css/uploadCSS.css">
    <script src="../../../js/helperScript.js"></script>
    <link rel="stylesheet" href="../../../css/landing.css">

    <title>Company Form Upload Point</title>
</head>
<body>


<div class="bar">

    <img class="uniLogo" src="../../../css/uniLogo.png"></div>


<h2 class="title">Placement Provider Form</h2>


<div class="main-cont-col">


    <div class="alert" style="display: none">

        File Uploaded successfully
        <span class="closebtn" onclick="this.parentElement.style.display='none';">&times;</span>
    </div>
    <div class="main-cont-row">

        <div class="upload-main-cont">
            <div class="upload-cont-flex">
                <h2>Upload your form :</h2>

                <div class="upload-cont">
                    <input id="SelectedFiles" type="file" multiple/>
                    <div class="browse-flex">

                        <label

                            for="SelectedFiles" class="browse "><span class="glyphicon glyphicon-upload"></span> Browse files</label
                            ></div>

                    <p class="warning-class NoFileSelected" style="display: none">Please select a file!</p>

                </div>

                <input class="upload-submit" value="Submit" type="submit"
                       onclick="UploadFile(SelectedFiles, 'NoFileSelected', '/public/addCompanyUpload', '${_csrf.token}')"/>
            </div>

            <div class="hrz-bar"></div>

            <%--        <a href="https://uniofleicester-my.sharepoint.com/:w:/r/personal/jbh13_leicester_ac_uk/Documents/CO2201/2022-2023/Project-Resources/Project-B_Placement-Tracking-System/CO2201-Placement%20Provider%20Form.docx?d=w64a61d42c55f4741b01b193925b715e6&csf=1&web=1&e=Oi3xDm">Download the form</a>--%>
            <a class="download" href="../../../Downloadables/CO2201-Placement%20Provider%20Form.docx">Download The
                Form </a>

        </div>
        <div class="vert-bar">


        </div>

        <div class="link-cont">

            <h3>Or you can complete the form online : </h3>
            <h3><a href="/public/PPFProviderDetails">Placement Provider Form</a></h3>

        </div>
    </div>


</div>
<div class="contact-section">

    <p>Please contact this email for any enquiries : <a href="mailto:placements@leicester.ac.uk">placements@leicester.ac.uk</a>
    </p>

</div>
<div id="help" ><a href="/help" class="glyphicon glyphicon-question-sign"></a></div>

</body>
</html>