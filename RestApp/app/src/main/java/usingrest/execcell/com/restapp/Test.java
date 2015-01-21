package usingrest.execcell.com.restapp;

import java.sql.Timestamp;
import java.text.DateFormat;

/**
 * Created by Joseph.Pestonit on 11/26/2014.
 */
public class Test {

    private int id;
    private int level;
    private int time_in_secs;
    private int par;
    private String initials;
    private String quote;



    private String time_stamp;




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTime_in_secs() {
        return time_in_secs;
    }

    public void setTime_in_secs(int time_in_secs) {
        this.time_in_secs = time_in_secs;
    }

    public int getPar() {
        return par;
    }

    public void setPar(int par) {
        this.par = par;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }



    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getTime_stamp() {
        return time_stamp;
    }

    public void setTime_stamp(String time_stamp) {
        this.time_stamp = time_stamp;
    }
  public String toString(){
      return String.format("OBJECT:\tID:%d)\n",id);
  }
}
