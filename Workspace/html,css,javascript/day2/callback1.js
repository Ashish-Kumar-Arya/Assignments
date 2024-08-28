function display(msg) {
    document.write(JSON.stringify(msg));
}

function getIp(callback) {
    fetch("https://api.ipify.org?format=json")
    .then((response)=>response.json()).then(msg=>callback(msg));
}

getIp(display);