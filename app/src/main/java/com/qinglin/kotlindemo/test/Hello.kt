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
    fun mParseInt(num:String) = parseInt(num)
//        将函数当作入参
    lock(ReentrantLock(),{hello()})
}

//    private fun hello(name: String) {
//        println("Hello:" + name)
//    }

fun hello():String{
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
    }
    finally {
        lock.unlock()
    }
}

fun parseInt(x:String):Int {
    return x.toInt()
}

