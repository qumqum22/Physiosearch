import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { RehabilitationService } from 'src/app/services/rehabilitation.service';
import { User } from '../../models/user';
import { Rehabilitation } from 'src/app/models/rehabilitation';
import { Router} from '@angular/router';
import { FormControl} from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})


export class SearchComponent implements OnInit {
  
  users: User[] = [];
  rehabilitations: Rehabilitation[] = [];

  titleField: string = "";
  nameField:string = "";
  surnameField:string = "";

  physioType = new FormControl();
  townType = new FormControl();
  titleType = new FormControl();
  miasta: string[] = ["Kraków", "Warszawa", "Katowice", "Gdańsk", "Kielce"];
  tytuly: string[] = ["mgr inż.", "mgr", "dr", "inż."];

  
  constructor(private userService: UserService, 
    private rehabilitationService: RehabilitationService,
     private router: Router) { }

  getUsers():void {
    this.userService.getUsers().subscribe(
      (data => this.users = data)
    )
  }
  
  ngOnInit(): void {
    this.rehabilitationService.getRehabilitations().subscribe(
      (data => {
        this.rehabilitations = data
        this.userService.getUsers().subscribe(
          (data => this.users = data)
        )
      })
    )
  }

  toProfile(user: User):void{
    this.router.navigate(['/profile',user.id]);
  }
}
