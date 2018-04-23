package com.github.denisidoro.korn.rating

import redux.Store

typealias RatingStore = Store<Rating, CounterAction>

fun createStore(initialState: Rating) =
        Store(initialState, createReducer())
