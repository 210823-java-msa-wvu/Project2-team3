import { Component, OnInit } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  // loggedIn$ : BehaviorSubject<boolean>;

  constructor(private authService: AuthenticationService){
    // this.loggedIn$ = this.authService.loggedIn$;
  }

  ngOnInit(): void {

  }

}
