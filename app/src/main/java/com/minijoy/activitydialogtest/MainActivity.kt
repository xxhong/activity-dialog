package com.minijoy.activitydialogtest

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.blankj.utilcode.util.Utils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.init(this@MainActivity.application)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btTest).setOnClickListener {
           BottomDialog(this@MainActivity).show()
        }
        findViewById<Button>(R.id.btTest2).setOnClickListener {
            startActivity(Intent(this@MainActivity,DialogActivity::class.java))
        }
    }


}