package ua.toshkaraf.chronovision.Util;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ua.toshkaraf.chronovision.R;

/**
 * Created by Антон on 04.03.2016.
 */
public class NewDatePickerFragment extends Fragment {

    android.widget.DatePicker mDatePicker;
    CheckBox mBC_checkBox;
    Spinner mMonthSpinner;
    Spinner mDaySpinner;
    EditText mYear;
    View rootView;
    Activity mActivity;
    int day;

    static final String PICKED_DATE = "PICKED_DATE";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] monthData = getResources().getStringArray(R.array.months);
        String[] dayData = new String[32];
        dayData[0] = getActivity().getResources().getString(R.string.day_field);
        for (Integer i = 1; i < 32; i++) {
            dayData[i] = i.toString();
        }

        rootView = inflater.inflate(R.layout.my_date_picker_fragment, container, false);
        mBC_checkBox = (CheckBox) rootView.findViewById(R.id.BC);

        mMonthSpinner = (Spinner) rootView.findViewById(R.id.month_spinner);
        ArrayAdapter monthSpinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, monthData);
        monthSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mMonthSpinner.setAdapter(monthSpinnerAdapter);

        mDaySpinner = (Spinner) rootView.findViewById(R.id.day_spinner);
        ArrayAdapter daySpinnerAdapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_item, dayData);
        monthSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mDaySpinner.setAdapter(daySpinnerAdapter);

        mYear = (EditText) rootView.findViewById(R.id.edit_year);
        return rootView;
    }

    public Date getCheckedDate(Boolean isInitialDate) throws Exception {
        EditText yearField = (EditText) rootView.findViewById(R.id.edit_year);
        Date dateEvent;
        if (yearField.getText() != null) {
            Integer year = Integer.parseInt(String.valueOf(yearField.getText()));
            if (((CheckBox) rootView.findViewById(R.id.BC)).isChecked()) year = year * (-1);
            if (year < 2100 && year > -5000) {
                int month = ((Spinner) rootView.findViewById(R.id.month_spinner)).getLastVisiblePosition();
                day = ((Spinner) rootView.findViewById(R.id.day_spinner)).getLastVisiblePosition();
                GregorianCalendar date = new GregorianCalendar(year, --month, day);
                if (((CheckBox) rootView.findViewById(R.id.BC)).isChecked()) date.set(Calendar.ERA,GregorianCalendar.BC);
                if (day > date.getActualMaximum(Calendar.DATE))
                    throw new NumberFormatException();
                if (year <0) {date.set(Calendar.YEAR, ++year);}
                dateEvent = date.getTime();
            } else throw new NumberFormatException();
        } else if (!isInitialDate) return null;
        else throw new NumberFormatException("ошибька");
        return dateEvent;
    }

    public Boolean isFullDate() {
        if (day > 0) return true;
        else return false;
    }
}
