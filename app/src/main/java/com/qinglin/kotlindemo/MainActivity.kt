package com.qinglin.kotlindemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var tv_world: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
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
