package teka.mobile.retrofit22;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {

    @GET("/products")
    Call<ProductResponse> getProducts();
}
