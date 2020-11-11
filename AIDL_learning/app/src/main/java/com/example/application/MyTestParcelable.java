package com.example.application;

import android.os.Parcel;
import android.os.Parcelable;

public class MyTestParcelable implements Parcelable {
    public int userId;
    public String userName;
    public boolean isMale;

    public Book book;

    public MyTestParcelable(int userId, String userName, boolean isMale) {
        this.userId = userId;
        this.userName = userName;
        this.isMale = isMale;
    }

    protected MyTestParcelable(Parcel in) {
        userId = in.readInt();
        userName = in.readString();
        isMale = in.readByte() != 0;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(userId);
        parcel.writeString(userName);
        parcel.writeBoolean(isMale);
        parcel.writeParcelable(book, 0);
    }

    public static final Creator<MyTestParcelable> CREATOR = new Creator<MyTestParcelable>() {
        @Override
        public MyTestParcelable createFromParcel(Parcel in) {
            return new MyTestParcelable(in);
        }

        @Override
        public MyTestParcelable[] newArray(int size) {
            return new MyTestParcelable[size];
        }
    };

}
