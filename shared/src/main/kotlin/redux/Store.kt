package redux

typealias Dispatcher<A> = (A) -> Unit
typealias Reducer<S, A> = (S, A) -> S
typealias Callback<S, A> = (S, Dispatcher<A>) -> Unit

class Store<S, A>(
        initialState: S,
        private val reducer: Reducer<S, A>) {

    var callback: Callback<S, A>? = null

    var state: S = initialState

    private fun update() {
        callback?.invoke(state, dispatch)
    }

    fun subscribe(onUpdate: Callback<S, A>) {
        console.log("SUBSCRIBE")
        callback = onUpdate
        update()
    }

    fun unsubscribe() {
        callback = null
    }

    val dispatch: Dispatcher<A> = { action: A ->
        state.let { state = reducer(it, action) }
        update()
    }
}
