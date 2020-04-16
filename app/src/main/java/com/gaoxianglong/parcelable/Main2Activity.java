package com.gaoxianglong.parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.gaoxianglong.parcelable.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {

    private ActivityMain2Binding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main2);
        event();
    }

    private void event() {
        Intent intent = getIntent();
        Bundle data = intent.getBundleExtra("data");
        if (data != null) {
            Student student = data.getParcelable("student");
            if (student != null) {
                mBinding.textViewName.setText(student.getName());
                mBinding.textViewMath.setText(String.valueOf(student.getScore().getMath()));
                mBinding.textViewChinese.setText(String.valueOf(student.getScore().getChinese()));
            }
        }
        // 目前还只是activity之间传递，在配置文件中的第二个activity中加入属性android:process=":new"表示这个activity将会开启一个名叫new的进程并在其中运行
        // 这样你会发现，数据还是传递成功了
        // 从我们自己定义的Application中获取数据
//        MyApplication application = (MyApplication) getApplication();
//        mBinding.textViewName.setText(application.mStudent.getName());
//        mBinding.textViewMath.setText(String.valueOf(application.mStudent.getScore().getMath()));
//        mBinding.textViewChinese.setText(String.valueOf(application.mStudent.getScore().getChinese()));
        // 虽然这样很高效 但是破坏了模块化的概念，如果是不同的进程就传递不了
    }
}
