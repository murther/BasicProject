package com.steve.basicproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Steve on 10/23/2014.
 */
public class FriendList extends Activity {
    private List<Friend> myFriends = new ArrayList<Friend>();

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.friendlist);
        setMyFriends();
        setFriendListView();
    }
    private void setMyFriends(){
        myFriends.add(new Friend("Friend 1",1,"Favorite",R.drawable.myspace_tom));
        myFriends.add(new Friend("Friend 2",2,"Regular",R.drawable.myspace_tom));
        myFriends.add(new Friend("Friend 3",3,"Regular",R.drawable.myspace_tom));
        myFriends.add(new Friend("Friend 4",4,"Favorite",R.drawable.myspace_tom));
        myFriends.add(new Friend("Friend 5",5,"Favorite",R.drawable.myspace_tom));
        myFriends.add(new Friend("Friend 6",6,"Favorite",R.drawable.myspace_tom));
    }
    private void setFriendListView(){
        ArrayAdapter<Friend> adapter = new MyListAdapter();
        ListView list= (ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
    }
    /*private void registerClickCallback(){
        ListView list=  (ListView)findViewById(R.id.list);
        list.setOnClickListener(new AdapterView.OnItemClickListener(){
            @Override
        public void onItemClick(AdapterView<?> parent, View viewClicked,int position, long id){
                Friend clickedFriend = myFriends.get(position);
                String message="you clicked"+clickedFriend.getPerson();
                Toast.makeText(FriendList.this, message, Toast.LENGTH_LONG).show();
            }
        });
    } */
    private class MyListAdapter extends ArrayAdapter<Friend>{
        public MyListAdapter(){
            super(FriendList.this,R.layout.friendlistimages,myFriends);
        }
    @Override
        public View getView(int position, View convertView, ViewGroup parent){
        View itemView= convertView;
        if(itemView==null){
            itemView=getLayoutInflater().inflate(R.layout.friendlistimages,parent, false);
        }
        //find friend
        Friend currentFriend = myFriends.get(position);
        //fill in the list for the view
        ImageView imageView= (ImageView)findViewById(R.id.image1);
        imageView.setImageResource(currentFriend.getIconId());
        //friend Name
        TextView friendText=(TextView)itemView.findViewById(R.id.friendName);
        friendText.setText(currentFriend.getPerson());
        //status
        TextView statusText=(TextView)itemView.findViewById(R.id.friendStatus);
        statusText.setText(currentFriend.getFavorite());
        return itemView;
        //return super.getView(position, convertView,parent);
    }
    }
}
