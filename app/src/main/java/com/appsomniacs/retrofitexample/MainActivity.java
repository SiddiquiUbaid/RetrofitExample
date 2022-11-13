package com.appsomniacs.retrofitexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    TextView tvResult;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = findViewById(R.id.tvResult);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


       /*

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts(4, "id", "desc");
        call.enqueue(new Callback<List<Post>>() {
                         @Override
                         public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                             if (!response.isSuccessful()) {
                                 tvResult.setText(response.code());
                             }

                             List<Post> posts = response.body();

                             for (Post post : posts) {
                                 String content = "";
                                 content += "ID: " + post.getId() + "\n";
                                 content += "User ID: " + post.getUserId() + "\n";
                                 content += "Title: " + post.getTitle() + "\n";
                                 content += "Text: " + post.getText() + "\n\n";

                                 tvResult.append(content);


                             }


                         }

                         @Override
                         public void onFailure(Call<List<Post>> call, Throwable t) {
                             tvResult.setText(t.getMessage());

                         }

        */




        //Post post = new Post(7, "MS Dhoni", "MS Dhoni is cricket player");

        Call<Post> call = jsonPlaceHolderApi.createPost(18, "Virat Kohli", "Virat Kohli is a circket player");
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    tvResult.setText("Code: " + response.code());
                }

                Post postResponse = (Post) response.body();

                String content = "";
                content += "CODE: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";

                tvResult.setText(content);



            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                tvResult.setText(t.getMessage());


            }
        });


    }



    public void munna(){
        Call<Post> call = jsonPlaceHolderApi.createPost(18, "Virat Kohli", "Virat Kohli is a circket player");

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    tvResult.setText("Code: " + response.code());
                }

                Post postResponse = (Post) response.body();

                String content = "";
                content += "CODE: " + response.code() + "\n";
                content += "ID: " + postResponse.getId() + "\n";
                content += "User ID: " + postResponse.getUserId() + "\n";
                content += "Title: " + postResponse.getTitle() + "\n";
                content += "Text: " + postResponse.getText() + "\n\n";

                tvResult.setText(content);



            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                tvResult.setText(t.getMessage());


            }
        });






    }

}





