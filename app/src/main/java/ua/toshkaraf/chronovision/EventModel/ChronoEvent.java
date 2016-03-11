package ua.toshkaraf.chronovision.EventModel;

/**
 * Created by Антон on 31.12.2015.
 */

import android.content.ContentValues;
import android.database.sqlite.SQLiteCursor;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

import ua.toshkaraf.chronovision.Storage.DBOpenHelper;

public class ChronoEvent implements Comparable, Serializable {

    public static final int FULL_DATE = 1;
    public static final int SHORT_DATE = 0;

    private int isFullInitialDate;
    private int isFullFinalDate;
    private int id;
    private Date initialDate;
    private Date finalDate;
    private String name;
    private EventDescription description;
    private int significance;  // up to 10
    private Map<String, Integer> tags;
    private byte media[];

    public ContentValues getPreparedEventValues() {
        ContentValues cv = new ContentValues();
        cv.put(DBOpenHelper.ID, id);
        cv.put(DBOpenHelper.EVENT_NAME, name);
        cv.put(DBOpenHelper.INITIAL_DATE, initialDate.getTime());
        cv.put(DBOpenHelper.IS_FULL_INITIAL_DATE, isFullInitialDate);
        cv.put(DBOpenHelper.FINALE_DATE, finalDate.getTime());
        cv.put(DBOpenHelper.IS_FULL_FINAL_DATE, isFullFinalDate);
        cv.put(DBOpenHelper.DESCRIPTION, description.getText());
        cv.put(DBOpenHelper.SIGNIFICANCE, significance);
//        for (Map.Entry<String, Integer> tag : tags.entrySet()){
//            cv.put(tag.getKey(), tag.getValue());
//        }
        return cv;
    }

    public static final ChronoEvent EMPTY = new ChronoEvent();

    public ChronoEvent() {
    }

    public ChronoEvent(String fullName) {
        this(Integer.valueOf(UUID.randomUUID().toString()), fullName);
    }

    public ChronoEvent(String fullName, Date initialDate, Boolean isFullInitialDate, Date finalDate, Boolean isFullFinalDate, String[] tags) {
        this(Integer.valueOf(UUID.randomUUID().toString()), fullName);
        if (isFullInitialDate) this.isFullInitialDate = FULL_DATE;
        else this.isFullInitialDate = SHORT_DATE;
        if (isFullFinalDate) this.isFullFinalDate = FULL_DATE;
        else this.isFullFinalDate = SHORT_DATE;
        this.initialDate = initialDate;
        this.finalDate = finalDate;
    }

    public ChronoEvent(int id, String fullName, Long initialDate, int isFullInitialDate, Long finalDate, int isFullFinalDate, String[] tags) {
        this(Integer.valueOf(UUID.randomUUID().toString()), fullName);
        this.isFullInitialDate = isFullInitialDate;
        this.isFullFinalDate = isFullFinalDate;
        this.initialDate = new Date(initialDate);
        this.finalDate = new Date(finalDate);
        this.id = id;
    }

    public ChronoEvent(int id, String name) {
        requireNonNull(name);
        requireNonNull(id);
        this.id = id;
        this.name = name;
    }

    private void requireNonNull(Object o) {
        if (o == null) throw new NullPointerException("the field must not be null");
    }

    public void setInitialDate(int year, int month, int day) {
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public Date getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(int year, int month, int day) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EventDescription getEventDescription() {
        return description;
    }

    public void setEventDescription(EventDescription description) {
        this.description = description;
    }

    public int getSignificance() {
        return significance;
    }

    public void setSignificance(byte significance) {
        this.significance = significance;
    }

//    public String getCountry() {
//        return country;
//    }
//
//    public void setCountry(String country) {
//        this.country = country;
//    }

    public Map<String, Integer> getTags() {
        return tags;
    }

    public void setTags(Map<String, Integer> tags) {
        this.tags = tags;
    }

    @NonNull
    @Override
    public int compareTo(Object e) {
        ChronoEvent event = (ChronoEvent) e;
        return this.initialDate.compareTo(event.initialDate);
    }

    public int getId() {
        return id;
    }

    public static ChronoEvent restoreEventFromDB(SQLiteCursor cursor) {
        return new ChronoEvent(
                cursor.getInt(1),
                cursor.getString(2),
                cursor.getLong(3),
                cursor.getInt(4),
                cursor.getLong(5),
                cursor.getInt(6),
                new String[]{""}
        );
    }

}


