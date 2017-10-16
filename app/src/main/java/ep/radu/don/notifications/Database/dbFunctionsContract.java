package ep.radu.don.notifications.Database;

import android.provider.BaseColumns;

/*
 *  Created by ep on 31/08/2017.
 */

public final class dbFunctionsContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private dbFunctionsContract() {}

    /* Inner class that defines the table contents */
    public static class DefineDatabase implements BaseColumns {
        public static final String TABLE_NOTIFICATIONS = "notifications";
        public static final String CONTENT = "content";
        public static final String IMAGE_ID = "image_id";
        public static final String DETAILS = "details";
    }

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + DefineDatabase.TABLE_NOTIFICATIONS + " (" +
                    DefineDatabase._ID + " INTEGER PRIMARY KEY," +
                    DefineDatabase.CONTENT + " TEXT)" +
                    DefineDatabase.IMAGE_ID + " INT)" +
                    DefineDatabase.DETAILS + " TEXT)";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + DefineDatabase.TABLE_NOTIFICATIONS;
}