package com.example.suitmedia.data.remote.dto

import com.example.suitmedia.domain.model.User

data class ListDto(
    val data: List<Data>,
    val page: Int,
    val per_page: Int,
    val support: Support,
    val total: Int,
    val total_pages: Int
)

data class Data(
    val avatar: String,
    val email: String,
    val first_name: String,
    val id: Int,
    val last_name: String
) {
    fun toUser(): User {
        return User(
            avatar = this.avatar,
            email = this.email,
            first_name = this.first_name,
            last_name = this.last_name,
            id = this.id
            )
    }
}

data class Support(
    val text: String,
    val url: String
)
