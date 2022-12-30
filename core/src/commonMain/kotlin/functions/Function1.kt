package functions

fun interface Function1<in T, out R> {
    operator fun invoke(value: T): R
}