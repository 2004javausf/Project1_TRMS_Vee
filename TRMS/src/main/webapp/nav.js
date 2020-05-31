var empTitle;
window.onload=function(){
    console.log("in load navigation");
    
    empTitle=localStorage.getItem("title");
    console.log(empTitle);
    
    if(empTitle=="Associate") {
    	document.getElementById("allRims").style.cssText="display:none";
    }
    else {
    	document.getElementById("allRims").style.cssText="display:block";
    }

}