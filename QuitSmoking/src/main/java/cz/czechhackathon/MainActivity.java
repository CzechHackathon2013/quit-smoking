
package cz.czechhackathon;

import android.app.Activity;
import android.content.Intent;
import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.games.Player;

import cz.czechhackathon.gps.BaseGameActivity;


public class MainActivity extends BaseGameActivity {

    Player p;

    private View signInBox;
    private View content;

    /**
     * Called when the activity is first created.
     * @param savedInstanceState If the activity is being re-initialized after 
     * previously being shut down then this Bundle contains the data it most 
     * recently supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it is null.</b>
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        content = (View) findViewById(R.id.content);
        signInBox = (View) findViewById(R.id.sign_in_bar);

        findViewById(R.id.sign_in_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginUserInitiatedSignIn();
            }
        });

    }

    private void showLogIn(boolean show){
        if(show){
            signInBox.setVisibility(View.VISIBLE);
            content.setVisibility(View.GONE);

        } else {
            content.setVisibility(View.VISIBLE);
            signInBox.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
	// Inflate the menu; this adds items to the action bar if it is present.
	getMenuInflater().inflate(R.menu.main, menu);
	return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        switch (item.getItemId()){

            case R.id.action_logout:
                signOut();
                showLogIn(true);
                return true;


            case R.id.action_settings:


                return true;
        }

        return super.onMenuItemSelected(featureId, item);

    }

    @Override
    public void onSignInFailed() {
        showLogIn(true);

        Toast.makeText(getApplicationContext(), "Chyba", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSignInSucceeded() {
        showLogIn(false);
        Toast.makeText(getApplicationContext(), ":)", Toast.LENGTH_LONG).show();
    }
}

