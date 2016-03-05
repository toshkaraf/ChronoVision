package ua.toshkaraf.chronovision.MainScreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ua.toshkaraf.chronovision.AddEventActivity;
import ua.toshkaraf.chronovision.R;
import ua.toshkaraf.chronovision.Util.ThemeUtil;

/**
 * Created by Антон on 07.01.2016.
 */
public class PlaceholderFragment extends Fragment {
    private static final String ARG_SECTION_NUMBER = "section_number";

    MainScreenActivity activity;

//    private GestureDetector mGestureDetector;

    public PlaceholderFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PlaceholderFragment newInstance(int sectionNumber) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        activity = (MainScreenActivity) getActivity();
        final Context contextThemeWrapper = new ContextThemeWrapper(activity, ThemeUtil.mAppThemeID);
        LayoutInflater localInflater = inflater.cloneInContext(contextThemeWrapper);
        View rootView = localInflater.inflate(R.layout.placeholder_fragment, container, false);
//        TextView textView = (TextView) rootView.findViewById(R.id.section_label);
//        textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));

        FloatingActionButton fab = (FloatingActionButton) rootView.findViewById(R.id.add_event_button);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(activity, AddEventActivity.class));
            }
        });

        rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                activity.toggle();
            }
        });

//        mGestureDetector = new GestureDetector(activity, new GestureDetector.SimpleOnGestureListener() {
//            @Override
//            public void onLongPress(MotionEvent e) {
//                activity.toggle();
////                return true;
//            }
//        });

        return rootView;
    }

}