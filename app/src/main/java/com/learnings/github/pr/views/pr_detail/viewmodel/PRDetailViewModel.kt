package com.learnings.github.pr.views.pr_detail.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learnings.github.pr.data.enums.PRStatus
import com.learnings.github.pr.data.model.PullRequestModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PRDetailViewModel : ViewModel() {

    val repository = GitRepository()
    val pullRequestList: MutableLiveData<List<PullRequestModel>> = MutableLiveData()
    val fetchErrorString = MutableLiveData<String?>()
    val toggleLoading = MutableLiveData<Boolean>(false)


    fun getPullRequest(ownerName: String, repoName: String, state: PRStatus) {
        toggleLoading.value = true
        repository.getPullRequestList(ownerName,repoName, state, object: Callback<List<PullRequestModel>>{
            override fun onFailure(call: Call<List<PullRequestModel>>, t: Throwable) {
                toggleLoading.value = false
                fetchErrorString.value = t.message
            }

            override fun onResponse(call: Call<List<PullRequestModel>>, response: Response<List<PullRequestModel>>) {
                if(response.isSuccessful && !response.body().isNullOrEmpty()) {
                    pullRequestList.value = response.body()
                    toggleLoading.value = false
                }
                else {
                    fetchErrorString.value = response.message()
                }
                toggleLoading.value = false
            }
        })
    }

}