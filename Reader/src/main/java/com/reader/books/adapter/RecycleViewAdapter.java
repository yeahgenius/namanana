package com.reader.books.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.reader.R;
import com.reader.books.entify.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by john on 2017/5/30.
 */

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.InnerViewHolder> {
    private List<Book> books;
    private Context context;

    public RecycleViewAdapter(Context context) {
        this.context = context;
        books = new ArrayList<>();
    }
    public void AddBookList(List<Book> list){
        if (books!=null){
            books.clear();
        }
        books.addAll(list);
        notifyDataSetChanged();
    }

    class InnerViewHolder extends RecyclerView.ViewHolder {
        ImageView bookPhoto;
        TextView bookName;

        public InnerViewHolder(View itemView) {
            super(itemView);
            bookPhoto = (ImageView) itemView.findViewById(R.id.img_book_photo);
            bookName = (TextView) itemView.findViewById(R.id.tv_book_name);
        }
    }

    @Override
    public InnerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inflate_card_view, parent, false);
        return new InnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InnerViewHolder holder, int position) {
        Book book=books.get(position);
        if (book.getImg1()==0) {
//            holder.bookPhoto.setMaxWidth(90);
//            holder.bookPhoto.setMaxHeight(120);
            holder.bookPhoto.setScaleType(ImageView.ScaleType.FIT_XY);
            holder.bookPhoto.setImageResource(R.mipmap.ic_wu);
        }else{
//            holder.bookPhoto.setMaxWidth(90);
//            holder.bookPhoto.setMaxHeight(90);
            holder.bookPhoto.setScaleType(ImageView.ScaleType.CENTER);
            holder.bookPhoto.setImageResource(book.getImg1());
        }
        holder.bookName.setText(book.getTitle());
    }


    @Override
    public int getItemCount() {
        return books.size();
    }
}
