package fi.antonina.pilldiary;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);

        //Make each icon selected event
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);
        navigationView.setOnItemSelectedListener(new BottomNavigationView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.circle_check:
                        Toast.makeText(MainFragment.this,"Today",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.my_Medicine:
                        Toast.makeText(MainFragment.this,"My Medicine",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.person:
                        Toast.makeText(MainFragment.this,"Person",Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.calendar:
                        Toast.makeText(MainFragment.this,"Calendar",Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }
}