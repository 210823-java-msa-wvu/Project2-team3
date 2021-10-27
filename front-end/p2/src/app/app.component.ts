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

  constructor(private authService: AuthenticationService, private router: Router){
    this.authService.currentUser.subscribe(data => {
      this.currentUser = data;
    });
  }



  ngOnInit(): void {

  }
}
