import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { UserService } from 'src/app/services/user.service';
import { User } from '../../models/user';
@Component({
  selector: 'app-settings',
  templateUrl: './settings.component.html',
  styleUrls: ['./settings.component.scss']
})
export class SettingsComponent implements OnInit {
  isLoggedIn = false;
  isLoginFailed = false;
  roles: string[] = [];
  genders: string[] = ["Male", "Female"];
  selectedGender: string = "";
  currentUser: any;
  userData: User;
  
  userForm: any = {
    Title: null,
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


  public users: User[];

  constructor(private userService: UserService, 
    private router:Router, 
    private tokenStorage: TokenStorageService) { }

  ngOnInit(): void {
    this.currentUser = this.tokenStorage.getUser();
    console.log(this.currentUser);
    this.userService.getUser(this.currentUser.userdataId).subscribe(
      (response) => {
        this.userData = response;
        this.selectedGender = this.userData.gender;
      })
  }


  toTitleCase(name: string): string{
    return `${name[0].toUpperCase()}${name.substr(1).toLowerCase()}`;
  }

  updateProfile():void{    
    // this.updateUserRequest.title = this.titleField;
    // if (this.nameField != "")
    //   this.updateUserRequest.name = this.toTitleCase(this.nameField);
    // if (this.surnameField != "")
    //   this.updateUserRequest.surname = this.toTitleCase(this.surnameField);
    // if (this.descriptionField != "")
    //   this.updateUserRequest.description = this.descriptionField;

    // this.userService.updateUser(this.profileUser.id, this.updateUserRequest).subscribe(
    //   (response) => {
    //     this.getPhones(this.profileUser.id);
    //     alert("Profile updated.")
    //   })
  }
}
