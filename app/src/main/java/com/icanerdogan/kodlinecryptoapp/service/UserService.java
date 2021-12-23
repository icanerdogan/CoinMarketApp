package com.icanerdogan.kodlinecryptoapp.service;

import com.icanerdogan.kodlinecryptoapp.model.User;
import com.icanerdogan.kodlinecryptoapp.model.request.SignInRequest;
import com.icanerdogan.kodlinecryptoapp.model.request.SignUpRequest;
import com.icanerdogan.kodlinecryptoapp.model.response.SignInResponse;
import com.icanerdogan.kodlinecryptoapp.model.response.SignUpResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface UserService {

    @GET("v3/73dae1e0-8731-4aa1-a8ca-7e87a412d68c")
    Call<List<User>> getUsers();

    @POST("v3/73dae1e0-8731-4aa1-a8ca-7e87a412d68c")
    Call<User> createUser(@Body User user);


    @POST("users")
    Call<SignInResponse> loginUser(@Body SignInRequest signInRequest);

    @POST("users")
    Call<SignUpResponse> saveUser(@Body SignUpRequest signUpRequest);


}
