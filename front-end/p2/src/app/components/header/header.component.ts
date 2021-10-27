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
    isLoggedIn:boolean = false;


  constructor(private authService: AuthenticationService){
    this.authService.currentUser.subscribe(data => {
      this.currentUser = data;
    });

    // this.authService.logout();
  }



  ngOnInit(): void {
   console.log(this.currentUser);
  }


  logout(){
    this.authService.logout();
  }

}
