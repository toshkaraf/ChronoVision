package ua.toshkaraf.chronovision.AddEvent;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import ua.toshkaraf.chronovision.R;

public class AddActivityPlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    public static AddActivityPlaceholderFragment newInstance(int sectionNumber) {
        AddActivityPlaceholderFragment fragment = new AddActivityPlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Integer sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        View rootView;
        EditText initialDateField;
        EditText finaleDateField;
        Button initialDateFieldButton;
        Button finaleDateFieldButton;
        switch (sectionNumber){
            case 1:
                rootView = inflater.inflate(R.layout.add_event_main_features, container, false);
                initialDateField = (EditText) rootView.findViewById(R.id.initial_date_field);
                finaleDateField = (EditText) rootView.findViewById(R.id.finale_date_field);
                initialDateFieldButton = (Button) rootView.findViewById(R.id.initial_time_picker_button);
                finaleDateFieldButton = (Button) rootView.findViewById(R.id.finale_time_picker_button);
                initialDateFieldButton.setOnClickListener(new OnClickListenerForDatePickerButton(getActivity(), initialDateField));
                finaleDateFieldButton.setOnClickListener(new OnClickListenerForDatePickerButton(getActivity(), finaleDateField));
            break;
            case 2:
                rootView = inflater.inflate(R.layout.add_multimedia, container, false);
                break;
            case 3:
                rootView = inflater.inflate(R.layout.add_tags, container, false);
                break;
            default:
                rootView = inflater.inflate(R.layout.add_event_main_features, container, false);

        }
        return rootView;
    }


}

