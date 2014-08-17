package com.iamemustan.tsubufc_board

import android.content.Context
import android.widget.TextView
import kotlin.properties.Delegates
import android.util.AttributeSet
import android.widget.RelativeLayout
import java.text.SimpleDateFormat
import java.util.Date


/**
 * Created by watyaa on 2014/06/28.
 */

public open class PostItemView(context: Context, attrs: AttributeSet) : RelativeLayout(context, attrs) {
    var mAuthorTextView: TextView by Delegates.notNull()
    var mCommentTextView: TextView by Delegates.notNull()
    var mDateTextView: TextView by Delegates.notNull()

    override fun onFinishInflate() {
        super<RelativeLayout>.onFinishInflate()
        mAuthorTextView = findViewById(R.id.userName) as TextView
        mCommentTextView = findViewById(R.id.comment) as TextView
        mDateTextView = findViewById(R.id.date) as TextView
    }

    public fun setValues(post: PostParseObject) {
        mAuthorTextView.setText(post.getUser())
        mCommentTextView.setText(post.getComment())
        val sdf = SimpleDateFormat("yyyy-MM-dd")
        val date = sdf.format(Date(post.getDate() as Long))
        mDateTextView.setText(date)
    }
}

