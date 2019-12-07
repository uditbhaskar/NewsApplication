package com.saharsh.newsfeed.Fragments;


import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;


public class BaseDialogFragment extends DialogFragment {

    Typeface MR, MRR;
    protected int percent;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        getDialog().setCanceledOnTouchOutside(false);
        /*getDialog().getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;*/
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setPercent();
    }

    protected void setPercent(){
        percent = 100;
    }

    @Override
    public void onStart() {

        super.onStart();

        MR = Typeface.createFromAsset(getActivity().getAssets(), "fonts/myriad.ttf");
        MRR = Typeface.createFromAsset(getActivity().getAssets(), "fonts/myriadregular.ttf");

        Window window = getDialog().getWindow();
        WindowManager.LayoutParams windowParams = window.getAttributes();
        windowParams.dimAmount = 0.50f;
        window.setAttributes(windowParams);
    }

    public void onResume() {

        super.onResume();
        WindowManager.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = (getWidth(getContext()) / 100) * percent;
        params.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
        params.gravity = Gravity.CENTER;
        getDialog().getWindow().setAttributes(params);



    }

    public static int getWidth(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowmanager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        windowmanager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

}