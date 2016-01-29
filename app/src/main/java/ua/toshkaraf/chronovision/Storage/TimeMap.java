package ua.toshkaraf.chronovision.Storage;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import ua.toshkaraf.chronovision.EventModel.ChronoEvent;

/**
 * Created by Антон on 01.01.2016.
 */

public class TimeMap {
    List<ChronoEvent> list = new ArrayList<>();
    String mapName;
    String tags[];
    Context mContext;
    DBOpenHelper mDBOpenHelper;

    public TimeMap(Context context, String mapName, String tags[]) {
        this.mapName = mapName;
        this.tags = tags;
        mDBOpenHelper = new DBOpenHelper(context, mapName, null, 1);
        mDBOpenHelper.setDBTags(tags);
    }

    protected boolean exist(Integer idx) {
        return idx >= 0;
    }

    protected Integer getContext(String uuid) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    protected void Clear() {
        list.clear();
    }


    protected void Save(ChronoEvent r, Integer idx) {
        list.add(r);
    }


    protected void Update(ChronoEvent r, Integer idx) {
        list.set(idx, r);
    }


    protected ChronoEvent Load(Integer idx) {
        return list.get(idx);
    }


    protected void Delete(Integer idx) {
        list.remove((idx).intValue());
    }


    protected List<ChronoEvent> doGetAll() {
        return new ArrayList<>(list);
    }


    public int size() {
        return list.size();
    }
}
