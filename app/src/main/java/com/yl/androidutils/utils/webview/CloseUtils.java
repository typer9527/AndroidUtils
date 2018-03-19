package com.yl.androidutils.utils.webview;

import java.io.Closeable;

class CloseUtils {

    public static void closeIO(Closeable closeable) {
        try {
            if (closeable != null){
                closeable.close();
            }
        } catch (Exception e) {

        }

    }
}
