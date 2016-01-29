package ua.toshkaraf.chronovision;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.LinkedList;

import ua.toshkaraf.chronovision.Storage.TimeMap;

public class CreateNewMapActivity extends AppCompatActivity {

    private TimeMap newTimeMap;
    private CheckBox tagsCheckBox[];
    private LinkedList<String> tags;
    private TextView name;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_map);

        mContext = getApplicationContext();

        tagsCheckBox = new CheckBox[]{
                (CheckBox) findViewById(R.id.checkBox1),
                (CheckBox) findViewById(R.id.checkBox2),
                (CheckBox) findViewById(R.id.checkBox3),
                (CheckBox) findViewById(R.id.checkBox4),
                (CheckBox) findViewById(R.id.checkBox5),
                (CheckBox) findViewById(R.id.checkBox6),
                (CheckBox) findViewById(R.id.checkBox7),
        };
        name = (TextView) findViewById(R.id.event_name);

        findViewById(R.id.create_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tags = new LinkedList<>();
                for (CheckBox chBox : tagsCheckBox) {
                    if (chBox.isChecked())
                        tags.add((String) chBox.getText());
                }

                if (name != null) {
                    newTimeMap = new TimeMap(mContext,(String) name.getText(), (String[]) tags.toArray());
                    
                    startActivity(new Intent(mContext, MainScreenActivity.class));
                }
            }
        }

        );
    }
}
