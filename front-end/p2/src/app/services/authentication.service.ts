import { Injectable } from '@angular/core';
import {HttpClient, HttpHandler, HttpHeaders } from '@angular/common/http';
import {environment} from '../../environments/environment'
import { map, tap } from 'rxjs/operators';
import { BehaviorSubject, Observable } from 'rxjs';
import { User } from '../_models/user';
import { JwtHelperService } from '@auth0/angular-jwt';

// interface SignupCredentials{
//   firstName: string;
//   lastName: string;
//   username: string;
//   password: string;
//   confirmPassword: string;
// }

interface loginCredentials{
    username: string;
    password: string;
}

interface loggedInResponse{
  authenticated: boolean;
  username: string;
  firstName: string;
  lastName: string;
  cookie: string;
}



@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  userLogin: User = new User();

  loggedInUser: any | undefined;

  expToken: any;
  tokenPayload: any;
  expirationDate: any;

  private currentUserSubject: BehaviorSubject<User>
  public currentUser: Observable<User>;

  headers = new HttpHeaders().set('content-type', 'application/json')
  .set('Access-Control-Allow-Origin', '*')

  constructor(private http: HttpClient, private jwtHelper: JwtHelperService) {
    let storageUser;
    const storageUserAsStr = localStorage.getItem('currentUser');
    if(storageUserAsStr){
      storageUser = JSON.parse(storageUserAsStr);
    }
    this.currentUserSubject = new BehaviorSubject<User>(storageUser);
    this.currentUser = this.currentUserSubject.asObservable();

    this.expToken = storageUserAsStr;
    // localStorage.setItem('user', )
    this.GetTokenDecoded();
    this.getTokenExpirationDate();

   }

   public get currentUserValue(): User{
     return this.currentUserSubject.value;
   }

  register(user: User) {
    return this.http.post(`${environment.apiUrl}/api/register`, user);
  }

  login(user: User){
    return this.http.post<any>(`${environment.apiUrl}/api/login`, user).pipe(
      map(response => {
        if(response){
        // this.GetTokenDecoded(response.token)
        localStorage.setItem('currentUser', JSON.stringify(response));
          // localStorage.setItem('currentUser', JSON.parse(response));
          this.currentUserSubject.next(response);
        }
        return response;

      })
    );

  }

  checkAuth(){
    return this.isAuthenticated();
  }

  GetTokenDecoded() {
    console.log(this.jwtHelper.decodeToken(this.expToken))
    this.tokenPayload = JSON.stringify(this.jwtHelper.decodeToken(this.expToken));
    this.loggedInUser = localStorage.setItem('user', this.tokenPayload);
    this.userLogin =  JSON.parse(this.tokenPayload);
    console.log(this.tokenPayload);
    console.log(this.userLogin.firstName);
  }

  getTokenExpirationDate() {
    this.expirationDate = this.jwtHelper.getTokenExpirationDate(this.expToken);
    console.log(this.expirationDate)
  }
  isAuthenticated(): boolean {
    return !this.jwtHelper.isTokenExpired(this.expToken);
  }

  logout(){
    localStorage.removeItem('currentUser');
    localStorage.removeItem('user');
    this.currentUserSubject.next(new User);
  }

}
