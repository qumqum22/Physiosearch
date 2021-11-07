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
  
  from6to14: OfficeHoursDay = new OfficeHoursDay("6:00", "14:00");
  from7to15: OfficeHoursDay = new OfficeHoursDay("7:00", "15:00");
  from8to16: OfficeHoursDay = new OfficeHoursDay("8:00", "16:00");
  from9to17: OfficeHoursDay = new OfficeHoursDay("9:00", "17:00");
  from10to18: OfficeHoursDay = new OfficeHoursDay("10:00", "18:00");
  noWorkDay: OfficeHoursDay = new OfficeHoursDay("---", "---");

  allDaysFrom8: OfficeHours = new OfficeHours(this.from8to16, this.from8to16,this.from8to16,this.from8to16,this.from8to16,this.noWorkDay,this.noWorkDay)
  allDaysFrom9: OfficeHours = new OfficeHours(this.from9to17, this.from9to17,this.from9to17,this.from9to17,this.from9to17,this.noWorkDay,this.noWorkDay)

  user1: UserForArray = new UserForArray(1, "kamil","Ivon","assets/images/default-profile.jpg","inz","Hello",31,"Male","sss","xxxxx","mamja@mail.com", this.allDaysFrom8);
  user2: UserForArray = new UserForArray(2, "michal","bat","assets/images/default-profile.jpg","dr","Hello",42,"Male","sss","xxxxx","mamja@mail.com", this.allDaysFrom9);
  user3: UserForArray = new UserForArray(3, "kamil","cccc","assets/images/default-profile.jpg","mgr inż.","Hello",22,"Male","sss","xxxxx","mamja@mail.com", this.allDaysFrom9);
  usersForArray: UserForArray[] = [this.user1, this.user2, this.user3];
  users: User[] = [];

  titleField: string = "";
  nameField:string = "";
  surnameField:string = "";

  toppings = new FormControl();
  toppingList: string[] = ['Extra cheese', 'Mushroom', 'Onion', 'Pepperoni', 'Sausage', 'Tomato'];

  rodzajeRehabilitacji: string[] = ["Terapia pocovidowa", "Kontuzje kończyn górnych","Kontuzje kończyn dolnych", "Schorzenia kręgosłupa", "Stawy"];
  miasta: string[] = ["Kraków", "Warszawa", "Katowice", "Gdańsk", "Kielce"];
  constructor(private userService: UserService, private router: Router) { }

  getUsers():void {
    this.userService.getUsers().subscribe(
      (data => this.users = data)
    )
  }
  
  ngOnInit(): void {
    this.getUsers();
  }

  onSelect(user: User):void{
    this.router.navigate(['/profile',user.id]);
  }
}


class UserForArray {
  constructor(
    public id: number, 
    public name: string, 
    public surname: string, 
    public profileImage: string, 
    public title: string, 
    public description: string,
    public age: number, 
    public gender: string, 
    public login: string, 
    public password: string, 
    public email: string,
    public officeHours: OfficeHours) {}

    public getOfficeHours(){
      return this.officeHours;
    }
}

class OfficeHours {
  constructor(
    public monday: OfficeHoursDay,
    public tuesday: OfficeHoursDay,
    public wednesday: OfficeHoursDay,
    public thursday: OfficeHoursDay,
    public friday: OfficeHoursDay,
    public saturday: OfficeHoursDay,
    public sunday: OfficeHoursDay
  ) {}

  public getMonday(){
    return this.monday;
  }
  public getTuesday(){
    return this.tuesday;
  }
  public getWednesday(){
    return this.wednesday;
  }
  public getThursday(){
    return this.thursday;
  }
  public getFriday(){
    return this.friday;
  }
  public getSaturday(){
    return this.saturday;
  }
  public getSunday(){
    return this.sunday;
  }
}

class OfficeHoursDay {
  constructor(
    public start: string,
    public end: string
  ) {}

  public getStart(){
    return this.start;
  }
  
  public getEnd(){
    return this.end;
  }
}