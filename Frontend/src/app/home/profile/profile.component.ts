import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { PhoneService } from 'src/app/services/phone.service';
import { ClinicService } from 'src/app/services/clinic.service';
import { User } from '../../models/user';
import { Phone } from '../../models/phone';
import { AddPhoneRequest } from '../../models/addPhoneRequest'
import { NgForm } from '@angular/forms';
import { Clinic } from 'src/app/models/clinic';
import { UpdateUserRequest } from 'src/app/models/updateUserRequest';
import { ActivatedRoute } from '@angular/router';
import { TokenStorageService } from 'src/app/services/token-storage.service';
import { forkJoin } from 'rxjs';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {


  currentUser: any;
  profileUser: User;
  isSelfProfile = false;

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

  phones: Phone[];
  clinics: Clinic[];
  titleField: string = "";
  nameField: string = "";
  surnameField: string = "";
  descriptionField: string = "";

  constructor(private userService: UserService,
    private phoneService: PhoneService,
    private clinicService: ClinicService,
    private token: TokenStorageService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.currentUser = this.token.getUser();
    this.userService.getUser(this.route.snapshot.params.id).subscribe(
      (response) => {
        this.profileUser = response;
        this.isSelfProfile = true; // (this.profileUser?.id == this.currentUser.userdataId) ? true : false;
        forkJoin([this.phoneService.getPhones(this.profileUser?.id), this.clinicService.getClinics(this.profileUser?.id)]).subscribe(results => {
          this.phones = results[0];
          this.clinics = results[1];
        });
        this.getSignature();
      })
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

  updateUser(): void {
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


  deletePhone(phoneId: number): void {
    this.phoneService.deletePhone(phoneId).subscribe(
      (response) => this.getPhones(this.profileUser.id))
  }

  getPhones(userId: number): void {
    this.phoneService.getPhones(userId).subscribe(
      (response) => this.phones = response)
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


}
