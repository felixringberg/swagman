/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function validateApplicantFormInput(){
    var username_applicant = document.registrationForm["registrationForm:username"].value;
    var password_applicant = document.registrationForm["registrationForm:password"].value;
    var firstname_applicant = document.registrationForm["registrationForm:firstname"].value;
    var lastname_applicant = document.registrationForm["registrationForm:lastname"].value;
    var dob_applicant = document.registrationForm["registrationForm:dateofbirth"].value;
    var password_applicant = document.registrationForm["registrationForm:password"].value;

    var fn = "";
    var ln = "";
    var dob = "";
    var us = "";
    var pw = "";
    
    var pattern =/^([0-9]{4})-([0-9]{2})-([0-9]{2})$/;
    
    
    if(username_applicant.length < 6){
        us = "The username is too short.";
        if(username_applicant.length === 0){
            us = "You must specify a username.";
        }
    }
    if(password_applicant.length < 6){
        pw = "The password is too short.";
        if(password_applicant.length === 0){
            pw = "You must specify a password.";
        }
    }
    if(firstname_applicant.length === 0){
        fn = "You must specify a firstname.";
    }
    if(lastname_applicant.length === 0){
        ln = "You must specify a lastname.";
    }
    if(!pattern.test(dob_applicant)){
        dob = "Date of birth must be YYYY-MM-DD.";
    }
    if(fn == null && ln == null && dob == null && us == null && pw == null){
        alert("Looks fine to me.");
    }
    if(fn != "" || ln != "" || dob != "" || us != "" || pw != ""){
        alert(fn +"\n"+
              ln +"\n"+
              dob +"\n"+
              us +"\n"+
              pw);
    }
    
    //alert("Exit validation");
}

function validateLoginFormAInput(){
    var username = document.loginFormA('loginFormA:loginuserA').value;
    var password = document.loginFormA('loginFormA:loginpassA').value;
    
    if(username == "") {
        alert("You need to write a username.");
    }
    if(password == "") {
        alert("You need to write a password.");
    }
}

function validateLoginFormRInput(){
    var username = document.loginFormR('loginFormR:loginuserR').value;
    var password = document.loginFormR('loginFormR:loginpassR').value;
    
    if(username == "") {
        alert("You need to write a username.");
    }
    if(password == "") {
        alert("You need to write a password.");
    }
}


