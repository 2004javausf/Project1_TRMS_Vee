window.onload=function(){
    
	console.log("in load");
    
    this .postLogout();
    
}

function postLogout(){
    console.log("in postLogout");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/logout",true);
    xhr.send();
}