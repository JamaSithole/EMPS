package co.za.ngwane.epms.report.beans;

import  java.util.Date;

public class  ActorBean {

    private  String movie = "Lion King";
    private  String character;
    private  String name;
    private  Date birthday;

    public  ActorBean() {
    }

    public  ActorBean(String movie, String character, String name, Date birthday) {
        super ();
        this .movie = movie;
        this .character = character;
        this .name = name;
        this .birthday = birthday;
    }

    public  String getMovie() {
        return  movie;
    }

    public  void  setMovie(String movie) {
        this .movie = movie;
    }

    public  String getCharacter() {
        return  character;
    }

    public  void  setCharacter(String character) {
        this .character = character;
    }

    public  String getName() {
        return  name;
    }

    public  void  setName(String name) {
        this .name = name;
    }

    public  Date getBirthday() {
        return  birthday;
    }

    public  void  setBirthday(Date birthday) {
        this .birthday = birthday;
    }
    
}
