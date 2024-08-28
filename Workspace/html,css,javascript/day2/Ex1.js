let i=0;
for(i=0; i<5; i++) {
    console.log(i);
    document.write(i+"<br>");
}

const day=prompt("Enter the day");
if(day=="Rainy")
document.write("Use umberlla");
else if(day==="Sunny")
    document.write("use sunscrean");
else {
    document.write("Enjoy the weather");
}