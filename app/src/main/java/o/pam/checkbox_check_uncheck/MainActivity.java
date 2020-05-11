package o.pam.checkbox_check_uncheck;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public static List<String> checkedMonthArray=new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     Spinner spinnerMonth = findViewById(R.id.spinnerMonth);
//        SpinAdapter adapter = new SpinAdapter(getApplicationContext(),
//                android.R.layout.simple_spinner_item,
//                getResources().getStringArray(R.array.month_array));
//         spinnerMonth.setAdapter(adapter);



        spinadapter_test spinadapter_test=new spinadapter_test(getApplicationContext(),
                android.R.layout.simple_spinner_item,getResources().getStringArray(R.array.month_array));

        spinnerMonth.setAdapter(spinadapter_test);
    }
}
