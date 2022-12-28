package functions

fun interface Function1IO<in T, out R> {
    fun invoke(value: T): R
}