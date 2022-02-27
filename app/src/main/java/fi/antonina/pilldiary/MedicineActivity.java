package fi.antonina.pilldiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MedicineActivity extends AppCompatActivity {
    //Initialize and Assign Variable
    BottomNavigationView navigationView;
    FirebaseAuth auth;
    FirebaseDatabase db;
    DatabaseReference users;
    Button addNewMedicineButton;
    ImageButton deleteButton, editButton;
    ListView medListView;
    ArrayList<MedicineType> medArrayList;
    MedicineType medicineType;
    MedicineAdapter medicineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine);
        // auth = FirebaseAuth.getInstance();
        // auth.signOut();
        navigationView = findViewById(R.id.bottom_nav);
        //Set icon selected
        navigationView.setSelectedItemId(R.id.my_Medicine);
        Toast.makeText(MedicineActivity.this, "My Medicine", Toast.LENGTH_SHORT).show();

        //Perform ItemSelectedListener
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.my_Medicine) {
                    return true;
                } else if (itemId == R.id.person) {
                    startActivity(new Intent(getApplicationContext()
                            , PersonActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.calendar) {
                    startActivity(new Intent(getApplicationContext()
                            , CalendarActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });


        //Add New Medicine button click event
        medListView = findViewById(R.id.medListView);
        medArrayList = new ArrayList<>();
        medicineAdapter = new MedicineAdapter(MedicineActivity.this,R.layout.medicineitem,medArrayList);
        medListView.setAdapter(medicineAdapter);
        addNewMedicineButton = findViewById(R.id.addMedicineButton);
        //When Add New Medicine is clicked, a dialog will appear
        addNewMedicineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MedicineActivity.this);
                View v2 = getLayoutInflater().inflate(R.layout.activity_medicine_add,null);
                final EditText medNameEditText = v2.findViewById(R.id.editTextGetMedName);
                final EditText medAmountEditText = v2.findViewById(R.id.editTextMedNumber);
                final EditText medTimeEditText = v2.findViewById(R.id.editTextMedTime);
                Button addButton = v2.findViewById(R.id.addMedButton);

                builder.setView(v2);
                final Dialog dialog = builder.create();
                dialog.show();

                addButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String medName = medNameEditText.getText().toString().toUpperCase();
                        String medAmount = medAmountEditText.getText().toString();
                        String medTime = medTimeEditText.getText().toString();

                        if(medName.isEmpty() || medAmount.isEmpty() || medTime.isEmpty()){
                            Toast.makeText(MedicineActivity.this, "Please fill information!", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MedicineActivity.this, "Successfully added!", Toast.LENGTH_SHORT).show();

                            medicineType = new MedicineType(medName,"Dont have!",medAmount,medTime);
                            medArrayList.add(medicineType);
                            medicineAdapter.notifyDataSetChanged();
                            dialog.dismiss();
                        }

                    }
                });
            }
        });

        // Delete button click event
    }

    @Override
    protected void onStop() {
        auth = FirebaseAuth.getInstance();
        auth.signOut();
        super.onStop();
    }
}