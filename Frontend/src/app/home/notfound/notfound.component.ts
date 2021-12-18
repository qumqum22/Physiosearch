import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-notfound',
  templateUrl: './notfound.component.html',
  styleUrls: ['./notfound.component.scss']
})
export class NotfoundComponent implements OnInit {

  constructor(private activatedRoute: ActivatedRoute) { }
  errorType: ErrorType;
  errorMessage: string;

  ngOnInit(): void {
    this.errorType = +this.activatedRoute.snapshot.params.errorType;
    this.errorMessage = this.getMessage(this.errorType);
  }

  getMessage(errorType: ErrorType)
  {
    switch (this.errorType)
    {
      case ErrorType.WrongProfile:

        return "Invalid profile id";
      case ErrorType.ServerNoResponse:

        return "Server is down";

      case ErrorType.WrongRights:
        return "You have no rights to do it";

      default:
        return "Something went wrong";
    }
  }

}

export enum ErrorType {
  WrongProfile,
  ServerNoResponse,
  WrongRights
}
