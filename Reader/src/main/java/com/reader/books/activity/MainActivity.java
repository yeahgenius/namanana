package com.reader.books.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.reader.R;
import com.reader.books.adapter.ViewPagerAdapter;
import com.reader.books.fragment.BookShelfFragment;
import com.reader.books.fragment.FoundFragment;
import com.reader.books.fragment.HomeFragment;
import com.reader.books.fragment.RecommandFragment;
import com.reader.books.manager.ImageManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    /**
     * 登录标志，登录为true
     */
    public static final boolean loginFlag = false;

    private ViewPager pager;
    private RadioGroup group;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化主建面
        initView();
        //设置监听
        setClickListener();
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        //得到NavigationView的头部
        View view = navigationView.getHeaderView(0);
//        Log.i(TAG, "onCrea/te: view--"+view);
        //侧滑头部背景图片
        ImageView drawableHeaderBg = (ImageView) view.findViewById(R.id.drawable_header_bg);
        //给背景图片设置上下移动动画

        //侧滑头部用户头像和用户名
        ImageView userPhoto = (ImageView) view.findViewById(R.id.user_photo);
        TextView userName = (TextView) view.findViewById(R.id.user_name);
        Bitmap photo;
        if (loginFlag) {

        } else {
            photo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_contact);
            userName.setText("未登录");
        }
        photo = ImageManager.getCircleImage(this, photo);
        userPhoto.setImageBitmap(photo);
    }

    /**
     * 初始化
     */
    private void initView() {
        LinearLayout layout = (LinearLayout) findViewById(R.id.main_bottom_radio_button);
        pager = (ViewPager) layout.findViewById(R.id.main_view_pager);
        group = (RadioGroup) layout.findViewById(R.id.main_radio_group);

        //准备数据
        List<Fragment> list = new ArrayList<>();
        list.add(new BookShelfFragment());
        list.add(new RecommandFragment());
        list.add(new HomeFragment());
        list.add(new FoundFragment());
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
        pager.setAdapter(adapter);
    }

    /**
     * 设置监听
     */
    private void setClickListener() {
        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {//i为选中的button的id
                RadioButton button = (RadioButton) radioGroup.findViewById(i);
                int position = radioGroup.indexOfChild(button);
                pager.setCurrentItem(position, false);
//                Log.i(TAG, "onCheckedChanged: position-->" + position);
            }
        });
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                RadioButton button = (RadioButton) group.getChildAt(position);
                button.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
