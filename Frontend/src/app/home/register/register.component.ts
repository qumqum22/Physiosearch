import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { RegisterUserAccountRequest } from 'src/app/models/registerUserAccountRequest';
import { UserAccountService } from 'src/app/services/user-account.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  rehabilitantIdField=0;
  emailField ="";
  passwordField = "";
  confirmPasswordField = "";
  nameField = "";
  surnameField = "";

  registeredUserRequest: RegisterUserAccountRequest = {
    rehabilitantId : 0,
    email : "",
    password : "",
    name : "",
    surname : ""
  }


registerForm = new FormGroup({
  rehabilitantId: new FormControl('',[Validators.required,Validators.minLength(1)]),
  email: new FormControl('',[Validators.required,Validators.email]),
  password: new FormControl('',[Validators.required,Validators.minLength(6)]),
  confirmPassword: new FormControl('',[Validators.required,Validators.minLength(6)]),
  name: new FormControl('',[Validators.required,Validators.minLength(4)]),
  surname: new FormControl('',[Validators.required,Validators.minLength(4)])
})
public users: User[];

get rehabilitantId(){return this.registerForm.get('rehabilitantId')}
get email(){return this.registerForm.get('email')}
get password(){return this.registerForm.get('password')}
get confirmPassword(){return this.registerForm.get('confirmPassword')}
get name(){return this.registerForm.get('name')}
get surname(){return this.registerForm.get('surname')}

constructor(private userAccountService: UserAccountService, private router:Router) { }

toTitleCase(name: string): string{
  return `${name[0].toUpperCase()}${name.substr(1).toLowerCase()}`;
}

registerUser():void{    
  if(this.emailField.length > 4 
    && this.passwordField.length > 4
    && this.nameField.length > 4
    && this.surnameField.length > 4)
    {
      this.registeredUserRequest.rehabilitantId = this.rehabilitantIdField;
      this.registeredUserRequest.email = this.emailField;
      this.registeredUserRequest.password = this.passwordField;
      this.registeredUserRequest.name = this.toTitleCase(this.nameField);
      this.registeredUserRequest.surname = this.toTitleCase(this.surnameField);
      console.log(this.registeredUserRequest);
      this.userAccountService.registerUser(this.registeredUserRequest).subscribe(
        (data) => {
          console.log(data);
          this.router.navigateByUrl('/login')})
      }
      else{
        alert("Wrong data");
      }
    }
    
    registerRehabilitant():void{    
      if(this.emailField.length > 4 
        && this.passwordField.length > 4
        && this.nameField.length > 4
        && this.surnameField.length > 4)
        {
          this.registeredUserRequest.rehabilitantId = this.rehabilitantIdField;
          this.registeredUserRequest.email = this.emailField;
          this.registeredUserRequest.password = this.passwordField;
          this.registeredUserRequest.name = this.toTitleCase(this.nameField);
          this.registeredUserRequest.surname = this.toTitleCase(this.surnameField);
          console.log(this.registeredUserRequest);
          this.userAccountService.registerUser(this.registeredUserRequest).subscribe(
            (data) => {
              console.log(data);
              this.router.navigateByUrl('/login')})
          }
          else{
            alert("Wrong data");
          }
        }
  

ngOnInit(): void {
}

}
