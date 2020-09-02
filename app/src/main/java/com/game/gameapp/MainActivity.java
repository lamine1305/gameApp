package com.game.gameapp;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import android.os.Bundle;
import android.widget.LinearLayout;

import com.game.gameapp.com.game.gameapp.model.Box;
import com.game.gameapp.com.game.gameapp.model.Pieces;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    GridView simpleGrid;
    CustomAdapter  adapter ;
   Map<Integer,CustomAdapter> adapters = new HashMap<>();
   // public Piece[][] piece1 ;
   // public Piece[][] piece2 ;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN_MR1)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout layout = findViewById(R.id.linLayout);
        //setContentView(R.layout.activity_main);

        final Pieces pieces = new Pieces();
        int i=0;
        List<Box[][]> piecesListe = Arrays.asList(new Box[][][]{pieces.getP1(),pieces.getP5(),pieces.getP6(),pieces.getP7(), pieces.getP8()});
        for(Box[][] piece :piecesListe) {
            final GridView gridView = new GridView(this);
             int colCount = piece[0].length;
            gridView.setNumColumns(colCount);
            gridView.setId(i);
            LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams(200, 300);
            parms.setMargins(0,0,0,10);
            gridView.setLayoutParams(parms);

            adapter = new CustomAdapter(getApplicationContext(), piece, colCount);
           adapters.put(i,adapter);
            gridView.setAdapter(adapter);
            layout.addView(gridView);

            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View v,
                                        int position, long id) {
                    int idGrid = parent.getId();
                    adapter = adapters.get(idGrid);
                    Box[][] piece = adapter.getPiece();
                    Box[] piecec = adapter.convert(piece);
                     if (piecec[position].isViewable() == true){
                    Box[][] rotationPiece = pieces.rotation(piece);
                    adapter = new CustomAdapter(getApplicationContext(), rotationPiece, piece.length);
                    adapters.put(idGrid,adapter);
                    gridView.setNumColumns(piece.length);
                         LinearLayout.LayoutParams parms = new LinearLayout.LayoutParams( piece.length*60, 300);
                         parms.setMargins(20,0,0,10);
                         gridView.setLayoutParams(parms);
                    gridView.setAdapter(adapter);
                }
            }
            });
            i=i+1;
        }
    }

}
