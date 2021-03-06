package ua.toshkaraf.chronovision;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.LinkedList;

import ua.toshkaraf.chronovision.Storage.TimeMap;

public class CreateNewMapActivity extends AppCompatActivity {

    private TimeMap newTimeMap;
    private CheckBox tagsCheckBox[];
    private LinkedList<String> tags;
    private EditText editName;
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
        editName = (EditText) findViewById(R.id.edit_name);

        findViewById(R.id.create_button).
                setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View v) {
                                           String name = editName.getText().toString();

                                           if (!name.equals("")) {
                                               tags = new LinkedList<>();
                                               for (CheckBox chBox : tagsCheckBox) {
                                                   if (chBox.isChecked())
                                                       tags.add(chBox.getText().toString().replaceAll(" ", "_"));
                                               }

                                               newTimeMap = new TimeMap(mContext, name, tags.toArray(new String[tags.size()]));
                                               startActivity(new Intent(CreateNewMapActivity.this, MainScreenActivity.class));
                                           } else
                                               Toast.makeText(CreateNewMapActivity.this, mContext.getResources().getText(R.string.toast_invalide_name), Toast.LENGTH_SHORT).show();
                                       }
                                   }

                );
    }
}
