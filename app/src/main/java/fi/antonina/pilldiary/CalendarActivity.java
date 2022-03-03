package fi.antonina.pilldiary;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.CalendarView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tooltip.TooltipDrawable;

public class CalendarActivity extends AppCompatActivity {
    TodayActivity todayact;
    TextView hasMedicinsBeenTaken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calendar);

        //Initialise and Assign Variable
        BottomNavigationView navigationView = findViewById(R.id.bottom_nav);

        //Set icon selected
        navigationView.setSelectedItemId(R.id.calendar);

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

      //  todayact = new TodayActivity();
        hasMedicinsBeenTaken = findViewById(R.id.hasMedicinsBeenTaken);


        CalendarView cv = findViewById(R.id.calendarView);
        cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {

            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month,
                                            int dayOfMonth) {

                cv.setSelectedDateVerticalBar(R.color.grey);
              //  cv.setDateTextAppearance();
                Intent intent = new Intent(CalendarActivity.this
                        , TodayActivity.class);
                startActivity(intent);
            }
        });
    }

    public void isTaken (View view){
       Intent incomingIntent = getIntent();
       String takenValue = incomingIntent.getStringExtra("value");
       hasMedicinsBeenTaken.setText(takenValue);

   /*    if(todayact.otettu() == true)
        hasMedicinsBeenTaken.setText("All medicins have been taken");
        else
            hasMedicinsBeenTaken.setText("All medicins have not been taken!");
*/
    }

}
