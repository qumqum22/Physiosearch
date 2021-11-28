import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { User } from '../../models/user';
import { Router} from '@angular/router';
import { FormControl} from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})


export class SearchComponent implements OnInit {
  
  users: User[] = [];

  titleField: string = "";
  nameField:string = "";
  surnameField:string = "";

  physioType = new FormControl();
  townType = new FormControl();
  titleType = new FormControl();
  
  rodzajeRehabilitacji: string[] = ["Terapia pocovidowa", "Kontuzje kończyn górnych","Kontuzje kończyn dolnych", "Schorzenia kręgosłupa", "Stawy"];
  miasta: string[] = ["Kraków", "Warszawa", "Katowice", "Gdańsk", "Kielce"];
  tytuly: string[] = ["mgr inż.", "mgr", "dr", "inż."];
  constructor(private userService: UserService, private router: Router) { }

  getUsers():void {
    this.userService.getUsers().subscribe(
      (data => this.users = data)
    )
  }
  
  ngOnInit(): void {
    this.getUsers();
  }

  toProfile(user: User):void{
    this.router.navigate(['/profile',user.id]);
  }
}
