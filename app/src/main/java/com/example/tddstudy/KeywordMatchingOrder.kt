package com.example.tddstudy

class KeywordMatchingOrder : Order {

    override fun reorderItems(items: List<String>, keyword: String): List<String> {
        return items.sortedWith(Comparator { left, right ->
            if (left == keyword) {
                return@Comparator -1
            } else if (right == keyword) {
                return@Comparator 0
            }
            left.compareTo(right)
        })
    }
}