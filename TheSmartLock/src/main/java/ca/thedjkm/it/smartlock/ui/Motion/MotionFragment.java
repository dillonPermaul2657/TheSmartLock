// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B
package ca.thedjkm.it.smartlock.ui.Motion;

import static android.widget.Toast.*;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.hardware.TriggerEventListener;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.fragment.app.Fragment;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import ca.thedjkm.it.smartlock.R;

public class MotionFragment extends Fragment {

    private TextView MsgTxt;
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference mRootReference = firebaseDatabase.getReference();
    private final DatabaseReference mChildReference = mRootReference.child("message");

    private SensorManager sensorManager;
    private Sensor sensor;
    private TriggerEventListener triggerEventListener;
    //Button ON;

    private static final String CHANNEL_ID = "SIMPLFIED_CODING";
    private static final String CHANNEL_NAME = "SIMPLFIED CODING";
    private static final String CHANNEL_DESC = "SIMPLFIED_CODING NOTIFICATION";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_motion,container,false);
        Button btn=(Button) root.findViewById(R.id.ON);
       Button btn2=(Button) root.findViewById(R.id.OFF);

        MsgTxt = (TextView)root.findViewById(R.id.msgTxt) ;
       MsgTxt.setText("1");

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                StyleableToast.makeText(getActivity(), "Motion Sensor is on !!!", R.style.onbtn).show();
                displayNotification();

            }
        });


        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StyleableToast.makeText(getContext(), "Motion Sensor is OFF !!!", R.style.offbtn).show();
            }
        });

        return root;
    }



    private void displayNotification(){

        NotificationCompat.Builder nBuilder =
                new NotificationCompat.Builder(getContext(),CHANNEL_ID)
                    .setSmallIcon(R.drawable.motion_icon)
                    .setContentTitle("Motion")
                    .setContentText("Motion sensor is on")
                    .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mnotificationManager = NotificationManagerCompat.from(getContext());
        mnotificationManager.notify(1,nBuilder.build());

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


