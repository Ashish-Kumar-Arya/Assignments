async function getIp() {
    let resolve= await fetch("https://api.ipify.org?format=json");
    let msg=await response.json();
    document.write(JSON.stringify(msg));
}

getIp();