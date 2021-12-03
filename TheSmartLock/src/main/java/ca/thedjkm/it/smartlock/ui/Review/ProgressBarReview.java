//Kamaljit Mahal N01377647 Section B
//Dillon Permaul N01372657 Section B
//Janpreet Singh N01361405 Section B
//Meet Gajjar N01391319 Section B
package ca.thedjkm.it.smartlock.ui.Review;

import android.app.Activity;
import android.app.AlertDialog;
import android.view.LayoutInflater;

import ca.thedjkm.it.smartlock.R;

public class ProgressBarReview {
    Activity activity;
    AlertDialog dialog;

    public ProgressBarReview(Activity myActivity){ activity = myActivity;
    }

    public void loadingProgressBar(){
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        LayoutInflater inflater = activity.getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.progressbar_review, null));
        builder.setCancelable(false);

        dialog = builder.create();
        dialog.show();
    }

    public void dismissProgressBar(){
        dialog.dismiss();
    }
}
