package o.pam.checkbox_check_uncheck;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static o.pam.checkbox_check_uncheck.MainActivity.checkedMonthArray;

public class spinadapter_test extends ArrayAdapter<String> {

    String[] month_name_array;
    Context context;

    public spinadapter_test(@NonNull Context context, int resource,
                            String[] month_name_array
                            ) {

        super(context, resource,month_name_array);
        this.context=context;
        this.month_name_array=month_name_array;
    }


    @Override
    public View getDropDownView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView=layoutInflater.inflate(R.layout.spinner_item,null);

        CheckBox checkBox=convertView.findViewById(R.id.checkbox);
        checkBox.setText(month_name_array[position]);


        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked)
                    MainActivity.checkedMonthArray.add(month_name_array[position]);
                    else
                        MainActivity.checkedMonthArray.remove(month_name_array[position]);

                Toast.makeText(context,checkedMonthArray.toString(),Toast.LENGTH_LONG).show();
            }
        });


        return convertView;
    }
}
