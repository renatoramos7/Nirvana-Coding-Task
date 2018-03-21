package com.renatoramos.nirvanacodingtask.presentation.ui.users.adapters

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.renatoramos.nirvanacodingtask.R
import de.hdodenhof.circleimageview.CircleImageView

/**
 * Created by renatoramos on 20.03.18.
 */
open class UsersViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {

    val titleTextView by lazy { itemView?.findViewById<TextView>(R.id.titleTextView)}
    val seeAllReviewsTextView by lazy { itemView?.findViewById<TextView>(R.id.seeAllReviewsTextView)}
    val avatarCircleImageView by lazy { itemView?.findViewById<CircleImageView>(R.id.avatarCircleImageView)}

}