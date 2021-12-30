import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import { RehabilitationService } from 'src/app/services/rehabilitation.service';
import { User } from '../../models/user';
import { Rehabilitation } from 'src/app/models/rehabilitation';
import { ActivatedRoute, Router} from '@angular/router';
import { FormControl} from '@angular/forms';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.scss']
})


export class SearchComponent implements OnInit {
  
  private readonly pageSize = 5;
  private users: User[] = [];
  private tempUsers: User[] = [];

  searchingTerm: String = "";

  usersPage: User[] = [];
  page = 1;
  maxPage: number;
  isPreviousDisabled: boolean;
  isNextDisabled: boolean;

  rehabilitations: Rehabilitation[] = [];

  titleField: string = "";
  nameField:string = "";
  surnameField:string = "";

  physioType = new FormControl();
  townType = new FormControl();
  titleType = new FormControl();

  miasta: string[] = ["Kraków", "Warszawa", "Katowice", "Gdańsk", "Kielce"];
  titles: string[] = ["mgr inż.", "mgr", "dr", "inż."];
  
  constructor(private userService: UserService, 
    private rehabilitationService: RehabilitationService,
     private router: Router,
     private route: ActivatedRoute) { }

  getUsers():void {
    this.userService.getUsers().subscribe(
      (data => this.users = data)
    )
  }
  
  ngOnInit(): void {
    this.rehabilitationService.getRehabilitations().subscribe(
      data => {
        this.rehabilitations = data;
        this.route.params.subscribe(params => 
          {
            this.userService.getUsers().subscribe(
              data => 
              {
                if(params.searchTerm)
                { 
                  data.forEach(element => {
                    element.person = element.name + " " + element.surname;
                  });
                  console.log(params.searchTerm);
                  this.users = data.filter(user => {
                    return user.person.toLowerCase().includes(params.searchTerm.toLowerCase());
                  })
                  this.maxPage = Math.floor(this.users.length / 5 + 1);
                  this.onPageChange();
                }
                else
                {
                  this.userService.getUsers().subscribe(
                    data => {
                      this.users = data;
                      this.maxPage = Math.floor(this.users.length / 5 + 1);
                      this.onPageChange();
                  })
                }
              })
          })
      }
    )
  }

  search():void{
    if(this.searchingTerm)
    this.router.navigateByUrl('/search/' + this.searchingTerm);
  }

  toProfile(user: User):void{
    this.router.navigate(['/profile',user.id]);
  }

  onPageChange(): void{
    const startIndex = (this.page - 1) * this.pageSize;
    const endIndex = startIndex + this.pageSize;
    this.usersPage = this.users.slice(startIndex, endIndex);
    this.isPreviousDisabled = this.page === 1;
    this.isNextDisabled = this.page === this.maxPage;
  }

  onPrevious(): void{
    this.page -= 1;
    this.onPageChange();
  }

  onNext(): void{
    this.page += 1;
    this.onPageChange();
  }
}
