package com.game.gameapp.com.game.gameapp.model;

import com.game.gameapp.R;

/*
Classe représentant la table de jeu
 une  scene de 7*5 box
 */
public class SceneDeJeu {
    private final static Box GREY = new Box(R.drawable.gris, true);
    private final static Box BLACK = new Box(R.drawable.black, true);
    private Box[][] table;

    public Box[][] getTable() { return table; }

    public SceneDeJeu(){
        table = new Box[][]{{GREY, GREY, GREY,GREY,GREY,GREY,GREY},
                                    {GREY, GREY, GREY,GREY,GREY,GREY,GREY},
                                    {GREY, GREY, GREY,GREY,GREY,GREY,GREY},
                                    {GREY, GREY, GREY,GREY,GREY,GREY,GREY},
                                    {GREY, GREY, GREY,GREY,GREY,GREY,GREY},
                                    {BLACK, GREY, GREY,GREY,GREY,GREY,BLACK}};
    }

}
