package com.example.suitmedia.data.remote

import com.example.suitmedia.data.remote.dto.ListDto
import retrofit2.http.GET

interface SuitmediaAPI {
    @GET("users?page=2")
    suspend fun getList(): ListDto
}