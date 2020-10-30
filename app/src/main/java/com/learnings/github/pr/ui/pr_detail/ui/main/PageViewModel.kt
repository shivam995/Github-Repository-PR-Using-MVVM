package com.learnings.github.pr.ui.pr_detail.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learnings.github.pr.data.model.PullRequestModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PageViewModel : ViewModel() {

    val repository = GitRepository()
    val openPrList: MutableLiveData<List<PullRequestModel>> = MutableLiveData<List<PullRequestModel>>()

    fun getOpenPullRequest(ownerName: String, repoName: String) {
        repository.getOpenPullRequestList(ownerName,repoName,object: Callback<List<PullRequestModel>>{
            override fun onFailure(call: Call<List<PullRequestModel>>, t: Throwable) {

            }

            override fun onResponse(call: Call<List<PullRequestModel>>, response: Response<List<PullRequestModel>>) {

            }
        })
    }

}