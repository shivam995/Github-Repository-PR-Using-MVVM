package com.learnings.github.pr.ui.pr_detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.learnings.github.pr.R
import com.learnings.github.pr.network.ApiService
import com.learnings.github.pr.ui.pr_detail.ui.main.SectionsPagerAdapter

class RepoDetailsActivity : AppCompatActivity() {

    companion object {
        val EXTRA_OWNER_NAME = "EXTRA_OWNER_NAME"
        val EXTRA_REPO_NAME = "EXTRA_REPO_NAME"
        fun createIntent(context: Context, ownerName: String, repoName: String): Intent {
            val intent = Intent(context, RepoDetailsActivity::class.java)
            intent.putExtra(EXTRA_OWNER_NAME,ownerName)
            intent.putExtra(EXTRA_REPO_NAME,repoName)

            return intent
        }
    }

    private var mOwnerName = ""
    private var mRepoName = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repo_details)

        mOwnerName = intent?.getStringExtra(EXTRA_OWNER_NAME) ?: ""
        mRepoName = intent?.getStringExtra(EXTRA_REPO_NAME) ?: ""


        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        getPullRequest()

    }

    private fun getPullRequest() {

    }
}