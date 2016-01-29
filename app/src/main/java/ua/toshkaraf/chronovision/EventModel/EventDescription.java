package ua.toshkaraf.chronovision.EventModel;

/**
 * Created by Антон on 31.12.2015.
 */
public class EventDescription {
    String text = "";

    public EventDescription() {
    }

    public EventDescription(String text) {
        this.text = text;
    }

    public void setText(String text){
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
