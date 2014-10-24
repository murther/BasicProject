package com.steve.basicproject;

/**
 * Created by Steve on 10/23/2014.
 */
public class Friend {
    private String person;
    private int personID;
    private String favorite;
    private int iconId;

    public Friend(String person, int personID, String favorite,int iconID){
        super();
        this.person=person;
        this.personID=personID;
        this.favorite=favorite;
        this.iconId=iconID;
    }
    public String getPerson(){
        return person;
    }
    public String getFavorite(){
        return favorite;
    }
    public int getPersonID(){
        return personID;
    }
    public int getIconId(){return iconId;}

}
