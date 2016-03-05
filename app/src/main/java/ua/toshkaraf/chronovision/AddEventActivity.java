package ua.toshkaraf.chronovision;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import ua.toshkaraf.chronovision.EventModel.ChronoEvent;
import ua.toshkaraf.chronovision.R;
import ua.toshkaraf.chronovision.Util.DatePickerFragment;

public class AddEventActivity extends AppCompatActivity  {

    public AddEventActivity() {
        super();
    }

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;
    private static EditText mEventName;
    private static EditText mDescription;
    private static EditText mInitialDateField;
    private static EditText mFinaleDateField;
    private static ChronoEvent newChronoEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        mViewPager = (ViewPager) findViewById(R.id.add_container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.add_tabs);
        tabLayout.setupWithViewPager(mViewPager);

        FloatingActionButton fab = (FloatingActionButton) this.findViewById(R.id.save_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                Snackbar.make(view, "Event is saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_event, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class AddActivityPlaceholderFragment extends Fragment {

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
            ImageButton initialDateFieldButton;
            ImageButton finaleDateFieldButton;
            switch (sectionNumber) {
                case 1:
                    rootView = inflater.inflate(R.layout.add_event_main_features, container, false);
                    mInitialDateField = (EditText) rootView.findViewById(R.id.initial_date_field);
                    mFinaleDateField = (EditText) rootView.findViewById(R.id.finale_date_field);
                    initialDateFieldButton = (ImageButton) rootView.findViewById(R.id.initial_time_picker_button);
                    finaleDateFieldButton = (ImageButton) rootView.findViewById(R.id.finale_time_picker_button);
                    initialDateFieldButton.setOnClickListener(new OnClickListenerForDatePickerButton(getActivity(), mInitialDateField));
                    finaleDateFieldButton.setOnClickListener(new OnClickListenerForDatePickerButton(getActivity(), mFinaleDateField));
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

    public static class OnClickListenerForDatePickerButton implements View.OnClickListener {
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
//
//    /**
//     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
//     * one of the sections/tabs/pages.
//     */

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return AddActivityPlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getResources().getString(R.string.add_main_features);
                case 1:
                    return getResources().getString(R.string.add_multimedia);
                case 2:
                    return getResources().getString(R.string.add_tags);
            }
            return null;
        }
    }

}
