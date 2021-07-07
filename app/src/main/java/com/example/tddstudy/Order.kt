package com.example.tddstudy

interface Order {
    fun reorderItems(items: List<String>, keyword: String): List<String>
}