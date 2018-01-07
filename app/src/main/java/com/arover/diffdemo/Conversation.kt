package com.arover.diffdemo

/**
 *
 * @author arover
 * created at 06/01/2018 16:21
 */
class Conversation(val id: Long,
                   var username: String,
                   var avatarUrl: String,
                   var contentPreview: String,
                   var targetType: String):Cloneable {

    fun isContentSameAs(other: Conversation): Boolean {
        return username == other.username
                && avatarUrl == other.avatarUrl
                && contentPreview == other.contentPreview
                && targetType == other.targetType
    }

    override public fun clone(): Any {
        return super.clone()
    }

    override fun toString(): String {
        return "Conversation(id=$id, username='$username', avatarUrl='$avatarUrl', contentPreview='$contentPreview', targetType='$targetType')"
    }


}