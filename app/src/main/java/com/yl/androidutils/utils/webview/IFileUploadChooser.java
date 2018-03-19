package com.yl.androidutils.utils.webview;

import android.content.Intent;


public interface IFileUploadChooser {



    void openFileChooser();

    void fetchFilePathFromIntent(int requestCode, int resultCode, Intent data);
}
