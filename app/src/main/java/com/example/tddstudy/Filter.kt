package com.example.tddstudy

interface Filter {

    fun filterItems(
        items: List<String>,
        keyword: String
    ): List<String>

}