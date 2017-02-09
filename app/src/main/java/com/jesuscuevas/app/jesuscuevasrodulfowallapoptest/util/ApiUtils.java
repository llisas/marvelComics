package com.jesuscuevas.app.jesuscuevasrodulfowallapoptest.util;

import android.util.Log;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ApiUtils {

    public static String generateMarvelHash (String publicKey, String privateKey) {

        String mHash = "";
        try {
            String timeStamp = getUnixTimeStamp();
            String marvelData = timeStamp + privateKey + publicKey;
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            byte[] hash = messageDigest.digest(marvelData.getBytes());
            StringBuilder stringBuilder = new StringBuilder(2 * hash.length);

            for (byte b : hash)
                stringBuilder.append(String.format("%02x", b & 0xff));

            mHash = stringBuilder.toString();

        } catch (NoSuchAlgorithmException e) {
            Log.d(Constants.LOG,"error"+e.getMessage());
        }
        return mHash;
    }

    public static String getUnixTimeStamp() {
        return String.valueOf(System.currentTimeMillis() / 1000L);
    }
}
