package o.pam.checkbox_check_uncheck;

import android.content.Context;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import static o.pam.checkbox_check_uncheck.MainActivity.checkedMonthArray;

public class SpinAdapter extends ArrayAdapter<String> {
    private Context context;
    // Your custom values for the spinner (User)
    private  String[] names;

    public SpinAdapter(Context context, int textViewResourceId,
                       String[] names) {
        super(context, textViewResourceId, names);
        this.context = context;
        this.names = names;
    }

//    @Override
//    public int getCount(){
//        return names.length;
//    }
//
//    @Override
//    public String getItem(int position){
//        return names[position];
//    }
//
//    @Override
//    public long getItemId(int position){
//        return position;
//    }


    // And the "magic" goes here
    // This is for the "passive" state of the spinner
//    @Override
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        // I created a dynamic TextView here, but you can reference your own  custom layout for each spinner item
//        if (convertView == null)
//        {
//            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//            //convertView = vi.inflate(android.R.layout.simple_spinner_dropdown_item, null);
//            convertView = vi.inflate(R.layout.spinner_item, null);
//        }
//
//        // And finally return your dynamic (or custom) view for each spinner item
//        return convertView;
//    }

    // And here is when the "chooser" is popped up
    // Normally is the same view, but you can customize it if you want
    @Override
    public View getDropDownView(final int position, View convertView,
                                ViewGroup parent) {
        if (convertView == null)
        {
            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            //convertView = vi.inflate(android.R.layout.simple_spinner_dropdown_item, null);
            convertView = vi.inflate(R.layout.spinner_item, null);
        }
        final CheckBox label = (CheckBox) convertView.findViewById(R.id.checkbox);
        label.setText(names[position]);

        label.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    checkedMonthArray.add(names[position]);
                }else {
                    checkedMonthArray.remove(names[position]);
                }
                Log.e("checkedMonthArray",checkedMonthArray.toString());
            }
        });
        return convertView;
    }
}