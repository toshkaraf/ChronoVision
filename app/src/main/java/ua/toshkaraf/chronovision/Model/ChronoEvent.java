package ua.toshkaraf.chronovision.Model;

/**
 * Created by Антон on 31.12.2015.
 */

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.UUID;

public class ChronoEvent implements Comparable, Serializable {

    private String uuid;
    private GregorianCalendar date;
    private Integer yearPoint;
    private String name;
    //    Image image;
    private EventDescription description;
    private byte significance;  // up to 10
    String country;
    private boolean[] sphere; //1-out politic, 2-inner politic, 3-religion, 4-economic, 5-science, 6-culture

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

    public void setDate(int year, int month, int day) {
        date.set(year, month, day);
    }

    public GregorianCalendar getDate() {
        return date;
    }

    public int getYear() {
        return yearPoint;
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

    public byte getSignificance() {
        return significance;
    }

    public void setSignificance(byte significance) {
        this.significance = significance;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean[] getSphere() {
        return sphere;
    }

    public void setSphere(boolean[] sphere) {
        this.sphere = sphere;
    }

    @Override
    public int compareTo(Object e) {
        ChronoEvent event = (ChronoEvent) e;
        return this.date.compareTo(event.date);
    }

    public String getUuid() {
        return uuid;
    }
}


