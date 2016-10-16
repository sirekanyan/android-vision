package com.google.android.gms.samples.vision.face.facetracker.storage;

import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * User: vadik
 * Date: 10/16/16
 */

public class PhotoSaver {

    private static final String TAG = PhotoSaver.class.getName();
    private static final String DATE_MASK = "yyyyMMdd_HHmmss";
    private static final String FILE_EXT = ".jpg";

    public static void save(byte[] bytes, String prefix) {
        try {
            new FileOutputStream(file(prefix)).write(bytes);
        } catch (IOException e) {
            Log.e(TAG, "cannot save photo to storage", e);
        }
    }

    private static File file(String prefix) {
        String filename = prefix + "_" + timestamp() + FILE_EXT;
        return new File(directory(), filename);
    }

    private static File directory() {
        return Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
    }

    private static String timestamp() {
        return new SimpleDateFormat(DATE_MASK, Locale.US).format(new Date());
    }
}
