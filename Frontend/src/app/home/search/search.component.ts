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
