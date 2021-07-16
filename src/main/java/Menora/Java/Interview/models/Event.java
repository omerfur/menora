package Menora.Java.Interview.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;

@Entity
public class Event implements Serializable{

    @Id
    @JsonProperty("Id")
    private String id;
    @JsonProperty("Type")
    private String type;
    @JsonProperty("InsuredId")
    private BigDecimal insuredId;
    @JsonProperty("Product")
    @JacksonXmlElementWrapper(useWrapping = false)
    @Column(length = 2000)
    private ArrayList<Product> products;

    public Event() {
    }

    public Event(String id, String type, BigDecimal insuredId, ArrayList<Product> products) {
        this.id = id;
        this.type = type;
        this.insuredId = insuredId;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getInsuredId() {
        return insuredId;
    }

    public void setInsuredId(BigDecimal insuredId) {
        this.insuredId = insuredId;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", insuredId=" + insuredId +
                ", products=" + products +
                '}';
    }
}
