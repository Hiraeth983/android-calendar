package com.haibin.calendar.base.datebase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.haibin.calendar.base.pojo.Schedule;

public class DBHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "contact.db";

    public static final int DATABASE_VERSION = 1;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 初始化数据库的表结构，执行一条建表的SQL语句
        String SQL_TABLE = "CREATE TABLE " + Schedule.TABLE_NAME + " ("
                + Schedule._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," // 主键自增
                + Schedule.COLUMN_TITLE + " TEXT NOT NULL, "
                + Schedule.COLUMN_LOCATE + " TEXT NOT NULL, "
                + Schedule.COLUMN_TIME_SLOT + " REAL NOT NULL, "
                + Schedule.COLUMN_BEGIN_TIME + " TEXT NOT NULL, "
                + Schedule.COLUMN_END_TIME + " TEXT NOT NULL, "
                + Schedule.COLUMN_REPEAT + " TEXT NOT NULL, "
                + Schedule.COLUMN_IMPORTANT + " REAL NOT NULL, "
                + Schedule.COLUMN_ACCOUNT + " TEXT NOT NULL, "
                + Schedule.COLUMN_DESCRIPTION + " TEXT NOT NULL, "
                + Schedule.COLUMN_TIME_ZONE + " TEXT DEFAULT \"GMT+8:00 中国标准时间\");";

        sqLiteDatabase.execSQL(SQL_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
