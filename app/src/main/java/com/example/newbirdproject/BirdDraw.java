package com.example.newbirdproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class BirdDraw extends SurfaceView implements SurfaceHolder.Callback {

    public BirdDraw(Context context) {
        super(context);
        getHolder().addCallback(this);
    }

    public BirdDraw(Context context, AttributeSet attrs) {
        super(context, attrs);

        getHolder().addCallback(this);
    }

    public BirdDraw(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        getHolder().addCallback(this);
    }

    @Override
    public void surfaceCreated(@NonNull SurfaceHolder surfaceHolder) {
        SetupThread(getContext());
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder surfaceHolder, int i, int i1, int i2) {

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder surfaceHolder) {

    }

    GameThread gameThread;

    private void SetupThread(Context context) {
        gameThread = new GameThread();
        gameThread.setContext(context);
        gameThread.setSurfaceHolder(getHolder());
        gameThread.start();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gameThread.setGoal((int) event.getX(), (int) event.getY());
        return super.onTouchEvent(event);
    }

}


class GameThread extends Thread {

    private SurfaceHolder surfaceHolder;
    private Context context;
    private float birdX = 0;
    private float birdY = 0;
    private float goalX = 0;
    private float goalY = 0;
    private boolean running = true;

    public void setSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.surfaceHolder = surfaceHolder;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setGoal(float goalX, float goalY) {
        this.goalX = goalX;
        this.goalY = goalY;
    }

    public void stopDraw() {
        running = false;
    }


    @Override
    public void run() {
        Bitmap bird = BitmapFactory.decodeResource(context.getResources(), R.drawable.bird1);
        bird = Bitmap.createScaledBitmap(bird, 250, 250, false);


        while (running) {

            if (!surfaceHolder.getSurface().isValid())
                continue;

            Canvas canvas = surfaceHolder.lockCanvas();

            if (canvas != null) {
                canvas.drawColor(Color.RED);


                canvas.drawBitmap(bird, birdX, birdY, new Paint());

                if (birdX < goalX)
                    birdX = birdX + 10;
                else if (birdX > goalX)
                    birdX = birdX - 10;

                if (Math.abs(birdX - goalX) < 10) {
                    birdX = goalX;
                }

                if (birdY < goalY)
                    birdY = birdY + 10;
                else if (birdY > goalY)
                    birdY = birdY - 10;

                if (Math.abs(birdY - goalY) < 10) {
                    birdY = goalY;
                }
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }
}