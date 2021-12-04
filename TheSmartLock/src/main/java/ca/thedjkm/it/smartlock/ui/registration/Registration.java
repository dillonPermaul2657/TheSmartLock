// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B
package ca.thedjkm.it.smartlock.ui.registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Patterns;
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
    boolean isNameValid, isEmailValid, isPasswordValid;


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
                SetValidation();
                if (isNameValid && isEmailValid && isPasswordValid) {
                    Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();

                    progressBarReview.loadingProgressBar();
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            progressBarReview.dismissProgressBar();
                        }
                    }, 2000);


                    RegisterData reg = new RegisterData(name.getText().toString(), email.getText().toString(),
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
            }
        });


    }

    public void SetValidation() {
        // Check for a valid name.
        if (name.getText().toString().isEmpty()) {
            name.setError(getResources().getString(R.string.name_error));
            isNameValid = false;
        } else {
            isNameValid = true;
        }

        // Check for a valid email address.
        if (email.getText().toString().isEmpty()) {
            email.setError(getResources().getString(R.string.email_error));
            isEmailValid = false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email.getText().toString()).matches()) {
            email.setError(getResources().getString(R.string.error_invalid_email));
            isEmailValid = false;
        } else {
            isEmailValid = true;
        }

        // Check for a valid password.
        if (pass.getText().toString().isEmpty()) {
            pass.setError(getResources().getString(R.string.password_error));
            isPasswordValid = false;
        } else if (pass.getText().length() < 6) {
            pass.setError(getResources().getString(R.string.error_invalid_password));
            isPasswordValid = false;
        } else {
            isPasswordValid = true;
        }

        if (isNameValid && isEmailValid && isPasswordValid) {
            Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
        }
    }
};
