const user=new Object();
user.name= "Ashish Kumar Arya";
user.email= "ashish2018ku@gmail.com"
user.age=25;

function changeName(newName) {
    user.name=newName;
}

function updateEmail(newEmail) {
    user.email=newEmail;
}

function birthYear() {
    const currentYear=new Date().getFullYear();
    return currentYear-user.age;
}

changeName("Kalmal Sharma");
updateEmail("kamal123@gmail.com");
const year=birthYear();

document.write("Name: "+user.name+"<br> Email: "+user.email+"<br> Birth year: "+year);