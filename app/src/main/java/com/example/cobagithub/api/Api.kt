package com.example.cobagithub.api


import com.example.cobagithub.data.dataset.Repositories
import com.example.cobagithub.data.dataset.UserResponse
import com.example.cobagithub.data.dataset.Users
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {

    @GET("users")
    @Headers("Authorization: token ghp_eljwpMCrhQP7CKz0vTYKPKtJT3aJeUe0QoVMQ")
    fun getUsers(): Call<ArrayList<Users>>

    @GET("search/users")
    fun getSearchUsers(
        @Query("q") q: String
    ): Call<UserResponse>

    @GET("users/{username}")
    fun getDetailUsers(
        @Path("username") username: String
    ): Call<Users>

    @GET("users/{username}/followers")
    fun getFollowers(
        @Path("username") username: String
    ): Call<ArrayList<Users>>

    @GET("users/{username}/following")
    fun getFollowing(
        @Path("username") username: String
    ): Call<ArrayList<Users>>

    @GET("users/{username}/repos")
    fun getUserRepository(
        @Path("username") username: String
    ): Call<ArrayList<Repositories>>

}