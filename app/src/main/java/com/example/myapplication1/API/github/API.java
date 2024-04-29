package com.example.myapplication1.API.github;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface API {

    String URL = "http://localhost:8080/dsaApp/";

    @GET("/users/getUsers")
    Call<List<Usuario>> usuarios(
    );

    //@GET("/users/{users}/repos")
    //Call<List<Usuario>> repos(@Path("users") String owner);


    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}