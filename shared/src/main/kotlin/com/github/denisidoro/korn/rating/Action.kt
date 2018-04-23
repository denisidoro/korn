package com.github.denisidoro.korn.rating

sealed class CounterAction {
    object INCREMENT: CounterAction()
    object DECREMENT: CounterAction()
}
