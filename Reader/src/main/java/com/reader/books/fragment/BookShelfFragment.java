package com.reader.books.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.reader.R;
import com.reader.books.adapter.RecycleViewAdapter;
import com.reader.books.entify.Book;
import com.reader.books.manager.HttpManager;

import java.util.ArrayList;
import java.util.List;

/**
 * 书架
 * A simple {@link Fragment} subclass.
 */
public class BookShelfFragment extends BaseFragment {
    private List<Book> booksList;
    private RecycleViewAdapter adapter;

    public BookShelfFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        contentView = inflater.inflate(R.layout.fragment_book_shelf, container, false);
        showActionBar();
        setRecycleView();
        refreshList();
        return contentView;
    }

    private void refreshList() {
        booksList = new ArrayList<>();
        Book book = new Book(R.mipmap.txt, "本地书籍");
        booksList.add(0, book);
        book=new Book(R.mipmap.add,"添加书籍");
        booksList.add(booksList.size(),book);
        adapter.AddBookList(booksList);
    }

    private void setRecycleView() {
        RecyclerView recycleView = (RecyclerView) contentView.findViewById(R.id.book_shelf_grid_view);
        GridLayoutManager manager = new GridLayoutManager(getContext(), 3);
//        manager.setSpanSizeLookup();
        adapter = new RecycleViewAdapter(getContext());
        recycleView.setLayoutManager(manager);
        recycleView.setAdapter(adapter);
    }

    @Override
    protected void showActionBar() {
        actionBar = (LinearLayout) contentView.findViewById(R.id.book_shelf_action_bar);
        initActionBar(R.mipmap.ic_contact, R.mipmap.ic_menu_delete);

//        ImageView userPhoto = (ImageView) actionBar.findViewById(R.id.img_user_photo);
//        TextView search = (TextView) actionBar.findViewById(R.id.tv_search);
        ImageView delected = (ImageView) actionBar.findViewById(R.id.img_right);

        //添加监听
        delected.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getActivity(),SearchFragment.class);
                Toast.makeText(getActivity(), "批量删除", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
