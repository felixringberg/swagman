/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateApplicantFormInput(){
    var username_applicant = document.getElementById("username").value;
    var password_applicant = document.getElementById("password").value;

    if(username_applicant.length() < 6){
        alert("Username to short");
    }
}

function validateLoginFormInput(){
    var username = document.getElementById("loginuser").value;
    var password = document.getElementById("loginpass").value;
    
    if(username == ""){
        if(password == "")
            alert("Enter a username and password.");
        else
            alert("Enter a username.")
    }
    else if(password == "")
        alert("Enter a password.");
}


