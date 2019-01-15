package com.example.pedro.nosurf;

/**
 * Created by pedro on 08/06/17.
 */

public class Praias {

    private String android_version_name;
    private String android_image_url;
    private String temperatura;
    private String vento;
    private String onda;

    public String getVento() {
        return vento;
    }

    public void setVento(String vento) {
        this.vento = vento;
    }

    public String getOnda() {
        return onda;
    }

    public void setOnda(String onda) {
        this.onda = onda;
    }

    public String getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(String temperatura) {
        this.temperatura = temperatura;
    }

    public String getAndroid_version_name() {
        return android_version_name;
    }

    public void setAndroid_version_name(String android_version_name) {
        this.android_version_name = android_version_name;
    }

    public String getAndroid_image_url() {
        return android_image_url;
    }

    public void setAndroid_image_url(String android_image_url) {
        this.android_image_url = android_image_url;
    }
}
