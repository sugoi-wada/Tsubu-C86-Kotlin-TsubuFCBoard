package com.iamemustan.tsubufc_board

import android.app.Application
import com.parse.Parse
import com.parse.ParseObject

/**
 * Created by watyaa on 2014/06/28.
 */

public class TsubuFcApplication : Application() {

    override fun onCreate() {
        super<Application>.onCreate()

        ParseObject.registerSubclass(javaClass<PostParseObject>())

        // Required - Initialize the Parse SDK
        Parse.initialize(this, getString(R.string.parse_app_id), getString(R.string.parse_client_key))

        Parse.setLogLevel(Parse.LOG_LEVEL_WARNING)

    }
}