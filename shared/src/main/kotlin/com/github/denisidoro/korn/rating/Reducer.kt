package com.github.denisidoro.korn.rating

import com.github.denisidoro.korn.rating.CounterAction.DECREMENT
import com.github.denisidoro.korn.rating.CounterAction.INCREMENT

fun createReducer() = { state: Rating, action: CounterAction ->
    when (action) {
        is INCREMENT -> state.copy(score = state.score + 1)
        is DECREMENT -> state.copy(score = state.score - 1)
    }
}
