package net.blogsv.calculator_nts;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import net.blogsv.calculator_nts.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    EditText ed_cal;
    TextView tv_Cal;
    Button btn_KQ;
    MainViewModel mainViewModel;

    String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
        addDisplays();
        addEvents();
//
    }

    private void addDisplays() {
        mainViewModel.getResult().observe(this, integer -> {
            if (integer != null) {
            }
        });
    }

    private void addEvents() {
    }

    private void addControls() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

    }


}
