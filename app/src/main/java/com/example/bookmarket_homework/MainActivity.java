package com.example.bookmarket_homework;


import android.content.Intent;
import android.os.Bundle;
import android.os.Build;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

public class MainActivity extends AppCompatActivity {
    ImageButton button1, button2, button3, button4;
    private ViewPager2 sliderViewPager; // 커버 이미지 슬라이더 뷰
    private LinearLayout layoutIndicator;
    private int[] images = new int[]{R.drawable.cover01, R.drawable.cover02};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 액션바 숨기기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        // 객체와 아이디 연결
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        sliderViewPager = findViewById(R.id.sliderViewPager);
        layoutIndicator = findViewById(R.id.layoutIndicators);

        sliderViewPager.setOffscreenPageLimit(1);
        // 현재 보이지 않는 화면의 생명주기 관리, 1 일경우 좌우 하나 씩 미리 로딩된다.
        sliderViewPager.setAdapter(new ImageSliderAdapter(this, images));

        // ViewPager의 콜백함수 지정
        sliderViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentIndicator(position);
            }
        });

        // 하단의 이미지 갯수 표시
        setupIndicators(images.length);

        String[] message = new String[]{"도서목록", "동영상 강좌", "고객센터", "마이페이지"};
        ImageButton[] imageButtonList = new ImageButton[]{button1, button2, button3, button4};
        for (int i = 0; i < 4; i++) {
            int finalI = i;
            // 버튼별로 리스너 부착
            imageButtonList[i].setOnClickListener(view -> {
                Toast.makeText(getApplicationContext(), message[finalI], Toast.LENGTH_SHORT).show();

                // 도서목록 버튼은 인텐트 전환하도록 설정
                if (finalI == 0) {
                    Intent backIntent = new Intent(MainActivity.this, BooksActivity.class);
                    startActivity(backIntent);
                    finish();
                }
            });
        }
    }

    private void setupIndicators(int count) {
        ImageView[] indicators = new ImageView[count];
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        params.setMargins(16, 8, 16, 8);

        for (int i = 0; i < indicators.length; i++) {
            indicators[i] = new ImageView(this);
            indicators[i].setImageDrawable(ContextCompat.getDrawable(this,
                    R.drawable.bg_indicator_in_active));
            indicators[i].setLayoutParams(params);
            layoutIndicator.addView(indicators[i]);
        }
        setCurrentIndicator(0);
    }

    private void setCurrentIndicator(int position) {
        int childCount = layoutIndicator.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutIndicator.getChildAt(i);
            if (i == position) {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this,
                        R.drawable.bg_indicator_active
                ));
            } else {
                imageView.setImageDrawable(ContextCompat.getDrawable(
                        this,
                        R.drawable.bg_indicator_in_active
                ));
            }
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(getApplicationContext(), "종료", Toast.LENGTH_SHORT).show();
            moveTaskToBack(true); // 태스크를 백그라운드로 이동
            // 종료
            if (Build.VERSION.SDK_INT >= 21) {
                // 액티비티 종료 + 태스크 리스트에서 지우기
                finishAndRemoveTask();
            } else {
                // 액티비티 종료
                finish();
            }
            System.exit(0);
            return true;
        }
        return false;
    }

}