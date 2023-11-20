function req(driverId, routeId, applicationId, tag) {

    let xhr = new XMLHttpRequest();

    xhr.open("GET", "http://localhost:8080/driver/" + driverId +
        "/route/changeStatus?routeId=" + routeId + "&applicationId=" + applicationId, true);
    xhr.responseType = 'json';
    xhr.send();

    xhr.onreadystatechange = function() {
        if (this.readeState == 4 && this.status == 200) {

            let data = JSON.parse(xhr.response);

            tag.innerHTML = data;

        }
    }

}