<!DOCTYPE html>
<html lang="en">
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta charset="UTF-8">
    <title>Application Status Form</title>
    <link rel="stylesheet" href="../../../css/FormCSS.css">
</head>
<body>
<div class="bar"><img src="../../../css/uniLogo.png"></div>
<h2 class="title">Application Status Form</h2>
<div class="flex-row">
    <form action="/public/ApplicationResult">
        <label for="studentID" >Student Number: </label>
        <input type="text" id="studentID" name="studentID" onkeydown="return /[0-9]/i.test(event.key) || event.keyCode == 8" required/>

        <label for="companyName" > Company Name: </label>
        <input type="text" id="companyName" name="companyName" onkeydown="return /[0-9A-Za-z]/i.test(event.key) || event.keyCode == 8" required>

        <label for="uniqueID" >Unique ID: </label>
        <input type="text" id="uniqueID" name="uniqueID" onkeydown="return /[0-9]/i.test(event.key) || event.keyCode == 8" required>

        <input type="submit"  onvalue="Check"/>


    </form>
</div>
</body>
</html>
