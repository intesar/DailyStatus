package com.bia.dailystandup.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.Cache;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import org.hibernate.search.annotations.*;

/**
 *
 * @author Intesar Mohammed <mdshannan@gmail.com>
 */
@Entity
@Table(name = "Standup")
@Cache(usage = NONSTRICT_READ_WRITE)
@Indexed
@XmlRootElement
public class Standup implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Field
    @Column
    private String hashtag;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;
    // daily statuses
    @ElementCollection(fetch = FetchType.EAGER)
    private Set<DailyStatus> dailyStatuses = new HashSet<DailyStatus>();

    public Standup() {
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Set<DailyStatus> getDailyStatuses() {
        return dailyStatuses;
    }

    public void setDailyStatuses(Set<DailyStatus> dailyStatuses) {
        this.dailyStatuses = dailyStatuses;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + (this.hashtag != null ? this.hashtag.hashCode() : 0);
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
        final Standup other = (Standup) obj;
        if ((this.hashtag == null) ? (other.hashtag != null) : !this.hashtag.equals(other.hashtag)) {
            return false;
        }
        return true;
    }
}
