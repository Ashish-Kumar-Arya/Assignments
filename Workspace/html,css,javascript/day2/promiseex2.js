function getIp() {
    return fetch("https://api.ipify.org?format=json");
}

let promise=getIp();
promise.then(response=>response.json()).then(msg=>document.write(JSON.stringify(msg))).catch(error=>document.write(error));