package com.lec.android.a009_sound;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/** 음향: SoundPool
 *      짧은 음향 리소스(들)을 SoundPool 에 등록(load)하고, 원할때마다 재생(play)
 *
 *  res/raw 폴더 만들고  음향 리소스 추가하기
 */

public class MainActivity extends AppCompatActivity {

    //2
    private SoundPool sp;
    //음향 리소스 id

    //3 파일 가져오기
    private  final int [] SOUND_RES = {R.raw.gun, R.raw.gun2, R.raw.gun3};
    //6
    int [] soundId = new int [SOUND_RES.length];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //1
        Button btnPlay1 = findViewById(R.id.btnPlay);
        Button btnPlay2 = findViewById(R.id.btnPlay2);
        Button btnPlay3 = findViewById(R.id.btnPlay3);
        Button btnStop = findViewById(R.id.btnStop);

        //4
        // SoundPool 객체 생성
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            //api21 이상에서는 아래와 같이 SoundPool 생성
            sp = new SoundPool.Builder().setMaxStreams(10).build();
        }else {

            sp = new SoundPool(1, // 재생음향 최대 개수
                    AudioManager.STREAM_MUSIC,  // 재생 미디어 타입
                    0); // 재생품질 (안쓰임 디폴트 0)

        }

        // 5
        for(int i = 0; i < SOUND_RES.length; i++){
           soundId[i] = sp.load(this,   // 현재 화면의 제어방식
                    SOUND_RES[i],   // 음원 파일소스
                    1);     //
        }

        // 7
        btnPlay1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.play(soundId[0],// 준비한 sound 리소스id
                        1,  // 왼쪽볼륨 float 0.0~1.0
                        1,   // 오른쪽 볼륨 float
                        0, //우선순위 int
                        0,  // 반복횟수 int, 0: 반복안함 -1 무한반복
                        1f  //재생속도 float, 0.5(절반속도) -2.0( 2배속)
                );
            }
        });
        // 8
        btnPlay2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.play(soundId[1],// 준비한 sound 리소스id
                        1,  // 왼쪽볼륨 float 0.0~1.0
                        0,   // 오른쪽 볼륨 float
                        0, //우선순위 int
                        2,  // 반복횟수 int, 0: 반복안함 -1 무한반복
                        2f  //재생속도 float, 0.5(절반속도) -2.0( 2배속)
                );
            }
        });
        //9
        btnPlay3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sp.play(soundId[2],// 준비한 sound 리소스id
                        0,  // 왼쪽볼륨 float 0.0~1.0
                        1,   // 오른쪽 볼륨 float
                        0, //우선순위 int
                        -1,  // 반복횟수 int, 0: 반복안함 -1 무한반복
                        0.5f  //재생속도 float, 0.5(절반속도) -2.0( 2배속)
                );
            }
        });
        // 10
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0; i < soundId.length; i++){
                    sp.stop(soundId[i]);
                }
            }
        });

    }
}
