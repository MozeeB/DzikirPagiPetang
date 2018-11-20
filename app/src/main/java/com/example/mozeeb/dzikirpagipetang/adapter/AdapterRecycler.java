package com.example.mozeeb.dzikirpagipetang.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mozeeb.dzikirpagipetang.DetailActivity;
import com.example.mozeeb.dzikirpagipetang.R;
import com.example.mozeeb.dzikirpagipetang.response.TbDzikirItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.MyViewHolder> {
    //Buat GLOBAL variabel untuk menampung context
    Context context;
    List<TbDzikirItem> tbDzikirItems;
    public AdapterRecycler(Context context, List<TbDzikirItem> data){
        //inisialisi
        this.context = context;
        this.tbDzikirItems = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        //Layout inflater
        View view = LayoutInflater.from(context).inflate(R.layout.design_list,parent,false);
        //hubungkan dengan myViewHolder
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position){
        //set widget
        holder.tvJudul.setText(tbDzikirItems.get(position).getJudul());
        //dapatkan url gambar
        final String urlGambarBerita = "" + tbDzikirItems.get(position).getGambar();
        //set image ke widget deengan picca library
        //karena image dari internet
        Picasso.with(context).load(urlGambarBerita).into(holder.ivGamvar);
        //Event klik ketika item list nya di klik
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //memulai Activity Details
                Intent varIntent = new Intent(context, DetailActivity.class);
                //sisipkan data ke intent
                varIntent.putExtra("judul", tbDzikirItems.get(position).getJudul());
                varIntent.putExtra("gambar", tbDzikirItems.get(position).getGambar());
                varIntent.putExtra("isi", tbDzikirItems.get(position).getIsi());


                //method startActivity cuma bisa di pakai di Activity/Fragment
                //jadi harus masuk ke context dulu
                context.startActivity(varIntent);
            }
        });
    }
    //menentukan jumlah item yang tampil
    @Override
    public int getItemCount(){
        return tbDzikirItems.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        //declarasi widget
        ImageView ivGamvar;
        TextView tvJudul;
        TextView tvIsi;

        public MyViewHolder(View itemView){
            super(itemView);
            //inisialisai widget
            ivGamvar =(ImageView)itemView.findViewById(R.id.gambar_das);
            tvJudul = (TextView)itemView.findViewById(R.id.judul);
            tvIsi = (TextView)itemView.findViewById(R.id.isi);
        }
    }
}
