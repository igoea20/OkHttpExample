package com.example.okhttpexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

//pull all the tables at the same time
public class MainActivity extends AppCompatActivity {
    private TextView mTextViewResult;
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewResult = findViewById(R.id.text_view_result);

        //get request   client_table
        OkHttpClient client = new OkHttpClient();
        String urlClient = "https://workmatedb.ddns.net/workmateFiles/json_output_client.php";
        Request request = new Request.Builder()
                .url(urlClient)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();
                    loadClients(myResponse);

                    //the json object is stored in myResponse
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(myResponse);
                        }
                    });

                }
            }
        });
    }

    private void loadClients(String stringResponse) {
        try {
            JSONArray array = new JSONArray((stringResponse));

            for(int i = 0; i<array.length();i++) {
                JSONObject client = array.getJSONObject(i);

                ClientModel clientModel = new ClientModel(client.getInt("client_id"), client.getString("client_fname"),
                        client.getString("client_lname"), client.getString("client_email"), client.getString("client_phone"), client.getString("client_addr"));
                Log.d("STRING", clientModel.toString());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
