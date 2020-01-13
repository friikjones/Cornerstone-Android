package com.example.project_assignment3.network;

import com.example.project_assignment3.database.ContactList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RandomUserService {
    @GET("?nat=ca")
    Call<ContactList> listContacts(@Query("results") int num);
}
