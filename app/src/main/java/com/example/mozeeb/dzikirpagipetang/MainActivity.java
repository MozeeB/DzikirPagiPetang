package com.example.mozeeb.dzikirpagipetang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.mozeeb.dzikirpagipetang.adapter.AdapterRecycler;
import com.example.mozeeb.dzikirpagipetang.api.ApiService;
import com.example.mozeeb.dzikirpagipetang.api.UtilsApi;
import com.example.mozeeb.dzikirpagipetang.response.ResponseData;
import com.example.mozeeb.dzikirpagipetang.response.TbDzikirItem;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
// Inisialisasi Widget
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
// RecyclerView harus pakai Layout manager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
// Eksekusi method
        tampilDzikir();
    }
        private void tampilDzikir() {
            ApiService api = UtilsApi.getApiService();
// Siapkan request
            Call<ResponseData> dataCall = api.getAllData();
// Kirim request
            dataCall.enqueue(new Callback<ResponseData>() {
                @Override
                public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
// Pasikan response Sukses
                    if (response.isSuccessful()) {
                        Log.d("response api", response.body().toString());
// tampung data response body ke variable
                        List<TbDzikirItem> data = response.body().getTbDzikir();
                        boolean status = response.body().isStatus();
// Kalau response status nya = true
                        if (status) {
// Buat Adapter untuk recycler view
                            AdapterRecycler adapter = new AdapterRecycler(MainActivity.this, data);
                            recyclerView.setAdapter(adapter);
                        } else {
// kalau tidak true
                            Toast.makeText(MainActivity.this, "Tidak ada Data untuk saat ini", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

                @Override
                public void onFailure(Call<ResponseData> call, Throwable t) {
// print ke log jika Error
                    t.printStackTrace();
                }
            });
        }

    }

