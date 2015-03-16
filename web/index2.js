/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateApplicantFormInput(){
    alert("Entered validateApplicantFormInput()");
    var username_applicant = document.getElementById['username'].value;
    var password_applicant = document.getElementById['password'].value;
    
    if(username_applicant.length < 6){
        alert("JS: Username too short");
        document.getElementById['usernameLabel'].innerHTML = "must be atleast 6 characters";
    }
    alert("Exit validation");
}

function validateLoginFormAInput(){
    var username = document.getElementById('loginuser').value;
    var password = document.getElementById('loginpass').value;
    
    if(username == "") {
        if(password == "") {
            document.loginFormA["loginFormA:loginuserLabel"].innerHTML = 'Username: Required field!';
            document.loginFormA["loginFormA:loginpassLabel"].innerHTML = 'Password: Required field!';
        }
        else {
            document.loginFormA["loginFormA:loginuserLabel"].innerHTML = 'Username: Required field!';
        }
    }
    else if(password == "") {
        document.loginFormA["loginFormA:loginpassLabel"].innerHTML = 'Password: Required field!';
    }
}


