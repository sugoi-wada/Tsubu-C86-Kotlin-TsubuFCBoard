package com.iamemustan.tsubufc_board

import android.app.Fragment
import android.view.View
import android.view.LayoutInflater
import android.view.ViewGroup
import android.os.Bundle
import kotlin.properties.Delegates
import android.view.MenuInflater
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.parse.SaveCallback
import com.parse.ParseException
import android.widget.Toast
import android.content.Context

/**
 * Created by watyaa on 2014/06/29.
 */

public class PostFragment : Fragment() {

    var mAuthor: EditText by Delegates.notNull()
    var mComment: EditText by Delegates.notNull()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_post, container, false)
        mAuthor = view?.findViewById(R.id.author) as EditText
        mComment = view?.findViewById(R.id.comment) as EditText
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super<Fragment>.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        inflater?.inflate(R.menu.post, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.getItemId()) {
            R.id.postBtn -> post()
            else -> super<Fragment>.onOptionsItemSelected(item)
        }
    }

    fun post(): Boolean {
        val post = PostParseObject()
        post.setUser(mAuthor.getText().toString())
        post.setComment(mComment.getText().toString())
        post.setDate(System.currentTimeMillis())
        post.saveInBackground(object : SaveCallback() {

            override fun done(e: ParseException?) {
                if (e == null) {
                    Toast.makeText(getActivity() as Context, "投稿完了！", Toast.LENGTH_SHORT).show()
                    getFragmentManager()?.popBackStack()
                }
                Toast.makeText(getActivity() as Context, "投稿失敗。。。", Toast.LENGTH_SHORT).show()
            }
        })
        return true
    }

}
