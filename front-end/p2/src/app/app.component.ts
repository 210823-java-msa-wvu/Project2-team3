import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './services/authentication.service';
import { User } from './_models/user';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = " D & D";

  currentUser: User = new User;

  user: User| undefined ;


  constructor(private authService: AuthenticationService, private router: Router){
    this.authService.currentUser.subscribe(data => {
      this.currentUser = data;
    });
  }



  ngOnInit(): void {
    // this.user = JSON.parse(localStorage.getItem('user');
    this.user = this.authService.userLogin;

    console.log("user from local storage")
    console.log(this.user.username);
  }
}
