/*****************************************************************************

 CSCI 522 - Assignment 2 - Semester - Spring 2016

 Programmer: Nitin Vinod Guda
 Section   : 1
 Date Due  : 03/04/2016

 Purpose   : This application is used to display information about
             5 NBA (National Basketball Association) teams. The application
             consists of two activities, when a team is selected from the
             spinner in first activity, an image for that topic is displayed.
             When the user wants to see the information for that topic, they
             will click a button to start the second activity.

 ******************************************************************************/

package edu.niu.cs.z1760203.intentsandwidgets;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;

public class MainActivity extends Activity {

    // Initializing variables to hold screen objects
    private Spinner gameSpin;
    private String[] listOfObjects;     // Using a string array to hold team names
    private TypedArray images;          // Using an array to hold team images
    private ImageView itemImage;

    // defining the onCreate method
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Connecting the initialized variables with the screen objects
        listOfObjects = getResources().getStringArray(R.array.spinnerArray);
        images = getResources().obtainTypedArray(R.array.object_image);
        itemImage = (ImageView)findViewById(R.id.logoImageView);
        gameSpin = (Spinner)findViewById(R.id.gameSpinner);

        // Creating a new ArrayAdapter from external resources.
        ArrayAdapter<CharSequence> adapter01 = ArrayAdapter.createFromResource(getApplicationContext(), R.array.spinnerArray, R.layout.spinner1);

        // Sets the data behind this Spinner.
        gameSpin.setAdapter(adapter01);

        // Register a callback to be invoked when an item in this AdapterView has been selected.
        gameSpin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                // Sets a drawable as the content of this ImageView (itemImage)
                itemImage.setImageResource(images.getResourceId(gameSpin.getSelectedItemPosition(), -1));

                // Connecting the screen button object
                Button btn = (Button)findViewById(R.id.playerButton);
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String spinnerText = gameSpin.getSelectedItem().toString();

                        // Starting an intent(helpIntent) to start the ContentActivity
                        Intent helpIntent = new Intent(MainActivity.this, ContentActivity.class);

                        // Add extended data to the intent.
                        // Here the selected team name is sent via an intent to ContentActivity
                        helpIntent.putExtra("selection", spinnerText);

                        // The startActivity(Intent) method is used to start a new activity,
                        // which will be placed at the top of the activity stack.
                        // It takes a single argument, an Intent, which describes the activity to be executed.
                        startActivity(helpIntent);
                    }
                }); // End of onClickListener

            }   //End of onItemSelected

            // Callback method to be invoked when the selection disappears from this view.
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });     //setOnitemselectedListener

    }           //onCreate ends here

    }           //main ends here
