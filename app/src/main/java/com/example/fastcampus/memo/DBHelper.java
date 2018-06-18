package com.example.fastcampus.memo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DBNAME = "memo.db";
    public static final int DBVERSION = 1;

    // SQLite 데이터베이스를 생성 - 없으면 생성 - 있으면 연결
    public DBHelper(Context context) {
        super(context, DBNAME, null, DBVERSION);
    }

    // 최초에 SQLite를 생성했을 때 테이블을 만들어주는 영역
    @Override
    public void onCreate(SQLiteDatabase db) {
        // 여기서 쿼리를 실행해서 앞으로 사용할 테이블을 만들어 준다
        String createQuery = "create table memo(" +
                " id integer not null primary key autoincrement" +
                " ,title text" +
                " ,memo text" +
                " ,author text" +
                " ,date integer)";
        db.execSQL(createQuery);
        // 테스트 쿼리
//        String test = "insert into memo(title, memo) values('제목','내용')";
//        db.execSQL(test);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 테이블 변경내역 쿼리를 실행
    }
}
