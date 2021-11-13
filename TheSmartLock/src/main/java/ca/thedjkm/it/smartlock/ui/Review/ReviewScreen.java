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
import android.widget.EditText;
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
        final EditText edit_name = view.findViewById(R.id.editText1);
        final  EditText edit_email = view.findViewById(R.id.editText2);
        DAOReview doa = new DAOReview();
        submitButton.setOnClickListener(v ->
                {

                    ReviewData rev = new ReviewData(edit_name.getText().toString(),edit_email.getText().toString());
                    doa.add(rev).addOnSuccessListener(suc ->

                    {

                        Toast.makeText(getActivity(),"Insterted",Toast.LENGTH_SHORT).show();
                    }).addOnFailureListener(er ->

                    {

                        Toast.makeText(getActivity(),""+er.getMessage(),Toast.LENGTH_SHORT).show();


                    }



                    );

                }

                );
        // perform click event on button
       // submitButton.setOnClickListener(new View.OnClickListener() {
         //   @Override
          //  public void onClick(View v) {
                // get values and then displayed in a toast
            //   String totalStars = "Total Stars:: " + simpleRatingBar.getNumStars();
               // String rating = "Rating :: " + simpleRatingBar.getRating();
            //    Snackbar snackBar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                 //       totalStars + "\n" + rating, Snackbar.LENGTH_LONG);
             //   snackBar.show();
          //  }
       // });
        return view;
    }
}