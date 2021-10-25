import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthenticationService } from 'src/app/services/authentication.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm = new FormGroup(
    {
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
    private authService: AuthenticationService
    ) { }

  ngOnInit(): void {}

  onSubmit(){
    if(this.registerForm.invalid){
      return;
    }
    console.log(this.registerForm.value);
    this.authService.signup(this.registerForm.value).subscribe(
     {
       next: response => {
          console.log(this);
          //navigate to some other route
       },
       error: (err) =>{
          console.log(err);
       }

     }
    );
  }

}

