package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();  // ✅ Correct capitalization
        System.out.println("Client created: " + client);
        String url = "https://jsonplaceholder.typicode.com/posts/1";  // ✅ Correct URL
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                System.out.println("Response: " + response.body().string());
            } else
                System.out.println("Request failed: " + response.code());

        } catch (IOException exp) {
            exp.printStackTrace();
        }
    }
}
