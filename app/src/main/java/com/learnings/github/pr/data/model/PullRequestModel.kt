package com.learnings.github.pr.data.model

import com.google.gson.annotations.SerializedName


data class PullRequestModel (

    @SerializedName("number")
    
    private val number: Int? = null,

    @SerializedName("title")
    
    private val title: String? = null,

    @SerializedName("state")
    private val state: String? = null,

    @SerializedName("created_at")
    private val createdAt: String? = null
)