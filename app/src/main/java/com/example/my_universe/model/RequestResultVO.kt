package com.example.my_universe.model

data class RequestResultVO(
    val token : String,
    val result : Boolean,
    val message : String,
    val userDto : UserDto,
    val boardItemDtos : List<BoardItemDto>
)
