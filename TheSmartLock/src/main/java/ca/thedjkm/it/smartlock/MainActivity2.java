package ca.thedjkm.it.smartlock;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    ListView myListview;
    List<Students> studentsList;

    DatabaseReference studentDbRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

    myListview = findViewById(R.id.myListview);
    studentsList = new ArrayList<>();

    studentDbRef = FirebaseDatabase.getInstance().getReference("Students");


    studentDbRef.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            studentsList.clear();

            for(DataSnapshot studentDatasnap: snapshot.getChildren()){
                Students students = studentDatasnap.getValue(Students.class);
                studentsList.add(students);
            }

            ListAdapter adapter = new ListAdapter(MainActivity2.this,studentsList);
            myListview.setAdapter(adapter);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });



    }
}