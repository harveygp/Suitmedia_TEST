package com.example.suitmedia.domain.use_case

import com.example.suitmedia.Utils.Condition
import com.example.suitmedia.domain.model.User
import com.example.suitmedia.domain.repository.ListRepository
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GetListUserUseCase @Inject constructor(
    private val repository : ListRepository
){
    suspend operator fun invoke() : Flow<Condition<List<User>>> = repository.getList()
}