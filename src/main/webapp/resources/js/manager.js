function add() {
    let appForm = document.getElementById('appForm');
    let newField = document.createElement('input');
    newField.setAttribute('name','applicationId');
    newField.setAttribute('class','input');
    appForm.appendChild(newField);
}

function remove(){
    let inputTags = appForm.getElementsByTagName('input');
    if(inputTags.length > 1) {
        appForm.removeChild(inputTags[(inputTags.length) - 1]);
    }
}