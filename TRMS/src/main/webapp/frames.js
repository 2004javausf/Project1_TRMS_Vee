var emp=null;
var localStorage;
var empTitle=null;
window.onload=function(){
    
	this.getLogin();
    
}

function getLogin(){
    console.log("in getLogin");
//    let uName=document.getElementById("uName").value;
//    let uPassword=document.getElementById("uPassword").value;
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
    
    eTitle=emp.empTitle;
    
    if(eTitle=="Associate") {
        console.log(eTitle)
    	document.getElementById("top").src="nav.html"
    }
    else {
    	document.getElementById("top").src="nav1.html"
    }
}