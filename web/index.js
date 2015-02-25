/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateApplicantFormInput(){
    alert("Entered validateApplicantFormInput()");
    var username_applicant = document.getElementById('username').value;
    var password_applicant = document.getElementById('password').value;
    alert("After getElementById");
    if(username_applicant.length() < 6){
        alert("Username too short");
    }
}

function validateLoginFormInput(){
    var username = document.getElementById('loginuser').value;
    var password = document.getElementById('loginpass').value;
    
    if(username == "") {
        if(password == "") {
            alert("Enter a username and password.");
            document.getElementById('usernameLabel').innerHTML = 'Username: Required field!';
            document.getElementById('passwordLabel').innerHTML = 'Password: Required field!';
        }
        else {
            alert("Enter a username.");
            document.getElementById('usernameLabel').innerHTML = 'Username: Required field!';
        }
    }
    else if(password == "") {
        alert("Enter a password.");
        document.getElementById('passwordLabel').innerHTML = 'Password: Required field!';
    }
}


