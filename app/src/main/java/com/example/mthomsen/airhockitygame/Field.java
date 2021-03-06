package com.example.mthomsen.airhockitygame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by MThomsen on 18-06-2015.
 */
public class Field extends View {
    private View mFrame;
    private Paint mPaint;
    private int scoreTop = 0;
    private int scoreBot = 0;
    private int topWins = 0;
    private int botWins = 0;

    public Field(Context context, View mFrame) {
        super(context);
        mPaint = new Paint();
        this.mFrame = mFrame;

    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {

        mPaint.setColor(Color.YELLOW);
        //right
        canvas.drawRect(mFrame.getLeft(), mFrame.getTop(), mFrame.getLeft() + 10, mFrame.getBottom(), mPaint);

        //left
        canvas.drawRect(mFrame.getRight() - 10, mFrame.getTop(), mFrame.getRight(), mFrame.getBottom(), mPaint);

        //top
        canvas.drawRect(mFrame.getLeft(), mFrame.getTop(), (mFrame.getRight()/2)-100, mFrame.getTop()+10, mPaint);
        canvas.drawRect((mFrame.getRight() / 2) + 100, mFrame.getTop(), mFrame.getRight(), mFrame.getTop() + 10, mPaint);

        //bottom
        canvas.drawRect(mFrame.getLeft(), mFrame.getBottom() - 10, (mFrame.getRight() / 2) - 100, mFrame.getBottom(), mPaint);
        canvas.drawRect((mFrame.getRight() / 2) + 100, mFrame.getBottom() - 10, mFrame.getRight(), mFrame.getBottom(), mPaint);

        //centerline
        mPaint.setColor(Color.GRAY);
        canvas.drawRect(mFrame.getLeft() + 10, (mFrame.getBottom() / 2) - 2, (mFrame.getRight() / 2) - 150, (mFrame.getBottom() / 2) + 2, mPaint);
        canvas.drawRect((mFrame.getRight() / 2) + 150, (mFrame.getBottom() / 2) - 2, (mFrame.getRight() - 10), (mFrame.getBottom() / 2) + 2, mPaint);

        //bottom score
        mPaint.setTextSize(50);
        canvas.drawText(Integer.toString(scoreBot), mFrame.getRight() / 2, (mFrame.getBottom() / 2)+100, mPaint);

        //top score
        canvas.rotate(180,mFrame.getRight() / 2, (mFrame.getBottom() / 2)-100);
        canvas.drawText(Integer.toString(scoreTop),((mFrame.getRight() / 2)-25), (mFrame.getBottom() / 2)-100, mPaint);

    }

    public void setScoreTop(int s){
        this.scoreTop=s;
        this.postInvalidate();
    }

    public void setScoreBot(int s){
        this.scoreBot=s;
        this.postInvalidate();
    }

    public int getScoreTop(){
        return this.scoreTop;
    }

    public int getScoreBot(){
        return this.scoreBot;
    }

    public void resetScore(){
        this.scoreBot=0;
        this.scoreTop=0;

    }

    public int getTopWins() {
        return topWins;
    }

    public void setTopWins(int topWins) {
        this.topWins = topWins;
    }

    public int getBotWins() {
        return botWins;
    }

    public void setBotWins(int botWins) {
        this.botWins = botWins;
    }
}
