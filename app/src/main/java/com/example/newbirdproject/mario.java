package com.example.newbirdproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class mario {

    private double currentMarioNumber = 0;

    public Bitmap getNextMario (Context context) {

        Bitmap mario = BitmapFactory.decodeResource(context.getResources(), R.drawable.mario0);

        switch ((int)currentMarioNumber) {
            case 0:
                mario = BitmapFactory.decodeResource(context.getResources(), R.drawable.mario0);
                break;
            case 1:
                mario = BitmapFactory.decodeResource(context.getResources(), R.drawable.mario1);
                break;
            case 2:
                mario = BitmapFactory.decodeResource(context.getResources(), R.drawable.mario2);
                break;
        }

        mario = Bitmap.createScaledBitmap(mario, 200,200, false);

        currentMarioNumber+=0.2;

        if (currentMarioNumber > 2)
            currentMarioNumber = 0;

        return mario;
    }



}
