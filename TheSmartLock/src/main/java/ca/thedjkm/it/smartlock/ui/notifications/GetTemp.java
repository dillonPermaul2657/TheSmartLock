// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B
package ca.thedjkm.it.smartlock.ui.notifications;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


import ca.thedjkm.it.smartlock.R;

public class GetTemp extends AppCompatActivity {


    // creating variables for Firebase Database.
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private TextView retrieveTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_temp);


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Temp");

        retrieveTV = findViewById(R.id.idTVRetrieveDataTemp);

        //getTemp();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                // this method is call to get the realtime
                // updates in the data.
                // this method is called when the data is
                // changed in our Firebase console.
                // below line is for getting the data from
                // snapshot of our database.
                String value = snapshot.getValue(String.class);

                // after getting the value we are setting
                // our value to our text view in below line.
                retrieveTV.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getApplicationContext(),"Fail to get data",Toast.LENGTH_SHORT).show();
            }



        });


    }







}
