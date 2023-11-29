function add() {
var appForm = document.getElementById('appForm');
    var newField = document.createElement('input');
    newField.setAttribute('name','applicationId');
    newField.setAttribute('class','input');
    appForm.appendChild(newField);
}

function remove(){
    var inputTags = appForm.getElementsByTagName('input');
    if(inputTags.length > 0) {
        appForm.removeChild(inputTags[(inputTags.length) - 1]);
    }
}