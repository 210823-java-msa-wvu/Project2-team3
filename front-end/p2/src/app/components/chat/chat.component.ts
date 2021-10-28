import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import Pusher from 'pusher-js';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { User } from 'src/app/_models/user';
import { environment } from 'src/environments/environment';

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

  // username : string | undefined;
  message  = '';
  messages: Messages[] = [];
  loggedInUser: User = new User();


  constructor(private http: HttpClient, private authService: AuthenticationService) {
    this.loggedInUser = this.authService.userLogin;
  }
  ngOnInit(): void{
    Pusher.logToConsole = true;
    // console.log(this.loggedInUser.username);

    const pusher = new Pusher('8b393a4526b0c1792e2b', {
      cluster: 'us2'
    });


  const channel = pusher.subscribe('chat');
    channel.bind('message', (data: Messages) => {
      this.messages.push(data)
      console.log("data: " + data);
    });
  }

  submit(): void{//'http://localhost:8000/chatapi/messages'
    this.http.post(`${environment.apiUrl}/chatapi/messages`, {//
      username: this.loggedInUser.username,
      message: this.message
      //withCredentials: true
    }).subscribe(() => this.message = '');
  }

}
