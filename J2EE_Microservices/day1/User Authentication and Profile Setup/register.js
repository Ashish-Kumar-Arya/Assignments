import { myData } from "./sharedData.js";
document.getElementById('registerContainer').addEventListener('submit', function(event) {
  event.preventDefault()
  const inputEmail=document.getElementById('register-email').value;
  const inputPassword=document.getElementById('register-password').value;
  const confirmPassword=document.getElementById('confirm-password').value;
  const emailPattern=/^[a-zA-Z0-9]+@gmail\.com$/;
  const message=document.getElementById('register-message');
  if(emailPattern.test(inputEmail)) {
    if(myData.has(inputEmail)) {
      message.textContent='User already exists';
    }
    else if(inputPassword===''){
      message.textContent='Enter password';
    }
    else {
      if(inputPassword===confirmPassword) {
        myData.set(inputEmail, inputPassword);
        message.textContent="User added"
      }
      else {
        message.textContent='Password does not matched';
      }
    }
  }
  else {
    message.textContent='Invaild email';
  }
});