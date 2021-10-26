package com.revature.p2.controllers;

import com.google.gson.Gson;
import com.pusher.rest.Pusher;

import com.revature.p2.dtos.MessageDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("chatapi")
public class ChatController {

    @PostMapping("/messages")
    public String message(@RequestBody MessageDTO body){//ResponseEntity<ArrayList<String>>

        Pusher pusher = new Pusher("1285942", "8b393a4526b0c1792e2b", "6c2a3f80202fad39d390");
        //"8b393a4526b0c1792e2b" app key
        pusher.setCluster("us2");
        pusher.setEncrypted(true);

        //pusher.trigger("my-channel", "my-event", Collections.singletonMap("message", "hello world"));
        pusher.trigger("chat","message",body);
        System.out.println("chat controller");
        System.out.println(body);
        System.out.println(body.username);
        System.out.println(body.message);

        String str = new Gson().toJson(body);
        System.out.println(str);

        //ArrayList<String> myEmptyArray = new ArrayList<String>();
        //return ResponseEntity.ok(myEmptyArray);

        return str;
    }



}
