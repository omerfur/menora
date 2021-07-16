package Menora.Java.Interview.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;


@XmlRootElement(name = "Root")
public class RootObject {
    @JsonProperty("RequestDetails")
    RequestDetails requestDetails;
    @JsonProperty("Event")
    @JacksonXmlElementWrapper(useWrapping = false)
    ArrayList<Event> events;

    public RootObject() {
    }

    public RootObject(RequestDetails requestDetails, ArrayList<Event> events) {
        this.requestDetails = requestDetails;
        this.events = events;
    }

    public RequestDetails getRequestDetails() {
        return requestDetails;
    }

    public void setRequestDetails(RequestDetails requestDetails) {
        this.requestDetails = requestDetails;
    }

    public ArrayList<Event> getEvents() {
        return events;
    }

    public void setEvents(ArrayList<Event> events) {
        this.events = events;
    }

    @Override
    public String toString() {
        return "RootObject{" +
                "requestDetails=" + requestDetails +
                ", events=" + events +
                '}';
    }
}
