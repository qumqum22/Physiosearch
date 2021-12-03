import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Clinic } from 'src/app/models/clinic';
import { User } from 'src/app/models/user';
import { ClinicService } from 'src/app/services/clinic.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-clinic',
  templateUrl: './clinic.component.html',
  styleUrls: ['./clinic.component.scss']
})
export class ClinicComponent implements OnInit {

  constructor(private userService: UserService, 
    private clinicService: ClinicService,
    private route: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.currentClinic = +this.route.snapshot.paramMap.get('id')!;
    this.getClinic();
    this.getUsersByClinic();
  }

  currentClinic : number;
  clinic: Clinic;
  users: User[] =[];

  getClinic():void {
    this.clinicService.getClinic(this.currentClinic).subscribe(
      (data) => {
        this.clinic = data;
      })}

  public getUsersByClinic():void {
    this.userService.getUsersByClinic(this.currentClinic).subscribe(
      (data => this.users = data)
    )
  }

  toProfile(user: User):void{
    this.router.navigate(['/profile',user.id]);
  }

}
