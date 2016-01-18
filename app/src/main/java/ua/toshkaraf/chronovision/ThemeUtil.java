package ua.toshkaraf.chronovision;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Антон on 18.01.2016.
 */
public class ThemeUtil implements SharedPreferences.OnSharedPreferenceChangeListener {

    public static int mFullScreenThemeID;
    public static int mAppThemeID;
    public static int mNoActionBarThemeID;
    public static boolean mMainPreferencesChanged;
    Context mContext;


    public ThemeUtil() {

        mMainPreferencesChanged = false;
    }

    public void setContext(Context context) {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        prefs.registerOnSharedPreferenceChangeListener(this);

        setThemes(prefs);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        mMainPreferencesChanged = true;
        setThemes(sharedPreferences);
    }

    private void setThemes(SharedPreferences preferences) {
        String theme = preferences.getString("pref_theme", "");
        switch (theme) {
            case "Dark":
                mFullScreenThemeID = R.style.FullscreenTheme;
                mAppThemeID = R.style.AppTheme;
                mNoActionBarThemeID = R.style.NoActionBar;
                break;
            case "Warm":
            case "":
                mFullScreenThemeID = R.style.FullscreenTheme_Warm;
                mAppThemeID = R.style.AppTheme_Warm;
                mNoActionBarThemeID = R.style.AppTheme_Warm_NoActionBar;
                break;
            case "Cold":
                mFullScreenThemeID = R.style.FullscreenTheme_Warm;
                mAppThemeID = R.style.AppTheme_Cold;
                mNoActionBarThemeID = R.style.AppTheme_Warm_NoActionBar;
                break;
        }
    }
}
