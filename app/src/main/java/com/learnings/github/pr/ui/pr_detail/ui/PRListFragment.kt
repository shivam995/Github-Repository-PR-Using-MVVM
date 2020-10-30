package com.learnings.github.pr.ui.pr_detail.ui.main

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.learnings.github.pr.R
import com.learnings.github.pr.data.enums.PRStatus
import com.learnings.github.pr.data.model.PullRequestModel
import com.learnings.github.pr.ui.pr_detail.RepoDetailsActivity
import com.learnings.github.pr.ui.pr_detail.adapter.PullRequestListAdapter
import com.learnings.github.pr.ui.pr_detail.viewmodel.PRDetailViewModel
import kotlinx.android.synthetic.main.fragment_pr_list.*

class PRListFragment : Fragment() {

    private var mOwnerName = ""
    private var mRepoName = ""
    private lateinit var mState: PRStatus
    private var mListAdapter: PullRequestListAdapter? = null
    private var pullRequestList = ArrayList<PullRequestModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null){
            mOwnerName = arguments?.getString(RepoDetailsActivity.EXTRA_OWNER_NAME,"") ?: ""
            mRepoName = arguments?.getString(RepoDetailsActivity.EXTRA_REPO_NAME,"") ?: ""
            mState =  PRStatus.valueOf(arguments?.getString(RepoDetailsActivity.EXTRA_PR_STATE,"") ?: PRStatus.open.name)
        }
    }

    private fun observeViewModelChanges() {
        val pageViewModel = ViewModelProvider(this).get(PRDetailViewModel::class.java)
        pageViewModel.pullRequestList.observe(this,
            Observer<List<PullRequestModel>> {
                if (!it.isNullOrEmpty()) {
                    pullRequestList.clear()
                    pullRequestList.addAll(it)
                    mListAdapter?.notifyDataSetChanged()
                }
            })
        pageViewModel.getPullRequest(mOwnerName,mRepoName,mState)
        pageViewModel.fetchErrorString.observe(this, Observer {
            if (!TextUtils.isEmpty(it.toString())) {
                showToastMessage(it)
            }
        })
        pageViewModel.toggleLoading.observe(this, Observer {
            loading.visibility = if (it)  View.VISIBLE else View.GONE
        })
    }

    private fun initializeListAdapter() {
        mListAdapter = PullRequestListAdapter(context!!,pullRequestList)
        rvPrList.layoutManager = LinearLayoutManager(context!!,LinearLayoutManager.VERTICAL,false)
        rvPrList.adapter = mListAdapter
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val root = inflater.inflate(R.layout.fragment_pr_list, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeListAdapter()
        observeViewModelChanges()

    }

    private fun showToastMessage(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    companion object {
        fun getInstance(ownerName: String, repoName: String, state: PRStatus): PRListFragment {
            val fragment = PRListFragment()
            val argument = Bundle()
            argument.putString(RepoDetailsActivity.EXTRA_REPO_NAME,repoName)
            argument.putString(RepoDetailsActivity.EXTRA_OWNER_NAME,ownerName)
            argument.putString(RepoDetailsActivity.EXTRA_PR_STATE,state.name)
            fragment.arguments = argument
            return fragment
        }
    }

}