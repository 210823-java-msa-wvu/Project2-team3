// import { HttpErrorResponse } from '@angular/common/http';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import  Pusher from 'pusher-js';
// import { FormsModule } from '@angular/forms';
// import { User } from './user';
// import { UserService } from './user.service';

type Messages  = {
  username: string;
  message: string;
};

@Component({
  selector: 'app-chat',
  templateUrl: './chat.component.html',
  styleUrls: ['./chat.component.css']
})

export class ChatComponent implements OnInit{

  // public users: User[] = [];

  username = 'username';
  message  = '';
  messages: Messages[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit(): void{
    Pusher.logToConsole = true;

    const pusher = new Pusher('8b393a4526b0c1792e2b', {
      cluster: 'us2'
    });


  const channel = pusher.subscribe('chat');
    channel.bind('message', (data: Messages) => {
      this.messages.push(data)
      console.log("data: " + data);
    });
  }

  submit(): void{
    this.http.post('http://localhost:8080/chatapi/messages', {
      username: this.username,
      message: this.message
      //this.messages.push({username: this.username, message: this.message})
    }).subscribe(() => this.message = '');
  }

}
