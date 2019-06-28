package com.reader.books.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.reader.R;
import com.reader.books.entify.BookSpecies;

import java.util.ArrayList;
import java.util.List;

/**
 * 书店列表适配器
 * Created by Administrator on 2017/6/5.
 */

public class BookShopListAdapter extends BaseAdapter {
    private static final String TAG = "BookShopListAdapter";
    private List<BookSpecies> speciesList = new ArrayList<>();

    public void addBookSpeice(List<BookSpecies> list) {
        if (list != null) {
            speciesList.clear();
        }
        speciesList.addAll(list);
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
//        Log.i(TAG, "getCount: speciesList.size()=" + speciesList.size());
        return speciesList.size();
    }

    @Override
    public BookSpecies getItem(int i) {
        return speciesList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.inflate_book_shop_list, viewGroup, false);
//            Log.i(TAG, "getView: view= "+view);
            viewHolder = new ViewHolder();
            viewHolder.imgName = (ImageView) view.findViewById(R.id.book_species_photo);
            viewHolder.tvCatalog = (TextView) view.findViewById(R.id.book_species_catalog);
            viewHolder.tvNum = (TextView) view.findViewById(R.id.book_species_num);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        BookSpecies bookSpecies = getItem(i);
//        Log.i(TAG, "getView: getItem(i)="+getItem(i));
        viewHolder.imgName.setImageResource(R.mipmap.ic_launcher);
        viewHolder.tvCatalog.setText(bookSpecies.getCatalog());
        viewHolder.tvNum.setText("共1002册");
        return view;
    }

    private class ViewHolder {
        ImageView imgName;
        TextView tvCatalog;
        TextView tvNum;
    }
}
