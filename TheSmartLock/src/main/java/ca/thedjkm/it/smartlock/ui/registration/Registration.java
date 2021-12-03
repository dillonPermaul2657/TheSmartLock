package ca.thedjkm.it.smartlock.ui.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

import ca.thedjkm.it.smartlock.R;
import ca.thedjkm.it.smartlock.ui.Review.DAOReview;
import ca.thedjkm.it.smartlock.ui.Review.ProgressBarReview;
import ca.thedjkm.it.smartlock.ui.Review.ReviewData;


public class Registration extends AppCompatActivity {

    EditText name;
    EditText email;
    EditText pass;
    Button register;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        name = findViewById(R.id.txtName);
        email = findViewById(R.id.txtEmail);
        pass = findViewById(R.id.txtPwd);
        register = findViewById(R.id.btnrgstr);
        final ProgressBarReview progressBarReview = new ProgressBarReview(Registration.this);

        DAORegister doa = new DAORegister();

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressBarReview.loadingProgressBar();
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        progressBarReview.dismissProgressBar();
                    }
                },2000);


                RegisterData reg = new RegisterData(name.getText().toString(),email.getText().toString(),
                        pass.getText().toString());
                doa.add(reg).addOnSuccessListener(suc ->
                {
                    Toast toast = Toast.makeText(getApplicationContext(), "You have been registered", Toast.LENGTH_LONG);
                    toast.show();

                }).addOnFailureListener(er ->
                        {
                            Toast toast = Toast.makeText(getApplicationContext(), "Please try again", Toast.LENGTH_LONG);
                            toast.show();
                           // Toast.makeText(getActivity(),""+er.getMessage(),Toast.LENGTH_SHORT).show();
                        }
                );


            }
        });


        }};
