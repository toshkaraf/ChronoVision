package ua.toshkaraf.chronovision;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Антон on 18.01.2016.
 */
public class ThemeUtil {

    public static int mFullScreenThemeID;
    public static int mAppThemeID;
    public static int mNoActionBarThemeID;
    public static boolean mMainPreferencesChanged;


    public static void initialise(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        setThemes(prefs.getString("pref_theme", ""));
    }


    public static void setThemes(String theme) {

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

    public static void mainPreferencesChanged() {
        mMainPreferencesChanged = true;
    }
}
