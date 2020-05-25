var er;
window.onload=function(){
    console.log("in load");
    this.getER();

    // document.getElementById("eType").addEventListener("change",calculateRP,false);
    // document.getElementById("tFees").addEventListener("change",calculateRP,false);
}

function getER(){
    console.log("in getGF");
    //let vgid=document.getElementById("vgIDInput").value;
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            er=JSON.parse(xhr.responseText);
            console.log(er);
            loadER(er);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/viewallreim",true);
    xhr.send();
}

function loadER(er){
    var table = document.getElementById("viewAllRim");      
        
    var tableBody = document.createElement('TBODY');
    table.appendChild(tableBody);
      
    for (var i=0; i<er.length;i++){
       var tr = document.createElement('TR');
       tableBody.appendChild(tr);
       
       for(var j=0;j<10;j++){
           var td = document.createElement('TD');
           td.appendChild(er[i][j]);
           tr.appendChild(td);
       }
    }
    myTableDiv.appendChild(table);
}