package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

/**
 * Created by Nik on 28.03.2017.
 */

public class Losed implements Screen {

    MyGame game;

    Stage stage;

    Losed(final MyGame game){
        this.game=game;

        stage=new Stage(new StretchViewport(Gdx.graphics.getWidth(),Gdx.graphics.getHeight()));

        stage.addActor(new Phon());

        TextButton again=new TextButton("Again",Resource.again);
again.setBounds((float) (bounds.width*0.1),(float) (bounds.heigth*0.1666667),(float) (bounds.width*0.35),(float) (bounds.heigth*0.1666667));
    again.addListener(new ClickListener(){
        @Override
        public void clicked(InputEvent event, float x, float y) {
            game.setScreen(new NowGame(game));
            dispose();
        }
    });
        stage.addActor(again);

        TextButton main =new TextButton("Main Menu",Resource.main_menu);
        main.setBounds((float) (bounds.width*0.55),(float) (bounds.heigth*0.1666667),(float) (bounds.width*0.35),(float) (bounds.heigth*0.1666667));
        main.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new Menu(game));
                bounds.count=0;
                Resource.Chance.stop();
                dispose();
            }
        });
        stage.addActor(main);
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
