//Kamaljit Mahal N01377647 Section B
//Dillon Permaul N01372657 Section B
//Janpreet Singh N01361405 Section B
//Meet Gajjar N01391319 Section B

//Real time is displayed as well as a FULLY working runtime permission.
//@author Kamaljit Mahal
package ca.thedjkm.it.smartlock.ui.home;

import android.Manifest;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Layout;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import ca.thedjkm.it.smartlock.MainActivity;
import ca.thedjkm.it.smartlock.R;
import ca.thedjkm.it.smartlock.Registration;
import ca.thedjkm.it.smartlock.ui.Review.ReviewScreen;

public class HomeFragment extends Fragment {

    private ConstraintLayout m1;
    private TextView marquee;

    TextView textViewDate;
    TextView textView;
    private final int STORAGE_PERMISSION_CODE = 1;
    Button buttonRequest;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //code for animated text
        textView = (TextView) view.findViewById(R.id.marquee);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);


        //code to show the current date and time
        textViewDate = (TextView) view.findViewById(R.id.text_view_date);


        marquee = view.findViewById(R.id.marquee);
        m1 = view.findViewById(R.id.mlaout);
        Load_setting();

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textViewDate.setText(dateTime);

        buttonRequest = view.findViewById(R.id.button);
// Code for floating action button that redirects to register screen.
        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Register here", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent intent = new Intent(getContext().getApplicationContext(),Registration.class);
                startActivity(intent);
            }
        });

        //This is the runtime permission fully functioning by Kamaljit Mahal (Nov 13,2021)
        //This was completed in deliverable 2, this is just an update
        buttonRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(getActivity(), "You have already granted this permission!",
                            Toast.LENGTH_SHORT).show();
                } else {
                    requestStoragePermission();
                }
            }

            private void requestStoragePermission() {
                if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(),
                        Manifest.permission.READ_EXTERNAL_STORAGE)) {
                    new AlertDialog.Builder(getActivity())
                            .setTitle("Permission needed")
                            .setMessage("We need permissions to access your storage")
                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    ActivityCompat.requestPermissions(getActivity(),
                                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                                }
                            })
                            .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            })
                            .create().show();
                } else {
                    ActivityCompat.requestPermissions(getActivity(),
                            new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
                }
            }

            private void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                if (requestCode == STORAGE_PERMISSION_CODE) {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(getActivity(), "Permission GRANTED", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getActivity(), "Permission DENIED", Toast.LENGTH_SHORT).show();

                    }
                }
            }









        });
        return view;
    }

    private void Load_setting() {
        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(getActivity());

//        boolean chk_night = sp.getBoolean("NIGHT", false);
//        if (chk_night) {
//            m1.setBackgroundColor(Color.parseColor("#222222"));
//         //   marquee.setTextColor(Color.parseColor("#ffffff"));
//
//        } else {
//            m1.setBackgroundColor(Color.parseColor("#ffffff"));
//          //  marquee.setTextColor(Color.parseColor("#000000"));
//        }


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






