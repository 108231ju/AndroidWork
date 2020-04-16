package com.lec.android.a004widget;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Main4Activity extends AppCompatActivity {

    RadioGroup rg;
    Button btnResult;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        // 체크박스와는 달리
        // RadioButton 은 각각 선언하는 것이 아니라 Radiogroup 으로 선언하여 사용
        rg = findViewById(R.id.rg);

        btnResult = findViewById(R.id.btnResult);

        tvResult = findViewById(R.id.tvResult);

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //선택된 라디오버튼의 id 값 가져오기
                int id = rg.getCheckedRadioButtonId();
                // 위 id 값을 통해 radioButton 객체 가져오기
                RadioButton rb = findViewById(id);

                tvResult.setText("결과" + rb.getText());
            }
        });

        //라디오버튼을 선택했을떄도 위와 같은 동작하게 하기
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            // checkedid : 선택된 라디오 버튼의id
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
                tvResult.setText("결과: " + rb.getText());
            }
        });

    }
}
