package ua.toshkaraf.chronovision;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InitialActivity extends AppCompatActivity {

    private static final String ATTRIBUTE_NAME = "name";
    private static final String ATTRIBUTE_NAME_SUMMARY = "summary";

    private ListView lv;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mContext = getApplicationContext();
        setContentView(R.layout.activity_initial);

        String names[] = getResources().getStringArray(R.array.initial_choice);
        String summaries[] = getResources().getStringArray(R.array.initial_choice_summary);
        ArrayList<Map<String, Object>> data = new ArrayList<>(
                names.length);

        Map<String, Object> m;
        for (int i = 0; i < names.length; i++) {
            m = new HashMap<>();
            m.put(ATTRIBUTE_NAME, names[i]);
            m.put(ATTRIBUTE_NAME_SUMMARY, summaries[i]);
            data.add(m);
        }

        String[] from = {ATTRIBUTE_NAME, ATTRIBUTE_NAME_SUMMARY};
        int[] to = {R.id.init_list_name, R.id.init_list_summary};

        SimpleAdapter sAdapter = new SimpleAdapter(this, data, R.layout.initial_activity_item_layout,
                from, to);
        lv = (ListView) findViewById(R.id.initialList);
        lv.setAdapter(sAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        startActivity(new Intent(mContext, CreateNewMapActivity.class));
                        break;
                }
            }
        });
    }
}
