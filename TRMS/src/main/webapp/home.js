var emp;
var localStorage;
var c=0;
window.onload=function(){
    
	this.getLogin();
  
}

function getLogin(){
    console.log("in getLogin");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            emp=JSON.parse(xhr.responseText);
            loadLogin(emp);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/home",true);
//    var payload=jsonBuilder();
    xhr.send();
}

function loadLogin(emp){
    var name = emp.fName + " " + emp.lName;
    localStorage.setItem("user", name);
    localStorage.setItem("eID",emp.empID);
    localStorage.setItem("fName",emp.fName);
    localStorage.setItem("lName",emp.lName);
    localStorage.setItem("title",emp.empTitle);
    localStorage.setItem("dept",emp.empDept);
    localStorage.setItem("balance",emp.balance);
    localStorage.setItem("email",emp.email);
    localStorage.setItem("uName",emp.uName);
    localStorage.setItem("uPassword",emp.uPassword);
    console.log(localStorage.getItem("title"));
	console.log(emp);
	
    document.getElementById("welcome").innerHTML=("Welcome "+name);
//    document.getElementById("eID").innerHTML=emp.empID;
//    document.getElementById("fname").innerHTML=emp.fName;
//    document.getElementById("lname").innerHTML=emp.lName;
//    document.getElementById("uname").innerHTML=emp.uName;
//    document.getElementById("upass").innerHTML=emp.uPassword;
//    document.getElementById("email").innerHTML=emp.email;
//    document.getElementById("title").innerHTML=emp.empTitle;
//    document.getElementById("dept").innerHTML=emp.empDept;

}

