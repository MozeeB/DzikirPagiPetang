package com.example.mozeeb.dzikirpagipetang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {

    @BindView(R.id.gambar_detail)
    ImageView gambarDetail;
    @BindView(R.id.judul_detail)
    TextView judulDetail;
    @BindView(R.id.isi)
    TextView isi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        Picasso.with(this).load(getIntent().getIntExtra("gambar" ,1)).into(gambarDetail);
        judulDetail.setText(getIntent().getStringExtra("judul"));
        isi.setText(getIntent().getStringExtra("isi"));
    }
}
