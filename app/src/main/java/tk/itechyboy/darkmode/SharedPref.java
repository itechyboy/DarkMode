package tk.itechyboy.darkmode;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by SWAGGER on 15/03/2020.
 */
public class SharedPref {
    private SharedPreferences sharedPreferences;
    public SharedPref(Context context) {
        sharedPreferences = context.getSharedPreferences("SharedPref",Context.MODE_PRIVATE);
    }
    public void setNightModeState(Boolean state) {
        SharedPreferences.Editor editor;
        editor = sharedPreferences.edit();
        editor.putBoolean("NightMode",state);
        editor.apply();
    }
    public Boolean loadNightModeState() {
        return sharedPreferences.getBoolean("NightMode",false);
    }
}
