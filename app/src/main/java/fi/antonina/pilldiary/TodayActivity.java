package fi.antonina.pilldiary;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class TodayActivity extends AppCompatActivity {

    ListView lv;
    CheckBox cb;
    boolean taken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.today);

        cb = findViewById(R.id.medicineCheck);
        lv = findViewById(R.id.listMed);

        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_checked, MedicineSingleton.getInstance().getMedNames()));

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Log.i("DBG", "Alkio " + id + " valittu");
                CheckedTextView v = (CheckedTextView) view;
                v.setChecked(!v.isChecked());
                boolean currentCheck;

                if(v.isChecked()){
                    currentCheck = true;
                }else
                    currentCheck = false;

                cb.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(TodayActivity.this
                                , CalendarActivity.class);
                     /*   if (v.isChecked())
                            intent.putExtra("value", "All medicins have been taken");
                        else
                            intent.putExtra("value", " Not all medicins have been taken");
                     */ //Kumpikin tapa ok
                        if(currentCheck)
                            intent.putExtra("value", "All medicins have been taken");
                        else
                            intent.putExtra("value", " Not all medicins have been taken");

                        startActivity(intent);
                    }
                });
                Toast.makeText(getApplicationContext(),
                        "Click ListItem Number " + position, Toast.LENGTH_LONG)
                        .show();
            }
        });

    }

   public void checked(View view) {
        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.medicineCheck:
                if (checked)
                    taken = true;
                else
                    taken = false;

                Toast.makeText(getApplicationContext(),
                        "Medicins taken " + taken, Toast.LENGTH_LONG)
                        .show();

                break;
        }
    }
  /*public boolean otettu (){
       return taken;
    }

*/
}


