package teka.mobile.retrofit22;

import com.google.gson.annotations.SerializedName;

/*
* NB: THIS MODEL IS NOT COMPLETE AND HENCE NOT USED
* This model class is going to be used for an instance whereby
* the response is an object containing an array.
* */
public class Product {
    private int id;
    private String title;
    private String description;
    private String thumbnail;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getThumbnail() {
        return thumbnail;
    }
}
