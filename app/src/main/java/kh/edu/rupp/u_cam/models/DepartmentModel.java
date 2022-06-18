package kh.edu.rupp.u_cam.models;

import java.util.ArrayList;

public class DepartmentModel {
    ArrayList<String> feature;
    ArrayList<String> college;

    public DepartmentModel(ArrayList<String> feature, ArrayList<String> college) {
        this.feature = feature;
        this.college = college;
    }

    public ArrayList<String> getFeature() {
        return feature;
    }

    public ArrayList<String> getCollege() {
        return college;
    }
}
