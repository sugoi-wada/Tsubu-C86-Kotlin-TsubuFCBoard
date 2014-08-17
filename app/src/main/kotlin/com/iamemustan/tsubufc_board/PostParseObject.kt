package com.iamemustan.tsubufc_board

import com.parse.ParseObject
import com.parse.ParseClassName

/**
 * Created by watyaa on 2014/07/04.
 */

ParseClassName("PostParseObject")
public open class PostParseObject : ParseObject() {

    public fun getUser(): String? {
        return getString("user")
    }

    public fun setUser(user: String?) {
        put("user", user)
    }

    public fun getComment(): String? {
        return getString("comment")
    }

    public fun setComment(comment: String?) {
        put("comment", comment)
    }

    public fun getDate(): Long? {
        return getLong("date")
    }

    public fun setDate(date: Long?) {
        put("date", date)
    }
}
