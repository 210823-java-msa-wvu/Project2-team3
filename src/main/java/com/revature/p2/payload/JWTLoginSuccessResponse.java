package com.revature.p2.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JWTLoginSuccessResponse {
    private boolean success;
    private String token;
}
