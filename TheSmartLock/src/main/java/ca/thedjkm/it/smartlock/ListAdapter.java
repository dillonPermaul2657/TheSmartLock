package ca.thedjkm.it.smartlock;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class ListAdapter extends ArrayAdapter {

    private Activity mContext;
    List<Students> studentsList;

    public ListAdapter(Activity mContext, List<Students> studentsList){
        super(mContext,R.layout.list_item,studentsList);
        this.mContext = mContext;
        this.studentsList = studentsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.list_item,null,true);

        TextView tvDate_t = listItemView.findViewById(R.id.tvdate_t);

        Students students = studentsList.get(position);

        tvDate_t.setText(students.getDate_t());

        return listItemView;

    }
}
