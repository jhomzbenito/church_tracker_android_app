package ph.jomaribenito.churchtracker.persistence.database;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "churchtracker.sqlite";

    private static DatabaseHelper sInstance;
    private Context context;
    private final Object sync = new Object();

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    public static synchronized DatabaseHelper getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new DatabaseHelper(context.getApplicationContext());
        }
        return sInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*db.execSQL(DatabaseQuery.CREATE_CATEGORY);
        db.execSQL(DatabaseQuery.CREATE_PRODUCT);
        db.execSQL(DatabaseQuery.CREATE_PAYLOAD);
        db.execSQL(DatabaseQuery.CREATE_PAYLOAD_FIELD);*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
//        if(oldVersion < DATABASE_VERSION)
//            db.execSQL(DatabaseQuery.CREATE_CATEGORY);
    }

//    public SQLiteDatabase openDataBase() throws SQLException {
//        File dbFile = context.getDatabasePath(DATABASE_NAME);
//        if(sqLiteDatabase == null)
//            return sqLiteDatabase = SQLiteDatabase.openDatabase(dbFile.getPath(), null,
//                SQLiteDatabase.NO_LOCALIZED_COLLATORS | SQLiteDatabase.CREATE_IF_NECESSARY);
//        return sqLiteDatabase;
//    }

    public SQLiteDatabase openDatabase() {
        SQLiteDatabase db = null;
        try {
            synchronized (sync) {
                db = getWritableDatabase();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return db;
    }
}
