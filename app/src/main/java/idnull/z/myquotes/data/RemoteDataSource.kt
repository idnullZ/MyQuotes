package idnull.z.myquotes.data

import android.app.Application
import android.content.Context
import idnull.z.myquotes.R
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    val context:Application
) {



    val value = "YES ${context.getString(R.string.app_name)}"

}


