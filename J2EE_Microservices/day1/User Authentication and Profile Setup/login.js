import { myData } from "./sharedData.js";
document.getElementById('loginContainer').addEventListener('submit', function(event) {
  event.preventDefault();
  const inputEmail=document.getElementById('login-email').value;
  const inputPassword=document.getElementById('login-password').value;
  const messageElement=document.getElementById('message');
  if(myData.has(inputEmail)) {
    if(myData.get(inputEmail)===inputPassword) {
      messageElement.textContent="User is valid"
    }
    else {
      messageElement.textContent='Incorrect password';
    }
  }
  else {
    messageElement.textContent='User does not exist';
  }
});