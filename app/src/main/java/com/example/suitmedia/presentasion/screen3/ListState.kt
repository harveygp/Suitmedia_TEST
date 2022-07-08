package com.example.suitmedia.presentasion.screen3

import com.example.suitmedia.domain.model.User

data class ListState(
    val isLoading : Boolean = false,
    val Lists : List<User> = emptyList(),
    val error : String = ""
)
