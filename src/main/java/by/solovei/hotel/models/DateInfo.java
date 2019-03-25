package by.solovei.hotel.models;

import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class DateInfo {

    private Date dateFrom;
    private Date dateTo;

    public DateInfo() {
    }

    public DateInfo(Date dateFrom, Date dateTo) {
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }
}
