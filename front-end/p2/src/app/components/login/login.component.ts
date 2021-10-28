import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AlertService } from 'src/app/services/alert.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from 'src/app/_models/user';
import { AlertComponent } from '../alert/alert.component';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  username: string = '';


  user: User = new User();
  isloggedin: boolean | undefined;
  loading = false;
  submitted = false;

  loginForm = new FormGroup({
      username: new FormControl( '',
        [Validators.required , Validators.email]
      ),
      password: new FormControl('',
        [Validators.required, Validators.minLength(5)]
      )
  });

  loggedIn:any | undefined;

  constructor(
    private authService: AuthenticationService,
    private alertService: AlertService,
    private router: Router
    ) {
       // redirect to home if already logged in

    }

  // convenience getter for easy access to form fields
  get f() { return this.loginForm.controls; }

  ngOnInit(): void {
    console.log(this.username);
    if(this.authService.currentUserValue?.id){
      this.router.navigate(['/home']);
    }
  }

  onSubmit(){

    this.submitted = true;
    //reset alerts on submit
    this.alertService.clear();
    //stop here if form is invalid
    if(this.loginForm.invalid){
      return;
    }

    this.authService.login(this.loginForm.value)
    .subscribe(
     {
       next: response => {
         this.alertService.success('Login successful', true);
          console.log(this);
          //navigate to some other route
          console.log(response);
          // this.loggedIn = JSON.parse(response);
          // console.log(this.loggedIn);
          this.isloggedin = response.success;
          // this.authService.currentUser = response.token;
          console.log(response.token);
          this.router.navigate(['/home'])
          this.loading = false;
       },

       error: (error) =>{


         console.log(error.error);

         this.alertService.error("InValid Credentials", true);
          this.loading = false;
       }

     }
    );
  }

}
