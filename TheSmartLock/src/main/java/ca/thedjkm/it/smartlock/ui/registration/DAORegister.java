package ca.thedjkm.it.smartlock.ui.registration;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;



public class DAORegister {

    private DatabaseReference databaseReference;

    public DAORegister()
    {
        FirebaseDatabase db = FirebaseDatabase.getInstance();

        databaseReference = db.getReference(RegisterData.class.getSimpleName());

    }

    public Task<Void> add(RegisterData reg)

    {

        return databaseReference.push().setValue(reg);


    }
}

