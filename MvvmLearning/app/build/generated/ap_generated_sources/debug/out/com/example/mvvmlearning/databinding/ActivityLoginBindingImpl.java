package com.example.mvvmlearning.databinding;
import com.example.mvvmlearning.R;
import com.example.mvvmlearning.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityLoginBindingImpl extends ActivityLoginBinding implements com.example.mvvmlearning.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.down, 5);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener inEmailandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of loginViewModel.userEmail.getValue()
            //         is loginViewModel.userEmail.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(inEmail);
            // localize variables for thread safety
            // loginViewModel != null
            boolean loginViewModelJavaLangObjectNull = false;
            // loginViewModel.userEmail
            androidx.lifecycle.MutableLiveData<java.lang.String> loginViewModelUserEmail = null;
            // loginViewModel.userEmail.getValue()
            java.lang.String loginViewModelUserEmailGetValue = null;
            // loginViewModel
            com.example.mvvmlearning.viewmodel.LoginViewModel loginViewModel = mLoginViewModel;
            // loginViewModel.userEmail != null
            boolean loginViewModelUserEmailJavaLangObjectNull = false;



            loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
            if (loginViewModelJavaLangObjectNull) {


                loginViewModelUserEmail = loginViewModel.getUserEmail();

                loginViewModelUserEmailJavaLangObjectNull = (loginViewModelUserEmail) != (null);
                if (loginViewModelUserEmailJavaLangObjectNull) {




                    loginViewModelUserEmail.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener inPasswordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of loginViewModel.userPassword.getValue()
            //         is loginViewModel.userPassword.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(inPassword);
            // localize variables for thread safety
            // loginViewModel != null
            boolean loginViewModelJavaLangObjectNull = false;
            // loginViewModel.userPassword != null
            boolean loginViewModelUserPasswordJavaLangObjectNull = false;
            // loginViewModel.userPassword.getValue()
            java.lang.String loginViewModelUserPasswordGetValue = null;
            // loginViewModel.userPassword
            androidx.lifecycle.MutableLiveData<java.lang.String> loginViewModelUserPassword = null;
            // loginViewModel
            com.example.mvvmlearning.viewmodel.LoginViewModel loginViewModel = mLoginViewModel;



            loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
            if (loginViewModelJavaLangObjectNull) {


                loginViewModelUserPassword = loginViewModel.getUserPassword();

                loginViewModelUserPasswordJavaLangObjectNull = (loginViewModelUserPassword) != (null);
                if (loginViewModelUserPasswordJavaLangObjectNull) {




                    loginViewModelUserPassword.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public ActivityLoginBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 6, sIncludes, sViewsWithIds));
    }
    private ActivityLoginBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.ImageButton) bindings[5]
            , (android.widget.EditText) bindings[1]
            , (android.widget.EditText) bindings[2]
            , (android.widget.Button) bindings[3]
            , (android.widget.Button) bindings[4]
            );
        this.inEmail.setTag(null);
        this.inPassword.setTag(null);
        this.logIn.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.signUp.setTag(null);
        setRootTag(root);
        // listeners
        mCallback1 = new com.example.mvvmlearning.generated.callback.OnClickListener(this, 1);
        mCallback2 = new com.example.mvvmlearning.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.loginViewModel == variableId) {
            setLoginViewModel((com.example.mvvmlearning.viewmodel.LoginViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setLoginViewModel(@Nullable com.example.mvvmlearning.viewmodel.LoginViewModel LoginViewModel) {
        this.mLoginViewModel = LoginViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.loginViewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeLoginViewModelUserEmail((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeLoginViewModelUserPassword((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeLoginViewModelToastMessage((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeLoginViewModelUserEmail(androidx.lifecycle.MutableLiveData<java.lang.String> LoginViewModelUserEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelUserPassword(androidx.lifecycle.MutableLiveData<java.lang.String> LoginViewModelUserPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeLoginViewModelToastMessage(androidx.lifecycle.MutableLiveData<java.lang.String> LoginViewModelToastMessage, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String loginViewModelToastMessageGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> loginViewModelUserEmail = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> loginViewModelUserPassword = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> loginViewModelToastMessage = null;
        java.lang.String loginViewModelUserPasswordGetValue = null;
        java.lang.String loginViewModelUserEmailGetValue = null;
        com.example.mvvmlearning.viewmodel.LoginViewModel loginViewModel = mLoginViewModel;

        if ((dirtyFlags & 0x1fL) != 0) {


            if ((dirtyFlags & 0x19L) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.userEmail
                        loginViewModelUserEmail = loginViewModel.getUserEmail();
                    }
                    updateLiveDataRegistration(0, loginViewModelUserEmail);


                    if (loginViewModelUserEmail != null) {
                        // read loginViewModel.userEmail.getValue()
                        loginViewModelUserEmailGetValue = loginViewModelUserEmail.getValue();
                    }
            }
            if ((dirtyFlags & 0x1aL) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.userPassword
                        loginViewModelUserPassword = loginViewModel.getUserPassword();
                    }
                    updateLiveDataRegistration(1, loginViewModelUserPassword);


                    if (loginViewModelUserPassword != null) {
                        // read loginViewModel.userPassword.getValue()
                        loginViewModelUserPasswordGetValue = loginViewModelUserPassword.getValue();
                    }
            }
            if ((dirtyFlags & 0x1cL) != 0) {

                    if (loginViewModel != null) {
                        // read loginViewModel.toastMessage
                        loginViewModelToastMessage = loginViewModel.getToastMessage();
                    }
                    updateLiveDataRegistration(2, loginViewModelToastMessage);


                    if (loginViewModelToastMessage != null) {
                        // read loginViewModel.toastMessage.getValue()
                        loginViewModelToastMessageGetValue = loginViewModelToastMessage.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.inEmail, loginViewModelUserEmailGetValue);
        }
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.inEmail, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, inEmailandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.inPassword, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, inPasswordandroidTextAttrChanged);
            this.logIn.setOnClickListener(mCallback1);
            this.signUp.setOnClickListener(mCallback2);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.inPassword, loginViewModelUserPasswordGetValue);
        }
        if ((dirtyFlags & 0x1cL) != 0) {
            // api target 1

            com.example.mvvmlearning.common.AppAdapters.toastMessage(this.logIn, loginViewModelToastMessageGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // loginViewModel != null
                boolean loginViewModelJavaLangObjectNull = false;
                // loginViewModel
                com.example.mvvmlearning.viewmodel.LoginViewModel loginViewModel = mLoginViewModel;



                loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
                if (loginViewModelJavaLangObjectNull) {


                    loginViewModel.onLoginClicked();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // loginViewModel != null
                boolean loginViewModelJavaLangObjectNull = false;
                // loginViewModel
                com.example.mvvmlearning.viewmodel.LoginViewModel loginViewModel = mLoginViewModel;



                loginViewModelJavaLangObjectNull = (loginViewModel) != (null);
                if (loginViewModelJavaLangObjectNull) {


                    loginViewModel.onRegisterClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): loginViewModel.userEmail
        flag 1 (0x2L): loginViewModel.userPassword
        flag 2 (0x3L): loginViewModel.toastMessage
        flag 3 (0x4L): loginViewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}