package com.example.application;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.RemoteException;

import com.example.application.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final IBookManager.Stub mBookBinder = new IBookManager.Stub() {

        @Override
        public List<Book> getBookList() throws RemoteException {
            synchronized ()
        }

        @Override
        public void addBook(Book book) throws RemoteException {

        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}