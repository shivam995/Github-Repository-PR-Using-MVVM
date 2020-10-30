package com.learnings.github.pr.ui.pr_detail.ui.main

import com.learnings.github.pr.data.enums.PRStatus
import com.learnings.github.pr.data.model.PullRequestModel
import com.learnings.github.pr.network.ApiService
import com.learnings.github.pr.network.RetrofitService
import retrofit2.Callback

class GitRepository {

    val apiService = RetrofitService.retrofit.create(ApiService::class.java)

    fun getOpenPullRequestList(ownerName: String, repoName: String, callback: Callback<List<PullRequestModel>>) {
        return apiService.getOpenPullRequestList(ownerName,repoName,PRStatus.Open.name).enqueue(callback)
    }
}