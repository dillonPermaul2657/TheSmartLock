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

TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_temp);

        textView = findViewById(R.id.tvtemp);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Temp");

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String m =snapshot.getValue(String.class);
                textView.setText(m);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });



    }







}
