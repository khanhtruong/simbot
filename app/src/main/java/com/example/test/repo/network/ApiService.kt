package com.example.test.repo.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Part
import retrofit2.http.Streaming

interface ApiService {
    @GET("")
    @Streaming
    suspend fun getPosts(@Part message: String): ResponseBody
}