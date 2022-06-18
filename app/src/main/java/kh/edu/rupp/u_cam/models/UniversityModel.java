package kh.edu.rupp.u_cam.models;
import com.google.firebase.database.IgnoreExtraProperties;

import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

@IgnoreExtraProperties
public class UniversityModel {
    String universityName;
    String imageLogo;
    String universityPlace;

    public UniversityModel() {}

    public UniversityModel(String image, String name, String place) {
        this.imageLogo = image;
        this.universityName = name;
        this.universityPlace = place;
    }

    public String getImageLogo() {
        return imageLogo;
    }
    public String getUniversityName() {
        return universityName;
    }
    public String getUniversityPlace() {
        return universityPlace;
    }

}
