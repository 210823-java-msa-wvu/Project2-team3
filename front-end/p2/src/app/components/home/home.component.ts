import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/_models/user';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  //loggedInUser: User = new User();
  currentUser: User = new User();

  constructor(private authService: AuthenticationService) {
    
    this.currentUser = this.authService.userLogin;
    this.authService.currentUser.subscribe(data => {
      this.currentUser = data;
      //this.loggedInUser = this.authService.userLogin;
    });
  }
  ngOnInit(): void {
  }

}
