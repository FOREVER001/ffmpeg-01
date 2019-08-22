package com.tianzhuan.wangyiplayer;

import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.HashMap;

public class WangyiPlayer implements SurfaceHolder.Callback {
    static {
        System.loadLibrary("wangyiplayer");
    }
    private SurfaceHolder surfaceHolder;
    //路径 NDK path
    public void setSurfaceView(SurfaceView surfaceView){
        if(this.surfaceHolder!=null){
            this.surfaceHolder.removeCallback(this);
        }
        this.surfaceHolder=surfaceView.getHolder();
        this.surfaceHolder.addCallback(this);
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {

    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
       this.surfaceHolder=holder;
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

    }

    public void start(String path) {
        native_start(path,surfaceHolder.getSurface());
    }

    public native void native_start(String path, Surface surface);
}
