package Menora.Java.Interview.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class Product implements Serializable{
    @JsonProperty("Type")
    private String type;
    @JsonProperty("Price")
    private BigDecimal price;
    @JsonProperty("StartDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date startDate;
    @JsonProperty("EndDate")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date endDate;

    public Product() {
    }

    public Product(String type, BigDecimal price, Date startDate, Date endDate) {
        this.type = type;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "type='" + type + '\'' +
                ", price=" + price +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
