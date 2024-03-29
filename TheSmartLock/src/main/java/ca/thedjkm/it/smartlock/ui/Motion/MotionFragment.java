// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B
package ca.thedjkm.it.smartlock.ui.Motion;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

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

import ca.thedjkm.it.smartlock.MainActivity2;
import ca.thedjkm.it.smartlock.R;
//
// import ca.thedjkm.it.smartlock.userlist;

public class MotionFragment extends Fragment {

    private TextView MsgTxt;
    private final FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private final DatabaseReference mRootReference = firebaseDatabase.getReference();
    private final DatabaseReference mChildReference = mRootReference.child("message");



    private static final String CHANNEL_ID = "SIMPLFIED_CODING";
    private static final String CHANNEL_NAME = "SIMPLFIED CODING";
    private static final String CHANNEL_DESC = "SIMPLFIED_CODING NOTIFICATION";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);

        View root = inflater.inflate(R.layout.fragment_motion,container,false);
        Button btn=(Button) root.findViewById(R.id.ON);
     //  Button button2=(Button) root.findViewById(R.id.OFF);

        MsgTxt = (TextView)root.findViewById(R.id.msgTxt) ;
      // MsgTxt.setText("1");
        Load_setting();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID,CHANNEL_NAME,NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getActivity().getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }



        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                  Intent i = new Intent(getActivity(), MainActivity2.class);
                  startActivity(i);

            }
        });





        return root;
    }


    private void displayNotification(){

        NotificationCompat.Builder nBuilder =
                new NotificationCompat.Builder(getContext(),CHANNEL_ID)
                        .setSmallIcon(R.drawable.motion_icon)
                        .setContentTitle("Motion Sensor")
                        .setContentText("Motion sensor is on now !!!")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat mnotificationManager = NotificationManagerCompat.from(getContext());
        mnotificationManager.notify(1,nBuilder.build());

    }






    // code for shared preference for the landscape mode
    private void Load_setting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());

        String orien = sp.getString("ORIENTATION", "false");
        if ("1".equals(orien)) {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_BEHIND);


        } else if ("2".equals(orien)) {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        } else if ("3".equals(orien)) {
            getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        }



    }

    @Override
    public void onResume() {
        Load_setting();
        super.onResume();
    }



}


