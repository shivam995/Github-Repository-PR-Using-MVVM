package com.learnings.github.pr.network

import com.learnings.github.pr.data.model.PullRequestModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Used for declaring Rest APIs
 */
interface ApiService {

    //ConfigRestService
    @GET("repos/{ownerName}/{repoName}/issues?state={state}")
    fun getOpenPullRequestList(@Path("ownerName") ownerName: String?,
                                    @Query(value = "repoName") repoName: String?,
                                    @Query(value = "state") state: String?): Call<List<PullRequestModel>>
}