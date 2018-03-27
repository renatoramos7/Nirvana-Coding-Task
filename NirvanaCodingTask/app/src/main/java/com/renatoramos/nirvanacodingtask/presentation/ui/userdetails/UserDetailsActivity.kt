package com.renatoramos.nirvanacodingtask.presentation.ui.userdetails

import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.text.util.Linkify
import android.widget.Toast
import com.bumptech.glide.Glide
import com.renatoramos.nirvanacodingtask.R
import com.renatoramos.nirvanacodingtask.commons.constant.Constants
import com.renatoramos.nirvanacodingtask.commons.extensions.isInternetConnected
import com.renatoramos.nirvanacodingtask.commons.extensions.makeTextToast
import com.renatoramos.nirvanacodingtask.presentation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_user_details.*
import javax.inject.Inject

class UserDetailsActivity : BaseActivity(),  UserDetailsContract.View {

    @Inject
    lateinit var presenter : UserDetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)
        initialize()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        this.finish()
    }

    override fun isInternetConnected(): Boolean {
        return baseContext.isInternetConnected()
    }

    override fun displayErrorInternetConnection() {
        baseContext.makeTextToast( getString(R.string.MSG_ERROR_INTERNET_CONNECTION), Toast.LENGTH_LONG).show()
    }

    override fun displayError(error: String) {
        baseContext.makeTextToast( error, Toast.LENGTH_LONG).show()
    }

    override fun showUserDetails(avatarUrl: String?, name: String?, bio: String?, company: String?, location: String?, repo: String?) {

        nameTextView.text = name
        bioTextView.text = bio
        companyTextView.text = company
        locationTextView.text = location

        repoTextView.text = repo
        Linkify.addLinks(repoTextView, Linkify.WEB_URLS)
        repoTextView.movementMethod = LinkMovementMethod.getInstance()

        Glide.with(baseContext)
                .load(avatarUrl)
                .into(userDetailsImageView)
    }

    private fun initialize() {
        presenter.setIdUser(intent.getIntExtra(Constants.ID_USER, -1))
        presenter.onStart()
    }

}
