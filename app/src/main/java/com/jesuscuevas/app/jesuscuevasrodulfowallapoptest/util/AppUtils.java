package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util;

import android.os.Build;
import android.text.Html;

public class AppUtils {

    public static String fromHtmlToString(String text){
        String converted = "";
        if (text != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                converted = String.valueOf(Html.fromHtml(text, 0));
            } else {
                converted = String.valueOf(Html.fromHtml(text));
            }
        } else {
            converted ="error";
        }
        return converted;
    }
}
