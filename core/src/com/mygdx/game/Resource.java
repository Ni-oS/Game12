package com.mygdx.game;


import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;


public class Resource {
    public static BitmapFont font;


    static Music Sp1,Sp2,Sp3,main,Chance;

//    public static String rus="абвгдежзийклмнопрстуфхцчщшьъыэюяАБВГДЕЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЪЫЭЮЯ";

    public static TextureAtlas Atlas;

    public  static Button.ButtonStyle  p_button;

    public static TextButton.TextButtonStyle play,tools,exit,again,main_menu;

    public static Skin skin;

    static Texture plane;

    public static void load(){


        Sp1 =Gdx.audio.newMusic(Gdx.files.internal("Space.mp3"));
        Sp2 =Gdx.audio.newMusic(Gdx.files.internal("Space1.mp3"));
        Sp3 =Gdx.audio.newMusic(Gdx.files.internal("Space2.mp3"));
        main=Gdx.audio.newMusic(Gdx.files.internal("732280.mp3"));


        Atlas =new TextureAtlas(Gdx.files.internal("Atl/Atlas.atlas"));

        skin=new Skin();
        skin.addRegions(Atlas);


        p_button=new Button.ButtonStyle();
        p_button.up= (Drawable) skin.getDrawable("Pause");


        FreeTypeFontGenerator gen=new FreeTypeFontGenerator(Gdx.files.internal("10468.ttf"));
        FreeTypeFontGenerator.FreeTypeFontParameter p=new FreeTypeFontGenerator.FreeTypeFontParameter();
        p.color= Color.YELLOW;
        p.size=50;
//        p.characters=rus;
        p.shadowColor=Color.GRAY;
        p.shadowOffsetX=2;
        p.shadowOffsetY=2;

        font=gen.generateFont(p);


        play=new TextButton.TextButtonStyle();
        play.up= (Drawable) skin.getDrawable("Button");
        play.font=font;

        tools=new TextButton.TextButtonStyle();
        tools.up= (Drawable) skin.getDrawable("Button");
        tools.font=font;

        exit=new TextButton.TextButtonStyle();
        exit.up= (Drawable) skin.getDrawable("Button");
        exit.font=font;

        again=new TextButton.TextButtonStyle();
        again.up= (Drawable) skin.getDrawable("Button");
        again.font=font;

        main_menu= new TextButton.TextButtonStyle();
        main_menu.up= (Drawable) skin.getDrawable("Button");
        main_menu.font=font;


    }
    public static void disp(){

        Sp1.dispose();
        Sp2.dispose();
        Sp3.dispose();
        Chance.dispose();
        main.dispose();
        skin.dispose();
    }


    public static void Random(){
        int r=(int)(Math.random()*3);
        if(r==0) {
            Chance=Sp1;
            Chance.setVolume(0.4f);
        }
        if(r==1) Chance=Sp2;
        if(r==2)Chance=Sp3;
        Chance.setLooping(true);
        Chance.play();
        bounds.count++;
    }
    public  static  void Main(){
        main.setLooping(true);
        main.play();
    }

}
