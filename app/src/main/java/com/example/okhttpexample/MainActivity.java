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
    private TextView mTextViewResults;
    private TextView mTextViewResulto;
    private TextView mTextViewResultr;

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewResult = findViewById(R.id.text_view_result);
        mTextViewResults = findViewById(R.id.textViewsupplier);
        mTextViewResulto = findViewById(R.id.textViewOrder);
        mTextViewResultr = findViewById(R.id.textViewRating);

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
                    final String myResponsec = response.body().string();
                    loadClients(myResponsec);

                    //the json object is stored in myResponse
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResult.setText(myResponsec);
                        }
                    });

                }
            }
        });
        //get request   supplier_table
        OkHttpClient supplier = new OkHttpClient();
        String urlSupplier = "https://workmatedb.ddns.net/workmateFiles/json_output_supplier.php";
        Request requestS = new Request.Builder()
                .url(urlSupplier)
                .build();

        supplier.newCall(requestS).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponses = response.body().string();
                    loadSuppliers(myResponses);

                    //the json object is stored in myResponse
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResults.setText(myResponses);
                        }
                    });

                }
            }
        });
        //get request   order_table
        OkHttpClient order = new OkHttpClient();
        String urlOrder = "https://workmatedb.ddns.net/workmateFiles/json_output_order.php";
        Request requestO = new Request.Builder()
                .url(urlOrder)
                .build();

        order.newCall(requestO).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponseo = response.body().string();
                    loadOrders(myResponseo);

                    //the json object is stored in myResponse
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResulto.setText(myResponseo);
                        }
                    });

                }
            }
        });

        //get request   rating_table
        OkHttpClient rating = new OkHttpClient();
        String urlRating = "https://workmatedb.ddns.net/workmateFiles/json_output_rating.php";
        Request requestR = new Request.Builder()
                .url(urlRating)
                .build();

        order.newCall(requestR).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponser = response.body().string();
                    loadRatings(myResponser);

                    //the json object is stored in myResponse
                    MainActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTextViewResultr.setText(myResponser);
                        }
                    });

                }
            }
        });




    }


    private void loadClients(String stringResponse) {
        try {
            JSONArray array = new JSONArray((stringResponse));

            for (int i = 0; i < array.length(); i++) {
                JSONObject client = array.getJSONObject(i);

                ClientModel clientModel = new ClientModel(client.getInt("client_id"), client.getString("client_fname"),
                        client.getString("client_lname"), client.getString("client_email"), client.getString("client_phone"), client.getString("client_addr"));
                Log.d("STRING", clientModel.toString());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void loadSuppliers(String stringResponse) {
        try {
            JSONArray array = new JSONArray((stringResponse));

            for (int i = 0; i < array.length(); i++) {
                JSONObject supplier = array.getJSONObject(i);

                SupplierModel supplierModel = new SupplierModel(supplier.getInt("supplier_id"), supplier.getString("supplier_fname"),
                        supplier.getString("supplier_lname"), supplier.getString("supplier_email"), supplier.getString("supplier_phone"), supplier.getString("supplier_service"), supplier.getString("supplier_addr"));
                Log.d("STRING", supplierModel.toString());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void loadOrders(String stringResponse) {
        try {
            JSONArray array = new JSONArray((stringResponse));

            for (int i = 0; i < array.length(); i++) {
                JSONObject order = array.getJSONObject(i);

                OrderModel orderModel = new OrderModel(order.getInt("order_id"), order.getString("client_email"),
                        order.getString("supplier_email"), order.getString("supplier_service"), order.getString("order_date"), order.getInt("order_hours"), order.getString("order_location"));
                Log.d("STRING", orderModel.toString());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void loadRatings(String stringResponse) {
        try {
            JSONArray array = new JSONArray((stringResponse));

            for (int i = 0; i < array.length(); i++) {
                JSONObject rating = array.getJSONObject(i);

                RatingModel ratingModel = new RatingModel(rating.getInt("rating_id"), rating.getString("client_email"),
                        rating.getString("supplier_email"), rating.getInt("rating_number"), rating.getString("rating_comment"));
                Log.d("STRING", ratingModel.toString());

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }



}


