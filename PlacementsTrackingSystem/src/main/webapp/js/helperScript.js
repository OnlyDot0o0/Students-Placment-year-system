// This function takes three arguments:
// 1. The activation word which is usually "Other".
// 2. The chosen work/option
// 3. The class name of the entity to modify
function manageOther(monitored_input, chosen_input, entity_class_name) {
    if (chosen_input === monitored_input) {
        document.getElementsByClassName(entity_class_name).item(0).style.display = "inline-block";
    } else {
        document.getElementsByClassName(entity_class_name).item(0).style.display = "none";
    }
}


// This is file uploader. By default, it only allows one file per upload, but it can be modified to accept many.
// 1. "files_id" is the id of the file input tag
// 2. "noFile_class" is the class name of the error message when no files are selected.
// 3. "method_name" is the name of the post method found install the controller.
async function UploadFile(files_id, noFile_class = "", method_name, csrfToken) {
    if (files_id.files.length === 0) {
        document.getElementsByClassName(noFile_class).item(0).style.display = "block";
    } else {
        document.getElementsByClassName(noFile_class).item(0).style.display = "none";
        document.getElementsByClassName("alert").item(0).style.display = "none";
        document.getElementsByClassName("alert").item(0).style.backgroundColor = "#07A75A";
        document.getElementsByClassName("alert").item(0).innerHTML = "File Uploaded successfully\n <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>"


        let SelectedFile = new FormData();
        // Limit to one file per upload - add more by including the "multiple" attribute to the input tag and looping through them
        SelectedFile.append('_csrf', csrfToken);
        SelectedFile.append("file", files_id.files[0]);
        let res = await fetch(method_name, {
            method: "POST",
            body: SelectedFile
        }).then((jsonRes) => {
                //  In case of an undetected error
                if (!jsonRes.ok) {

                    document.getElementsByClassName("alert").item(0).style.display = "block";
                    document.getElementsByClassName("alert").item(0).style.backgroundColor = "#E4042C";
                    document.getElementsByClassName("alert").item(0).innerHTML = "There was at least one issue with the form. </br>Please try again or use the online form option or </br>contact the placement team. <span class=\"closebtn\" onclick=\"this.parentElement.style.display='none';\">&times;</span>"

                    throw new Error("There was at least one issue with the form. Please try again or use the online form option or contact the IT Help Desk.")
                } else {
                    document.getElementsByClassName("alert").item(0).style.display = "block";
                    // Get the unique ID, parse it to int and redirect the user.
                    jsonRes.text().then((text1) => {
                            try {
                                const uniqueID = parseInt(text1.split("-")[1])
                                console.log(uniqueID, uniqueID === NaN, uniqueID)
                                if (!isNaN(uniqueID)) {
                                    window.location.href = "/public/studentThankYou?uniqueID=" + uniqueID;
                                }
                            } catch {
                            }
                        }
                    );
                }
            }
        );

    }
}

// A function that will take an option id , a description, a student id , a company id and a placement id, and it will redirect the page.
function AddDescriptionToStatus(option_id, input_text, student_id, company_id, pending_id) {
    const textValue = document.getElementById(input_text).value;
    // Checks if the option is not waiting or approved and whether the reason field is empty.
    if (textValue === "" && option_id > 1) {
        const table = document.getElementById(input_text);
        table.style.outline = "red solid";
        table.style.borderRadius = "5px";
        alert("Reasons need to be added if the application is flagged or rejected.")
    } else {
        window.location.href = '/pendingPlacements/' + student_id + '_' + company_id + "_" + pending_id + "/" + option_id + "?description=" + textValue;
    }
}

function logOut() {
    if (confirm("Are you sure you want to log out ?")) window.location.href = '/logout';


}

function goTo(link) {
    window.location.href = link;

}