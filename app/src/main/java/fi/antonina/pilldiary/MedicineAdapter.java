package fi.antonina.pilldiary;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MedicineAdapter extends BaseAdapter {

    MedicineActivity context;
    int layout;
    ArrayList<MedicineType> medList;
    int position;

    public MedicineAdapter(MedicineActivity context, int layout, ArrayList<MedicineType> medList) {
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

        // get position of item by i
        position=i;

        // Delete button click event
        ImageButton deleteButton = view.findViewById(R.id.deleteButton);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Do you want to remove this medicine?");
                builder.setCancelable(true);
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        medList.remove(position);
                        notifyDataSetChanged();
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });

        //Edit button click event and editButton method is called here.
        ImageButton editButton = view.findViewById(R.id.editButton);
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.editButton(position);
            }
        });
        return view;
    }
}
