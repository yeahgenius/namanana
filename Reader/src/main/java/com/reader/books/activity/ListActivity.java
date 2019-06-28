package com.reader.books.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.reader.R;
import com.reader.books.adapter.BookListAdapter;
import com.reader.books.entify.Book;
import com.reader.books.manager.HttpManager;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity{
    private static final String TAG = "ListActivity";
    private int id;
    private String catalog;
    private BookListAdapter adapter;
    private List<Book> books;
    private ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        initActionBar();
        setBookList();

    }

    @Override
    protected void onResume() {
        super.onResume();
        HttpManager.anyscBooks(new HttpManager.LoadBookListener() {
            @Override
            public void onLoadBooksEnd(List<Book> books) {
                adapter.addAll(books, true);
            }
        }, id);
    }

    private void setBookList() {
        list = (ListView) findViewById(R.id.activity_list_view);
        books = new ArrayList<>();
        adapter = new BookListAdapter(this, books);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                TransUtil.setBook(adapter.getItem(position));
                Intent intent = new Intent(ListActivity.this, BookDetailedActivity.class);
//                intent.putExtra("book", book.toString());
                startActivity(intent);
            }
        });
    }

    private void initActionBar() {
        Intent intent = this.getIntent();
        id = intent.getIntExtra("id", 0);
        catalog = intent.getStringExtra("catalog");
        LinearLayout layout = (LinearLayout) findViewById(R.id.activity_action_bar);
        ImageView imgBack = (ImageView) layout.findViewById(R.id.img_back);
        TextView title = (TextView) layout.findViewById(R.id.tv_title);
        title.setText(catalog);
        imgBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
