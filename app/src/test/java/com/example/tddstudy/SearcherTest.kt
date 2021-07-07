package com.example.tddstudy

import org.junit.Assert.*
import org.junit.Test

class SearcherTest {

    private val allItems = listOf("first", "item 1", "second", "item 2", "foo", "barfoo")

    @Test
    fun return_empty_result_set() {
        // returns empty results when no items available
        val noItems = emptyList<String>()
        val searcher = Searcher(InMemoryInventory(noItems))
        assertEquals(emptyList<String>(), searcher.search(""))
    }

    @Test
    fun return_all_available_items_for_an_empty_query() {
        val allItems = listOf("item 1", "item 2")
        val searcher = Searcher(InMemoryInventory(allItems))
        assertEquals(allItems, searcher.search(""))
    }

    @Test
    fun return_items_containing_the_query() {
        val matchingItems = listOf("item 1", "item 2")
        val searcher = Searcher(InMemoryInventory(allItems))
        assertEquals(matchingItems, searcher.search("item"))
    }

    @Test
    fun return_more_relevant_matches_first() {
        val matchingItems = listOf("foo", "barfoo")
        val searcher = Searcher(InMemoryInventory(allItems))
        assertEquals(matchingItems, searcher.search("foo"))
    }

    class InMemoryInventory(private val allItems: List<String>) : Inventory {

        override fun fetchAllItems(): List<String> {
            return allItems
        }
    }

}