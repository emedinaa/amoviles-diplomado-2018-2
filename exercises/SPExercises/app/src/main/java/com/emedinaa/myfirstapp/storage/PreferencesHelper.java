
package com.emedinaa.myfirstapp.storage;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;


public class PreferencesHelper {

    private static final String MYNOTES_PREFERENCES = "com.emedinaa.sharedpref";
    private static final String PREFERENCES_USERNAME = MYNOTES_PREFERENCES + ".username";
    private static final String PREFERENCES_PASSWORD = MYNOTES_PREFERENCES + ".password";
    private static final String PRODUCT_ID=MYNOTES_PREFERENCES+".productId";
    private static final String PREFERENCES_COLOR=MYNOTES_PREFERENCES+".color";

    private PreferencesHelper() {
        //no instance
    }

    public static void clear(Context context){
        SharedPreferences.Editor editor = getEditor(context);
        editor.clear();
        //editor.commit();
        editor.apply();
    }

    public static void signOut(Context context) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.remove(PREFERENCES_USERNAME);
        editor.remove(PREFERENCES_PASSWORD);
        editor.apply();
    }

    public static void saveSession(Context context, String username, String password)
    {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_USERNAME, username);
        editor.putString(PREFERENCES_PASSWORD, password);
        editor.apply();
    }

    public static String getUserSession(Context context)
    {
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        String username= sharedPreferences.getString(PREFERENCES_USERNAME,null);

        return username;
    }

    public static boolean isSignedIn(Context context) {
        final SharedPreferences preferences = getSharedPreferences(context);
        return preferences.contains(PREFERENCES_USERNAME) &&
                preferences.contains(PREFERENCES_PASSWORD);
    }

    public static void saveColor(@NonNull  final Context context,
                                 @NonNull String color){
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(PREFERENCES_COLOR,color);
        editor.apply();
    }

    public static String getColor(@NonNull  final Context context){
        SharedPreferences sharedPreferences= getSharedPreferences(context);
        return sharedPreferences.getString(PREFERENCES_COLOR,null);
    }

    public static Boolean isColorSaved(@NonNull  final Context context){
        final SharedPreferences preferences = getSharedPreferences(context);
        return preferences.contains(PREFERENCES_COLOR);
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        SharedPreferences preferences = getSharedPreferences(context);
        return preferences.edit();
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(MYNOTES_PREFERENCES, Context.MODE_PRIVATE);
    }
}
