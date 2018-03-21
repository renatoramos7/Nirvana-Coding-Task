package com.renatoramos.nirvanacodingtask.presentation.ui.users

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import com.renatoramos.nirvanacodingtask.R
import com.renatoramos.nirvanacodingtask.commons.utils.ConstantsUtils
import com.renatoramos.nirvanacodingtask.commons.utils.MethodsUtils
import com.renatoramos.nirvanacodingtask.presentation.base.BaseActivity
import com.renatoramos.nirvanacodingtask.presentation.base.DisplayableItem
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
        presenter.stop()
    }

    override fun createAdapter(displayableList: List<DisplayableItem>) {
        usersRecyclerAdapter = UsersRecyclerAdapter(
                baseContext,
                displayableList,
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
        return MethodsUtils.isInternetConnected(baseContext)
    }

    override fun displayError(error: String) {
        MethodsUtils.makeTextToast(baseContext, error, Toast.LENGTH_LONG).show()
    }

    override fun displayErrorInternetConnection() {
        MethodsUtils.makeTextToast(baseContext, getString(R.string.MSG_ERROR_INTERNET_CONNECTION), Toast.LENGTH_LONG).show()
    }

    override fun openUserDetails(idUser: Int?) {
        val intent = Intent(this@UsersActivity,UserDetailsActivity::class.java)
        intent.putExtra(ConstantsUtils.ID_USER, idUser)
        startActivity(intent)
    }

    private fun initialize() {
        presenter.startPresenter()
    }

    private fun loadScreenComponents() {
        usersRecyclerView.layoutManager = LinearLayoutManager(this)
        toolbarTitleTextView.text = getString(R.string.STR_TITLE_ACTIVITY_USER)
    }

}
