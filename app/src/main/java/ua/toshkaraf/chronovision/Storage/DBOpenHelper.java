package ua.toshkaraf.chronovision.Storage;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Антон on 29.01.2016.
 */
public class DBOpenHelper extends SQLiteOpenHelper {

    private int mDatabaseVersion;

    public static final String GENERAL_TABLE_NAME = "GENERAL_TABLE";
    public static final String MAP_INITIAL_DATE = "MAP_INITIAL_DATE";
    public static final String MAP_FINALE_DATE = "MAP_FINALE_DATE";


    public static final String EVENT_TABLE_NAME = "EVENT_TABLE";
    public static final String EVENT_NAME = "EVENT_NAME";
    public static final String INITIAL_DATE = "INITIAL_DATE";
    public static final String FINALE_DATE = "FINALE_DATE";
    public static final String DESCRIPTION = "DESCRIPTION";
    public static final String SIGNIFICANCE = "SIGNIFICANCE";
    public String mTags[];

    public static final String PICTURE = "PICTURE";
    public static final String VIDEO = "VIDEO";


    public DBOpenHelper(Context context, String mapName, String tags[],
                        SQLiteDatabase.CursorFactory factory, int version) {
        super(context, mapName, factory, version);
        this.mDatabaseVersion = version;
        this.mTags = tags;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("CREATE TABLE " + GENERAL_TABLE_NAME + "("
                + "_id INTEGER PRIMARY KEY, "
                + MAP_INITIAL_DATE + " TEXT,"
                + MAP_FINALE_DATE + " TEXT)");

        db.execSQL("CREATE TABLE " + EVENT_TABLE_NAME + "("
                + "_id INTEGER PRIMARY KEY, "
                + EVENT_NAME + " TEXT,"
                + INITIAL_DATE + " TEXT,"
                + FINALE_DATE + " TEXT,"
                + DESCRIPTION + " TEXT,"
                + SIGNIFICANCE + " INTEGER)");

        for (String tag : mTags) {
            db.execSQL("ALTER TABLE " + EVENT_TABLE_NAME + " ADD COLUMN " + tag + " NUMERIC;");
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public int getDatabaseVersion() {
        return mDatabaseVersion;
    }
}
