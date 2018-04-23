package sg.edu.rp.c347.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    /**
    ListView lv;
    ArrayList<String> al;
    ArrayAdapter<String> aa;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        al = new ArrayList<String>();
        al.add("Secular");

        aa = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, al);

        lv = (ListView) findViewById(R.id.lvHoliday);

        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String a = al.get(position);
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                i.putExtra("Secular", al);
                startActivity(i);

            }
        });

    }
    **/

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvHoliday);

        // Create a holiday object in Holiday array
        holiday = new ArrayList<Holiday>();
        holiday.add(new Holiday("New Year's Day", "1 Jan 2017"));
        holiday.add(new Holiday("Labour Day", "1 May 2017"));

        aa = new SecondActivity(this, R.layout.row, holiday);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Holiday selectedHoliday = holiday.get(position);

                Toast.makeText(MainActivity.this, selectedHoliday.getHolidayName()
                + selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
