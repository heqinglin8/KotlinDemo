package com.qinglin.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import java.io.StringReader

class MainActivity : AppCompatActivity(), View.OnClickListener {
    val TAG = "hql"
    private var tv_world: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        test()

        test2()
    }

    private fun test2(){
      Log.e(TAG,max(5,8).toString())
    }

    private fun max(a:Int,b:Int):Int{
//        if(a>b){
//            return a
//        }else{
//            return b
//        }
        //由于支持这种简便写法，所以，koltin没有三元二次表达式
        return if(a>b) a else b
    }

    private  fun test(){
        print(sum(2,3))
        Log.e(TAG,"hql")
        Log.e(TAG,sum(2,3).toString())


        var a: Int = 1000
        Log.e(TAG,(a === a).toString())

        //当我们需要变大一个可为null的引用时，就不能使用基本类型了，这种情况下装箱为数值对象
        //注：装箱不包吃对象的同一性，
        val boxA :Int? = a  //可为null
        val boxB :Int? = a  //可为null

        Log.e(TAG,(boxA === boxB).toString())  //对象不相等

        Log.e(TAG,(boxA == boxB).toString())  //装箱会保持内容对象相等

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

        f = f+1
        f++
        f+=2
        Log.e(TAG,(f+1).toString())

        //字符串模版的运用
        val arr1 = arrayOf("你妹","你大爷","就是我")

        for (str in arr1){
            Log.e(TAG,"我就是:${str}")
        }
        val name : String = "令狐冲"
        tv_world!!.text = "我就是${name}"
    }

    private fun sum(a :Int,b:Int):Int{
        return a+b
    }

    private fun initView() {
        tv_world = findViewById(R.id.tv_world) as TextView

        tv_world!!.setOnClickListener(this)
        val tv_world2 = findViewById(R.id.tv_world2) as TextView
        tv_world2.setOnClickListener { tv_world!!.text = "tv_world2" }
    }

    override fun onClick(v: View) {
        when (v.id) {
            R.id.tv_world -> tv_world!!.text = "何清林"
        }
    }
}
