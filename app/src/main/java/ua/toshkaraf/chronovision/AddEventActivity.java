package ua.toshkaraf.chronovision;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import ua.toshkaraf.chronovision.EventModel.ChronoEvent;
import ua.toshkaraf.chronovision.MainScreen.PlaceholderFragment;
import ua.toshkaraf.chronovision.Storage.MapsHolder;
import ua.toshkaraf.chronovision.Storage.TimeMap;
import ua.toshkaraf.chronovision.Util.NewDatePickerFragment;

import static java.lang.Thread.sleep;

public class AddEventActivity extends AppCompatActivity {

    public AddEventActivity() {
        super();
    }

    private SectionsPagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    private static EditText mEventName;
    private static EditText mDescription;
    private static NewDatePickerFragment mInitialDateFragment;
    private static NewDatePickerFragment mFinalDateFragment;

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
                String[] tags = new String[5];
                try {
                    ChronoEvent newChronoEvent = new ChronoEvent(
                            String.valueOf(mEventName.getText()),
                            mInitialDateFragment.getCheckedDate(true),
                            mInitialDateFragment.isFullDate(),
                            mFinalDateFragment.getCheckedDate(false),
                            mFinalDateFragment.isFullDate(),
                            tags);
                    TimeMap map = MapsHolder.getMap(getIntent().getIntExtra(PlaceholderFragment.ARG_CURRENT_MAP_NUMBER, 1));
                    map.saveEvent(newChronoEvent);
                    AddEventActivity.this.finish();
//                    SimpleDateFormat formatter = new SimpleDateFormat("d MMM yyyy G");
//                    Date date1 = mInitialDateFragment.getCheckedDate(true);
//                    String initialDateteString = formatter.format(date1);
//                    GregorianCalendar date = new GregorianCalendar();
//                    date.setTime(date1);
//                    Snackbar.make(view, initialDateteString, Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                    sleep(Snackbar.LENGTH_LONG);
//                    String finalDateteString = formatter.format(mFinalDateFragment.getCheckedDate(false));
//                    Snackbar.make(view, finalDateteString, Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
                } catch (
                        Exception e) {
                    Snackbar.make(view, e.getMessage(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

//                Snackbar.make(view, "Event is saved", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
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
            switch (sectionNumber) {
                case 1:
                    rootView = inflater.inflate(R.layout.add_event_main_features, container, false);
                    mInitialDateFragment = insertDatePickerFragment(R.id.pick_initial_date);
                    mFinalDateFragment = insertDatePickerFragment(R.id.pick_final_date);
                    mEventName = (EditText) rootView.findViewById(R.id.name_field);
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


        // Embeds the child fragment dynamically
        private NewDatePickerFragment insertDatePickerFragment(int id) {
            NewDatePickerFragment datePickerFragment = new NewDatePickerFragment();
            FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
            transaction.add(id, datePickerFragment).commit();
            return datePickerFragment;
        }

    }

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
