package usingrest.execcell.com.restapp;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Joseph.Pestonit on 12/22/2014.
 */
public class working_Today implements Parcelable {

    String id;
    int UserKey;
    String LogInDateTime;
    String LogOutDateTime;
    String LunchOutDateTime;
    String LunchInDateTime;
    String Lunch_Duration;
    String working_at;
    String Status;

    public working_Today(){

    }

    public working_Today(String id,int UserKey,String LogInDateTime,String LogOutDateTime,String LunchOutDateTime, String LunchInDateTime, String Lunch_Duration, String working_at, String Status) {
        this.id= id;
        this.UserKey = UserKey;
        this.LogInDateTime = LogInDateTime;
        this.LogOutDateTime = LogOutDateTime;
        this.LunchOutDateTime = LunchOutDateTime;
        this.LunchInDateTime = LunchInDateTime;
        this.Lunch_Duration = Lunch_Duration;
        this.working_at = working_at;
        this.Status = Status;
    }


    public working_Today(Parcel in){
        id = in.readString();
        UserKey = in.readInt();
        LogInDateTime = in.readString();
        LogOutDateTime = in.readString();
        LunchOutDateTime = in.readString();
        LunchInDateTime = in.readString();
        Lunch_Duration = in.readString();
        working_at = in.readString();
        Status = in.readString();
    }

    public String getId() {
        return id;
    }

    public String getLogOutDateTime() {return LogOutDateTime; }

    public void setLogOutDateTime(String logOutDateTime) {LogOutDateTime= logOutDateTime;}
    public void setId(String id) {
        this.id = id;
    }

    public int getUserKey() {
        return UserKey;
    }

    public void setUserKey(int userKey) {
        UserKey = userKey;
    }

    public String getLogInDateTime() {
        return LogInDateTime;
    }

    public void setLogInDateTime(String logInDateTime) {
        LogInDateTime = logInDateTime;
    }

    public String getLunchOutDateTime() {
        return LunchOutDateTime;
    }

    public void setLunchOutDateTime(String lunchOutDateTime) {
        LunchOutDateTime = lunchOutDateTime;
    }

    public String getLunchInDateTime() {
        return LunchInDateTime;
    }

    public void setLunchInDateTime(String lunchInDateTime) {
        LunchInDateTime = lunchInDateTime;
    }

    public String getLunch_Duration() {
        return Lunch_Duration;
    }

    public void setLunch_Duration(String lunch_Duration) {
        Lunch_Duration = lunch_Duration;
    }

    public String getWorking_at() {
        return working_at;
    }

    public void setWorking_at(String working_at) {
        this.working_at = working_at;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        this.Status = status;
    }

    public String toString(){

     return id +"\n"+ Status;
    }

    public String toString1(){
        return "CLOCK IN:"+LogInDateTime + "\n"
         +  "ClOCK OUT:"+LogOutDateTime + "\n"
         + "LUNCH OUT:"+LunchOutDateTime + "\n"
         + "LUNCH IN:"+LunchInDateTime + "\n"
         + "DURATION:"+Lunch_Duration + "\n"
         +  "LOCATION #"+ working_at;
    }
    public int describeContents(){
        return  0;
    }

    public void writeToParcel(Parcel dest, int flags){
        dest.writeString(id);
        dest.writeInt(UserKey);
        dest.writeString(LogInDateTime);
        dest.writeString(LogOutDateTime);
        dest.writeString(LunchOutDateTime);
        dest.writeString(LunchInDateTime);
        dest.writeString(Lunch_Duration);
        dest.writeString(working_at);
        dest.writeString(Status);
    }

    public static final Parcelable.Creator<working_Today> CREATOR = new Parcelable.Creator<working_Today>()
    {
        public working_Today createFromParcel(Parcel in)
        {
            return new working_Today(in);
        }
        public working_Today[] newArray(int size)
        {
            return new working_Today[size];

        }
    };
}
