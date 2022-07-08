package com.example.suitmedia.data.remote.repository

import android.util.Log
import com.example.suitmedia.Utils.Condition
import com.example.suitmedia.data.remote.SuitmediaAPI
import com.example.suitmedia.domain.model.User
import com.example.suitmedia.domain.repository.ListRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class ListRepositoryImpl @Inject constructor(
    private val api : SuitmediaAPI
) : ListRepository{

    override suspend fun getList(): Flow<Condition<List<User>>> = flow {
        try {
            emit(Condition.Loading<List<User>>())
            val list = api.getList().data.map { it.toUser() }
            emit(Condition.Success(list))
        } catch (e : HttpException){
            // error
            emit(Condition.Error<List<User>>(e.localizedMessage ?: " An Error"))
        } catch (e: IOException) {
            // no internet
            emit((Condition.Error<List<User>>("couldn't search no internet")))
        }
    }
}