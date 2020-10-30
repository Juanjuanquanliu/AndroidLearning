package com.example.mvvmlearning.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.mvvmlearning.R;

public class AccountSpinner extends LinearLayout {
    private static final  String TAG = "AccountSpinner";

    /**
     * PopupWindow margin end.
     */
    private static final int MARGIN_END = 208;

    /**
     * PopupWindow margin end.
     */
    private static final int MARGIN_BOTTOM = 110;

    /**
     * Array index.
     * An array of length 2 is used to store the returned width and height,
     * which determine where popupwindow appear on the screen.
     * The subscript is 0 for the width and the subscript is 1 for the height.
     */
    public static final int SIZE = 2;

    public static final int HEIGHT = 1;

    private CharSequence[] mArray;
    private ImageButton mImageButton;
    private int mPosition;

    private AccountPopupWindow mAccountPopupWindow;
    private OnSpinnerStatusListener mOnSpinnerStatusListener;

    public AccountSpinner(Context context) {
        this(context, null);
    }

    public AccountSpinner(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        if (attrs != null){
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.AccountSpinner);
        mPosition = typedArray.getInt(R.styleable.AccountSpinner_accountPosition, 0);
        typedArray.recycle();
        }
        initView(context);
    }

    private void initView(Context context) {
        View rootView = LayoutInflater.from(context).inflate(R.layout.item_spinner, this);
        mImageButton = rootView.findViewById(R.id.down);
        mImageButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                int[] windowPos = calculatePopWindowPos(view);
                if (mOnSpinnerStatusListener != null) {
                    mOnSpinnerStatusListener.onShowSpinner(mAccountPopupWindow);
                }
                mAccountPopupWindow.showAtLocation(view, Gravity.TOP | Gravity.END, MARGIN_END, windowPos[HEIGHT]);
            }
        });
        mAccountPopupWindow = new AccountPopupWindow(context, mArray);
        mAccountPopupWindow.setOnPopupWindowClickListener(new AccountPopupWindow.OnPopupWindowClickListener() {
            @Override
            public void onPopupWindowItemClick(int position) {
                setPosition(position);
            }
        });
        mAccountPopupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                if (mOnSpinnerStatusListener != null) {
                    mOnSpinnerStatusListener.onDismissSpinner(mAccountPopupWindow);
                }
            }
        });
        setPosition(mPosition);
    }

    /**
     * Used to prevent controls within the layout from getting events.
     */
    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return true;
    }

    /**
     * Set switch check state.
     */
    public void setPosition(int position) {
        mPosition = position;
//        mItemOnDisplay.setText(mArray[position]);
    }

    /**
     * Get position.
     */
    public int getPosition() {
        return mPosition;
    }

    /**
     * Add listener to show spinner.
     *
     * @param listener listener
     */

    public void setOnSpinnerStatusListener(OnSpinnerStatusListener listener) {
        mOnSpinnerStatusListener = listener;
    }

    /**
     * Determine popup windows popup location.
     */
    private static int[] calculatePopWindowPos(final View contentView) {
        final int[] windowPos = new int[SIZE];
        final int[] anchorLoc = new int[SIZE];

        contentView.getLocationOnScreen(anchorLoc);
        final int anchorHeight = contentView.getHeight();

        //Get the height and width of the screen.
        final int screenHeight = contentView.getContext().getResources()
                .getDisplayMetrics().heightPixels;
        contentView.measure(View.MeasureSpec.UNSPECIFIED, View.MeasureSpec.UNSPECIFIED);

        // Calculate the height and width of the contentView.
        final int windowHeight = contentView.getMeasuredHeight();

        windowPos[HEIGHT] = (screenHeight - anchorLoc[HEIGHT] - anchorHeight < windowHeight)
                ? (windowPos[HEIGHT] = anchorLoc[HEIGHT] - windowHeight - MARGIN_BOTTOM)
                : (windowPos[HEIGHT] = anchorLoc[HEIGHT] + anchorHeight - MARGIN_BOTTOM);

        return windowPos;
    }

    /**
     * Dismiss spinner.
     */
    public void dismissSpinner() {
        if (mAccountPopupWindow != null) {
            mAccountPopupWindow.dismiss();
        }
    }

    @Override
    public void setVisibility(int visibility) {
        super.setVisibility(visibility);
        Log.d(TAG, "setVisibility");
        if (!(visibility == VISIBLE)) {
            dismissSpinner();
        }
    }

    public interface OnSpinnerStatusListener {
        void onShowSpinner(AccountPopupWindow popupWindow);

        void onDismissSpinner(AccountPopupWindow popupWindow);
    }
}
