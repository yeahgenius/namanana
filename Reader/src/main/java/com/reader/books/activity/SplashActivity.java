package com.reader.books.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.reader.R;
import com.reader.books.manager.AnimationManager;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getPackageVersion();
        //图片添加动画
        ImageView img = (ImageView) findViewById(R.id.img_splash);
        AnimationManager.showSplashAnimation(this,img);
    }

    /**
     * 获取当前应用的版本号
     */
    private void getPackageVersion() {
        TextView tvVersion = (TextView) findViewById(R.id.tv_app_version);
        PackageManager manager = getPackageManager();
        String packageName = getPackageName();
        try {
            PackageInfo inf = manager.getPackageInfo(packageName,PackageManager.GET_META_DATA);
            tvVersion.setText(inf.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }
}
