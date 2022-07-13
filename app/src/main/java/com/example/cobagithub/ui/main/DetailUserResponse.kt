package com.example.cobagithub

data class DetailUserResponse(
    val id: Int,
    val avatar_url: String,
    val name: String,
    val login: String,
    val followers: Int,
    val following: Int,
    val bio: String,
    val public_repos: Int,
    val followers_url: String,
    val following_url: String,
    val repos_url: String
)
