package com.sp.dct.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "DEAL")
@NamedQueries(
        {
                @NamedQuery(name = Deal.ALL, query = "FROM Deal"),
                @NamedQuery(name = Deal.DELETE_BY_IDS, query = "DELETE FROM Deal where id in (:ids)"),
                @NamedQuery(name = Deal.GET_COUNT, query = "SELECT count(*) FROM Deal")
        }
)
public class Deal implements Serializable {

    public static final String ALL = "Deal.ALL";
    public static final String DELETE_BY_IDS = "Deal.DELETE_BY_IDS";
    public static final String GET_COUNT = "Deal.GET_COUNT";

    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surv_schedule")
    private SurveillanceSchedule surveillanceSchedule;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "initial_date")
    private Date initialDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @Column(name = "scheduled_date")
    private Date scheduledDate;

    @Column(name = "periods")
    private Integer periods;

    public enum SurveillanceSchedule {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPeriods() {
        return periods;
    }

    public void setPeriods(Integer periods) {
        this.periods = periods;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public SurveillanceSchedule getSurveillanceSchedule() {
        return surveillanceSchedule;
    }

    public void setSurveillanceSchedule(SurveillanceSchedule surveillanceSchedule) {
        this.surveillanceSchedule = surveillanceSchedule;
    }
}
