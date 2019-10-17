package com.example.githubpro;

import android.text.GetChars;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    String BASE_URL="https://api.github.com/users/mahajanharshal2609/";

    @GET("repos")

    Call<List<Git>>getGit();


}
