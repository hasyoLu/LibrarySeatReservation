package com.example.libraryseatreservation.ui.home;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SearView extends ViewGroup {
    private Context context;
    public SearView(@NonNull Context context) {
        super(context);
    }

    public SearView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context=getContext();
    }

    public SearView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    }
    private ArrayList<ResultBean> mlist;
    public void setData(ArrayList<ResultBean> list){
        this.mlist = list;
        invalidate();
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mlist != null && mlist.size() > 0) {
            for (int i = 0; i < mlist.size(); i++) {
                ResultBean resultBean = mlist.get(i);
                resultBean.draw(canvas,context);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:

                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:

                float x = event.getX();
                float y = event.getY();
                completeByXY(x,y);
                break;
        }
        return true;
    }
    public void completeByXY(float x,float y){
        for (int i=0;i<mlist.size();i++){
            ResultBean resultBean1 = mlist.get(i);
            int left = resultBean1.getLeft();
            int right = resultBean1.getRight();
            int bottom = resultBean1.getBottom();
            int top = resultBean1.getTop();
            if (x>=left&&x<right&&y>=top&&y<=bottom){
                clickedSeat.clickedSeat(resultBean1);
                int status = resultBean1.getStatus();
                if (status==1){
                    status=3;
                    resultBean1.setStatus(status);
                }else if (status==3){
                    status=1;
                    resultBean1.setStatus(status);
                }
                break;
            }
        }
        postInvalidate();
    }
    public interface ClickedSeat{
        void clickedSeat(ResultBean resultBean);
    }
    private ClickedSeat clickedSeat;

    public void setClickedSeat(ClickedSeat clickedSeat) {
        this.clickedSeat = clickedSeat;
    }
}
