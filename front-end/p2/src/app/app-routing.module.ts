import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent} from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { NotFoundComponent } from './components/not-found/not-found.component';
import { ProfileComponent } from './components/profile/profile.component';
import { RegisterComponent } from './components/register/register.component';
import { UnautherizedComponent } from './components/unautherized/unautherized.component';
import { AuthGuard } from './guard/auth.guard';
import { Role } from './_models/role.enum';



const routes: Routes = [
  { path:'home', component: HomeComponent },
  {path: 'profile', component: ProfileComponent, canActivate: [AuthGuard], data:{isLoggedin: true}},
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent},
  {path: '404', component: NotFoundComponent},
  {path: '401', component: UnautherizedComponent},
  { path: '', redirectTo:'home', pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
