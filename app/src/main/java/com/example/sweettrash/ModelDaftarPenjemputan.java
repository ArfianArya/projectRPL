package com.example.sweettrash;

public class ModelDaftarPenjemputan {

     private String username, nomorHp, alamat;

     public ModelDaftarPenjemputan(){}

     public ModelDaftarPenjemputan(String username, String nomorHp, String alamat){
         this.username = username;
         this.nomorHp = nomorHp;
         this.alamat = alamat;
     }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username){ this.username = username;}

    public String getNomorHp() {
        return nomorHp;
    }
    public void setNomorHp(String nomorHp){ this.nomorHp = nomorHp;}

    public String getAlamat() {
        return alamat;
    }
    public void setAlamat(String alamat){ this.alamat = alamat;}
}