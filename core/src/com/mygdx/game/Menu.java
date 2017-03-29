package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;


/**
 * Created by Nik on 25.03.2017.
 */

public class Menu implements Screen {
    final MyGame game;
    Stage stage;


    public Menu(final MyGame game){
        this.game=game;

        Resource.Main();

        stage = new Stage(new StretchViewport(Gdx.graphics.getWidth(), Gdx.graphics.getHeight()));

        stage.addActor(new Phon());

        TextButton Play=new TextButton("Play",Resource.play);
        Play.setBounds((float) (bounds.width*0.35),(float) (bounds.heigth*0.6666667),(float) (bounds.width*0.3),(float) (bounds.heigth*0.083333));
        Play.addListener(new ClickListener(){
                        @Override
            public void clicked(InputEvent event, float x, float y) {
                            game.setScreen(new NowGame(game));
                            Resource.main.stop();
                            dispose();
            }
        });
        stage.addActor(Play);

        TextButton fix =new TextButton("Tools",Resource.tools);
        fix.setBounds( (float) (bounds.width*0.35),(float) (bounds.heigth*0.4444444),(float) (bounds.width*0.3),(float) (bounds.heigth*0.083333));
        fix.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {

            }
        });
        stage.addActor(fix);

        TextButton exit=new TextButton("Exit",Resource.exit);
        exit.setBounds( (float) (bounds.width*0.35),(float) (bounds.heigth*0.25),(float) (bounds.width*0.3),(float) (bounds.heigth*0.0833333));
        exit.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.exit();
                dispose();
            }
        });
        stage.addActor(exit);

        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {




    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
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
