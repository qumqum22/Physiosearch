import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { PhoneService } from 'src/app/services/phone.service';
import { AddressService } from 'src/app/services/address.service';
import { User} from '../../models/user';
import { Phone} from '../../models/phone';
import { AddPhoneRequest} from '../../models/addPhoneRequest'
import { NgForm } from '@angular/forms';
import { Address } from 'src/app/models/address';
import { UpdateUserRequest } from 'src/app/models/updateUserRequest';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {

  currentUser = 6;
  user: User;

  phoneRequest: AddPhoneRequest = {
    id : 1,
    phoneNumber:""
  };

  updateUserRequest: UpdateUserRequest = {
    name: "",
    surname: "",
    title: "",
    description:""
  }

  phones: Phone[];
  addresses: Address[];
  titleField: string ="";
  nameField:string = "";
  surnameField: string = "";
  descriptionField: string = "";

    constructor(private userService: UserService, 
                private phoneService: PhoneService,
                private addressService: AddressService,
                private route: ActivatedRoute) { }

    ngOnInit(): void {
      this.currentUser = this.route.snapshot.params.id;
      this.getUser();
      this.getPhones();
      this.getAddresses();
    }


    getUser():void {
      this.userService.getUser(this.currentUser).subscribe(
        (response) => {
          this.user = response;
          this.getSignature();
        })}

    getSignature(){
    this.titleField = this.user.title;
    this.nameField = this.user.name;
    this.surnameField = this.user.surname;
    this.descriptionField = this.user.description;
  }

    toTitleCase(name: string): string{
      return `${name[0].toUpperCase()}${name.substr(1).toLowerCase()}`;
    }

    updateUser():void{
      this.updateUserRequest.title = this.titleField;
      if(this.nameField != "")
        this.updateUserRequest.name = this.toTitleCase(this.nameField);
      if(this.surnameField != "")
        this.updateUserRequest.surname = this.toTitleCase(this.surnameField);
      if(this.descriptionField != "")
        this.updateUserRequest.description = this.descriptionField;

      this.userService.updateUser(this.user.id, this.updateUserRequest).subscribe(
        (response) => {
        this.getPhones();
        alert("Profile updated.")})
      }


    deletePhone(phoneId: number):void {
      this.phoneService.deletePhone(phoneId).subscribe(
        (response) => this.getPhones())
      }

    getPhones():void {
    this.phoneService.getPhones(this.currentUser).subscribe(
      (response) => this.phones = response)
    }

    addPhone(addPhoneForm: NgForm):void {  
      this.phoneRequest.id = this.user.id;
      this.phoneRequest.phoneNumber = addPhoneForm.value.phoneNumber;
      this.phoneService.addPhone(this.phoneRequest).subscribe(
        (response) => this.getPhones())
      }

    getAddresses(): void {
      this.addressService.getAddresses(this.currentUser).subscribe(
        (response) => this.addresses = response)
      }

    deleteAddress(addressId: number, userId:number):void {
      this.addressService.deleteAddress(addressId, userId).subscribe(
        (response) => this.getAddresses())
      }


}
