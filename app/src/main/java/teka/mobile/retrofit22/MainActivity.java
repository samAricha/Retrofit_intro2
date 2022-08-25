package teka.mobile.retrofit22;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView txtView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = findViewById(R.id.txt_view);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dummyjson.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);//retrofit bring life into the methods we created without a body i.e
        //retrofit creates the implementation of the various methods

        Call<ProductResponse> call = api.getProducts();

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(getApplicationContext(),"OUTSIDE",
                            Toast.LENGTH_LONG).show();
                    txtView.setText("code: " +response.code());
                    return;
                }
                Toast.makeText(getApplicationContext(),"INSIDE",
                        Toast.LENGTH_LONG).show();
                List<Product> products = new ArrayList<>(response.body().getProducts());
                for(Product product: products){
                    String content = "";
                    content += "ID: "+product.getId()+"\n";
                    content += "Title: "+product.getTitle()+"\n";
                    content += "Description: "+product.getDescription()+"\n";
                    content += "Thumbnail: "+product.getThumbnail()+"\n\n";



                    txtView.append(content);
                }

            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {

            }
        });

    }
}