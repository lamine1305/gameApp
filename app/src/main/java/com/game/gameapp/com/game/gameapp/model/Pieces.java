package com.game.gameapp.com.game.gameapp.model;

import com.game.gameapp.R;

//Classe représentant les différentes pièces du jeu
public class Pieces {
    private final static Box RED = new Box(R.drawable.red, true);
    private final static Box GREEN = new Box(R.drawable.green, true);
    private final static Box WHITE = new Box(R.drawable.white, true);
    private final static Box BLUE = new Box(R.drawable.blue, true);
    private final static Box NO_BOX = new Box(0, false);
    //le jeu est composé de 10 pièces
    public  static Box[][] p1, p2, p3, p4, p5, p6, p7, p8, p9, p10 ;

    //initialisation de chacune des box av
    public Pieces() {
        p1 = new Box[][]{{RED, GREEN, GREEN}, {WHITE, NO_BOX, NO_BOX}, {WHITE, NO_BOX, NO_BOX}};
        // p1 = new Box[][]{{RED, GREEN, GREEN,NO_BOX}, {WHITE, NO_BOX, NO_BOX,NO_BOX}, {WHITE, NO_BOX, NO_BOX,NO_BOX},{NO_BOX,NO_BOX,NO_BOX,NO_BOX}};
         p2 = new Box[][] {{WHITE, WHITE, WHITE}};
         p3 =  new Box[][]{{GREEN, GREEN, WHITE, RED}, {GREEN, NO_BOX, NO_BOX, NO_BOX}};
         p4 = new Box[][] {{BLUE, BLUE, BLUE}, {RED, RED,NO_BOX},{NO_BOX,NO_BOX,NO_BOX}};
         p5 = new Box[][] {{NO_BOX, BLUE, GREEN, GREEN}, {WHITE, WHITE, NO_BOX, NO_BOX}};
         p6 =  new Box[][]{{BLUE, WHITE, RED, RED}, {NO_BOX, GREEN, NO_BOX, NO_BOX}};
         p7 =  new Box[][]{{BLUE, NO_BOX, NO_BOX}, {RED, RED, RED}};
         p8 =  new Box[][]{{GREEN, WHITE, RED,}, {NO_BOX, RED, NO_BOX}};
         p9 =  new Box[][]{{WHITE, BLUE, NO_BOX}, {NO_BOX, BLUE, WHITE}};
         p10 = new Box[][] {{BLUE, WHITE}, {BLUE, NO_BOX}};
    }

    //getter de chacune des pièces
    public Box[][] getP1() {
        return p1;
    }
    public Box[][] getP2() {
        return p2;
    }
    public Box[][] getP3() {
        return p3;
    }
    public Box[][] getP4() {
        return p4;
    }
    public Box[][] getP5() {
        return p5;
    }
    public Box[][] getP6() {
        return p6;
    }
    public Box[][] getP7() {
        return p7;
    }
    public Box[][] getP8() {
        return p8;
    }
    public Box[][] getP9() {
        return p9;
    }
    public Box[][] getP10() {
        return p10;
    }

    //retourne le tableau représentant une piece après sa rotation suite à un clic
    public Box[][] rotation(Box[][] input){
        int length =input.length;
        int width = input[0].length;
        Box[][] output = new Box[width][length];
        for(int i=0; i<width; i++){
            for(int j=0; j <length; j++){
                output[i][j] = input[length - j-1][i];
            }
        }
       return output;
    }

}