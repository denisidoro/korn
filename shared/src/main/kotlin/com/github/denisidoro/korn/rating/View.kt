package com.github.denisidoro.korn.rating

import react.*

val buttonStyle = Style(height = 30, flex = 1, margin = 10)

class Rating : React.PureComponent<RatingProps, Any>() {
    override fun render() =
            view {
                text(style = TextStyle(margin = 10, fontSize = 18),
                     text = props.formattedText)
                view(style = Style(flex = 1, flexDirection = "row", marginBottom = 60)) {
                    view(buttonStyle) {
                        button(title = "-1",
                               onPress = props.onDecrementClick)
                    }
                    view(buttonStyle) {
                        button(title = "+1",
                               onPress = props.onIncrementClick )
                    }
                }
            }
}

class RatingContainer(private val store: RatingStore) : React.Component<Any, RatingProps>() {
    override fun componentWillMount() {
        store.subscribe { s, d -> setState(viewModel(s, d)) }
    }

    override fun componentWillUnmount() {
        store.unsubscribe()
    }

    override fun render(): dynamic {
        return view {
            component(Rating(), state)
        }
    }
}

fun ViewBuilder.rating(store: RatingStore) = component(RatingContainer(store))
