package com.learnings.github.pr.views.pr_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learnings.github.pr.R
import com.learnings.github.pr.views.pr_detail.adapter.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_repo_details.*

class RepoDetailsActivity : AppCompatActivity() {
    private var mOwnerName = ""
    private var mRepoName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_details)
        mOwnerName = intent?.getStringExtra(EXTRA_OWNER_NAME) ?: ""
        mRepoName = intent?.getStringExtra(EXTRA_REPO_NAME) ?: ""

        val sectionsPagerAdapter = SectionsPagerAdapter(this,mOwnerName, mRepoName, supportFragmentManager)
        view_pager.adapter = sectionsPagerAdapter
        tabs.setupWithViewPager(view_pager)
    }


    companion object {
        val EXTRA_OWNER_NAME = "EXTRA_OWNER_NAME"
        val EXTRA_REPO_NAME = "EXTRA_REPO_NAME"
        val EXTRA_PR_STATE = "EXTRA_PR_STATE"
        fun createIntent(context: Context, ownerName: String, repoName: String): Intent {
            val intent = Intent(context, RepoDetailsActivity::class.java)
            intent.putExtra(EXTRA_OWNER_NAME,ownerName)
            intent.putExtra(EXTRA_REPO_NAME,repoName)

            return intent
        }
    }
}