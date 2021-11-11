import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/models/loginRequest';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  emailField ="";
  passwordField = "";

  loginRequest: LoginRequest = {
    email : "",
    password : "",
  }


registerForm = new FormGroup({
  email: new FormControl('',[Validators.required,Validators.email]),
  password: new FormControl('',[Validators.required,Validators.minLength(6)]),
})

get email(){return this.registerForm.get('email')}
get password(){return this.registerForm.get('password')}

constructor(private userService: UserService, private router:Router) { }

  ngOnInit(): void {
  }

  signIn():void{    
    if(this.emailField.length > 4 
      && this.passwordField.length > 4)
      {
        this.loginRequest.email = this.emailField;
        this.loginRequest.password = this.passwordField;
        console.log(this.loginRequest);
        this.userService.loginUser(this.loginRequest).subscribe(
          (data) => {
            console.log(data);
            this.router.navigateByUrl('/register')})
        }
        else{
          alert("Wrong data");
        }
      }

}
