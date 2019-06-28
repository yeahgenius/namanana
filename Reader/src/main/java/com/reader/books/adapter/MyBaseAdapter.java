package com.reader.books.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by huangye on 2017/6/15.
 */

public abstract class MyBaseAdapter<T> extends BaseAdapter {

    Context context;
    List<T> dataSource;
    LayoutInflater inflater;

    public MyBaseAdapter(Context context, List<T> dataSource) {
        super();
        this.context = context;
        this.dataSource = dataSource;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public T getItem(int position) {
        return dataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getItemView(position, convertView, parent);
    }

    public abstract View getItemView(int position, View convertView, ViewGroup parent);

    public void addAll(List<T> list,boolean flag){
        if(flag){
            dataSource.clear();
        }
        dataSource.addAll(list);
        notifyDataSetChanged();
    }

    public void remove(T t){
        dataSource.remove(t);
        notifyDataSetChanged();
    }
}