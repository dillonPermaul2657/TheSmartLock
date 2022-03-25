// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B
package ca.thedjkm.it.smartlock.ui.notifications;

import android.os.Bundle;
import android.view.View;
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

TextView textView;
    private TextView temperature,humidity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_temp);

        temperature = findViewById(R.id.tvtemp);
        humidity = findViewById(R.id.tvhumi1);



        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Temp");
        DatabaseReference myRef2 = database.getReference("Humidity");



        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Double m1 =snapshot.getValue(Double.class);

                temperature.setText(m1 + " C");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Double m2 =snapshot.getValue(Double.class);

                humidity.setText(m2 + " %");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });





    }







}
