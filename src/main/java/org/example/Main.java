package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.io.IOException;
import java.util.List;



public class Main {
    public static void main(String[] args) throws IOException {
//        OkHttpClient client = new OkHttpClient();  // ✅ Correct capitalization
//        System.out.println("Client created: " + client);
//        String url = "https://jsonplaceholder.typicode.com/posts/1";  // ✅ Correct URL
//        Request request = new Request.Builder()
//                .url(url)
//                .build();
//        try (Response response = client.newCall(request).execute()) {
//            if (response.isSuccessful()) {
//                System.out.println("Response: " + response.body().string());
//            } else
//                System.out.println("Request failed: " + response.code());
//
//        } catch (IOException exp) {
//            exp.printStackTrace();
//        }
        //
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GitHubService service = retrofit.create(GitHubService.class);

        Call<List<Repo>> call = service.listRepos("octocat");

        Response<List<Repo>> response = call.execute(); // synchronous

        if (response.isSuccessful()) {
            List<Repo> repos = response.body();
            for (Repo repo : repos) {
                System.out.println(repo);
            }
        } else {
            System.out.println("Failed: " + response.code());
        }
    }
}
