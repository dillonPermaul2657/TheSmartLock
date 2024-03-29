package ca.thedjkm.it.smartlock.ui.Review;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.preference.PreferenceManager;
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

        Button submitButton = (Button) view.findViewById(R.id.submitButton);
        final EditText edit_name = view.findViewById(R.id.editText1);
        final  EditText edit_email = view.findViewById(R.id.editText2);
        final  EditText edit_phone = view.findViewById(R.id.editText3);
        final  EditText edit_feedback = view.findViewById(R.id.editText4);
        final ProgressBarReview progressBarReview = new ProgressBarReview(getActivity());
        Load_setting();
        DAOReview doa = new DAOReview();
        submitButton.setOnClickListener(v ->
                {
                    progressBarReview.loadingProgressBar();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBarReview.dismissProgressBar();
                        }
                    },2000);

                    ReviewData rev = new ReviewData(edit_name.getText().toString(),edit_email.getText().toString(),
                            edit_phone.getText().toString(),edit_feedback.getText().toString());
                    doa.add(rev).addOnSuccessListener(suc ->
                    {

                        // display snackbar when submitting review


                            Snackbar snackBar = Snackbar.make(getActivity().findViewById(android.R.id.content),
                                 R.string.ty_fb , Snackbar.LENGTH_LONG);
                           snackBar.show();
                    }).addOnFailureListener(er ->
                    {
                       Toast.makeText(getActivity(),""+er.getMessage(),Toast.LENGTH_SHORT).show();
                    }
                    );
                    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                    String pattern = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$";
                    if(edit_name.equals("") || edit_name.equals(null)) {
                        edit_name.setError(getString(R.string.error1));
                        return;
                    } else if (edit_email.equals("") || edit_email.equals(null)) {
                        edit_email.setError(getString(R.string.error2));
                        return;
                    }
                    else if (edit_phone.equals("") ||edit_phone.equals(null)||edit_phone.length()<10||edit_phone.length()>10) {
                        edit_phone.setError(getString(R.string.error3));
                        return;
                    }
                    else {
                    }

                }
                );


        return view;
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