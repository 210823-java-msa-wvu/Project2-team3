import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { first } from 'rxjs/operators';
import { AlertService } from 'src/app/services/alert.service';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  loading = false;
  submitted = false;

  registerForm = new FormGroup(
    {
      firstName: new FormControl('',
        [Validators.required]
      ),
      lastName: new FormControl('',
        [Validators.required]
      ),
      username: new FormControl( '',
        [Validators.required , Validators.email]
      ),
      password: new FormControl('',
        [Validators.required, Validators.minLength(5)]
      ),
      confirmPassword: new FormControl('',
        [Validators.required, Validators.minLength(5)]
      )
    }
  )

  constructor(
    private authService: AuthenticationService,
    private alertService: AlertService,
    private userService: UserService,
    private router: Router
    ) { }

  ngOnInit(): void {}

  // convenience getter for easy access to form fields
  get f() { return this.registerForm.controls; }

  onSubmit(){
    this.submitted = true;
    //reset alerts on submit
    this.alertService.clear();
    //stop here if form is invalid
    if(this.registerForm.invalid){
      return;
    }

    this.loading = true;
    // console.log(this.registerForm.value);

    this.userService.register(this.registerForm.value)
    .pipe(first())
    .subscribe(
     {
       next: response => {
         this.alertService.success('Registration successful', true);
          console.log(this);
          //navigate to some other route
          this.router.navigate(['/login'])
          this.loading = false;
       },

       error: (error) =>{


         console.log(error.error);

         this.alertService.error("Username already taken or password not Matched", true);
          this.loading = false;
       }

     }
    );
  }

}

