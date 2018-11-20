package com.example.mozeeb.dzikirpagipetang.response;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ResponseData{

	@SerializedName("tb_dzikir")
	private List<TbDzikirItem> tbDzikir;

	@SerializedName("status")
	private boolean status;

	public void setTbDzikir(List<TbDzikirItem> tbDzikir){
		this.tbDzikir = tbDzikir;
	}

	public List<TbDzikirItem> getTbDzikir(){
		return tbDzikir;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponseData{" + 
			"tb_dzikir = '" + tbDzikir + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}