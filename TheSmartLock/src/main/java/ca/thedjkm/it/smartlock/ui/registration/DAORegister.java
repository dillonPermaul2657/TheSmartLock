// Kamaljit Mahal N01377647 Section B
// Dillon Permaul N01372657 Section B
// Janpreet Singh N01361405 Section B
// Meet Gajjar N01391319 Section B
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

