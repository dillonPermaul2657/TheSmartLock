// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B
package ca.thedjkm.it.smartlock.ui.notifications;

import static android.content.Context.NOTIFICATION_SERVICE;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import android.content.Context;

import ca.thedjkm.it.smartlock.R;

public class NotificationsFragment extends Fragment {

    Button button;

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_notifications,container,false);

        button = (Button) view.findViewById(R.id.NotiButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                NotificationCompat.Builder mbuilder =
                        new NotificationCompat.Builder(getContext().getApplicationContext())
                        .setSmallIcon(R.drawable.ic_lock_foreground)
                        .setContentTitle(getString(R.string.notif))
                        .setContentText(getString(R.string.NotiMessage));

               NotificationManager notificationManager = (NotificationManager)
                        getActivity().getSystemService(getActivity().NOTIFICATION_SERVICE);
                notificationManager.notify(0,mbuilder.build());

            }
        });

        return view;
    }




}