package idnull.z.myquotes.data

import javax.inject.Inject

class MainScreenRepository @Inject constructor(
    val remoteDataSource: RemoteDataSource
){
    val test = remoteDataSource.value
}