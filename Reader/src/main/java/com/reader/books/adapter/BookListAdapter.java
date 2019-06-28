package com.reader.books.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reader.R;
import com.reader.books.entify.Book;
import com.reader.books.manager.LoadImageManager;

import java.util.List;

/**
 * 图书列表
 * Created by Administrator on 2017/6/5.
 */

public class BookListAdapter extends MyBaseAdapter<Book> {

    public BookListAdapter(Context context, List<Book> dataSource) {
        super(context, dataSource);
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.inflate_book_list, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imgBook = (ImageView) convertView.findViewById(R.id.book_photo);
            viewHolder.tvBookName = (TextView) convertView.findViewById(R.id.book_name);
            viewHolder.tvBookSub = (TextView) convertView.findViewById(R.id.book_intro);
            viewHolder.tvBookAuthor = (TextView) convertView.findViewById(R.id.book_author);
            viewHolder.tvBookReading = (TextView) convertView.findViewById(R.id.book_read_num);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Book book=getItem(position);
        LoadImageManager.getBitmapWithCache(context,viewHolder.imgBook,book.getImg());
        viewHolder.tvBookName.setText(book.getTitle());
        viewHolder.tvBookSub.setText(book.getSub());
        viewHolder.tvBookAuthor.setText(book.getAuthor());
        viewHolder.tvBookReading.setText(book.getReading());
        return convertView;
    }

    private class ViewHolder {
        ImageView imgBook;
        TextView tvBookName;
        TextView tvBookSub;
        TextView tvBookAuthor;
        TextView tvBookReading;
    }
}
