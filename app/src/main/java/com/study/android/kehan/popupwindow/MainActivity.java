package com.study.android.kehan.popupwindow;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

/**
 * Created by kehan on 16-6-22.
 */
public class MainActivity extends Activity {

    private Context context;
    private View contentView;
    private PopupWindow popupWindow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        context = this;
        contentView = LayoutInflater.from(context).inflate(R.layout.pop_layout, null);
        Button button1 = (Button) findViewById(R.id.popup1);
        Button button2 = (Button) findViewById(R.id.popup2);
        Button button3 = (Button) findViewById(R.id.popup3);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contructPopupWindow4();
                popupWindow.showAtLocation(view, Gravity.BOTTOM|Gravity.LEFT, 0, 0);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "button2被点击", Toast.LENGTH_SHORT).show();
            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, "button3被点击", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void contructPopupWindow1() {
        popupWindow = new PopupWindow();
        //设置页面布局
        popupWindow.setContentView(contentView);
        //设置高度和宽度
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    private void contructPopupWindow2() {
        popupWindow = new PopupWindow(contentView);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    private void contructPopupWindow3() {
        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
    }

    private void contructPopupWindow4() {
        popupWindow = new PopupWindow(contentView,
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT, false);
    }

    private void showPopupWindow(View view) {
        popupWindow.showAsDropDown(view);
    }
}

/**
 * showAtLocation的四个参数的含义
 * view 一个用于获取窗口的view，只要是能获得窗口的view都可以，形参命名为parent令人困惑
 * gravity 控件的位置
 *
 * Gravity.CENTER,Gravity.CENTER_HORIZONTAL,Gravity.CENTER_VERTICAL 既水平居中又竖直居中
 * Gravity.BOTTOM 处于屏幕底部并水平居中
 * Gravity.TOP,Gravity.FILL_VERTICAL 处于屏幕顶部并水平居中
 * Gravity.LEFT,Gravity.FILL_HORIZONTAL 处于屏幕左边并竖直居中
 * Gravity.RIGHT 处于屏幕右边并竖直居中
 * 如果需要处于左上方，写成Gravity.TOP|Gravity.LEFT
 *
 * x 横轴上的偏移量，正值向右，负值向左
 * y 纵轴上的偏移量，正值向上，负值向下
 * 如果位置不在屏幕中会直接被切掉
 */
