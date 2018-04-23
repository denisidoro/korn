@file:JsModule("react-native")
@file:Suppress("unused")

package react.native

import react.React

external object AppRegistry {
  fun <T : React.Component<*, *>> registerComponent(name: String, createComponent: () -> JsClass<T>)
}
