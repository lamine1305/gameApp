package com.game.gameapp;

import android.widget.BaseAdapter;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.game.gameapp.com.game.gameapp.model.Box;

public class CustomAdapter extends BaseAdapter {
    Context context;
    Box box[];
    int colCount;
    LayoutInflater inflter;
    public CustomAdapter(Context applicationContext,  Box boxes[][],int colCount) {
        this.context = applicationContext;
        this.box = convert(boxes);
        inflter = (LayoutInflater.from(applicationContext));
        this.colCount = colCount;
    }
    @Override
    public int getCount() {
        return box.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    public Box[][] getPiece(){
        return unconvert(box,colCount);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_gridview, null); // inflate the layout
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
                // get the reference of ImageView
        icon.setImageResource(box[i].getColor()); // set logo images
        return view;
    }

    public Box[] convert(Box[][] bidimension){
        int rows = bidimension.length;
        int cols = bidimension[0].length;
        Box[] unidimen = new Box[rows*cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                unidimen[i*cols+j] = bidimension[i][j];
            }
        }
            return unidimen ;
    }

public Box[][] unconvert(Box[] input, int colCount){
        int rows = input.length;
    Box[][] output = new Box[rows/colCount][colCount];
    for(int i=0;i<rows/colCount;i++){
        for(int j=0;j<colCount;j++){
            output[i][j] = input[i*colCount+j];
        }
    }
  return output;
}
}
