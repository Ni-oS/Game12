package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;


public class Plane extends Actor {

    public static Sprite sprite;
    static Rectangle plan;
    public Plane() {
        sprite = new Sprite(new Texture("2sp.png"));
        sprite.setBounds(getX(), getY(), getWidth(), getHeight());

        setBounds(bounds.width / 2 - 32, 30, 64, 64);

        plan=new Rectangle();
        plan.x=bounds.width/2-64/2;
        plan.y=30;
        plan.width=60;
        plan.height=60;
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        sprite.draw(batch);

    }

    @Override
    public void act(final float delta) {
        sprite.setBounds(plan.x, plan.y, getWidth(), getHeight());


if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) plan.x-=delta*300;
if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) plan.x+=delta*300;
    }

}

    class RIGHT extends Actor {
        RIGHT(){
            setBounds( bounds.width/2, 0, bounds.width/2, bounds.heigth);

        }




        @Override
        public void draw(Batch batch, float parentAlpha) {
            batch.draw(new Texture("Pause.png"),getX(),getY(),getWidth(),getHeight());
        }
    }


    class LEFT extends  Actor{
        LEFT(){
            setBounds( 0, 0, bounds.width/2, bounds.heigth);
            setColor(0,0,0,0.5f);


        }

        @Override
        public void draw(Batch batch, float parentAlpha) {
            batch.draw(new Texture("Pause.png"), getX(),getY(),getWidth(),getHeight());
        }
    }



 class Phon extends Actor {

    Texture phon=new Texture("3623.jpg");

    public Phon(){

        setPosition(0,0);
        setSize(bounds.width, bounds.heigth);

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.draw(phon,getX(),getY(),getWidth(),getHeight());
                     Gdx.gl.glClearColor(1,0,1,0);
    }
}


class Kom extends Actor{

    static Array<Rectangle> kom;

    Sprite K0m;

    Kom(){
        kom=new Array<Rectangle>();
        K0m=new Sprite(new Texture("Kom.png"));
        K0m.setBounds(getX(), getY(), getWidth(), getHeight());

        Drop();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        for (Rectangle DropK : kom) {
            batch.draw(K0m, DropK.x, DropK.y,74,74);
        }
    }

    public static void Drop(){
        Rectangle DropK=new Rectangle();
        DropK.x= MathUtils.random(0,bounds.width-64);
        DropK.y=bounds.heigth;
        DropK.width=64;
        DropK.height=64;
        kom.add(DropK);
        bounds.dTime= TimeUtils.nanoTime();
    }
    @Override
    public void act(float delta) {
        K0m.setBounds(getX(), getY(), getWidth(), getHeight());
            Iterator<Rectangle> iter = kom.iterator();
            while (iter.hasNext()) {

                bounds.speed();

                Rectangle Drop = iter.next();
                Drop.y -= bounds.Speed * delta;

                if (Drop.y + 64 < 0) {

                    bounds.niced++;

                    iter.remove();
                }

                if (Drop.overlaps(Plane.plan)) {

                    iter.remove();

                    bounds.Life--;

                    bounds.niced = bounds.niced - 10;
                }
            }
        }
    }




class L1fe extends Actor {
    Texture heard;
    L1fe(){
        heard=new Texture("life.png");
    }
    @Override
    public void draw(Batch batch, float parentAlpha) {
        if(bounds.Life>=1) {
        batch.draw(heard,0, bounds.heigth - 32, 32,32);
            if (bounds.Life >= 2) {
                batch.draw(heard,32, bounds.heigth - 32, 32,32);
                if (bounds.Life >= 3) {
                    batch.draw(heard,64, bounds.heigth - 32, 32,32);

                }
            }
        }
    }

}

