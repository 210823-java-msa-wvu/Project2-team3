import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from 'src/app/_models/user';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  currentUser: User = new User;
  loggedInUser: User = new User;

  constructor(private authService: AuthenticationService){
    this.authService.currentUser.subscribe(data => {
      this.currentUser = data;
      this.loggedInUser = this.authService.userLogin;
      if(this.loggedInUser == null){
        this.authService.refresh();
      }
    });

  }



  ngOnInit(): void {
    console.log("from header component");
    console.log(this.loggedInUser);
  }


  logout(){
    this.authService.logout();
  }

}

