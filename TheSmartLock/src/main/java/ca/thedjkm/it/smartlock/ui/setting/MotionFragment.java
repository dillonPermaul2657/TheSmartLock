// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B
package ca.thedjkm.it.smartlock.ui.setting;

import static android.widget.Toast.*;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.TriggerEventListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ca.thedjkm.it.smartlock.R;

public class MotionFragment extends Fragment {

    private TextView MsgTxt;
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference mRootReference = firebaseDatabase.getReference();
    private final DatabaseReference mChildReference = mRootReference.child("message");

    private SensorManager sensorManager;
    private Sensor sensor;
    private TriggerEventListener triggerEventListener;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_motion,container,false);
        Button btn=(Button) root.findViewById(R.id.ON);
        //Button btn2=(Button) root.findViewById(R.id.OFF);

        MsgTxt = (TextView)root.findViewById(R.id.msgTxt) ;
       MsgTxt.setText("1");
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Motion Sensor is on", LENGTH_SHORT).show();
            }
        });

//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(getActivity(), "Motion sensor is OFF", LENGTH_SHORT).show();
//            }
//        });

        return root;
    }





    @Override
    public void onStart() {
        super.onStart();
        mChildReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                Integer message = snapshot.getValue(Integer.class);
             //   MsgTxt.setText("message appear here..");
             //  MsgTxt.setText(message + "times motion detected");
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });

    }



}


