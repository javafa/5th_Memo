package com.example.fastcampus.memo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    TextView list;
    Button btnPost;
    DBHelper dbHelper;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        dbHelper = new DBHelper(this);
        db = dbHelper.getReadableDatabase();
        list = findViewById(R.id.list);

        // 리스트에 목록을 뿌려준다
        String selectQuery = "select * from memo";
        Cursor cursor = db.rawQuery(selectQuery,null);
        if(cursor != null){
            //반복문을 돌면서 커서를 다음 레코드의 위치로 이동시킨다
            while(cursor.moveToNext()){
                String temp = "";

                int index = cursor.getColumnIndex("id"); // 컬럼 번호 가져오기
                int id = cursor.getInt(index);                        // 컬럼 번호로 실제 값 가져오기
                index = cursor.getColumnIndex("title");
                String title = cursor.getString(index);
                index = cursor.getColumnIndex("memo");
                String memo = cursor.getString(index);
                index = cursor.getColumnIndex("author");
                String author = cursor.getString(index);
                index = cursor.getColumnIndex("date");
                long date = cursor.getLong(index);
                temp = id + " : " + title + " : " + date;
                list.append(temp + "\n");
            }
        }

        btnPost = findViewById(R.id.btnPost);
        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
