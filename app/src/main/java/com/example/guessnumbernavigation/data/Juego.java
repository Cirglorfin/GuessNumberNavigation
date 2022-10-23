package com.example.guessnumbernavigation.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * clase el nombre del usuario y el número de intentos.
 * Al ser Juego un objeto se debe implementar la interfaz Serializable y Parcelable en el objeto Juego.
 * @author Ciro León Espinosa Avilés
 * @version 1.0
 */
public class Juego implements Serializable, Parcelable {
    private String nombre;
    private String intentos;
    public static final String KEY="juego";
    public Juego(String nombre, String intentos) {
        this.nombre = nombre;
        this.intentos = intentos;
    }

//region MÉTODOS CREADOS DE LA INTERFAZ PARCELABLE
protected Juego(Parcel in) {
    nombre = in.readString();
    intentos = in.readString();
}

    public Juego() {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nombre);
        dest.writeString(intentos);
    }
public static final Creator<Juego> CREATOR = new Creator<Juego>() {
        @Override
        public Juego createFromParcel(Parcel in) {
            return new Juego(in);
        }

        @Override
        public Juego[] newArray(int size) {
            return new Juego[size];
        }
    };
    //endregion




    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIntentos() {
        return intentos;
    }

    public void setIntentos(String intentos) {
        this.intentos = intentos;
    }



}
