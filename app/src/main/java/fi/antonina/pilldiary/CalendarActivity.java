package fi.antonina.pilldiary;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CalendarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        //Initialise and Assign Variable
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);

        //Set icon selected
        navigationView.setSelectedItemId(R.id.calendar);
        Toast.makeText(CalendarActivity.this, "Calendar", Toast.LENGTH_SHORT).show();
        //Perform ItemSelectedListener
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.calendar) {
                    return true;
                } else if (itemId == R.id.person) {
                    startActivity(new Intent(getApplicationContext()
                            , PersonActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                } else if (itemId == R.id.my_Medicine) {
                    startActivity(new Intent(getApplicationContext()
                            , MedicineActivity.class));
                    overridePendingTransition(0, 0);
                    return true;
                }
                return false;
            }
        });
    }
}