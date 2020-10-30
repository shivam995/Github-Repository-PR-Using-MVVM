package com.learnings.github.pr.network

import com.learnings.github.pr.data.model.PullRequestModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Shivam Jaiswal on 30/10/20.
 */

/**
 * Used for declaring Rest APIs
 */
interface ApiService {

    //ConfigRestService
    @GET("repos/{ownerName}/{repoName}/issues")
    fun getPullRequestList(@Path("ownerName") ownerName: String,
                           @Path("repoName") repoName: String,
                           @Query("state") state: String?): Call<List<PullRequestModel>>
}