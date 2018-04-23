@file:JsModule("react-native")
@file:Suppress("unused")

package react.native

external interface PlatformSelectConfig<T> {
  var ios: T
  var android: T
}

external object StyleSheet {
  fun create(style: dynamic): dynamic
}

external object Platform {
  val OS: String

  @JsName("Version")
  val VERSION: dynamic

  fun <T> select(select: PlatformSelectConfig<T>): T
}
