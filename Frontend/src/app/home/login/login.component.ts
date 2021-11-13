import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginRequest } from 'src/app/models/loginRequest';
import { UserService } from 'src/app/services/user.service';
import { AuthService } from 'src/app/services/auth.service';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  form: any = {
    formEmail: null,
    formPassword: null
  };
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  loginRequest: LoginRequest = {
    email : "",
    password : "",
  }

constructor(private userService: UserService, 
  private router:Router, 
  private authService: AuthService,
  private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  // signIn():void{    
  //   if(this.emailField.length > 4 
  //     && this.passwordField.length > 4)
  //     {
  //       this.loginRequest.email = this.emailField;
  //       this.loginRequest.password = this.passwordField;
  //       console.log(this.loginRequest);
  //       this.userService.loginUser(this.loginRequest).subscribe(
  //         (data) => {
  //           console.log(data);
  //           this.router.navigateByUrl('/register')})
  //       }
  //       else{
  //         alert("Wrong data");
  //       }
  //     }

  onSubmit(): void {
    const { formEmail, formPassword } = this.form;
    this.loginRequest.email = formEmail;
    this.loginRequest.password = formPassword;
    console.log(this.loginRequest);

    this.authService.login(this.loginRequest).subscribe(
      data => {
        this.tokenStorage.saveToken(data.accessToken);
        this.tokenStorage.saveUser(data);

        this.isLoginFailed = false;
        this.isLoggedIn = true;
        this.roles = this.tokenStorage.getUser().roles;
        //console.log(data);
        //console.log(this.roles);
        this.reloadPage();
      },
      err => {
        this.errorMessage = err.error.message;
        this.isLoginFailed = true;
      }
    );
  }

  reloadPage(): void {
    window.location.reload();
  }

}
