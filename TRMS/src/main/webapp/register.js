var et;
var ed;
window.onload=function(){
    console.log("in load");
    
    this .getED();
    this.getET();
    
    document.getElementById("eFormSubmit").addEventListener("click",postEmp,false);
}

function getED(){
    console.log("in getGF");
    //let vgid=document.getElementById("vgIDInput").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            ed=JSON.parse(xhr.responseText);
            loadED(ed);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/edept",true);
    xhr.send();
}

function loadED(ed){
    for (var i=0; i<ed.length;i++){
        document.getElementById("Dept").options[i+1] = new Option(ed[i].deptName,ed[i].deptID);
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
    xhr.open("GET","http://localhost:8080/TRMS/etitle",true);
    xhr.send();
}

function loadET(et){
    for (var i=0; i<et.length;i++){
        document.getElementById("Title").options[i+1] = new Option(et[i].titleName,et[i].titleID);
    }
}

function jsonBuilder(){
    var elements=document.getElementById("registerForm").elements;
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

function postEmp(){
    console.log("in postEmp");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("POST","http://localhost:8080/TRMS/empinfo",true);
    var rimData=jsonBuilder()
    xhr.send(rimData);
}