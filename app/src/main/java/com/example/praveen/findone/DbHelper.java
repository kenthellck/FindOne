package com.example.praveen.findone;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    private static String CREATE_TABLE1;

    //    Database name
    static String DATABASE_NAME = "Project";

    //    Talble name
    public static final String TABLE1_NAME = "items";

    //      Fields for table
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String CATEGORY = "category";
    public static final String OWNER = "owner";
    public static final String OWNERCON = "ownercon";
    public static final String DISCREPITION = "discretion";

    //      Required resorces to manage database
    private ContentValues cValues;
    private SQLiteDatabase dataBase = null;
    private Cursor cursor;

    public DbHelper(Context context) {
        super(context, context.getExternalFilesDir(null).getAbsolutePath()
                + "/" + DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        CREATE_TABLE1 = "CREATE TABLE " + TABLE1_NAME + "(" + ID
                + " INTEGER PRIMARY KEY autoincrement, " + NAME
                + " TEXT, " + CATEGORY + " TEXT,"+OWNER+" TEXT,"+OWNERCON+" TEXT,"+DISCREPITION+"TEXT)";


        db.execSQL(CREATE_TABLE1);
        System.out
                .println("Table is created...........................!");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS " + TABLE1_NAME);

        onCreate(db);
    }

    public void inserRecord(String name, String category, String owner, String ownercon, String discretion) {

        dataBase = getWritableDatabase();
        cValues = new ContentValues();

        cValues.put(NAME, name);
        cValues.put(CATEGORY, category);
        cValues.put(OWNER, owner);
        cValues.put(OWNERCON, ownercon);
        cValues.put(DISCREPITION, discretion);

        // insert data into database
        dataBase.insert(TABLE1_NAME, null, cValues);

        dataBase.close();
    }

   /* public void updateRecord(String name, String salary) {

        dataBase = getWritableDatabase();

        cValues = new ContentValues();

        cValues.put(NAME, name);
        cValues.put(SALARY, salary);
//    Update data from database table
        dataBase.update(DbHelper.TABLE1_NAME, cValues,
                null, null);

        dataBase.close();
    }
    */

    public Cursor selectRecords() {

        dataBase = getReadableDatabase();

//    Getting data from database table
        cursor = dataBase.rawQuery("select * from " + TABLE1_NAME, null);
        return cursor;
    }

    public void deleteRecord() {

        dataBase = getWritableDatabase();

//    Deleting all records from database table
        dataBase.delete(TABLE1_NAME, null, null);

        dataBase.close();
    }

}