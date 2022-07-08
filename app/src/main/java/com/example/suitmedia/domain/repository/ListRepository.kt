package com.example.suitmedia.domain.repository

import com.example.suitmedia.Utils.Condition
import com.example.suitmedia.domain.model.User
import kotlinx.coroutines.flow.Flow

interface ListRepository {

    suspend fun getList(): Flow<Condition<List<User>>>
}