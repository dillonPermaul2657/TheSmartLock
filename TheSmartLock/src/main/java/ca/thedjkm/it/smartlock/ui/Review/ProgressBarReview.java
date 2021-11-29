package ca.thedjkm.it.smartlock.ui.Review;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import ca.thedjkm.it.smartlock.R;

public class ProgressBarReview {
    Activity activity;
    AlertDialog dialog;

    ProgressBarReview(Activity myActivity){
        activity = myActivity;
    }


    void loadingProgressBar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.progressbar_review, null));
        builder.setCancelable(true);

        dialog = builder.create();
        dialog.show();
    }

    void dismissProgressBar(){
        dialog.dismiss();
    }
}
