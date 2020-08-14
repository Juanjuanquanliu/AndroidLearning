package com.example.myandroidlearning.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myandroidlearning.R;

public class myFragment2 extends Fragment {
    private TextView my_frag_title;
    private String my_title_string;
    public myFragment2(){
        super();
    }
    //两种进行传参的方式
    public myFragment2(String title){
        my_title_string = title;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment2, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        my_frag_title = view.findViewById(R.id.my_fragment_title2);
        if(my_title_string != null) my_frag_title.setText(my_title_string);
    }
}
