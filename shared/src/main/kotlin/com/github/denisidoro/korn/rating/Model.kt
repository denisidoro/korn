package com.github.denisidoro.korn.rating

data class Rating(val language: String, val score: Int)

class RatingProps(val formattedText: String,
                  val onIncrementClick: () -> Unit,
                  val onDecrementClick: () -> Unit)

