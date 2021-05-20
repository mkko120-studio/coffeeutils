package studio.mkko120.coffeeutils.PVP.POJO;

import com.google.gson.Gson;
import studio.mkko120.coffeeutils.PVP.PvPUser;

public class POJOUtils {

    public static PvPUser convert(String json) {
        PvPUser user;
        Gson gson = new Gson();

        // Converting
        user = gson.fromJson(json, PvPUser.class);

        return user;
    }
}
