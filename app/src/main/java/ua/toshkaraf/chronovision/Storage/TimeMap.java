package ua.toshkaraf.chronovision.Storage;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import ua.toshkaraf.chronovision.EventModel.ChronoEvent;

/**
 * Created by Антон on 01.01.2016.
 */

public class TimeMap {

    Context mContext;
    DBOpenHelper mDBOpenHelper;
    SQLiteDatabase mDb;
    String mMapName;
    String mTags[];
    ContentValues contentValues;

    public TimeMap(Context context, String mapName, String tags[]) {
        this.mMapName = mapName;
        this.mTags = tags;
        mDBOpenHelper = new DBOpenHelper(context, mapName, tags, null, 1);
        mDb = mDBOpenHelper.getWritableDatabase();
    }

//    protected boolean exist(Integer idx) {
//        return idx >= 0;
//    }
//
//    protected Integer getContext(String uuid) {
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).getUuid().equals(uuid)) {
//                return i;
//            }
//        }
//        return -1;
//    }

    protected void Clear() {
        mDb.delete(DBOpenHelper.EVENT_TABLE_NAME, null, null);
    }


    protected void SaveEvent(ChronoEvent chronoEvent) {
        mDb.insert(DBOpenHelper.EVENT_TABLE_NAME, null, null);
    }


//    protected void Update(ChronoEvent r, Integer idx) {
//        list.set(idx, r);
//    }
//
//
//    protected ChronoEvent Load(Integer idx) {
//        return list.get(idx);
//    }
//
//
//    protected void Delete(Integer idx) {
//        list.remove((idx).intValue());
//    }
//
//
//    protected List<ChronoEvent> doGetAll() {
//        return new ArrayList<>(list);
//    }
//
//
//    public int size() {
//        return list.size();
//    }


}
