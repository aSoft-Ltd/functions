package functions

expect fun interface Consumer<T> {
    fun accept(value: T)
}