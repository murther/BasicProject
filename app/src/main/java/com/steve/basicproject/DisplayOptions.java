package com.steve.basicproject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Steve on 10/13/2014.
 */
public class DisplayOptions extends Activity implements View.OnClickListener {
    private Button mapButton;
    private Button frndButton;
    private Button msgButton;
    private Button endButton;

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.display);
        mapButton= (Button)findViewById(R.id.map);
        frndButton=(Button)findViewById(R.id.fList);
        msgButton=(Button)findViewById(R.id.message);
        endButton=(Button)findViewById(R.id.end);
        mapButton.setOnClickListener(this);
        frndButton.setOnClickListener(this);
        msgButton.setOnClickListener(this);
        endButton.setOnClickListener(this);
    }
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.map:
                showMap();
                break;
            case R.id.fList:
                showFriendsList();
                break;
            case R.id.message:
                showNotification();
                break;
            case R.id.end:
                endApp();
                break;
        }
    }
    public void showMap(){
        Intent intent=new Intent(this,DisplayMap.class);
        startActivity(intent);
    }
    public void showFriendsList(){
        Intent intent = new Intent(this,FriendList.class);
        startActivity(intent);
    }
    public void showNotification(){

    }
    public void endApp(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        dialogBuilder.setTitle("Go Offline");
        dialogBuilder.setMessage("Go offline so nobody can see you?");
        dialogBuilder.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(DisplayOptions.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(),"Nobody can see you",Toast.LENGTH_LONG).show();
            }
        });
        dialogBuilder.setNegativeButton("No",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"Resume what you were doing",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialogBuilder.create();
        alertDialog.show();
    }
    //public void onClick(View v){
    //    Intent intent= new Intent(this,DisplayMap.class);
    //    startActivity(intent);
    //}
}
