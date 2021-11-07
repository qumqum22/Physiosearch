import {HttpErrorResponse, HttpEvent, HttpHandler, HttpInterceptor, HttpRequest} from '@angular/common/http';
import {Injectable} from '@angular/core';
import {Observable, throwError} from 'rxjs';
import { catchError, retry } from 'rxjs/operators';


@Injectable()
export class CustomHttpInterceptor implements HttpInterceptor {
    intercept(req:HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>>
    {
        return next.handle(req).pipe(
            retry(1),
            catchError((error:HttpErrorResponse) => {
                alert(`HTTP error: ${req.url}`);
                return throwError(error);
            })
        );
    }
}