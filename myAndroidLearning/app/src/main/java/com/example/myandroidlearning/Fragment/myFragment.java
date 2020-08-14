package com.example.myandroidlearning.Fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myandroidlearning.R;

public class myFragment extends Fragment {
    private TextView my_frag_title;
    private Activity myActivity;
    private String my_title_string;
    private myFragment2 my_Fragment2;
    private Button change_fragment_to2, change_fragment_textView, send_msg_btn;
    private IOMessageClick listerner;
    public myFragment(){
        super();
    }

    //
    public static myFragment newInstance(String title){
        myFragment mf = new myFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",title);
        mf.setArguments(bundle);
        return mf;

    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_fragment, container, false);
        Log.d("MyFragment","oncreated...........");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        my_frag_title = (TextView) view.findViewById(R.id.my_fragment_title);
        change_fragment_to2 = (Button) view.findViewById(R.id.changeFragmentTo2);
        change_fragment_textView = (Button) view.findViewById(R.id.changeFragmentTextView);
        send_msg_btn = (Button) view.findViewById(R.id.send_msg_btn);
        if(getArguments() != null){
            my_frag_title.setText(getArguments().getString("title"));
        }
        change_fragment_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                my_frag_title.setText("我被点击了");
            }
        });
        change_fragment_to2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(my_Fragment2 == null){
                    my_Fragment2 = new myFragment2("我是myFrament2的参数传递(构造函数)");
                }
                Fragment fragment = getFragmentManager().findFragmentByTag("my_Fragment");
                if(fragment != null){
                    getFragmentManager().beginTransaction().hide(fragment).add(R.id.my_fragment_container, my_Fragment2).addToBackStack(null).commitAllowingStateLoss();
                } else{
                    getFragmentManager().beginTransaction().replace(R.id.my_fragment_container,my_Fragment2).addToBackStack(null).commitAllowingStateLoss();
                }

            }
        });
        send_msg_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContainerActivity tmp = (ContainerActivity)getActivity();
                listerner.onClick("你好！");
                //tmp.setData("我是碎片1传过来的");
            }
        });
    }
    public interface IOMessageClick{
        void onClick(String text);
    }
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        //myActivity = (Activity) context;
        try{
            listerner = (IOMessageClick) context;
        }catch (ClassCastException c){
            throw new ClassCastException("Activity 必须实现IOMessageClick接口");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
