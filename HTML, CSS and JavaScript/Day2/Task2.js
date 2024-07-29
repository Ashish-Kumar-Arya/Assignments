document.getElementById('emailForm').addEventListener('submit',function(event) {
event.preventDefault();
const emailInput=document.getElementById('email').value;
const emailPattern=/^[a-zA-Z0-9]+@gmail\.com$/;
const messageElement=document.getElementById('message');
if(emailPattern.test(emailInput)) {
    messageElement.textContent='Email is valid';
    messageElement.style.color='green';
}
else {
    messageElement.textContent='Email is invalid';
    messageElement.style.color='red';
}
});