package usingrest.execcell.com.restapp;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.EventLogTags;

/**
 * Created by Joseph.Pestonit on 12/3/2014.
 */
public class Locations implements Parcelable {
    int PrimeKey;
    String Code;

    public Locations(int PrimeKey, String Code){
        this.PrimeKey= PrimeKey;
        this.Code = Code;
    }
    public Locations(){

    }
    public Locations(Parcel in){
        PrimeKey = in.readInt();
        Code = in.readString();

    }

    public int getPrimeKey() {
        return PrimeKey;
    }

    public void setPrimeKey(int primeKey) {
        PrimeKey = primeKey;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }


    public String toString(){
        return Code ;

    }
    public int describeContents(){
        return  0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeInt(PrimeKey);
        dest.writeString(Code);

    }
    public static final Parcelable.Creator<Locations> CREATOR = new Parcelable.Creator<Locations>()
    {
        public Locations createFromParcel(Parcel in)
        {
            return new Locations(in);
        }
        public Locations[] newArray(int size)
        {
            return new Locations[size];

        }
    };
}
