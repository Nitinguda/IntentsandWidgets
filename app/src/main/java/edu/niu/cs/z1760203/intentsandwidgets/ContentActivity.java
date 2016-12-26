/*****************************************************************************

 CSCI 522 - Assignment 2 - Semester - Spring 2016

 Programmer: Nitin Vinod Guda
 Section   : 1
 Date Due  : 03/04/2016

 Purpose   : This activity is displays the information of the selected team in a
             scrollable textView. And also this activity contains a button to
             navigate to the home screen.

 ******************************************************************************/

package edu.niu.cs.z1760203.intentsandwidgets;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ContentActivity extends Activity {

    // defining the onCreate method
    // Called when the activity is first created.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        // Connecting the screen TextView object
        TextView txt1 = (TextView)findViewById(R.id.descTextView);

        // Connecting the screen ImageView object
        ImageView img2 = (ImageView)findViewById(R.id.titleImageView);

        // Return the intent that started this activity.
        Intent intent = getIntent();

        // Declaring a string to hold the selected team name retrieved from the intent
        String selected = intent.getStringExtra("selection");

        // Testing the selected team to display respective team information
        if(selected.equals("Golden State Warriors")){
            txt1.setText(R.string.desc);
            img2.setBackgroundResource(R.drawable.drawing);

        }
        else if (selected.equals("Los Angeles Lakers")){
            txt1.setText(R.string.desc2);
            img2.setBackgroundResource(R.drawable.los);
        }
        else if (selected.equals("Chicago Bulls")){
            txt1.setText(R.string.desc3);
            img2.setBackgroundResource(R.drawable.chic);
        }
        else if (selected.equals("Cleveland Cavaliers")){
            txt1.setText(R.string.desc4);
            img2.setBackgroundResource(R.drawable.cleve);
        }
        else {
            txt1.setText(R.string.desc5);
            img2.setBackgroundResource(R.drawable.san);
        }

    }

    //Using finish method to go back to the home page
    public void goBack( View v)
    {
        finish();
    }
}
