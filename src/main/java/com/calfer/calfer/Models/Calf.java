package com.calfer.calfer.Models;

import com.calfer.calfer.Utils.CalfSex;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "calves")
public class Calf {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagNumber;

    private String details;

    @Temporal(TemporalType.DATE)
    private Date birthDate;

    private Integer birthWeight;

    @Enumerated(EnumType.STRING)
    private CalfSex calfSex;

    public Calf() {
    }

    public Calf(String tagNumber, String details, Date date,Integer birthWeight,CalfSex calfSex){
        this.tagNumber = tagNumber;
        this.details = details;
        this.birthDate = date;
        this.birthWeight = birthWeight;
        this.calfSex = calfSex;
    }

    //GETTERS


    public String getTagNumber() {
        return tagNumber;
    }

    public Long getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public Integer getBirthWeight(){
        return this.birthWeight;
    }
    public CalfSex getCalfSex(){
        return this.calfSex;
    }

    //SETTERS

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setTagNumber(String tagNumber) {
        this.tagNumber = tagNumber;
    }
    public void setBirthWeight(Integer birthWeight){
        this.birthWeight = birthWeight;
    }
    public void setCalfSex(CalfSex calfSex){
        this.calfSex = calfSex;
    }
}
