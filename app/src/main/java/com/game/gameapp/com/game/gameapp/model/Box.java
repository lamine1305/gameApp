package com.game.gameapp.com.game.gameapp.model;

// une case représentée par une couleur et une visibilité
public class Box {

    private int color;
  private boolean viewable;

    public Box(int color, boolean viewable){
        this.color = color;
        this.viewable = viewable;
    }

    public int getColor() {
        return color;
    }

    public boolean isViewable() {
        return viewable;
    }
}
