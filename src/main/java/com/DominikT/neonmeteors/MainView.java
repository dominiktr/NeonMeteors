package com.DominikT.neonmeteors;

import android.content.Context;
import android.content.res.Resources;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MainView extends SurfaceView implements SurfaceHolder.Callback {

    private MainThread mainThread;
    private GameActivity gameActivity;

    public MainView(Context context, GameActivity gameActivity) {
        super(context);
        getHolder().addCallback(this);
        BitmapResources bitmapResources = new BitmapResources(this);
        mainThread = new MainThread(this, gameActivity, bitmapResources);
        this.gameActivity = gameActivity;

    }



    @Override
    public Resources getResources() {
        return super.getResources();
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        mainThread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    public MainThread getMainThread() {
        return mainThread;
    }

}
