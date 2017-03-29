package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.StretchViewport;




public class NowGame implements Screen {

    MyGame game;

    GameGui gui;
    Stage stage;

    Plane plane;
    static Kom k;

    Vector3 touchPos;


    public NowGame(MyGame game){
    this.game=game;

        if(bounds.count==0){
            Resource.Random();
        }

    stage=new Stage(new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));
gui=new GameGui();

        plane=new Plane();
        k=new Kom();
        stage.addActor(new Phon());
        stage.addActor(plane);
        stage.addActor(k);
        stage.addActor(new L1fe());

        touchPos=new Vector3();

        InputMultiplexer in=new InputMultiplexer();
        in.addProcessor(stage);
        in.addProcessor(gui);
        Gdx.input.setInputProcessor(in);
}

    @Override
    public void show() {

    }

    @Override
    public void render(final float delta) {
//        bounds.rein(bounds.Life);

        if (bounds.state == State.Play) {
            stage.act(delta);
        }
        stage.draw();

        gui.act(delta);
        gui.draw();

        game.batch.begin();
        Resource.font.draw(game.batch, Integer.toString(bounds.niced), bounds.width - 75, bounds.heigth);
        game.batch.end();

        if (bounds.Life == 0) {
            bounds.reincarnaciya(bounds.Life);
            game.setScreen(new Losed(game));
            dispose();
        }


        if (Plane.plan.x < 0) Plane.plan.x = 0;
        if (Plane.plan.x > bounds.width - 60) Plane.plan.x = bounds.width - 60;


        if (bounds.state == State.Play) {

            if (TimeUtils.nanoTime() - bounds.dTime > bounds.Time) k.Drop();

            if (Gdx.input.isTouched()) {
                touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
                if ( touchPos.x < bounds.width/2) {
                    Plane.plan.x -= 350 * delta;
                } else {
                    if ( touchPos.x > bounds.width/2)
                        Plane.plan.x += 350 * delta;
                }
            }
        }
    }




    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
stage.dispose();

    }
}
