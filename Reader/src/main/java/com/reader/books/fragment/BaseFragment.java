package com.reader.books.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.reader.R;
import com.reader.books.manager.ImageManager;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener {

    protected LinearLayout actionBar;
    protected View contentView;
    private Bitmap photo;

    public BaseFragment() {
        // Required empty public constructor
        super();
    }


    /**
     * 显示actionBar
     *
     * @param leftId  左边的图片
     * @param rightId 右边的图片
     */
    public void initActionBar(int leftId, int rightId) {
        if (actionBar == null)
            return;
        ImageView userPhoto = (ImageView) actionBar.findViewById(R.id.img_user_photo);
        TextView title= (TextView) actionBar.findViewById(R.id.tv_search);
        ImageView search = (ImageView) actionBar.findViewById(R.id.img_right);

        if (leftId > 0) {
//            userPhoto.setVisibility(View.VISIBLE);
            photo = BitmapFactory.decodeResource(getResources(), leftId);
        } else {
            photo = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_contact);
//            userPhoto.setVisibility(View.INVISIBLE);
        }
        photo = ImageManager.getCircleImage(getActivity(), photo);
        userPhoto.setImageBitmap(photo);
        if (rightId > 0) {
            search.setVisibility(View.VISIBLE);
            search.setImageResource(rightId);
        } else {
            search.setVisibility(View.INVISIBLE);
        }
        //为标题栏中不变的内容添加监听
        userPhoto.setOnClickListener(this);
        title.setOnClickListener(this);
    }

    protected abstract void showActionBar();


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.img_user_photo:
                Toast.makeText(getActivity(), "登录", Toast.LENGTH_SHORT).show();
                break;
            case R.id.tv_search:
                Toast.makeText(getActivity(), "查询", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
