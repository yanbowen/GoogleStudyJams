package com.ipc.aidl;

/**
 * Created by yanbowen on 8/1/2017.
 */

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yanbowen on 7/30/2017.
 */

public class Book implements Parcelable {
    private int bookId;
    private int price;
    private String bookName;

    public Book() {
    }

    private Book(Parcel in) {
        bookId = in.readInt();
        price = in.readInt();
        bookName = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(bookId);
        dest.writeInt(price);
        dest.writeString(bookName);
    }

    /**
     * 参数是一个Parcel,用它来存储与传输数据
     *
     * @param dest
     */
    public void readFromParcel(Parcel dest) {
        //注意，此处的读值顺序应当是和writeToParcel()方法中一致的
        bookName = dest.readString();
        price = dest.readInt();
        bookId = dest.readInt();
    }

    public int getBookId() {
        return bookId;
    }

    public int getPrice() {
        return price;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
