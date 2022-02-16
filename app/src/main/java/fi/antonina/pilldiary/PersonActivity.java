package fi.antonina.pilldiary;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PersonActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person);

        //Intitialize and Assign Variable
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);

        //Set icon selected
        navigationView.setSelectedItemId(R.id.person);
        Toast.makeText(PersonActivity.this, "Personal", Toast.LENGTH_SHORT).show();
        //Perform ItemSelectedListener
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.my_Medicine) {
                    startActivity(new Intent(getApplicationContext()
                            , MedicineActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.person) {
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
    }
}
