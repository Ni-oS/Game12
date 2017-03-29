package com.mygdx.game;

import com.badlogic.gdx.Gdx;

/**
 * Created by Nik on 26.03.2017.
 */

public class bounds {
    public static int Speed=300;
    public static int Time=235000000;
    public static int count=0;
    public static State state=State.Play;
    public static int niced=0;
    public static Long dTime;
    public static int Life=3;
    public static int width= Gdx.graphics.getWidth();
    public static int heigth=Gdx.graphics.getHeight();
    public static int S=12;


    public static void reincarnaciya(int L1fe){
        if(L1fe==0) {
            Life=3;
            niced=0;
        }
    }

    public static  void speed() {
        if(S<=120){
            if(bounds.niced==S){
                bounds.Speed=bounds.Speed+20;
                S=S+12;
                System.out.println(bounds.Speed);
            }}
    }
}

