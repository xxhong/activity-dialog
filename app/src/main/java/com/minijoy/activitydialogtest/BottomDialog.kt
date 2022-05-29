package com.minijoy.activitydialogtest

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout



class BottomDialog(context: Context, themeResId: Int=R.style.bottom_dialog_bg_style) :
    Dialog(context, themeResId) {
     var normalHeight:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bottom_dialog_layout);
        setWindowTheme();
        setCancelable(true);
        setCanceledOnTouchOutside(true);
        var container =  findViewById<LinearLayout>(R.id.container)
        var rlOpt =  findViewById<RelativeLayout>(R.id.rlOpt)
        normalHeight =  container.getLayoutParams().height
        findViewById<Button>(R.id.btFull).setOnClickListener {
            rlOpt.visibility = View.VISIBLE
        }

        findViewById<Button>(R.id.btNormal).setOnClickListener {

            rlOpt.visibility = View.GONE
        }
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