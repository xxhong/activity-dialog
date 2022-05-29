package com.minijoy.activitydialogtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout

class DialogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_dialog_layout)
        setWindowTheme();
        overridePendingTransition(R.anim.anim_slide_in_bottom, R.anim.no_anim);
        setFinishOnTouchOutside(true)
        var rlOpt = findViewById<RelativeLayout>(R.id.rlOpt)
        findViewById<Button>(R.id.btFull).setOnClickListener {
            rlOpt.visibility = View.VISIBLE
        }

        findViewById<Button>(R.id.btNormal).setOnClickListener {
//            val currHeight = container.getLayoutParams().height
//            val anim = ValueAnimator.ofInt(currHeight,normalHeight);
//            anim.addUpdateListener { valueAnimator: ValueAnimator ->
//                //获取当前的height值
//                val h = valueAnimator.animatedValue as Int
//                LogUtils.d("height",h)
//                val lp = container.getLayoutParams()
//                lp.height =h
//                container.setLayoutParams(lp)
//            }
//            anim.setDuration(10);
//            //开始动画
//            anim.start();
            rlOpt.visibility = View.GONE
        }
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.no_anim, R.anim.anim_slide_out_bottom);
    }

    private fun setWindowTheme() {
        val window: Window? = this.window
        // 设置弹出位置
        window!!.setGravity(Gravity.BOTTOM)
        // 设置弹出动画
        window.setWindowAnimations(R.style.show_dialog_animStyle)
        // 设置对话框大小
        window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
    }
}