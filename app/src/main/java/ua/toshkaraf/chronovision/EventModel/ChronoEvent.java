package ua.toshkaraf.chronovision.EventModel;

/**
 * Created by Антон on 31.12.2015.
 */

import android.content.ContentValues;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.UUID;

import ua.toshkaraf.chronovision.Storage.DBOpenHelper;

public class ChronoEvent implements Comparable, Serializable {

    private String uuid;
    private GregorianCalendar initialDate;
    private GregorianCalendar finalDate;
    private String name;
    private EventDescription description;
    private int significance;  // up to 10
    private Map<String, Integer> tags;
    private byte media[];

    private ContentValues preparedEventValues(){
        ContentValues cv = new ContentValues();
        cv.put(DBOpenHelper.EVENT_NAME, name);
        cv.put(DBOpenHelper.INITIAL_DATE, name);
        cv.put(DBOpenHelper.FINALE_DATE, name);
        cv.put(DBOpenHelper.DESCRIPTION, description.getText());
        cv.put(DBOpenHelper.SIGNIFICANCE, significance);
        for (Map.Entry<String, Integer> tag : tags.entrySet()){
            cv.put(tag.getKey(), tag.getValue());
        }
        return cv;
    }

    public static final ChronoEvent EMPTY = new ChronoEvent();

    public ChronoEvent() {
    }

    public ChronoEvent(String fullName) {
        this(UUID.randomUUID().toString(), fullName);
    }

    public ChronoEvent(String uuid, String name) {
        requireNonNull(name);
        requireNonNull(uuid);
        this.uuid = uuid;
        this.name = name;
    }

    private void requireNonNull(Object o) {
        if (o == null) throw new NullPointerException("the field must not be null");
    }

    public void setInitialDate(int year, int month, int day) {
        initialDate.set(year, month, day);
    }

    public GregorianCalendar getInitialDate() {
        return initialDate;
    }

    public GregorianCalendar getFinalDate() {
        return finalDate;
    }

    public void setFinalDate(int year, int month, int day) {
        initialDate.set(year, month, day);
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

    public String getUuid() {
        return uuid;
    }
}


