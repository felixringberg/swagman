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
        us = "The username is too short.\n";
        if(username_applicant.length === 0){
            us = "You must specify a username.\n";
        }
    }
    if(password_applicant.length < 6){
        pw = "The password is too short.\n";
        if(password_applicant.length === 0){
            pw = "You must specify a password.\n";
        }
    }
    if(firstname_applicant.length === 0){
        fn = "You must specify a firstname.\n";
    }
    if(lastname_applicant.length === 0){
        ln = "You must specify a lastname.\n";
    }
    if(!pattern.test(dob_applicant)){
        dob = "Date of birth must be YYYY-MM-DD.\n";
    }
    if(fn === "" && ln === "" && dob === "" && us === "" && pw === ""){
        alert("Looks fine to me.");
    }
    if(fn != "" || ln != "" || dob != "" || us != "" || pw != ""){
        alert(fn +
              ln +
              dob +
              us +
              pw);
        return false;
    }
    
    //alert("Exit validation");
}

function validateLoginFormAInput(){
    var usernameA = document.loginFormA["loginFormA:loginuserA"].value;
    var passwordA = document.loginFormA["loginFormA:loginpassA"].value;
    
    var usA = "";
    var passA = "";
    
    if(usernameA === "") {
        usA = "You need to specify a username.\n";
    }
    if(passwordA === "") {
        passA = "You need to specify a password.\n";
    }
    if(usA !== "" || passA !== ""){
        alert(usA + passA);
        return false;
    }
}

function validateLoginFormRInput(){
    var usernameR = document.loginFormR["loginFormR:loginuserR"].value;
    var passwordR = document.loginFormR["loginFormR:loginpassR"].value;
    
    var usR = "";
    var passR = "";
    
    if(usernameR === "") {
        usR = "You need to specify a username.\n";
    }
    if(passwordR === "") {
        passR = "You need to specify a password.\n";
    }
    if(usR !== "" || passR !== ""){
        alert(usR + passR);
        return false;
    }
}


