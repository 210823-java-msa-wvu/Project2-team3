// import { HttpErrorResponse } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import Pusher from 'pusher-js/types/src/core/pusher';
import { DiceService } from './dice.service';
// import { User } from './user';
// import { UserService } from './user.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{
  
  // public users: User[] = []; 

  username = 'username';
  message  = ' ';
  messages = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void{
    Pusher.logToConsole = true;

    const pusher = new Pusher('118154b065358d96fe54', {
      cluster: 'us2'
    });

    const channel = pusher.subscribe('chat');
    channel.bind('message', data => {
      this.messages.push(data)
    });
  }

  submit(): void{
    this.http.post('http://localhost:8080/api/messages', {
      username: this.username,
      message: this.message
    }).subscribe(() => this.message = '');
  }

}
