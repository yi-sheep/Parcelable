package com.gaoxianglong.parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.gaoxianglong.parcelable.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        event();
    }

    private void event() {
        mBinding.button.setOnClickListener(v -> {
            String name = mBinding.editTextName.getText().toString().trim();
            int math = Integer.parseInt(mBinding.editTextMath.getText().toString().trim());
            int chinese = Integer.parseInt(mBinding.editTextChinese.getText().toString().trim());
            Student student = new Student(name, new Score(math, chinese));
            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
            // 推荐先使用Bundle将数据打包，然后再使用intent传递
            Bundle bundle = new Bundle();
            bundle.putParcelable("student", student);
            intent.putExtra("data", bundle);
//            // 使用Application
//            MyApplication application = (MyApplication) getApplication();
//            application.mStudent = student;
            startActivity(intent);
        });
    }
}
