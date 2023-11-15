package com.example.bookmarket_homework;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookInfoActivity extends AppCompatActivity {
    ImageView imgObj;
    TextView bookidObj, nameObj,priceObj, dateObj, writerObj, pageObj, descriptionObj, categoryObj;
    Integer state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_more_info);

        imgObj = findViewById(R.id.book_iv01);
        bookidObj = findViewById(R.id.book_tv01);
        nameObj = findViewById(R.id.book_tv02);
        priceObj = findViewById(R.id.book_tv03);
        dateObj = findViewById(R.id.book_tv04);
        writerObj = findViewById(R.id.book_tv05);
        pageObj = findViewById(R.id.book_tv06);
        descriptionObj = findViewById(R.id.book_tv07);
        categoryObj = findViewById(R.id.book_tv08);
        Intent intent = getIntent(); // 전송된 인텐트 받기
        bookidObj.setText(intent.getStringExtra("bookid"));
        nameObj.setText(intent.getStringExtra("name"));
        priceObj.setText(intent.getStringExtra("price"));
        dateObj.setText(intent.getStringExtra("date"));
        writerObj.setText(intent.getStringExtra("writer"));
        pageObj.setText(intent.getStringExtra("page"));
        descriptionObj.setText(intent.getStringExtra("description"));
        categoryObj.setText(intent.getStringExtra("category"));
        state = intent.getIntExtra("state", 0);
        switch(bookidObj.getText().toString()){
            case "BOOK1234" :
                imgObj.setImageResource(R.drawable.book11);
                break;
            case "BOOK1235" :
                imgObj.setImageResource(R.drawable.book21);
                break;
            case "BOOK1236" :
                imgObj.setImageResource(R.drawable.book31);
                break;
            case "BOOK1237" :
                imgObj.setImageResource(R.drawable.book41);
                break;
        }

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Toast.makeText(getApplicationContext(), "뒤로 가기", Toast.LENGTH_SHORT).show();
            Intent backIntent = new Intent(getApplicationContext(), BooksActivity.class);
            backIntent.putExtra("state", state);
            setResult(RESULT_OK, backIntent);
            finish();
            return true;
        }
        return false;
    }
}