//Kamaljit Mahal N01377647 Section B
//Dillon Permaul N01372657 Section B
//Janpreet Singh N01361405 Section B
//Meet Gajjar N01391319 Section B

package ca.thedjkm.it.smartlock.ui.home;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import org.w3c.dom.Text;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import ca.thedjkm.it.smartlock.R;

public class HomeFragment extends Fragment {

    TextView textViewDate;
    TextView textView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        //code for animated text, does not work for some reason at the moment
        textView = (TextView) view.findViewById(R.id.marquee);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);

        //code to show the current date and time
        textViewDate = (TextView) view.findViewById(R.id.text_view_date);

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
        String dateTime = simpleDateFormat.format(calendar.getTime());
        textViewDate.setText(dateTime);
        return view;
    }
}

