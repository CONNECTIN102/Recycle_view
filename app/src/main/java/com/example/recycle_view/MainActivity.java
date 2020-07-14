package com.example.recycle_view;

import android.app.Activity;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    String urladdr = "http://192.168.0.148:8080/test/recipe_all.jsp";
    ArrayList<RecipeData> list;
    RecipeRecyclerAdapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        try{
            list = new ArrayList<RecipeData>();
            NetworkTask networkTask = new NetworkTask(this,urladdr);
            list = (ArrayList<RecipeData>) networkTask.execute().get();
        }catch (Exception e){
            e.printStackTrace();
        }



        // 리사이클러뷰에 LinearLayoutManager 객체 지정.
        recyclerView = findViewById(R.id.recuocler_list) ;
        recyclerView.setLayoutManager(new LinearLayoutManager(this)) ;

        // 리사이클러뷰에 SimpleTextAdapter 객체 지정.
        adapter = new RecipeRecyclerAdapter(list) ;
        recyclerView.setAdapter(adapter) ;


    }
}