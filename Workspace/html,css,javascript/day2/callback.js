function callbackfunction() {
    document.write("call function called");
}

function callbackfunction1() {
    setTimeout(()=> {
        callbackfunction();
    }, 3000);
}

callbackfunction1();