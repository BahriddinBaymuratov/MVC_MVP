package com.example.mvc_mvp.mvc

import java.util.Observable

// Model
class Model: Observable() {

    val list: MutableList<Int>

    init {
        list = ArrayList(3)
        list.add(0)
        list.add(0)
        list.add(0)
    }

    fun getValuesWithIndex(index: Int): Int {
        return list[index]
    }

    fun setValueWithIndex(index: Int) {
        list[index] += 1
        setChanged() // update data
        notifyObservers()  // update data
    }
}