package com.baluchi.ecommerce.ecommerce.services.auth;

import com.baluchi.ecommerce.ecommerce.dto.SignupRequest;
import com.baluchi.ecommerce.ecommerce.dto.UserDto;

public interface AuthService {

    UserDto createUser(SignupRequest signupRequest);

    Boolean hasUserWithEmail(String email);

}
