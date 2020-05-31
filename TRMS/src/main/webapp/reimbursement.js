var et;
var gf;
var fName;
var lName;
var eID;
window.onload=function(){
    console.log("in load");
    fName=localStorage.getItem("fName");
    lName=localStorage.getItem("lName");
    eID=localStorage.getItem("eID");
    
    document.getElementById("eID").value = eID;
    document.getElementById("fName").value = fName;
    document.getElementById("lName").value = lName;
    this.getET();
    this .getGF();
    //document.getElementById("rFormSubmit").addEventListener("click",checkForm,false);
    document.getElementById("eType").addEventListener("change",calculateRP,false);
    document.getElementById("tFees").addEventListener("change",calculateRP,false);
}
function calculateRP(){
    var cost = document.getElementById("tFees").value;
    console.log(cost);
    var sel = document.getElementById("eType");
    if(sel.value != 0){
        var percent = et[(sel.value)-1].etPercent;
        console.log(percent);
        var pr = ((cost*percent)/100);
        console.log(pr);

        document.getElementById("rProjected").value = pr;
    }
}
function getGF(){
    console.log("in getGF");
    //let vgid=document.getElementById("vgIDInput").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            gf=JSON.parse(xhr.responseText);
            loadGF(gf);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/gfinfo",true);
    xhr.send();
}

function loadGF(gf){
    for (var i=0; i<gf.length;i++){
        document.getElementById("gFormat").options[i+1] = new Option(gf[i].gfName,gf[i].gfID);
    }
}

function getET(){
    console.log("in getET");
    //let vgid=document.getElementById("vgIDInput").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            et=JSON.parse(xhr.responseText);
            loadET(et);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/etinfo",true);
    xhr.send();
}

function loadET(et){
    for (var i=0; i<et.length;i++){
        document.getElementById("eType").options[i+1] = new Option(et[i].etName,et[i].etID);
    }
}

function jsonBuilder(){
    var elements=document.getElementById("requestForm").elements;
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

function postRim(){
    console.log("in postRim");   
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/TRMS/applyrim",true);
    var rimData=jsonBuilder();
    xhr.send(rimData);
}

function checkForm()
{	
	var d = document.getElementById("eDate").value
	 // To set two dates to two variables 
    var date1 = new Date();  //Today's Date
	var date2 = new Date(d); //Event Date
	  
	// To calculate the time difference of two dates 
	var DiffInTime = date2.getTime() - date1.getTime(); 
	  
	// To calculate the no. of days between two dates 
	var DiffInDays = DiffInTime / (1000 * 3600 * 24); 
	
	console.log(d);
	console.log(DiffInTime);
	console.log(DiffInDays);
	
	if (DiffInDays < 7)
	{
		alert('As the event date is within a week, You are not elligible for this reimbursement!!!');
		return false;
	}
	else{
		postRim();
		//alert('Reimbursement Sucessfull !!!');
		return true;
	}
}
    

