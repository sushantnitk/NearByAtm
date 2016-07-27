package com.sushantkumarmirara.nearbyatm.Utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by sushantkumar on 26/7/16.
 */
public class Utils {
    public static String readStream(InputStream stream) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
