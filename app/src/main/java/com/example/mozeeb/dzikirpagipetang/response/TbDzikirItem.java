package com.example.mozeeb.dzikirpagipetang.response;

import com.google.gson.annotations.SerializedName;

public class TbDzikirItem{

	@SerializedName("id")
	private String id;

	@SerializedName("judul")
	private String judul;

	@SerializedName("gambar")
	private String gambar;

	@SerializedName("isi")
	private String isi;

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setJudul(String judul){
		this.judul = judul;
	}

	public String getJudul(){
		return judul;
	}

	public void setGambar(String gambar){
		this.gambar = gambar;
	}

	public String getGambar(){
		return gambar;
	}

	public void setIsi(String isi){
		this.isi = isi;
	}

	public String getIsi(){
		return isi;
	}

	@Override
 	public String toString(){
		return 
			"TbDzikirItem{" + 
			"id = '" + id + '\'' + 
			",judul = '" + judul + '\'' + 
			",gambar = '" + gambar + '\'' + 
			",isi = '" + isi + '\'' + 
			"}";
		}
}