// sync example
function sync() {
    document.write("One "+"<br>");
    document.write("Two "+"<br>");
    document.write("Three "+"<br>");
}

sync();
// async example
function async() {
    setTimeout(()=>{
        document.write("One "+"<br>");
    }, 3000);
    document.write("Two "+"<br>");
    document.write("Three "+"<br>");
}

async();