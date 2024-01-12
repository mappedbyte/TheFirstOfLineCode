package com.francis.first
//Kotlin中委托使用的关键字是by，我们只需要在接口声明的后面使用by关键字，再接上受委托
//的辅助对象，就可以免去之前所写的一大堆模板式的代码了
class MySet<T>(private val helperSet:HashSet<T>):Set<T> by helperSet{
  /*  override val size: Int
        get() = helperSet.size
    override fun contains(element: T) = helperSet.contains(element)
    override fun containsAll(elements: Collection<T>) = helperSet.containsAll(elements)
    override fun isEmpty() = helperSet.isEmpty()
    override fun iterator() = helperSet.iterator()*/
  fun helloWorld() = println("Hello World")
    override fun isEmpty() = false
}