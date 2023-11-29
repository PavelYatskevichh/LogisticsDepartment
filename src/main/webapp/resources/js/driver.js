function updateStatus(driverId, routeId, applicationId, tag) {
    let xhr = new XMLHttpRequest();

    xhr.open("GET", "http://localhost:8080/driver/" + driverId +
        "/route/changeStatus?routeId=" + routeId + "&applicationId=" + applicationId, true);
    xhr.responseType = 'text';
    xhr.send();

    xhr.onload = function() {
        if (this.status == 200) {
            let newStatus = xhr.response;
            if (newStatus == "DELIVERED") {
                location.reload();
            } else {
                tag.innerHTML = newStatus;
            }
        }
    }
}