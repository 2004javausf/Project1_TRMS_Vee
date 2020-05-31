var er;
var user;
var empID;
var fName;
var lName;
var uName;
var uPassword;
var uEmail;
var empTitle;
var empDept;


window.onload=function(){
    console.log("in load profile");
    user=localStorage.getItem("user");
    console.log(user);
    empID=localStorage.getItem("eID");
    console.log(empID);
    fName=localStorage.getItem("fName");
    lName=localStorage.getItem("lName");
    empTitle=localStorage.getItem("title");
    empDept=localStorage.getItem("dept");
    uEmail=localStorage.getItem("email");
    uName=localStorage.getItem("uName");
    uPassword=localStorage.getItem("uPassword");
//  bal=localStorage.getItem("balance");
    
    var name=(fName+" "+lName);
    document.getElementById("name").innerHTML=name;
    document.getElementById("uname").innerHTML=uName;
    document.getElementById("email").innerHTML=uEmail;
    document.getElementById("title").innerHTML=empTitle;
    document.getElementById("dept").innerHTML=empDept;

}