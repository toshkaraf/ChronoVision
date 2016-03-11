package ua.toshkaraf.chronovision.Util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.GregorianCalendar;

import ua.toshkaraf.chronovision.R;
import ua.toshkaraf.chronovision.Storage.DBOpenHelper;

@SuppressLint("ValidFragment")
public class DatePickerFragment extends DialogFragment {

    DatePicker mDatePicker;
    CheckBox mCheckBox;
    Button mOkButton;
    EditText mDateTxtField;
    Activity mActivity;
    GregorianCalendar date;
    static final String PICKED_DATE = "PICKED_DATE";

    private DatePickerFragment(EditText dateTxtField) {
        mDateTxtField = dateTxtField;
    }

    public static DatePickerFragment newInstance(EditText dateTxtField) {

        return new DatePickerFragment(dateTxtField);
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        mActivity = getActivity();
        View v = mActivity.getLayoutInflater().inflate(R.layout.my_date_picker_fragment, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
        builder.setView(v);
        builder.setTitle(getResources().getString(R.string.please_select_a_date));

        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int year = mDatePicker.getYear();
                mDateTxtField.setText(mDatePicker.getDayOfMonth() + "/" + mDatePicker.getMonth() + "/" + year);
                if (mCheckBox.isChecked()) {year = year * (-1);}
                date = new GregorianCalendar(year,mDatePicker.getMonth(),mDatePicker.getDayOfMonth());
                Bundle args = new Bundle();
                args.putLong(PICKED_DATE, date.getTimeInMillis());
                setArguments(args);
                dismiss();
            }
        });

        return builder.create();
    }

}
