package ca.thedjkm.it.smartlock.ui.Review;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import ca.thedjkm.it.smartlock.R;
// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B

public class ReviewScreen extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // return super.onCreateView(inflater, container, savedInstanceState);

        View view = inflater.inflate(R.layout.fragment_review_screen,container,false);

        // initiate rating bar and a button
        final RatingBar simpleRatingBar = (RatingBar) view.findViewById(R.id.RatingBar);
        Button submitButton = (Button) view.findViewById(R.id.submitButton);
        // perform click event on button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get values and then displayed in a toast
                String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
                String rating = "Rating :: " + simpleRatingBar.getRating();
                Toast.makeText(getContext().getApplicationContext(), totalStars + "\n" + rating, Toast.LENGTH_LONG).show();
                Snackbar snackBar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                        "Snackbar under construction", Snackbar.LENGTH_LONG);
                snackBar.show();
            }
        });
        return view;
    }
}