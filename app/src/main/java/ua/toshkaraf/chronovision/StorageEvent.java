package ua.toshkaraf.chronovision;

import java.util.ArrayList;
import java.util.List;

import ua.toshkaraf.chronovision.Model.ChronoEvent;

/**
 * Created by Антон on 01.01.2016.
 */
public class StorageEvent {
    List<ChronoEvent> list = new ArrayList<>();


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
