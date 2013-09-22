var pucUserDropDown = document.getElementById("pucUserDropDown");
var pucHeader = document.getElementById("pucHeader");

/**
* Inject smartbar into the dom until textbar overlay works
**/
function initSmartbar(){
    var pucHeader = document.getElementById("pucHeader");
    if(pucHeader != null){
        var smartbarInput = document.createElement("input");
        smartbarInput.setAttribute("id", "smartbarInput");
        pucHeader.appendChild(smartbarInput);
    }
    else{
        alert("pucHeader is null");
    }
}

// Find a better way to be notified on load
window.notifyOfLoad2 = function(area){
    var allFramesLoaded = true;
    for(var i=0; i<window.frames.length; i++){
        if(window.frames[i].document.readyState != "complete"){
            allFramesLoaded = false;
            break;
        }
    }

    if(allFramesLoaded){
        initSmartbar();
    } else {
        // check again in a bit
        setTimeout("notifyOfLoad()", 300);
    }
}

// Remove when notifyOfLoad is called from PUC
setTimeout(function(){
    notifyOfLoad2();
}, 4000);
