import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { RegisterRequest } from 'src/app/models/registerRequest';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/user.service';
import { User } from '../../models/user';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  isLoggedIn = false;
  isLoginFailed = false;
  errorMessage = '';
  roles: string[] = [];

  userForm: any = {
    Email: null,
    Password: null,
    ConfirmPassword: null,
    Name: null,
    Surname: null
  };

  physioForm: any = {
    physioID: null,
    Email: null,
    Password: null,
    ConfirmPassword: null,
    Name: null,
    Surname: null
  };

  registerRequest: RegisterRequest = {
    physioId : "0",
    email : "",
    password : "",
    name : "",
    surname : ""
  }

  public users: User[];

  ngOnInit(): void {
    if (this.tokenStorage.getToken()) {
      this.isLoggedIn = true;
      this.roles = this.tokenStorage.getUser().roles;
    }
  }

  constructor(private userService: UserService, 
    private router:Router, 
    private tokenStorage: TokenStorageService) { }

  toTitleCase(name: string): string{
    return `${name[0].toUpperCase()}${name.substr(1).toLowerCase()}`;
  }

  registerUser():void{    
    const {Email, Password, Name, Surname } = this.userForm;

    this.registerRequest.physioId = "0";
    this.registerRequest.email = Email;
    this.registerRequest.password = Password;
    this.registerRequest.name = this.toTitleCase(Name);
    this.registerRequest.surname = this.toTitleCase(Surname);
    this.userService.registerUser(this.registerRequest).subscribe(
      (data) => {
        console.log(data);
        this.router.navigateByUrl('/login')})
      

  }
      
  registerPhysio():void{    
    const {PhysioID, Email, Password, Name, Surname } = this.physioForm;
    this.registerRequest.physioId = PhysioID;
    this.registerRequest.email = Email;
    this.registerRequest.password = Password;
    this.registerRequest.name = this.toTitleCase(Name);
    this.registerRequest.surname = this.toTitleCase(Surname);
    console.log(this.registerRequest);
    this.userService.registerPhysio(this.registerRequest).subscribe(
      (data) => {
        console.log(data);
        this.router.navigateByUrl('/login')})
  }

}
