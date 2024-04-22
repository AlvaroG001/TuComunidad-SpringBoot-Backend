package com.tucomunidad.api.model;

import jakarta.persistence.*;

@Entity
@Table(name = "reuniones")
public class Reunion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "community_id", nullable = false)
    private Comunidad comunidad;

    @Column(name = "dia", nullable = false)
    private String day;

    @Column(name = "hora", nullable = false)
    private String hour;

    @Column(name = "mes", nullable = false)
    private String month;

    @Column(name = "año", nullable = false)
    private String year;

    @Column(nullable = false, length = 500)
    private String information;


    // Constructors
    public Reunion() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comunidad getComunidad() {
        return comunidad;
    }

    public void setComunidad(Comunidad comunidad) {
        this.comunidad = comunidad;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
