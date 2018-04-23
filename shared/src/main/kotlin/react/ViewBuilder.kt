package react

import react.native.*

inline fun view(style: Style? = null, block: ViewBuilder.() -> Unit): dynamic {
    val builder = ViewBuilder()
    builder.block()
    return builder.build(style)
}

inline fun view(block: ViewBuilder.() -> Unit) = view(null, block)

class ViewBuilder {
    val children = arrayListOf<dynamic>()

    fun text(text: String, style: Style? = null) {
        val props = json {
            this.style = style
        }

        addElement(element = Text::class.js, props = props, params = *arrayOf(text))
    }

    fun button(title: String, onPress: () -> Unit = {}) {
        val props = json {
            this.title = title
            this.onPress = onPress
        }

        addElement(element = Button::class.js, props = props)
    }

    fun touchableHighlight(onPress: () -> Unit, block: ViewBuilder.() -> Unit) {
        val props = json {
            this.onPress = onPress
        }
        addElement(element = TouchableHighlight::class.js, props = props, params = *arrayOf(react.view(null, block)))
    }

    fun scrollView(block: ViewBuilder.() -> Unit) {
        addElement(element = ScrollView::class.js, props = null, params = *arrayOf(react.view(null, block)))
    }

    fun image(style: Style? = null, uri: String) {
        val props = json {
            this.source = json { this.uri = uri }
            this.style = style
        }
        addElement(element = Image::class.js, props = props)
    }

    fun textInput(value: String, onChangeText: (String) -> Unit) {
        val props = json {
            this.value = value
            this.onChangeText = onChangeText
        }
        addElement(element = TextInput::class.js, props = props)
    }

    fun <P> component(component: React.Component<P, *>, props: P? = null) {
        val _props = if (props == null) json {} else props
        children.add(React.createElement({ component }, _props))
    }

    inline fun view(style: Style? = null, block: ViewBuilder.() -> Unit) {
        children.add(react.view(style, block))
    }

    // TODO: only wrap by a View when necessary
    fun build(style: Style? = null): dynamic {
        val props = json {
            this.style = style
        }
        return React.createElement(View::class.js, props, *children.toTypedArray())
    }

    private fun addElement(element: dynamic, props: dynamic, vararg params: dynamic) {
        val _props = props ?: json()

        val p = when {
            params.isEmpty() -> null
            params.size == 1 -> params.first()
            else             -> params
        }

        children.add(React.createElement(element, _props, p))
    }
}
