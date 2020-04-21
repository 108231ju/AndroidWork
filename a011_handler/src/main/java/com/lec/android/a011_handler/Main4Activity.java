package com.lec.android.a011_handler;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import android.widget.Toast;

// TODO
// Value1
// 1 ~ 10 까지 1초 단위로 증가시키기
// 10초에 도달하면 멈추어서 Toast 띄우기
// Message 사용

// Value2
// 1 ~ 20 까지 1초 단위로 증가시키기
// 20초에 도달하면 멈추어서 Toast 띄우기
// Handler 사용


public class Main4Activity extends AppCompatActivity {

    int value1 = 0, value2 = 0, value3 = 0, value4 = 0, value5 = 0;
    TextView tvResult1, tvResult2, tvResult3, tvResult4, tvResult5;
    Handler mHandler2, mHandler4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        tvResult1 = findViewById(R.id.tvResult1);
        tvResult2 = findViewById(R.id.tvResult2);
        tvResult3 = findViewById(R.id.tvResult3);
        tvResult4 = findViewById(R.id.tvResult4);
        tvResult5 = findViewById(R.id.tvResult5);

        // 방법 #1 핸들러 객체를 외부에서 생성
        mHandler1.sendEmptyMessage(0); // 앱 시작과 동시에 핸들러에 메세지 전달

        // 방법 #2 handler.postDelayed() 사용
        mHandler2 = new Handler();
        mHandler2.postDelayed(new Runnable() {
            @Override
            public void run() {
                value2++;
                tvResult2.setText("Value2 = " + value2);
                if(value2 < 20){
                    mHandler2.postDelayed(this, 1000);
                } else {
                    Toast.makeText(getApplicationContext(), "Value2 종료", Toast.LENGTH_LONG).show();
                }
            }
        }, 0);

        // 방법 3:
    } // end onCreate


    Handler mHandler1 = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            value1++;

            tvResult1.setText("Value1 = " + value1);

            if(value1 < 10){
                // 메세지를 처리하고 또다시 핸들러에 메세지 전달 (1000ms 지연)
                mHandler1.sendEmptyMessageDelayed(0,1000);
                // 첫번째 매개변수는 message 값
                // 두번째 매개변수는 millisec
            } else {
                Toast.makeText(getApplicationContext(), "Value1 종료", Toast.LENGTH_LONG).show();
            }
        }
    };


} // end Activity