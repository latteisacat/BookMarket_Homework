package com.example.bookmarket_homework;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class BooksActivity extends AppCompatActivity {

    ImageView menu1, menu2; // 레이아웃 선택 버튼
    Button backButton; // 상단 뒤로가기 버튼
    LinearLayout bookPage1, bookPage2; // 도서 레이아웃
    ImageView book11Obj, book12Obj, book13Obj, book14Obj, book21Obj, book22Obj, book23Obj, book24Obj;
    Integer state;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books);
        book11Obj = findViewById(R.id.book_image_1);
        book12Obj = findViewById(R.id.book_image_2);
        book13Obj = findViewById(R.id.book_image_3);
        book14Obj = findViewById(R.id.book_image_4);

        book21Obj = findViewById(R.id.book_1);
        book22Obj = findViewById(R.id.book_2);
        book23Obj = findViewById(R.id.book_3);
        book24Obj = findViewById(R.id.book_4);

        state = 0;

        // 액션바 숨기기
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

        // 전환 애니메이션 설정
        Animation animation = new AlphaAnimation(0, 1);
        animation.setDuration(500);

        // 객체와 아이디 연결
        menu1 = findViewById(R.id.menu_1);
        menu2 = findViewById(R.id.menu_2);
        bookPage1 = findViewById(R.id.book_page_1);
        bookPage2 = findViewById(R.id.book_page_2);
        backButton = findViewById(R.id.back_button);

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu1.setImageResource(R.drawable.list_type1); // 버튼 1 활성화 아이콘으로 변경
                menu2.setImageResource(R.drawable.list_type22); // 버튼 2 비활성화 아이콘으로 변경
                state = 0;
                // 도서 그리드 숨기기
                bookPage2.clearAnimation();
                bookPage2.setVisibility(View.GONE);
                // 도서 리스트 보이기
                bookPage1.setVisibility(View.VISIBLE);
                bookPage1.startAnimation(animation);
            }
        });

        // 그리드로 보기 버튼 클릭할 때
        menu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                menu1.setImageResource(R.drawable.list_type12); // 버튼 1 비활성화 아이콘으로 변경
                menu2.setImageResource(R.drawable.list_type2); // 버튼 2 활성화 아이콘으로 변경
                state = 1;
                // 도서 리스트 숨기기
                bookPage1.clearAnimation();
                bookPage1.setVisibility(View.GONE);
                // 도서 그리드 보이기
                bookPage2.setVisibility(View.VISIBLE);
                bookPage2.startAnimation(animation);
            }
        });

        // 상단의 뒤로 가기 버튼 누를 때 메인화면으로 인텐트 전환
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "뒤로 가기", Toast.LENGTH_SHORT).show();
                Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(backIntent);
            }
        });


        book11Obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"자바 코딩의 기술", Toast.LENGTH_LONG).show();
                BookItem1();
            }
        });

        book12Obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"머신 러닝을 다루는 기술", Toast.LENGTH_LONG).show();
                BookItem2();
            }
        });
        book13Obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"모던 리눅스 관리", Toast.LENGTH_LONG).show();
                BookItem3();
            }
        });
        book14Obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"유니티 교과서", Toast.LENGTH_LONG).show();
                BookItem4();
            }
        });


        book21Obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"자바 코딩의 기술", Toast.LENGTH_LONG).show();
                BookItem1();
            }
        });
        book22Obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"머신 러닝을 다루는 기술", Toast.LENGTH_LONG).show();
                BookItem2();
            }
        });
        book23Obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"모던 리눅스 관리", Toast.LENGTH_LONG).show();
                BookItem3();
            }
        });
        book24Obj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"유니티 교과서", Toast.LENGTH_LONG).show();
                BookItem4();
            }
        });
    }

    public void BookItem1(){
        Intent intent  = new Intent(BooksActivity.this, BookInfoActivity.class);
        intent.putExtra("bookid", "BOOK1234");
        intent.putExtra("name", "자바 코딩의 기술");
        intent.putExtra("price", "22000");
        intent.putExtra("date", "2020-07-30");
        intent.putExtra("writer", "사이먼 하러,리누스 디에츠,요르그 레너드/심지현");
        intent.putExtra("page", "264쪽");
        intent.putExtra("description", "코딩 스킬을 개선하는 가장 좋은 방법은 전문가의 코드를 읽는 것이다. 오픈 소스 코드를 읽으면서 이해하면 좋지만, 너무 방대하고 스스로 맥락을 찾는 게 어려울 수 있다. 그럴 땐 이 책처럼 현장에서 자주 발견되는 문제 유형 70가지와 해법을 비교하면서 자신의 코드에서 개선할 점을 찾는 것이 좋다.");
        intent.putExtra("category", "프로그래밍/오픈소스");
        intent.putExtra("state", state);
        startActivity(intent);
    }
    public void BookItem2(){
        Intent intent  = new Intent(BooksActivity.this, BookInfoActivity.class);
        intent.putExtra("bookid", "BOOK1235");
        intent.putExtra("name", "머신 러닝을 다루는 기술 with 파이썬, 사이킷런");
        intent.putExtra("price", "34000");
        intent.putExtra("date", "2020-06-3");
        intent.putExtra("writer", "마크 페너/황준식");
        intent.putExtra("page", "624쪽");
        intent.putExtra("description",
                "저자는 오랫동안 다양한 사람들에게 머신 러닝을 가르치면서 효과적인 학습 방법을 고안했고, 그대로 책에 담았다. 이 책은 그림과 스토리로 개념을 설명하고 바로 파이썬 코드로 구현하는 것에서 시작한다. 수학적 증명을 깊게 파고들거나 개념을 설명하기 위해 수식에 의존하지 않으며, 필요한 수학은 고등학교 수준으로 그때마다 첨가하여 설명한다. 또한, 바닥부터 모델을 구현하지 않고, 넘파이, 판다스, 사이킷런처럼 잘 구현된 강력한 파이썬 라이브러리를 사용해 실용적으로 접근한다. 개념과 기술을 잘 보여주는 양질의 예제를 직접 실행하며 머신 러닝 개념을 이해할 수 있다. ");
                intent.putExtra("category", "데이터베이스/데이터분석");
        intent.putExtra("state", state);
        startActivity(intent);
    }
    public void BookItem3(){
        Intent intent  = new Intent(BooksActivity.this, BookInfoActivity.class);
        intent.putExtra("bookid", "BOOK1236");
        intent.putExtra("name", "모던 리눅스 관리");
        intent.putExtra("price", "30000");
        intent.putExtra("date", "2019-10-10");
        intent.putExtra("writer", "데이비드 클린턴(David Cliton)/강석주");
        intent.putExtra("page", "472쪽");
        intent.putExtra("description", "이 책은 최신 기술을 활용한 리눅스 관리 방법을 가상화, 연결, 암호화, 네트워킹, 이미지관리, 시스템 모니터링의 6가지 주제로 나눠 설명한다. 가상 머신에 리눅스를 설치하고 서버를 구축하는 방법뿐만 아니라 구축 이후에 리눅스를 관리하고 운영하며 겪을수 있는 다양한 문제를 해결하는 방법까지 다룬다. VM과 컨테이너를 이용한 가상화, AWS S3를 이용한 데이터 백업, Nextcloud를 이용한 파일공유 서버 구축, 앤서블을 이용한 데브옵스 환경 구축 등 최신 기술을 활용한 실용적인 12가지 프로젝트로 실무에 필요한 리눅스 관리 방법을 배울 수 있다.");
        intent.putExtra("category", "임베디드/시스템/네트워크");
        intent.putExtra("state", state);
        startActivity(intent);
    }
    public void BookItem4(){
        Intent intent  = new Intent(BooksActivity.this, BookInfoActivity.class);
        intent.putExtra("bookid", "BOOK1237");
        intent.putExtra("name", "유니티 교과서");
        intent.putExtra("price", "28000");
        intent.putExtra("date", "2019-10-30");
        intent.putExtra("writer", "기타무라 마나미/김은철,유세라");
        intent.putExtra("page", "456쪽");
        intent.putExtra("description", "[유니티 교과서, 개정 3판]은 유니티를 사용해 2D/3D 게임과 애니메이션을 만들면서 유니티 기초 지식과 함께 게임 제작 흐름을 익히는 것을 목적으로 한다. 유니티를 설치한 후 C# 핵심 문법을 학습하고, 이어서 여섯 가지 2D/3D 게임을 ‘게임 설계하기 → 프로젝트와 씬 만들기 → 씬에 오브젝트 배치하기 → 스크립트 작성하기 → 스크립트 적용하기’ 단계로 만들어 보면서 게임 제작 흐름을 익힌다. ");
        intent.putExtra("category", "게임");
        intent.putExtra("state", state);
        startActivity(intent);
    }


    // 안드로이드의 뒤로 가기 버튼 누를 때 메인화면으로 인텐트 전환
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(getApplicationContext(), "뒤로 가기", Toast.LENGTH_SHORT).show();
            Intent backIntent = new Intent(getApplicationContext(), MainActivity.class);
            startActivity(backIntent);
            return true;
        }

        return false;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if(state == 0){
                bookPage2.setVisibility(View.GONE);
                bookPage1.setVisibility(View.VISIBLE);
            }
            else{
                bookPage1.setVisibility(View.GONE);
                bookPage2.setVisibility(View.VISIBLE);
            }
        } else {   // RESULT_CANCEL
            Toast.makeText(getApplicationContext(), "Something is wrong....", Toast.LENGTH_SHORT).show();
        }
    }
}