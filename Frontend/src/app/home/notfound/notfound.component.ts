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

        return "Taka strona nie istnieje. Sprawdź poprawność wpisanego linku.";
      case ErrorType.ServerNoResponse:

        return "Serwer nie odpowiada. Odczekaj kilka chwil i spróbuj ponownie.";

      case ErrorType.WrongRights:
        return "Nie masz odpowiednich uprawnień. Jeżeli uważasz, że jest to pomyłka, skontaktuj się z administracją.";

      default:
        return "Wystąpił błąd.";
    }
  }

}

export enum ErrorType {
  WrongProfile,
  ServerNoResponse,
  WrongRights
}
