package com.example.nino.lec4;

public class chModel {
    private String channel, detail;
    private int image, aidi;

    public chModel (String channel, int aida , int image , String detail)
    {
        this.channel = channel;
        this.image = image;
        this.aidi = aida;
        this.detail = detail;

    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getAidi() {
        return aidi;
    }

    public void setAidi(int aidi) {
        this.aidi = aidi;
    }

    public String getDetail() {return detail;}

    public void setDetail(String detail) { this.detail  = detail;}

}
