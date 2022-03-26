package ca.thedjkm.it.smartlock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class servo_Activity extends AppCompatActivity {

    private TextView servo1,lock;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_servo);


        servo1 = findViewById(R.id.servo112);
        lock = findViewById(R.id.servo2);


        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Servo_timestamp");
        DatabaseReference myRef2 = database.getReference("Servo_door_unlock");


        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s1 =snapshot.getValue(String.class);

                servo1.setText(s1);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        myRef2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String s2 =snapshot.getValue(String.class);
                lock.setText(s2);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
















    }
}