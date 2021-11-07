import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-start',
  templateUrl: './start.component.html',
  styleUrls: ['./start.component.scss']
})
export class StartComponent implements OnInit {

  latitude = 52.237049;
  longitude = 21.017532;
  
  constructor() { }

  ngOnInit(): void {
  }

  onChoseLocation(event: any){
    this.latitude = event.coords.lat;
    this.longitude = event.coords.lng;
  }
}
