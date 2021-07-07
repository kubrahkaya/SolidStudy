package com.example.tddstudy

class ContainsFilter : Filter {

    override fun filterItems(
        items: List<String>,
        keyword: String
    ): List<String> {
        return items.filter { it.contains((keyword)) }
    }
}