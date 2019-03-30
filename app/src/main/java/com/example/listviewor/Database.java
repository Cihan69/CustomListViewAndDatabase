package com.example.listviewor;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "personDB";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "personTable";

    private static final String NAME_SURNAME = "name_surname";
    private static final String ADRES = "adres";
    private static final String EMAIL = "email";
    private static final String ID = "_id";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String table_create = "CREATE  TABLE " + TABLE_NAME
                + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_SURNAME + " TEXT, "
                + EMAIL + " TEXT, "
                + ADRES + " TEXT);";
        db.execSQL(table_create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public List<Person> AllRecordlist() {

        SQLiteDatabase db = this.getReadableDatabase();

        String[] column = new String[]{NAME_SURNAME, ADRES, EMAIL, ID};

        Cursor cursor = db.query(TABLE_NAME, column, null, null, null, null, null, null);

        int name_index = cursor.getColumnIndex(NAME_SURNAME);
        int email_index = cursor.getColumnIndex(EMAIL);
        int adres_index = cursor.getColumnIndex(ADRES);
        int id_index = cursor.getColumnIndex(ID);

        List<Person> personList = new ArrayList<Person>();

        for (cursor.moveToFirst(); !cursor.isAfterLast(); cursor.moveToNext()) {

            Person person = new Person();
            person.setP_nameSurname(cursor.getString(name_index));
            person.setP_adress(cursor.getString(adres_index));
            person.setP_eMail(cursor.getString(email_index));
            person.setP_id(cursor.getLong(id_index));

            personList.add(person);
        }

        return personList;
    }

    public long addRecord(Person person) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(NAME_SURNAME, person.getP_nameSurname());
        cv.put(ADRES, person.getP_adress());
        cv.put(EMAIL, person.getP_eMail());

        long id = db.insert(TABLE_NAME, null, cv);
        db.close();

        return id;
    }
}
