package functions

fun interface Callback<in T> {
    operator fun invoke(value: T)
}