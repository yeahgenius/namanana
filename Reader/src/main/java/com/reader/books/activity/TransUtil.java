package com.reader.books.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.reader.books.entify.Book;

/**
 * Created by Administrator on 2017/6/13.
 */

public class TransUtil {
    private static final String TAG = "TransUtil";
    public static Book book = new Book();

    public static void setBook(Book mbook) {
        book = mbook;
//        Log.i(TAG, "setBook: book="+book.toString());
    }

    public static Book getBook() {
        return book;
    }
}
