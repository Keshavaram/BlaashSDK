package blaash.gaming.mobile.urlmodule;

import androidx.annotation.NonNull;

import org.json.JSONObject;

public class EventInfo {
    private String event_name;
    private JSONObject event_data;

    protected EventInfo(String event_name, JSONObject event_data) {
        this.event_name = event_name;
        this.event_data = event_data;
    }

    public String getEvent_name() {
        return event_name;
    }

    public void setEvent_name(String event_name) {
        this.event_name = event_name;
    }

    public JSONObject getEvent_data() {
        return event_data;
    }

    public void setEvent_data(JSONObject event_data) {
        this.event_data = event_data;
    }

    @NonNull
    @Override
    public String toString() {
        return "\tEvent Name = " + this.event_name + ",\n " + "\tJson = " + this.event_data;
    }
}
