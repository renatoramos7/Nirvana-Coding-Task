package com.renatoramos.nirvanacodingtask.presentation.ui.users.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.renatoramos.nirvanacodingtask.R
import com.renatoramos.nirvanacodingtask.infrastructure.model.UserData
import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem

/**
 * Created by renatoramos on 20.03.18.
 */
class UsersRecyclerAdapter(private val context: Context, private val baseDisplayableItemList: List<BaseDisplayableItem>, private val usersAdapterListener: UsersAdapterListener) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    // Just to control the click in this
    interface UsersAdapterListener {
        fun onClickCell(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val usersViewHolder = UsersViewHolder(LayoutInflater.from(parent?.context).inflate(R.layout.viewholder_users, parent, false))

        //Cell clicks
        usersViewHolder.itemView.setOnClickListener({usersAdapterListener.onClickCell(usersViewHolder.adapterPosition)})
        return usersViewHolder
    }

    override fun getItemCount(): Int {
        return baseDisplayableItemList?.size
    }

    override fun onBindViewHolder(viewHolder: RecyclerView.ViewHolder, position: Int) {

        // Just bind View Objects.
        val usersViewHolder = viewHolder as UsersViewHolder
        val userDataClass = baseDisplayableItemList[position] as UserData

        usersViewHolder.titleTextView?.text = userDataClass.login
        usersViewHolder.seeAllReviewsTextView?.text = context.getString(R.string.STR_SEE_ALL_REVIEWS_TEXT_VIEW)

        Glide.with(context)
                .load(userDataClass.avatarUrl)
                .into(usersViewHolder.avatarCircleImageView!!)
    }
}