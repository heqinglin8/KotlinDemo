package com.qinglin.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import java.util.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG = "hql"
    private var tv_world: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        test()
        test2()
        testNull()
        test3()
    }

    private fun test3(){
        var i:Int = 1

        var b:Byte = i.toByte()

        println(b)

        println("int:"+charConvertInt('9'))

        //16进制按位置取反
        var g = 0x000FF000
         g = g.inv()
        println(g)

        // 二进制

        var h = 0b111
        h = h.inv()
        println(h)

        val x: IntArray = intArrayOf(1, 2, 3)

        x[0] = x[0] + x.get(1)+x.get(2)
        println(x.get(0))

        //字符串

        val str = "afdfgfghfghgfh"
        for (c in str){
            println(c)
        }
    }

    private fun charConvertInt(c:Char):Int{
        if(c !in '0'..'9'){
           throw IllegalArgumentException("out of range")
        }

        return c.toInt() - '0'.toInt()
    }
    private fun testNull() {
        printPrice("8", "24")
        printPrice2("24","8")
        //正确：自动检测变量类型
        var list = listOf("何某某", null)
        println("size:" + list.size)
        //错误：检测到类型为空，不能引用到size
//        var list = null
//        println("size:" + list.size)

        for (entity in list){
            println(entity)
            //判断类型后不用强转
            if(entity is String){
                println(entity.length)
            }
        }
    }

    private fun printPrice(arg1: String, arg2: String) {
        var x = parseInt(arg1)
        var y = parseInt(arg2)
        //直接进行可能null的运算，编译不过去
//        println(x*y)

        //需要强制判断，才能编译过去，如下：（在编译期就避免空指针）
        if (x != null && y != null) {
            println(x * y)
        }
    }

    private fun printPrice2(arg1: String, arg2: String) {
        var x = parseInt(arg1)
        var y = parseInt(arg2)
        //直接进行可能null的运算，编译不过去
//        println(x*y)
        //只判断一个也不能编译过去
//        if (x == null) {
//            return
//        }
//        println(x * y)

        //需要强制判断，才能编译过去，如下：（在编译期就避免空指针）
        if (x == null) {
            return
        }
        if (y == null) {
            return
        }
        println(x * y)
    }

    fun parseInt(str: String): Int? {
        try {
            return str.toInt()
        } catch (e: Exception) {
            return null
        }
    }

    private fun test2() {
        Log.e(TAG, max(5, 8).toString())

        //创建一个对象，不用new
        val g = Greeter("丁彦雨航")
        g.greet()
    }


    class Greeter(val name: String) {
        val TAG = "hql"
        fun greet() {
            println(TAG + ":Hello, $name")
        }
    }


    private fun max(a: Int, b: Int): Int {
//        if(a>b){
//            return a
//        }else{
//            return b
//        }
        //由于支持这种简便写法，所以，koltin没有三元二次表达式
        return if (a > b) a else b
    }

    private fun test() {
        println(TAG + ":" + sum(2, 3))
        Log.e(TAG, "hql")
        Log.e(TAG, sum(2, 3).toString())


        var a: Int = 1000
        Log.e(TAG, (a === a).toString())

        //当我们需要变大一个可为null的引用时，就不能使用基本类型了，这种情况下装箱为数值对象
        //注：装箱不包吃对象的同一性，
        val boxA: Int? = a  //可为null
        val boxB: Int? = a  //可为null

        Log.e(TAG, (boxA === boxB).toString())  //对象不相等

        Log.e(TAG, (boxA == boxB).toString())  //装箱会保持内容对象相等

        //以下为假想代码, 实际上是无法编译的:
//        val c:Int? = 1 // 装箱为int类型
//
//        val d:Long? = c //Long
//
//        Log.e(TAG,(c == d).toString())  //false,因为 Long 的 equals() 方法会检查比较对象, 要求对方也是一个 Long 对象
        //val定义的变量只读，不可修改
//        val e = 1
//        e=e+1
//        Log.e(TAG,(e+1).toString())

        //var定义的变量时可变变量
        var f = 2

        f = f + 1
        f++
        f += 2
        Log.e(TAG, (f + 1).toString())

        //字符串模版的运用
        val arr1 = arrayOf("你妹", "你大爷", "就是我")

        for (str in arr1) {
            Log.e(TAG, "我就是:${str}")
        }
    }

    private fun sum(a: Int, b: Int): Int {
        return a + b
    }

    private fun initView() {
        tv_world = findViewById(R.id.tv_world) as TextView
        tv_world!!.setOnClickListener(this)
        //字符模板的运用
        val name: String = "令狐冲"
        val tv_world2 = findViewById(R.id.tv_world2) as TextView
        tv_world2.text = "我就是${name}"
        tv_world2.setOnClickListener { tv_world!!.text = "tv_world2" }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_world -> tv_world!!.text = "何清林"
        }
    }
}
