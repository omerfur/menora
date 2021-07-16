package Menora.Java.Interview.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

public class RequestDetails {

    @JsonProperty("Id")
    private String id;
    @JsonProperty("AcceptDate")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date acceptDate;
    @JsonProperty("SourceCompany")
    private String sourceCompany;

    public RequestDetails() {
    }

    public RequestDetails(String id, Date acceptDate, String sourceCompany) {
        this.id = id;
        this.acceptDate = acceptDate;
        this.sourceCompany = sourceCompany;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getSourceCompany() {
        return sourceCompany;
    }

    public void setSourceCompany(String sourceCompany) {
        this.sourceCompany = sourceCompany;
    }

    @Override
    public String toString() {
        return "RequestDetails{" +
                "id='" + id + '\'' +
                ", acceptDate=" + acceptDate +
                ", sourceCompany='" + sourceCompany + '\'' +
                '}';
    }
}
