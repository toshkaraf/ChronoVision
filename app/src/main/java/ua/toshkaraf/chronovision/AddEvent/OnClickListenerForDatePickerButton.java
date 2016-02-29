package ua.toshkaraf.chronovision.AddEvent;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.EditText;

import ua.toshkaraf.chronovision.Util.DatePickerFragment;

/**
 * Created by Антон on 29.02.2016.
 */

public class OnClickListenerForDatePickerButton implements View.OnClickListener {
    EditText mWhereShowPickedData;
    FragmentActivity activity;

    OnClickListenerForDatePickerButton(FragmentActivity activity,EditText whereShowPickedData) {
        this.mWhereShowPickedData = whereShowPickedData;
        this.activity = activity;
    }

    @Override
    public void onClick(View view) {
        DatePickerFragment dialog = DatePickerFragment.newInstance(mWhereShowPickedData);
        FragmentTransaction ft = activity.getSupportFragmentManager().beginTransaction();
        dialog.show(ft, "DatePicker");
    }

}
