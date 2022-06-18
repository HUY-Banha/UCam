package kh.edu.rupp.u_cam.models;

import java.util.ArrayList;

public class DetailModel {

    String tittle;
    String description;
    String yearExperience;
    String awardHonors;
    String contact;

    public DetailModel() {}

    public DetailModel( String tittle, String description, String yearExperience, String awardHonors, String contact) {

        this.tittle = tittle;
        this.description = description;
        this.yearExperience = yearExperience;
        this.awardHonors = awardHonors;
        this.contact = contact;


    }


    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public String getYearExperience() {
        return yearExperience;
    }

    public String getAwardHonors() {
        return awardHonors;
    }


    public String getContact() {
        return contact;
    }

}
