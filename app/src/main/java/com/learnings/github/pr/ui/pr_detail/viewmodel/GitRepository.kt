package com.learnings.github.pr.ui.pr_detail.viewmodel

import com.learnings.github.pr.data.enums.PRStatus
import com.learnings.github.pr.data.model.PullRequestModel
import com.learnings.github.pr.network.ApiService
import com.learnings.github.pr.network.RetrofitService
import retrofit2.Callback

class GitRepository {

    private val apiService: ApiService = RetrofitService.retrofit.create(ApiService::class.java)

    fun getPullRequestList(ownerName: String, repoName: String, state: PRStatus, callback: Callback<List<PullRequestModel>>) {
        return apiService.getPullRequestList(ownerName,repoName, state.name).enqueue(callback)
    }

}