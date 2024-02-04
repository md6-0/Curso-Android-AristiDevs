package com.mdn.androidmaster.thirdApp

sealed class Category(var isSelected:Boolean = true) {
    object Personal : Category()
    object Business : Category()
    object Other : Category()
}