import { Injectable } from '@angular/core';
import {HttpClient } from '@angular/common/http';
import {environment} from '../../environments/environment'

interface SignupCredentials{
  username: string;
  password: string;
  confirmPassword: string;
}

interface User{
   username: string;
   password: string;
   confirmPassword: string;
   id: number;
}

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }


  signup(credentials: SignupCredentials){
    return this.http.post<User>(`${environment.apiUrl}/api/register`, credentials);
  }
}
