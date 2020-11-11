package com.example.application;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {
    public String bookName;
    public String author;
    public int pages;
    public double price;

    protected Book(Parcel in) {
        bookName = in.readString();
        author = in.readString();
        pages = in.readInt();
        price = in.readDouble();
    }

    public String getBookName() {
        return bookName;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    public Book(String bookName) {
        this.bookName = bookName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bookName);
        parcel.writeString(author);
        parcel.writeInt(pages);
        parcel.writeDouble(price);
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

}
