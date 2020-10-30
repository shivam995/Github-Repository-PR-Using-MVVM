package com.learnings.github.pr.views.pr_detail.adapter

import android.content.Context
import android.text.format.DateUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.learnings.github.pr.R
import com.learnings.github.pr.data.enums.PRStatus
import com.learnings.github.pr.data.model.PullRequestModel
import com.learnings.github.pr.utils.AppUtils
import kotlinx.android.synthetic.main.itemview_pull_request_list.view.*

class PullRequestListAdapter(var context: Context, var pullRequestList: List<PullRequestModel>): RecyclerView.Adapter<PullRequestListAdapter.ViewHolder>() {

    val inflater: LayoutInflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = inflater.inflate(R.layout.itemview_pull_request_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return pullRequestList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val dataItem = pullRequestList[position]

        holder.prTitle.text = dataItem.title
        holder.prNumber.text = "#${dataItem.number}"
        holder.createdAt.text = dataItem.createdAt
        holder.state.text = dataItem.state
        val dateString = DateUtils.getRelativeTimeSpanString(AppUtils.getDateInMillis(dataItem.createdAt ?: ""))
        holder.createdAt.text = dateString
        if(dataItem.state == PRStatus.open.name) {
            holder.stateImage.setColorFilter(ContextCompat.getColor(context, R.color.green))
        }
        else {
            holder.stateImage.setColorFilter(ContextCompat.getColor(context, R.color.red))
        }

    }



    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val prTitle = itemView.prTitle
        val prNumber = itemView.prNumber
        val stateImage = itemView.ivState
        val createdAt = itemView.prCreated
        val state = itemView.prStatus

    }
}