package com.beokbeok.bowlini.data

import android.content.Context
import com.beokbeok.bowlini.R

object FakeItemsRemoteDataResource {
    private val DUMMY_ITEMS = mutableListOf<Car>()

    fun createCarItems(context: Context) : MutableList<Car> {
        for (i in 0 until 10) {
            val newCar = getSampleCar(context, i)
            DUMMY_ITEMS.add(newCar)
        }
        return DUMMY_ITEMS
    }

    private fun getSampleCar(context: Context, index: Int): Car =
        Car(
            index,
            context.getString(R.string.title),
            context.getString(R.string.subhead),
            context.getString(R.string.supporting),
            context.getString(R.string.expanded_supporting)
        )
}