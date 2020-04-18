package com.lec.android.a008_practice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    PhonebookAdapter adapter;  // Adapter 객체
    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = findViewById(R.id.rv);

        // RecyclerView 를 사용하기 위해서는 LayoutManager 지정해주어야 한다.
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rv.setLayoutManager(layoutManager);

        // Adapter객체 생성
        adapter = new PhonebookAdapter();

        initAdapter(adapter);

        rv.setAdapter(adapter);



    } // end onCreate()

    // 샘플데이터 가져오기
    protected void initAdapter(PhonebookAdapter adapter){
        // 몇개만 생성
        for(int i = 0; i < 10; i++){
            int idx = D.next();
            adapter.addItem(new Phonebook(D.NAME[idx], D.AGE[idx], D.ADDRESS[idx]));
        }
    }

    protected void insertData(View v){
        int idx = D.next();
        // 리스트 맨 앞에 추가
        adapter.addItem(0, new Phonebook( D.NAME[idx], D.AGE[idx], D.ADDRESS[idx]));
        adapter.notifyDataSetChanged();// 데이터 변경을 Adapter 에 알리고 , 리스트뷰에 반영
    }

    protected void appendData(View v){
        int idx = D.next();

        //리스트 맨 뒤에 추가
        adapter.addItem(0, new Phonebook( D.NAME[idx], D.AGE[idx], D.ADDRESS[idx]));
        adapter.notifyDataSetChanged();
    }
} // end Activity


