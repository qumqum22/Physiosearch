import { Component, OnInit } from '@angular/core';
import { TokenStorageService } from 'src/app/services/token-storage.service';

@Component({
  selector: 'app-navigation-bar',
  templateUrl: './navigation-bar.component.html',
  styleUrls: ['./navigation-bar.component.scss']
})
export class NavigationBarComponent implements OnInit {

  private roles: string[] = [];
  isLoggedIn = false;
  showUserBoard = false;
  showPhysioBoard = false;
  showModeratorBoard = false;
  showAdminBoard = false;
  username?: string;
  userId : number;
  constructor(private tokenStorageService: TokenStorageService) { }

  ngOnInit(): void {
    this.isLoggedIn = !!this.tokenStorageService.getToken();
    if (this.isLoggedIn) {
      const user = this.tokenStorageService.getUser();
      this.roles = user.roles;
      this.userId = user.userdataId;
      this.showUserBoard = this.roles.includes('USER');
      this.showPhysioBoard = this.roles.includes('PHYSIO');
      this.showModeratorBoard = this.roles.includes('MODERATOR');
      this.showAdminBoard = this.roles.includes('ADMIN');

      this.username = user.username;
    }
  }  

  logout(): void {
    this.tokenStorageService.signOut();
    window.location.reload();
  }
}
