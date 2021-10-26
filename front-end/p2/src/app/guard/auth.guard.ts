import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { AuthenticationService } from '../services/authentication.service';
import { UserService } from '../services/user.service';
import { User } from '../_models/user';

@Injectable({
  providedIn: 'root'
})
export class AuthGuard implements CanActivate {
  private currentUser: User = new User;

  constructor(private authService: AuthenticationService, private router: Router){

    this.authService.currentUser.subscribe( data => {
      this.currentUser = data;
    });
  }


  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {

      // if(this.currentUser){
      //   if(route.data?.indexOf(this.currentUser) === -1){
      //     this.router.navigate(['/401']);
      //     return false;
      //   }
      //   return true;
      // }
      if(this.currentUser){
        if(!route.data?.isLoggedin){
          this.router.navigate(['/401']);
          return false;
        }
        return true;
      }

      this.router.navigate(['/login'])
      return true;
  }

}
