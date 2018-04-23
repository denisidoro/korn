package com.github.denisidoro.korn.header

import org.w3c.fetch.Headers
import react.*

class Header : React.PureComponent<Any, Any>() {
    override fun render() =
            view(style = Style(backgroundColor = "skyblue", padding = 20, marginBottom = 10)) {
                text(style = TextStyle(color = "white", fontSize = 26, fontWeight = "bold"),
                     text = "Kotlin React Native")
            }
}

fun ViewBuilder.header() = component(Header())
