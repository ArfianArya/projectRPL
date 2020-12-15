package com.example.sweettrash;

public class ModelJual {

     private String namaSampah, kategoriSampah, beratSampah, jenisTopUp;

     public ModelJual(){}

     public ModelJual(String namaSampah, String kategoriSampah, String beratSampah, String jenisTopUp){
         this.namaSampah = namaSampah;
         this.kategoriSampah = kategoriSampah;
         this.beratSampah = beratSampah;
         this.jenisTopUp = jenisTopUp;
     }

    public String getNamaSampah() {
        return namaSampah;
    }
    public void setUsername(String namaSampah){ this.namaSampah = namaSampah;}

    public String getkategoriSampah() {
        return kategoriSampah;
    }
    public void setkategoriSampah(String kategoriSampah){ this.kategoriSampah = kategoriSampah;}

    public String getberatSampah() {
        return beratSampah;
    }
    public void setberatSampah(String beratSampah){ this.beratSampah = beratSampah;}

    public String getjenisTopUp() {
        return jenisTopUp;
    }
    public void setjenisTopUp(String jenisTopUp){ this.jenisTopUp = jenisTopUp;}
}