package com.github.denisidoro.korn

import com.github.denisidoro.korn.header.header
import com.github.denisidoro.korn.rating.*
import react.React
import react.Style
import react.native.AppRegistry
import react.registerComponent
import react.view

val kotlinStore = createStore(Rating("Kotlin", 55))
val javascriptStore = createStore(Rating("JavaScript", 50))

fun main(args: Array<String>) {
    AppRegistry.registerComponent<HelloWorld>("Korn")
}

class HelloWorld : React.Component<Any, Any>() {
    override fun render() =
            view {
                header()
                rating(kotlinStore)
                rating(javascriptStore)
            }
}
