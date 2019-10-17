package com.example.githubpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.makeText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.listview);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();


        Api api=retrofit.create(Api.class);
        Call<List<Git>> Call=api.getGit();

        Call.enqueue(new Callback<List<Git>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Git>> call, Response<List<Git>> response) {

             List<Git> gits=response.body();

             String[] gitNames= new String[gits.size()];
             for (int i=0; i<gits.size();i++){

                 gitNames[i]=gits.get(i).getType();

                 listView.setAdapter(
                         new ArrayAdapter<String>(
                                 getApplicationContext(),
                                 android.R.layout.simple_list_item_1,
                                 gitNames
                         )

                 );

             }
            }

            @Override
            public void onFailure(retrofit2.Call<List<Git>> call, Throwable t) {

             makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
