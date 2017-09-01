package ep.radu.don.notifications.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ep on 31/08/2017.
 */

public class dbFunctionsHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "notifications.db";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + dbFunctionsContract.DefineDatabase.TABLE_NOTIFICATIONS + " (" +
                    dbFunctionsContract.DefineDatabase._ID + " INTEGER PRIMARY KEY," +
                    dbFunctionsContract.DefineDatabase.CONTENT + " TEXT," +
                    dbFunctionsContract.DefineDatabase.IMAGE_ID + " INT," +
                    dbFunctionsContract.DefineDatabase.DETAILS + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + dbFunctionsContract.DefineDatabase.TABLE_NOTIFICATIONS;

    public dbFunctionsHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}