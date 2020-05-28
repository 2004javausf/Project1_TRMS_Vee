var emp;

window.onload=function(){
    console.log("in load");
    var user = '<%= session.getAttribute("user") %>';
	console.log(user);
	var session = '<%= Session["user"] %>';
	console.log(session);
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
            console.log(emp);
            loadLogin(emp);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/login",true);
//    var payload=jsonBuilder();
    xhr.send();
}

function loadLogin(emp){
	
	var emp = emp;
	console.log(emp);
	var user = '<%= session.getAttribute("user") %>';
	console.log(user);

//    document.getElementById("eID").innerHTML=emp.empID;
//    document.getElementById("fname").innerHTML=emp.fName;
//    document.getElementById("lname").innerHTML=emp.lName;
//    document.getElementById("uname").innerHTML=emp.uname;
//    document.getElementById("upass").innerHTML=emp.uPassword;
//    document.getElementById("email").innerHTML=emp.email;
//    document.getElementById("title").innerHTML=emp.title;
//    document.getElementById("dept").innerHTML=emp.dept;

}

function jsonBuilder(){
    var elements=document.getElementById("loginForm").elements;
    var obj={};
    for(var i=0; i<elements.length-1;i++){
        var item=elements.item(i);
        obj[item.name]=item.value;
        console.log(obj);
    }
    var json=JSON.stringify(obj);
    console.log(json);
    return json;
}