package com.iamemustan.tsubufc_board

import android.widget.ArrayAdapter
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.view.LayoutInflater

/**
 * Created by watyaa on 2014/06/28.
 */

public class PostAdapter(context: Context) : ArrayAdapter<PostParseObject>(context, 0) {

    var inflater: LayoutInflater
    {
        inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View? {
        val view = convertView ?: inflater.inflate(R.layout.view_post_item, null)

        (view as PostItemView).setValues(getItem(position) as PostParseObject)
        return view
    }
}
