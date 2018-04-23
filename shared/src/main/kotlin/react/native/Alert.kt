@file:JsModule("react-native")
@file:Suppress("unused")

package react.native

external object Alert {

  fun alert(title: String,
            message: String? = definedExternally,
            buttons: dynamic = definedExternally,
            options: dynamic = definedExternally,
            type: dynamic = definedExternally)
}
