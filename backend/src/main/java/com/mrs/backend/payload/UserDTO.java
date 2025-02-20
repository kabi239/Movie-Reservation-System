package com.mrs.backend.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
   
    private String username;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String role;
}
