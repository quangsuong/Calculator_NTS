package net.blogsv.calculator_nts;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import net.blogsv.calculator_nts.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {
    TextView tvInput, tvOutput;
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnOp, btnCl, btnTotal, btnMinus, btnAddition, btnMultiply, btnDivision, btnC, btnAC;
    MainViewModel mainViewModel;
    String process;
    int checkOp = 0;

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
        mainViewModel.getResult().observe(this, num -> {
            if (num != null) {
                tvOutput.setText(num.toString());
            } else {
                tvOutput.setText("0");
            }
        });

    }

    private void addEvents() {
        btn0.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "0");
        });
        btn1.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "1");
        });
        btn2.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "2");
        });
        btn3.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "3");
        });
        btn4.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "4");
        });
        btn5.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "5");
        });
        btn6.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "6");
        });
        btn7.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "7");
        });
        btn8.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "8");
        });
        btn9.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "9");
        });

        btnC.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            if (!process.isEmpty())
                tvInput.setText(process.substring(0, process.length() - 1));
        });
        btnAC.setOnClickListener(v -> {
            tvInput.setText("");
            tvOutput.setText("");
        });

        btnAddition.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "+");
        });
        btnMultiply.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "*");
        });
        btnMinus.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "-");
        });
        btnOp.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "(");
            checkOp++;
        });
        btnCl.setOnClickListener(v -> {
            if (checkOp > 0) {
                process = tvInput.getText().toString();
                tvInput.setText(process + ")");
                checkOp--;
            } else {
                Toast.makeText(this, "Bạn cần mở ngoặc", Toast.LENGTH_SHORT).show();
            }
        });
        btnDivision.setOnClickListener(v -> {
            process = tvInput.getText().toString();
            tvInput.setText(process + "/");
        });
        btnTotal.setOnClickListener(v -> {
            try {
                mainViewModel.calMath(tvInput.getText().toString());
            } catch (Exception e) {
                tvOutput.setText("Error");
            }

        });
    }

    private void addControls() {
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);
        btn0 = findViewById(R.id.btn_0);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
        btn6 = findViewById(R.id.btn_6);
        btn7 = findViewById(R.id.btn_7);
        btn8 = findViewById(R.id.btn_8);
        btn9 = findViewById(R.id.btn_9);
        btnC = findViewById(R.id.btn_c);
        btnAC = findViewById(R.id.btn_ac);
        btnTotal = findViewById(R.id.btn_tol);
        btnAddition = findViewById(R.id.btn_add);
        btnDivision = findViewById(R.id.btn_div);
        btnMinus = findViewById(R.id.btn_minus);
        btnMultiply = findViewById(R.id.btn_mul);
        btnOp = findViewById(R.id.btn_op);
        btnCl = findViewById(R.id.btn_cl);
        tvInput = findViewById(R.id.tv_inpput);
        tvOutput = findViewById(R.id.tv_output);

    }


}
