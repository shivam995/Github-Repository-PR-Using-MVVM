package com.learnings.github.pr.ui.login

import android.os.Bundle
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import android.widget.Toast
import com.learnings.github.pr.R
import com.learnings.github.pr.ui.pr_detail.RepoDetailsActivity
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
                showLoginFailed(R.string.generic_error_user_input)
            }
        }

    }

    private fun isValidInput(): Boolean {
        return (!ownerName.text.toString().isEmpty() && !repoName.text.toString().isEmpty())
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        Toast.makeText(applicationContext, errorString, Toast.LENGTH_SHORT).show()
    }

    /**
     * could be moved to separate extension class
     */
    private fun String?.isEmpty(): Boolean {
        return (this == null || this.trim() == "")
    }
}
