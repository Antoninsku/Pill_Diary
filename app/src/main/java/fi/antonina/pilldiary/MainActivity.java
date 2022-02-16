package fi.antonina.pilldiary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView createNewAccount;
    Button goInButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a new account Click Event with lambda
        createNewAccount = findViewById(R.id.new_Account_Create);
        createNewAccount.setOnClickListener(view ->
                Toast.makeText(getApplicationContext(),"Create a new account!",Toast.LENGTH_SHORT).show());

        //GO IN Button Click event, move to MainFragment lambda
        goInButton = findViewById(R.id.goInButton);
        goInButton.setOnClickListener(view -> {
            Toast.makeText(getApplicationContext(), "Login Successfully", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, MedicineActivity.class);
            startActivity(intent);
            });
        }
    }
