package com.dungnm.example.compose.home.network

import com.dungnm.example.compose.home.model.res.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

const val SEARCH_PATH = "search/repositories"

interface GithubService {

    @GET(SEARCH_PATH)
    suspend fun search(
        @Query("q") query: String,
        @Query("page") page: String,
        @Query("per_page") perPage: String,
    ): SearchResponse

}