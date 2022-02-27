package fi.antonina.pilldiary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MedicineAdapter extends BaseAdapter {

    Context context;
    int layout;
    ArrayList<MedicineType> medList;

    public MedicineAdapter(Context context, int layout, ArrayList<MedicineType> medList) {
        this.context = context;
        this.layout = layout;
        this.medList = medList;
    }

    @Override
    public int getCount() {
        return medList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(layout,null);

        TextView medName = view.findViewById(R.id.medName);
        TextView medCapsule = view.findViewById(R.id.medCapsule);
        TextView medTime = view.findViewById(R.id.medTime);
        TextView medFeedback = view.findViewById(R.id.medFeedback);

        medName.setText(medList.get(i).getMedName());
        medCapsule.setText(medList.get(i).getMedAmount());
        medTime.setText(medList.get(i).getMedGetTime());
        medFeedback.setText(medList.get(i).getFeedBack());

        ImageButton deleteButton = view.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                medList.remove(i);
            }
        });
        ImageButton editButton = view.findViewById(R.id.editButton);

        return view;
    }
}
