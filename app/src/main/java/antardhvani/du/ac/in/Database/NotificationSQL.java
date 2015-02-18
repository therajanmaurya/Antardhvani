package antardhvani.du.ac.in.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by lusifer on 17/2/15.
 */
public class NotificationSQL extends SQLiteOpenHelper {


    // Database Version
    private static final int DATABASE_VERSION = 3;
    // Database Name
    private static final String DATABASE_NAME = "DataDB";

    public NotificationSQL(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // SQL statement to create book table
        String CREATE_BOOK_TABLE = "CREATE TABLE data ( " +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, "+
                "subtitle TEXT, status INTEGER )";

        // create books table
        db.execSQL(CREATE_BOOK_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older books table if existed
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_DATA);

        // create fresh books table
        this.onCreate(db);
    }
    //---------------------------------------------------------------------

    /**
     * CRUD operations (create "add", read "get", update, delete) book + get all books + delete all books
     */

    // Books table name
    private static final String TABLE_DATA = "data";

    // Books Table Columns names
    private static final String KEY_ID = "id";
    private static final String KEY_TITLE = "title";
    private static final String KEY_SUBTITLE = "subtitle";
    private static final String KEY_STATUS = "status";

    private static final String[] COLUMNS = {KEY_ID,KEY_TITLE, KEY_SUBTITLE,KEY_STATUS};

    public void addNotification(String x1, String x2){
        Log.e("addBook", x1+"   "+x2);
        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, x1); // get title
        values.put(KEY_SUBTITLE, x2);
        values.put(KEY_STATUS,0);// get author

        // 3. insert
        db.insert(TABLE_DATA, // table
                null, //nullColumnHack
                values); // key/value -> keys = column names/ values = column values

        // 4. close
        db.close();
    }

    public MyResult getNotification(int id){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        Cursor cursor =
                db.query(TABLE_DATA, // a. table
                        COLUMNS, // b. column names
                        " id = ?", // c. selections
                        new String[] { String.valueOf(id) }, // d. selections args
                        null, // e. group by
                        null, // f. having
                        null, // g. order by
                        null); // h. limit

        // 3. if we got results get the first one
        if (cursor != null)
            cursor.moveToFirst();

        // 4. build book object
        MyResult book = new MyResult(cursor.getString(1),cursor.getString(2));

        Log.e("getBook("+id+")", book.getFirst()+"    "+book.getSecond());

        // 5. return book
        return book;
    }

    // Get All Books
    public ArrayList<MyResult> getAllNoti() {
        ArrayList<MyResult> books = new ArrayList<MyResult>();

        // 1. build the query
        String query = "SELECT  * FROM " + TABLE_DATA;

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);

        // 3. go over each row, build book and add it to list
        MyResult book = null;
        if (cursor.moveToFirst()) {
            do {
                book = new MyResult(cursor.getString(1),cursor.getString(2));

                // Add book to books
                books.add(book);
            } while (cursor.moveToNext());
        }

        Log.e("getAllBooks()", books.toString());

        // return books
        return books;
    }

    // Updating single book
    public int updateBook() {

        // 1. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();

        // 2. create ContentValues to add key "column"/value
        ContentValues values = new ContentValues();
        values.put("status",1); // get title
        //values.put("author", book.getAuthor()); // get author

        // 3. updating row
        int i = db.update(TABLE_DATA, //table
                values, // column/value
                null, // selections
                null); //selection args

        // 4. close
        db.close();

        return i;

    }

    public int unread_Num() {
        String query = "SELECT  * FROM " + TABLE_DATA+" WHERE status = 0";

        // 2. get reference to writable DB
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        int x=cursor.getCount();
        cursor.close();
        db.close();
        Log.e("Total No","xxxxxxxxx  "+String.valueOf(x));
        return x ;

    }
    public String getLastNotification(){

        // 1. get reference to readable DB
        SQLiteDatabase db = this.getReadableDatabase();

        // 2. build query
        String query="SELECT * " +
                "    FROM    " +TABLE_DATA+
                "    WHERE   id = (SELECT MAX(id)  FROM"+TABLE_DATA+" )";

        Cursor cursor = db.rawQuery(query, null);
        MyResult book=null;
        if(cursor!=null && cursor.getCount()==0){
            return "";
        }
        if (cursor.moveToLast()) {
               book  = new MyResult(cursor.getString(1),cursor.getString(2));
        }

        cursor.close();
        db.close();


        Log.e("last detail", book.getFirst()+"    "+book.getSecond());

        // 5. return book
        return book.getFirst()+"@"+book.getSecond();
    }

}