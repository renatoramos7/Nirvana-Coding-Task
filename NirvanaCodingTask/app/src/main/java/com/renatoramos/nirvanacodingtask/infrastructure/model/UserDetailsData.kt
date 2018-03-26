package com.renatoramos.nirvanacodingtask.infrastructure.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.renatoramos.nirvanacodingtask.infrastructure.model.base.BaseDisplayableItem

/**
 * Created by renatoramos on 19.03.18.
 */

data class UserDetailsData(
                                   @SerializedName("login") @Expose var login: String?,
                                   @SerializedName("id") @Expose var id: Int?,
                                   @SerializedName("avatar_url") @Expose var avatarUrl: String?,
                                   @SerializedName("gravatar_id") @Expose var gravatarId: String?,
                                   @SerializedName("url") @Expose var url: String?,
                                   @SerializedName("html_url") @Expose var htmlUrl: String?,
                                   @SerializedName("followers_url") @Expose var followersUrl: String?,
                                   @SerializedName("following_url") @Expose var followingUrl: String?,
                                   @SerializedName("gists_url") @Expose var gistsUrl: String?,
                                   @SerializedName("starred_url") @Expose var starredUrl: String?,
                                   @SerializedName("subscriptions_url") @Expose var subscriptionsUrl: String?,
                                   @SerializedName("organizations_url") @Expose var organizationsUrl: String?,
                                   @SerializedName("repos_url") @Expose var reposUrl: String?,
                                   @SerializedName("events_url") @Expose var eventsUrl: String?,
                                   @SerializedName("received_events_url") @Expose var receivedEventsUrl: String?,
                                   @SerializedName("type") @Expose var type: String?,
                                   @SerializedName("site_admin") @Expose var siteAdmin: Boolean?,
                                   @SerializedName("name") @Expose var name: String?,
                                   @SerializedName("company") @Expose var company: String?,
                                   @SerializedName("blog") @Expose var blog: String?,
                                   @SerializedName("location") @Expose var location: String?,
                                   @SerializedName("email") @Expose var email: String?,
                                   @SerializedName("hireable") @Expose var hireable: String?,
                                   @SerializedName("bio") @Expose var bio: String?,
                                   @SerializedName("public_repos") @Expose var publicRepos: Int?,
                                   @SerializedName("public_gists") @Expose var publicGists: Int?,
                                   @SerializedName("followers") @Expose var followers: Int?,
                                   @SerializedName("following") @Expose var following: Int?,
                                   @SerializedName("created_at") @Expose var createdAt: String?,
                                   @SerializedName("updated_at") @Expose var updatedAt: String?): BaseDisplayableItem()



