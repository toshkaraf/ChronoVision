package ua.toshkaraf.chronovision.Util;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.GregorianCalendar;

import ua.toshkaraf.chronovision.R;

/**
 * Created by Антон on 04.03.2016.
 */
public class NewDatePickerFragment extends Fragment  {

    android.widget.DatePicker mDatePicker;
    CheckBox mBC_checkBox;
    Spinner mMonthSpinner;
    Spinner mDaySpinner;
    EditText mYear;
    Activity mActivity;
    GregorianCalendar date;
    static final String PICKED_DATE = "PICKED_DATE";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String[] monthData = {"one", "two", "three", "four", "five"};
        Integer[] dayData = new Integer[31];
        for (int i=0; i<32; i++){dayData[i]=i;}

//        View v = inflater.inflate(R.layout.my_date_picker_fragment, container, false);
//        mBC_checkBox = (CheckBox) v.findViewById(R.id.BC);
//
//        mMonthSpinner = (Spinner) v.findViewById(R.id.spinner);
////        ArrayAdapter monthSpinnerAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_spinner_item, monthData);
////        monthSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////        mMonthSpinner.setAdapter(monthSpinnerAdapter);
//
//        mDaySpinner = (Spinner) v.findViewById(R.id.spinner2);
////        ArrayAdapter daySpinnerAdapter = new ArrayAdapter<Integer>(getContext(), android.R.layout.simple_spinner_item, dayData);
////        monthSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
////        mDaySpinner.setAdapter(daySpinnerAdapter);
//
//        mYear = (EditText) v.findViewById(R.id.edit_year);
        return inflater.inflate(R.layout.my_date_picker_fragment, container, false);

    }

//    @Override
//    public void onFocusChange(View v, boolean hasFocus) {
//    }
}
