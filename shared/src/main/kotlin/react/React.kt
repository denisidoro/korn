package react

@JsModule("react")
external object React {
  abstract class Component<P, S>(
      props: P? = definedExternally,
      state: S? = definedExternally
  ) {
    open var props: P
    open var state: S
    open val context: Any?

    fun forceUpdate()

    @JsName("setState")
    fun setState(state: S, callback: (() -> Unit)? = definedExternally)

    @JsName("setState")
    fun setState(updater: (S, P) -> S)

    open fun componentWillMount()

    open fun componentDidMount()

    open fun componentWillReceiveProps(nextProps: P)

    open fun shouldComponentUpdate(nextProps: P, nextState: S): Boolean

    open fun componentWillUpdate(nextProps: P, nextState: S)

    @JsName("render")
    abstract fun render(): dynamic

    open fun componentDidUpdate(prevProps: P, prevState: S)

    open fun componentWillUnmount()

    open fun componentDidCatch(error: Throwable, info: Any?)
  }

  abstract class PureComponent<P, S> : Component<P, S>

  fun createElement(elementClass: dynamic, props: dynamic, vararg children: dynamic): dynamic
}
