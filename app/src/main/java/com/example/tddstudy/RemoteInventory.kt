package com.example.tddstudy

open class RemoteInventory : Inventory {
    override fun fetchAllItems() = ExternalSystem.fetchAllItems()
}