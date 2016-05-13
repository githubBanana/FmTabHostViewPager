package com.xs.fmtabhostviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;
import com.nineoldandroids.view.ViewHelper;
import com.xs.fmtabhostviewpager.R;

/**
 * @version V1.0 <描述当前版本功能>
 * @author: Xs
 * @date: 2016-05-12 10:26
 * @email Xs.lin@foxmail.com
 */
public class ThreeFragment extends Fragment {
    private static final String TAG = "ThreeFragmetn";

    private View mTouchView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.e(TAG,"onCreateView");
        return inflater.inflate(R.layout.fragment_tab3_layout,container,false);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG,"onCreate");

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.e(TAG,"onViewCreated");
        mTouchView = view.findViewById(R.id.view_touchId);
        mTouchView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    touch();
                }
                return true;
            }
        });
    }

    private void touch() {
        //设置中心点为中间点
        /*ViewHelper.setPivotX(mTouchView, mTouchView.getWidth() / 2f);
        ViewHelper.setPivotY(mTouchView, mTouchView.getHeight() / 2f);*/
        //1.创建动画集
        AnimatorSet set = new AnimatorSet();
        //2.添加动画
        set.setupEndValues();
        set.playTogether(
                ObjectAnimator.ofFloat(mTouchView, "scaleX", 2, 1.5f, 1).setDuration(1000),
                ObjectAnimator.ofFloat(mTouchView, "scaleY", 2, 1.5f, 1).setDuration(1000),
                ObjectAnimator.ofFloat(mTouchView, "alpha", 0, 1).setDuration(1000 * 3 / 2));
        //3.开启动画
        set.start();
    }
    @Override
    public void onStart() {
        super.onStart();
        Log.e(TAG,"onStart");

    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG,"onResume");

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e(TAG,"onPause");

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e(TAG,"onStop");

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e(TAG,"onDestroyView");

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG,"onDestroy");

    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e(TAG,"onDetach");

    }
}
