package com.example.newbirdproject;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class enemy {
    private double currentMarioNumber = 0;

    public Bitmap getNextMario (Context context) {

        Bitmap enemy = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy0);

        switch ((int)currentMarioNumber) {
            case 0:
                enemy = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy1);
                break;
            case 1:
                enemy = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy2);
                break;
            case 2:
                enemy = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy3);
                break;
            case 3:
                enemy = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy4);
                break;
            case 4:
                enemy = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy5);
                break;
            case 5:
                enemy = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy6);
                break;
            case 6:
                enemy = BitmapFactory.decodeResource(context.getResources(), R.drawable.enemy7);
                break;
        }

        enemy = Bitmap.createScaledBitmap(enemy, 200,200, false);

        currentMarioNumber+=0.2;

        if (currentMarioNumber > 2)
            currentMarioNumber = 0;

        return enemy;
    }
}
