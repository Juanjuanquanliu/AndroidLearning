package com.example.myandroidlearning.Fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myandroidlearning.R;

public class twoPartFragmentActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_part_fragment);
        Button btn = (Button) findViewById(R.id.left_fragment_btn);
        btn.setOnClickListener(this);
        replaceFragment(new rightFragment());

    }
    public void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.right_frame_layout, fragment);
        transaction.commitAllowingStateLoss();
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.left_fragment_btn:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }
}