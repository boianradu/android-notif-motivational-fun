package ep.radu.don.notifications.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by ep on 31/08/2017.
 */


public class dbFunctions {
    Context context;
    dbFunctionsHelper dbFunctionsHelper;

    public dbFunctions(Context ctx) {
        context = ctx;
        dbFunctionsHelper = new dbFunctionsHelper(context);

    }

    private void createDB(Context context){
        dbFunctionsHelper = new dbFunctionsHelper(context);
    }
    public void insertDB(String content, int imageId, String details) {
        // Gets the data repository in write mode
        SQLiteDatabase db = dbFunctionsHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(dbFunctionsContract.DefineDatabase.CONTENT, content);
        values.put(dbFunctionsContract.DefineDatabase.IMAGE_ID, imageId);
        values.put(dbFunctionsContract.DefineDatabase.DETAILS, details);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(dbFunctionsContract.DefineDatabase.TABLE_NOTIFICATIONS, null, values);
    }

    public void readDB(){
        Log.e("MyApp","SAMURAI");
        SQLiteDatabase db = dbFunctionsHelper.getReadableDatabase();

        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                dbFunctionsContract.DefineDatabase._ID,
                dbFunctionsContract.DefineDatabase.CONTENT,
                dbFunctionsContract.DefineDatabase.IMAGE_ID,
                dbFunctionsContract.DefineDatabase.DETAILS
        };

        // Filter results WHERE "title" = 'My Title'
        String selection = dbFunctionsContract.DefineDatabase.CONTENT + " = ?";
        String[] selectionArgs = { "" };

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                dbFunctionsContract.DefineDatabase.CONTENT + " DESC";

        Cursor cursor = db.query(
                dbFunctionsContract.DefineDatabase.TABLE_NOTIFICATIONS,                     // The table to query
                null,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        List itemIds = new ArrayList<>();
        while(cursor.moveToNext()) {
            Log.e("MyApp",cursor.getString(0));
            Log.e("MyApp",cursor.getString(1));
            long itemId = cursor.getLong(
                    cursor.getColumnIndexOrThrow(dbFunctionsContract.DefineDatabase._ID));
            itemIds.add(itemId);
        }
        cursor.close();


    }
}

