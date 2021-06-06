package com.example.pronotebook;

public class note {
    private String hading;
    private  String decrip;

    public note(String hading, String decrip){
        this.hading=hading;
        this.decrip=decrip;
    }

    public String getHading() {
        return hading;
    }

    public void setHading(String hading) {
        this.hading = hading;
    }

    public String getDecrip() {
        return decrip;
    }

    public void setDecrip(String decrip) {
        this.decrip = decrip;
    }
}
