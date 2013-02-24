/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bia.dailystandup.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author mdshannan
 */
@Embeddable
public class DailyStatus implements Serializable {

    @Temporal(TemporalType.DATE)
    @Column(name = "statusDay")
    private Date statusDay;
    //@ElementCollection
    @Lob
    @Column(length = 1024)
    private String statuses;

    public Date getStatusDay() {
        return statusDay;
    }

    public void setStatusDay(Date statusDay) {
        this.statusDay = statusDay;
    }

    public String getStatuses() {
        return statuses;
    }

    public void setStatuses(String statuses) {
        this.statuses = statuses;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + (this.statusDay != null ? this.statusDay.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DailyStatus other = (DailyStatus) obj;
        if (this.statusDay != other.statusDay && (this.statusDay == null || !this.statusDay.equals(other.statusDay))) {
            return false;
        }
        return true;
    }
}
