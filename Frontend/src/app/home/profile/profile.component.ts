import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { PhoneService } from 'src/app/services/phone.service';
import { ClinicService } from 'src/app/services/clinic.service';
import { User } from '../../models/user';
import { Phone } from '../../models/phone';
import { Comment } from '../../models/comment';
import { AddPhoneRequest } from '../../models/addPhoneRequest'
import { NgForm } from '@angular/forms';
import { Clinic } from 'src/app/models/clinic';
import { UpdateUserRequest } from 'src/app/models/updateUserRequest';
import { ActivatedRoute, Router } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { forkJoin } from 'rxjs';
import { CommentService } from 'src/app/services/comment.service';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  currentUser: any;
  profileUser: User;
  averageRate = 0;
  
  isSelfProfile = false;
  isUserEdited = false;
  isDescriptionEdited = false;
  isPhoneEdited = false;
  isClinicAdding = false;
  isNormalUser = false;
  isRehabilitant = false;
  isAdmin = false;

  phoneRequest: AddPhoneRequest = {
    id: 1,
    phoneNumber: ""
  };

  updateUserRequest: UpdateUserRequest = {
    name: "",
    surname: "",
    title: "",
    description: ""
  }

  displayedPhoneColumns: string[] = ['number'];
  displayedClinicsColumns: string[] = ['navigation','name','address','postalCode','city'];

  phones: Phone[];
  clinics: Clinic[];
  comments: Comment[];
  external: String[] = ['www', 'facebook', 'youtube'];
  titleField: string = "";
  nameField: string = "";
  surnameField: string = "";
  descriptionField: string = "";

  constructor(private userService: UserService,
    private phoneService: PhoneService,
    private clinicService: ClinicService,
    private commentService: CommentService,
    private token: TokenStorageService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    if(this.currentUser.roles)
    {
      if (this.currentUser.roles.indexOf('PHYSIO') > -1) this.isRehabilitant = true;
      if (this.currentUser.roles.indexOf('USER') > -1) this.isNormalUser = true;
      if (this.currentUser.roles.indexOf('ADMIN') > -1) this.isAdmin = true;
    }
    
    this.userService.getUser(this.route.snapshot.params.id).subscribe(
      (response) => {
        this.profileUser = response;
        this.isSelfProfile = (this.profileUser?.id == this.currentUser.userdataId) ? true : false;
        forkJoin([this.phoneService.getPhones(this.profileUser?.id), 
          this.clinicService.getClinics(this.profileUser?.id),
          this.commentService.getCommentsAboutUser(this.profileUser?.id)
        ]).subscribe(results => {
          this.phones = results[0];
          this.clinics = results[1];
          this.comments = results[2];
          
          this.phones.forEach(phone => {
            phone.isEdited = false;            
          });
          this.comments.forEach(element => {
            element.isEdited = false;            
          });
          this.averageRate = this.calculateRate(this.comments);
        });
        this.getSignature();
      },
      (error) => {
        this.router.navigate(["/error"], {queryParams: { errorType: 0}});
      }
      )
  }

  calculateRate(comments: Comment[])
  {
    var sum = 0;
    comments.forEach(element => {
      sum = sum + element.rate;
    });
    return (Math.round(sum /comments.length * 100) / 100);
  }

  getSignature() {
    this.titleField = this.profileUser.title;
    this.nameField = this.profileUser.name;
    this.surnameField = this.profileUser.surname;
    this.descriptionField = this.profileUser.description;
  }

  toTitleCase(name: string): string {
    return `${name[0].toUpperCase()}${name.substr(1).toLowerCase()}`;
  }

  editPost(post: Comment){
    this.comments.forEach(comment => {
      if(comment.id == post.id)
      comment.isEdited = true;
    });
  }

  updatePost(post: Comment): void{    
    // service and update add
    this.comments.forEach(comment => {
    if(comment.id == post.id)
    comment.isEdited = false;
  });
  }

  declineUpdatePost(post: Comment):void {
    this.comments.forEach(comment => {
      if(comment.id == post.id)
      comment.isEdited = false;
    });
  }

  editUser() :void
  {
    this.isUserEdited = true;
  }

  updateUser(): void {
    this.isUserEdited = false;
    this.updateUserRequest.title = this.titleField;
    if (this.nameField != "")
      this.updateUserRequest.name = this.toTitleCase(this.nameField);
    if (this.surnameField != "")
      this.updateUserRequest.surname = this.toTitleCase(this.surnameField);
    if (this.descriptionField != "")
      this.updateUserRequest.description = this.descriptionField;

    this.userService.updateUser(this.profileUser.id, this.updateUserRequest).subscribe(
      (response) => {
        this.getPhones(this.profileUser.id);
        alert("Profile updated.")
      })
  }

  declineUpdateUser():void {
    this.isUserEdited = false;
  }

  editUserDescription():void{
    this.isDescriptionEdited = true;
  }
  updateUserDescription(): void {
    
  }
  declineUpdateUserDescription(): void {
    this.isDescriptionEdited = false;
  }

  editUserPhone(phoneId: number):void{
    this.phones.forEach(phone => {
    if(phone.id == phoneId)
    phone.isEdited = true;
  });
  }
  updateUserPhone(phoneId: number): void {
    // TODO update phone
    this.phones.forEach(phone => {
      if(phone.id == phoneId)
      phone.isEdited = false;
    });
  }
  declineUpdateUserPhone(phoneId: number): void {
    this.phones.forEach(phone => {
      if(phone.id == phoneId)
      phone.isEdited = false;
    });
  }

  addClinic():void {
    this.isClinicAdding = true;
  }

  saveClinic():void{
    // TODO save clinic
    this.getClinics(this.profileUser.id);
    this.isClinicAdding = false;
  }
  declineAddClinic():void{
    this.isClinicAdding = false;
  }

  deletePhone(phoneId: number): void {
    this.phoneService.deletePhone(phoneId).subscribe(
      (response) => this.getPhones(this.profileUser.id))
      
  }

  getPhones(userId: number): void {
    this.phoneService.getPhones(userId).subscribe(
      (response) => this.phones = response)
    this.phones.forEach(phone => {
      phone.isEdited = false;
    }); 
    }

  addPhone(addPhoneForm: NgForm): void {
    this.phoneRequest.id = this.profileUser.id;
    this.phoneRequest.phoneNumber = addPhoneForm.value.phoneNumber;
    this.phoneService.addPhone(this.phoneRequest).subscribe(
      (response) => this.getPhones(this.profileUser.id))
  }

  getClinics(userId: number): void {
    this.clinicService.getClinics(userId).subscribe(
      (response) => this.clinics = response)
  }

  deleteClinic(clinicId: number, userId: number): void {
    this.clinicService.deleteClinic(clinicId, userId).subscribe(
      (response) => this.getClinics(userId))
  }

  toClinic(clinicId: number): void {
    this.router.navigate(['/clinic',clinicId]);
  }

  checkIfUser(): boolean {
    return this.isNormalUser;
  }
  checkIfPhysio(): boolean {
    return this.isRehabilitant;
  }
  checkIfAdmin(): boolean {
    return this.isAdmin;
  }
}
