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
    if(fn === "" && ln === "" && dob === "" && us === "" && pw === ""){
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
    alert("inside A");
    var usernameA = document.loginFormA("loginFormA:loginuserA").value;
    var passwordA = document.loginFormA("loginFormA:loginpassA").value;
    
    alert("deeper in A");
    if(usernameA === "") {
        alert("You need to write a username.");
    }
    if(passwordA === "") {
        alert("You need to write a password.");
    }
}

function validateLoginFormRInput(){
    alert("inside R");
    var usernameR = document.loginFormR("loginFormR:loginuserR").value;
    var passwordR = document.loginFormR("loginFormR:loginpassR").value;
    alert("deeper in R");
    if(usernameR === "") {
        alert("You need to write a username.");
    }
    if(passwordR === "") {
        alert("You need to write a password.");
    }
}


