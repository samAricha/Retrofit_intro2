package teka.mobile.retrofit22;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ProductResponse {

    @SerializedName("products")
    @Expose()
    private List<Product> products;

    public List<Product> getProducts(){
        return products;
    }
}
