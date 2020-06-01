var er;
var user;
var empID;
window.onload=function(){
    console.log("in load");
    user=localStorage.getItem("user");
    console.log(user);
    empID=localStorage.getItem("eID");
    this.getER();

    // document.getElementById("eType").addEventListener("change",calculateRP,false);
    // document.getElementById("tFees").addEventListener("change",calculateRP,false);
}

function getER(){
    console.log("in getGF");
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            er=JSON.parse(xhr.responseText);
            console.log(er);
            loadER(er);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/viewmyrim?eid="+empID,true);
    xhr.send();
}

function loadER(er){
    var col = [];
    for (var c = 0; c < er.length; c++) {
        for (var key in er[c]) {
            if (col.indexOf(key) === -1) {
                col.push(key);
            }
        }
    }
    console.log(col);
    
    var table = document.createElement("table");

        // Create table header row using the extracted headers above.
        var tr = table.insertRow(-1);                   // table row.

        for (var h = 0; h < col.length; h++) {
            var th = document.createElement("th");      // table header.
            th.innerHTML = col[h];
            tr.appendChild(th);
        }

        // add json data to the table as rows.
        for (var i = 0; i < er.length; i++) {

            tr = table.insertRow(-1);

            for (var j = 0; j < col.length; j++) {
                var tabCell = tr.insertCell(-1);
                console.log(er[i][col[j]]);
                if(j==4){
                	var d = er[i][col[j]];
                	var date = new Date(d).toDateString();
                	console.log(date);
                	tabCell.innerHTML = date;
                }
                else {
                tabCell.innerHTML = er[i][col[j]];
                }
            }
            var tabCell = tr.insertCell(-1);
            var button = document.createElement('input');

            // set input attributes.
            button.setAttribute('type', 'button');
            button.setAttribute('value', 'Click to Select');
            button.setAttribute('id',er[i][col[0]]);
            // add button's 'onclick' event.
            button.setAttribute('onclick', 'getRow(this)');

            tabCell.appendChild(button);
        }

        // Now, add the newly created table with json data, to a container.
        var divShowData = document.getElementById('showData');
        divShowData.innerHTML = "";
        divShowData.appendChild(table);
}

function getRow(oButton) {
	var BID = oButton.getAttribute("id")
    console.log(BID)
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange=function(){
        console.log("in ORSC"+xhr.readyState);
        if(xhr.readyState==4 && xhr.status==200){
            console.log(xhr.responseText);
            var vr=JSON.parse(xhr.responseText);
            loadVR(vr);
        }
    }
    xhr.open("GET","http://localhost:8080/TRMS/viewrim?rid="+BID,true);
    xhr.send();
}

function loadVR(vr){
    document.getElementById("rimID").value=vr.rimID;
    document.getElementById("EName").innerHTML=vr.empName;
   // document.getElementById("tFees").innerHTML=vr.rimCost;
    document.getElementById("eType").innerHTML=vr.etName;
//	var date = new Date(vr.etDate).toDateString();
//	console.log(date);
//	document.getElementById("eDates").innerHTML=date;
//    document.getElementById("location").innerHTML=vr.etLocation;
    document.getElementById("eDesc").innerHTML=vr.etDesc;
    document.getElementById("eGrade").value=vr.eGrade;
//    document.getElementById("justifi").innerHTML=vr.rimJustify;
//    document.getElementById("mDays").innerHTML=vr.daysMissed;
//    document.getElementById("rStatus").innerHTML=vr.rimStatus;
//    document.getElementById("rStatusBy").innerHTML=vr.rimStatusBy;
//    document.getElementById("rNodes").innerHTML=vr.rimNotes;
}

