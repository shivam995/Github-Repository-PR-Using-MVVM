package com.learnings.github.pr.views.pr_detail.adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.learnings.github.pr.R
import com.learnings.github.pr.data.enums.PRStatus
import com.learnings.github.pr.views.pr_detail.ui.main.PRListFragment

private val TAB_TITLES = arrayOf(
    R.string.tab1_title,
    R.string.tab2_title
)


class SectionsPagerAdapter(private val context: Context, private val ownerName: String, private val repoName: String, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {

        return PRListFragment.getInstance(ownerName, repoName, getPrState(position))
    }

    private fun getPrState(position: Int): PRStatus {

        return when (position) {
            0 -> PRStatus.open
            1 -> PRStatus.closed
            else -> PRStatus.open
        }
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}