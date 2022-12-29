package functions

fun interface Function1I1R<in T, out R> {
    operator fun invoke(value: T): R
}