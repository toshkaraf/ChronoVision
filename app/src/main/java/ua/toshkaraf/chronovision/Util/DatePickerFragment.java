package ua.toshkaraf.chronovision.Util;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;

import ua.toshkaraf.chronovision.R;

///**
// * A simple {@link Fragment} subclass.
// * Activities that contain this fragment must implement the
// * {@link DatePickerFragment.OnFragmentInteractionListener} interface
// * to handle interaction events.
// * Use the {@link DatePickerFragment#newInstance} factory method to
// * create an instance of this fragment.
// */

@SuppressLint("ValidFragment")
public class DatePickerFragment extends DialogFragment{

    DatePicker mDatePicker;
    CheckBox mCheckBox;
    Button mOkButton;
    EditText mDateTxtField;

    // Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";

//    // Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;

    private DatePickerFragment(EditText dateTxtField) {
        mDateTxtField = dateTxtField;
    }

    public static DatePickerFragment newInstance(EditText dateTxtField) {
////        Bundle args = new Bundle();
////        args.putString(ARG_PARAM1, param1);
////        args.putString(ARG_PARAM2, param2);
////        fragment.setArguments(args);
        return new DatePickerFragment(dateTxtField);
    }

     @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_date_picker, container, false);
        mDatePicker = (DatePicker) v.findViewById(R.id.datePicker3);
        mCheckBox = (CheckBox) v.findViewById(R.id.BC_checkBox);
        mOkButton = (Button) v.findViewById(R.id.ok_button);
        mOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDateTxtField.setText(mDatePicker.getDayOfMonth()+"/"+mDatePicker.getMonth()+"/"+mDatePicker.getYear());
                dismiss();
            }
        });
        return v;
    }


}
