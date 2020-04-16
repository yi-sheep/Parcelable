package com.gaoxianglong.parcelable;

import android.app.Application;

/**
 * Application可以说是全局类所有的activity都能访问到
 * 如果是在同一个进程中把想要传递是数据放到这个里面，也可以很高效的获取到数据
 * 但是需要在配置文件中的application标签下添加 android:name=".MyApplication"
 * 表示不使用默认的Application而是使用我们继承的子类
 */
public class MyApplication extends Application {
    Student mStudent;
}
