//Kamaljit Mahal N01377647 Section B
//Dillon Permaul N01372657 Section B
//Janpreet Singh N01361405 Section B
//Meet Gajjar N01391319 Section B


package ca.thedjkm.it.smartlock.ui.dashboard;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import ca.thedjkm.it.smartlock.R;

public class DashboardFragment extends Fragment {


    ImageButton lockButton1;
    ImageButton unlockButton2;
    RelativeLayout relativeLayout;




    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard,container,false);

        lockButton1 = (ImageButton) view.findViewById(R.id.imageButton1);
        unlockButton2 = (ImageButton) view.findViewById(R.id.imageButton2);
        relativeLayout = (RelativeLayout) view.findViewById(R.id.rlVar1);

        lockButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundResource(R.color.red);
                Toast.makeText(getActivity(),"The Door is Locked!",Toast.LENGTH_SHORT).show();
            }

        });

        unlockButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setBackgroundResource(R.color.green);
                Toast.makeText(getActivity(),"The Door is Unlocked!",Toast.LENGTH_SHORT).show();

            }
        });

        return view;

    }




}