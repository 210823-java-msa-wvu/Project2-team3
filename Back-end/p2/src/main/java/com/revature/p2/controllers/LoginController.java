package com.revature.p2.controllers;

import com.revature.p2.beans.User;
import com.revature.p2.payload.JWTLoginSuccessResponse;
import com.revature.p2.payload.LoginRequest;
import com.revature.p2.security.JwtTokenProvider;
import com.revature.p2.services.MapValidationErrorService;
import com.revature.p2.services.UserService;
import com.revature.p2.validators.UserValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;

import static com.revature.p2.security.SecurityConstants.TOKEN_PREFIX;

@RestController
@RequestMapping("/api")
@Slf4j
public class LoginController {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    UserValidator userValidator;
//    @Autowired
//    JwtTokenProvider tokenProvider;
//    @Autowired
//    AuthenticationManager authenticationManager;
//    @Autowired
//    private MapValidationErrorService mapValidationErrorService;
//
//
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@Valid @RequestBody User user, BindingResult result){
//        //Validate Password match
//        log.info("Getting User Attributes in register and checking password" );
//        userValidator.validate(user, result);
//
//        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
//        if (errorMap != null){
//            log.error("Error Register in: {}", errorMap);
//            return errorMap;
//        }
//
//        User newUser = userService.registerUser(user);
//
//
//        return  new ResponseEntity<User>(newUser, HttpStatus.CREATED);
//    }
//
//    @PostMapping("/login")
//    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, BindingResult result){
//        ResponseEntity<?> errorMap = mapValidationErrorService.MapValidationService(result);
//        if (errorMap != null){
//            log.error("Error logging in: {}", errorMap);
//
//            return errorMap;
//        }
//
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        loginRequest.getUsername(),
//                        loginRequest.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        String jwt =TOKEN_PREFIX + tokenProvider.generateToken(authentication);
//        return ResponseEntity.ok(new JWTLoginSuccessResponse(true, jwt));
//    }
//
//    @GetMapping("/users/all")
//    public List<User> getAllUsers(){
//        log.info("Getting all users");
//        return userService.getAllUsers();
//    }
}
