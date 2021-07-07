package com.example.tddstudy

class Searcher(
    private val inventory: Inventory = RemoteInventory(),
    private val filter: Filter = ContainsFilter(),
    private val order: Order = KeywordMatchingOrder()
) {

    fun search(query: String): List<String> {
        val allItems = inventory.fetchAllItems()
        val filtered = filter.filterItems(allItems, query)
        return order.reorderItems(filtered, query)
    }

    //    fun search(query: String): List<String> {
//        // delegating to somewhere to get items
//        val allItems: List<String> = ExternalSystem.fetchAllItems()
//
//        // we leverage filter function from Kotlin sdk
//        val filtered = allItems.filter { it.contains((query)) }
//        val reordered = filtered.sortedWith(object : Comparator<String> {
//            override fun compare(left: String, right: String): Int {
//                if (left == query) {
//                    return -1
//                } else if (right == query) {
//                    return 0
//                }
//                return left.compareTo(right)
//            }
//        })
//        return reordered
//    }
}