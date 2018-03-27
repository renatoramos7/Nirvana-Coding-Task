package com.renatoramos.nirvanacodingtask.presentation.ui.users

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.renatoramos.nirvanacodingtask.R
import com.renatoramos.nirvanacodingtask.commons.constant.Constants
import com.renatoramos.nirvanacodingtask.commons.extensions.isInternetConnected
import com.renatoramos.nirvanacodingtask.commons.extensions.makeTextToast
import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem
import com.renatoramos.nirvanacodingtask.presentation.base.BaseActivity
import com.renatoramos.nirvanacodingtask.presentation.ui.userdetails.UserDetailsActivity
import com.renatoramos.nirvanacodingtask.presentation.ui.users.adapters.UsersRecyclerAdapter
import kotlinx.android.synthetic.main.activity_users.*
import kotlinx.android.synthetic.main.toolbar_base_with_title.*
import javax.inject.Inject


class UsersActivity : BaseActivity(), UsersContract.View {

    @Inject
    lateinit var presenter : UsersPresenter

    private lateinit var usersRecyclerAdapter: UsersRecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_users)
        loadScreenComponents()
        initialize()
    }

    override fun onStop() {
        super.onStop()
        presenter.onStop()
    }

    override fun createAdapter(baseDisplayableList: List<BaseDisplayableItem>) {
        usersRecyclerAdapter = UsersRecyclerAdapter(
                baseContext,
                baseDisplayableList,
                object: UsersRecyclerAdapter.UsersAdapterListener{
                    override fun onClickCell(position: Int) {
                        presenter.onOpenUserDetailsScreen(position)
                    }
                }
        )
    }

    override fun displayAdapter() {
        usersRecyclerView.adapter = usersRecyclerAdapter
    }

    override fun isInternetConnected(): Boolean {
        return baseContext.isInternetConnected()
    }

    override fun displayError(error: String) {
        baseContext.makeTextToast( error, Toast.LENGTH_LONG).show()
    }

    override fun displayErrorInternetConnection() {
        baseContext.makeTextToast( getString(R.string.MSG_ERROR_INTERNET_CONNECTION), Toast.LENGTH_LONG).show()
    }

    override fun openUserDetails(idUser: Int?) {
        val intent = Intent(this,UserDetailsActivity::class.java)
        intent.putExtra(Constants.ID_USER, idUser)
        startActivity(intent)
    }

    private fun initialize() {
        presenter.onStart()
    }

    private fun loadScreenComponents() {
        usersRecyclerView.layoutManager = LinearLayoutManager(this)
        toolbarTitleTextView.text = getString(R.string.STR_TITLE_ACTIVITY_USER)
    }

}
