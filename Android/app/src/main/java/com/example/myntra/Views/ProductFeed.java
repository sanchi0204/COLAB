package com.example.myntra.Views;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.myntra.Adapters.ProductAdapter;
import com.example.myntra.Model.Constants;
import com.example.myntra.Model.MySingleton;
import com.example.myntra.Model.ProductType;
import com.example.myntra.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductFeed extends AppCompatActivity {

    RecyclerView recyclerViewProductFeed;
    private boolean doSend = true;
    DatabaseReference reference=FirebaseDatabase.getInstance().getReference().child("results");
    ArrayList<ProductType> productItemList;
    ProductAdapter productAdapter;
    List<String> productId;
    String[] mArray;
    FirebaseAuth mAuth;
    private static final String TAG = "ProductFeed";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_feed);

        mAuth = FirebaseAuth.getInstance();

        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.app_name));
        setSupportActionBar(toolbar);

        recyclerViewProductFeed = findViewById(R.id.recycler_product);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recyclerViewProductFeed.setLayoutManager(gridLayoutManager);
        productId = new ArrayList<>();

        //handle api responses for recommendations
         sendAndRequestResponse();

            reference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    productItemList = new ArrayList<>();

                    for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                            Log.d(TAG, "Result0:" + dataSnapshot1);

                            ProductType prod = dataSnapshot1.getValue(ProductType.class);
                            productItemList.add(prod);
                        Log.d(TAG, "Added item datas");

                    }

                            productAdapter = new ProductAdapter(productItemList,
                ProductFeed.this,
                Constants.friendCart,
                Constants.friendWish);
        recyclerViewProductFeed.setAdapter(productAdapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Toast.makeText(ProductFeed.this, "Something went wrong", Toast.LENGTH_SHORT).show();
                }
            });


    }


    private void sendAndRequestResponse() {

        Map<String,String> data = new HashMap<>();
        data.put("product_ID",Constants.PRODUCTID );
        data.put("User_id", mAuth.getUid());
        data.put("Ratings",Constants.RATING);

        JSONObject jsonData = new JSONObject(data);
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.POST, "https://scando.herokuapp.com/predict",jsonData, response -> {
            try {
                Log.d("Response", String.valueOf(response.get("key")));
               // Toast.makeText(this, String.valueOf(response.get("key")), Toast.LENGTH_SHORT).show();
                String op = String.valueOf(response.get("key"));
                JSONArray temp = new JSONArray(op);
                mArray = temp.join(",").split(",");
                productId = Arrays.asList(mArray);


            } catch(JSONException e) {
                e.printStackTrace();
            }
            doSend = !doSend;
        },

                error -> {
                    Toast.makeText(getApplicationContext(),"Something went wrong",Toast.LENGTH_LONG).show();
                    error.printStackTrace();
                });

        if (doSend){
            MySingleton.getInstance(this).addToRequestQueue(request);
            doSend = !doSend;
        }

    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.notif_dash, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {
            case R.id.item1:
                return true;

            case R.id.item2:
                Intent intent = new Intent(ProductFeed.this, Cart.class);
                startActivity(intent);
                return true;

            case R.id.item3:
                Intent i = new Intent(ProductFeed.this, Friends.class);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}