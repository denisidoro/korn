@file:Suppress("unused")

package react

import react.native.AppRegistry

// Components

inline fun <reified T : React.Component<*, *>> AppRegistry.registerComponent(name: String) {
  registerComponent(name) { T::class.js }
}

// JS

inline fun json(init: dynamic.() -> Unit): dynamic {
  val o = json()
  init(o)
  return o
}

@Suppress("NOTHING_TO_INLINE")
inline fun json(): dynamic = js("{}")