package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.FitViewport;

/**
 * Created by Nik on 26.03.2017.
 */

public class GameGui extends Stage {

    public GameGui(){
super(new FitViewport(bounds.width,bounds.heigth));

        Button p=new Button(Resource.p_button);
        p.setBounds(bounds.width/2-50,bounds.heigth-100,100,100);
        p.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(bounds.state==State.Play) {
                    bounds.state = State.Pause;
                }else bounds.state=State.Play;
            }
        });
        addActor(p);
    }

}
