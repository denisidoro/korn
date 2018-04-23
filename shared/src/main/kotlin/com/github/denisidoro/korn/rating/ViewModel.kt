package com.github.denisidoro.korn.rating

import com.github.denisidoro.korn.rating.CounterAction.*
import redux.Dispatcher

fun viewModel(state: Rating, dispatch: Dispatcher<CounterAction>): RatingProps {
    return RatingProps(
            formattedText = "${state.language} scores ${state.score}!",
            onIncrementClick = { dispatch(INCREMENT) },
            onDecrementClick = { dispatch(DECREMENT) })
}
