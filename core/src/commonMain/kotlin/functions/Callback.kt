package functions

fun interface Callback<in T> {
    fun invoke(value: T)
}