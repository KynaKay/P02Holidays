package sg.edu.rp.c347.p02_holidays;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**public class SecondActivity extends AppCompatActivity { **/

public class SecondActivity extends ArrayAdapter<Holiday> {
    /**
     * ListView lv;
     * TextView tv;
     * ArrayAdapter aa;
     * ArrayList<Holiday> holiday;
     *
     * @Override protected void onCreate(Bundle savedInstanceState) {
     * super.onCreate(savedInstanceState);
     * setContentView(R.layout.second_activity);
     * <p>
     * lv = (ListView)this.findViewById(R.id.lvHoliday);
     * tv = (TextView)findViewById(R.id.tv);
     * <p>
     * Intent i = getIntent();
     * String holiday = i.getStringExtra("holiday");
     * <p>
     * ArrayList<Holiday> holidays = new ArrayList<Holiday>();
     * <p>
     * if (holiday.equals("New Year's Day")) {
     * <p>
     * } else if (holiday.equals("Labour Day")) {
     * holidays.add("New Year's Day", "1 Jan 2017");
     * <p>
     * }
     * }
     **/

    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvHoliday;
    private ImageView iv;

    public SecondActivity(Context context, int resource, ArrayList<Holiday> objects) {
        super(context, resource, objects);

        holiday = objects;

        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);

        tvHoliday = (TextView) rowView.findViewById(R.id.tv1);

        iv = (ImageView)rowView.findViewById(R.id.lvHoliday);

        Holiday currentHoliday = holiday.get(position);

        tvHoliday.setText(currentHoliday.getHolidayName());

        if (currentHoliday.equals("New Year's Day")) {
            iv.setImageResource(R.drawable.newyear);
        } else if (currentHoliday.equals("Labour Day")) {
            iv.setImageResource(R.drawable.labourday);
        }

        return rowView;

    }

}
