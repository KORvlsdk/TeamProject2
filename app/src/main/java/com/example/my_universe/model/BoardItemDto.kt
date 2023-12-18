package com.example.my_universe.model

data class BoardItemDto(
    val title : String,
    val subTitle : String,
    val content : String,
    val images : List<String>
)
