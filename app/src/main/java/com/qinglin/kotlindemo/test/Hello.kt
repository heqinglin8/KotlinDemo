package com.qinglin.kotlindemo.test

import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

/**
 * Created by heqinglin8 on 17/7/12.
 */

fun main(args: Array<String>) {
    //方法赋值变量调用
//        hello("何清林")
//        fun sayhello(name:String) = hello(name)
//        sayhello("李寻欢")
    fun mParseInt(num: String) = parseInt(num)
//        将函数当作入参
    lock(ReentrantLock(), { hello() })

    //Lambda 表达式的用法
    var ints = listOf(1, 2, 3, 4, 5, 6)
    var intsSquare = ints.map { x -> x * x }
    println(intsSquare)
    //注意,如果一个函数字面值(function literal)只有唯一一个参数, 那么这个参数的声明可以省略(-> 也可以一起省略), 参数声明省略后, 将使用默认名称 it
    var ints2 = ints.map { it * it }
    println(ints2)
    //过滤
    var ints3 = ints.filter { it%2 == 0 }
    println(ints3)

    //map的迭代
    var map = mapOf("淘宝" to "马云","腾讯" to "马化腾","百度" to "李彦宏")
    for((key,value) in map){
        println("企业：${key},创始人：${value}")
    }
    println(map.get("腾讯"))
}

//    private fun hello(name: String) {
//        println("Hello:" + name)
//    }

fun hello(): String {
    println("Hello")
    return "hello"
}

/**
 * 高阶函数|指的是将函数当作入参或返回值的函数
 */
fun <T> lock(lock: Lock, body: () -> T): T {
    lock.lock()
    try {
        return body()
    } finally {
        lock.unlock()
    }
}

fun parseInt(x: String): Int {
    return x.toInt()
}

