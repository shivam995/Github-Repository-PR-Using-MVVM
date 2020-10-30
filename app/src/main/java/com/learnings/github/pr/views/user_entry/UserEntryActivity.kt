package com.learnings.github.pr.views.user_entry

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.learnings.github.pr.R
import com.learnings.github.pr.views.pr_detail.RepoDetailsActivity
import kotlinx.android.synthetic.main.activity_user_entry.*

class UserEntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_entry)

        submitButton.setOnClickListener {
            if (isValidInput()) {
                val intent = RepoDetailsActivity.createIntent(this@UserEntryActivity,
                        ownerName.text.toString(),
                        repoName.text.toString())
                startActivity(intent)
            }
            else {
                showToastMessage(R.string.generic_error_user_input)
            }
        }

    }

    private fun isValidInput(): Boolean {
        return (!ownerName.text.toString().isEmpty() && !repoName.text.toString().isEmpty())
    }

    private fun showToastMessage(@StringRes message: Int) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }

    /**
     * could be moved to separate extension class
     */
    private fun String?.isEmpty(): Boolean {
        return (this == null || this.trim() == "")
    }
}
