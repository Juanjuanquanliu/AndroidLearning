package com.example.mvvmlearning.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.mvvmlearning.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountPopupWindow extends PopupWindow {
    private static int WRAP_CONTENT = ViewGroup.LayoutParams.WRAP_CONTENT;

    private Context mContext;

    private OnPopupWindowClickListener mListener;

    private ArrayAdapter mAdapter;

    private List<String> mList = new ArrayList<>();

    private ListView mListView;

    public AccountPopupWindow(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public void initView( ) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.list_accounts, null);
        setContentView(popupView);

        setWidth(WRAP_CONTENT);
        setFocusable(true);
        setOutsideTouchable(true);
        mListView = popupView.findViewById(R.id.accounts_list);
        mList = Arrays.asList();
        mAdapter = new ArrayAdapter(mContext, R.layout.support_simple_spinner_dropdown_item,R.id.pop_item, mList);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                dismiss();
                if (mListener != null) {
                    mListener.onPopupWindowItemClick(position);
                }
            }
        });
    }

    /**
     * Set a callback interface for PopupWindow.
     */
    public void setOnPopupWindowClickListener(OnPopupWindowClickListener listener) {
        mListener = listener;
    }

    /**
     * Callback interface. For external calls.
     */
    public interface OnPopupWindowClickListener {
        /**
         * This method is called when the ListView item of PopupWindow is clicked.
         * The advantage of using a callback method is to reduce the coupling.
         */
        void onPopupWindowItemClick(int position);
    }
}
