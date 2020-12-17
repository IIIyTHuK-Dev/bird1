package com.example.newbirdproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.view.View;

public class BirdDraw extends View {

    class Timer extends CountDownTimer{

        public Timer() {
            super(Integer.MAX_VALUE, 1000/60);
        }

        @Override
        public void onTick(long l) {
            BirdDraw.this.invalidate();
        }

        @Override
        public void onFinish() {

        }
    }

    Timer timer;

    public BirdDraw(Context context) {
        super(context);
        timer = new Timer();
        timer.start();
    }


    float birdX = 0;
    float birdY = 0;

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bird = BitmapFactory.decodeResource(getResources(),R.drawable.bird1);
        bird = Bitmap.createScaledBitmap(bird, 250,250,false);

        canvas.drawBitmap(bird, birdX,birdY,new Paint());
        birdX++;
        birdY++;
    }
}
