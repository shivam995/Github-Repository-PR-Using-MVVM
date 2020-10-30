package com.learnings.github.pr.data.model

import com.google.gson.annotations.SerializedName


data class PullRequestModel (

    @SerializedName("number")
    
     val number: Int? = null,

    @SerializedName("title")
    
     val title: String? = null,

    @SerializedName("state")
     val state: String? = null,

    @SerializedName("created_at")
     val createdAt: String? = null
)