package com.yl.androidutils.utils.utils;

import android.Manifest;
import android.app.Activity;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;

import com.dawei.okmaster.R;

import java.io.File;

import static com.dawei.okmaster.utils.FileUtils.getMimeType;

/**
 * 打开系统应用
 */
public class ActionUtils {

    private ActionUtils() {
        throw new Error("Do not need instantiate!");
    }

    /**
     * 调用系统发短信
     *
     * @param context
     * @param strMobile
     * @param strContent
     */
    public static void sendMessage(Context context, String strMobile, String strContent) {

        Uri uri = Uri.parse("smsto:" + strMobile);
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", strContent);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 调用系统拨号界面
     *
     * @param strMobile 电话号码
     */
    public static void callPhone(Context context, String strMobile) {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + strMobile));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }

    /**
     * 调用拨号功能
     *
     * @param strMobile 电话号码
     */
    public static void callPhone2(Context context, String strMobile) {
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + strMobile));
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager
                .PERMISSION_GRANTED) {
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        context.startActivity(intent);
    }

    /**
     * 调用系统分享图片
     *
     * @param context
     * @param uri
     * @param strTitle
     */
    public static void shareImage(Context context, Uri uri, String strTitle) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("image/jpeg");
        context.startActivity(Intent.createChooser(shareIntent, strTitle));
    }

    /**
     * 调用系统分享
     *
     * @param context
     * @param str
     */
    public static void share(Context context, String str) {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT, "普惠多格赠品商城");
        intent.putExtra(Intent.EXTRA_TEXT, str);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setType("text/plain");
        context.startActivity(Intent.createChooser(intent, "来自普惠多格android客户端"));
    }

    /**
     * 进入系统拍照
     *
     * @param activity
     * @param outputUri 照片输出路径 Environment.getExternalStorageDirectory() + "/image.jpg")
     */
    public static void startActivityForCamera(Activity activity, int requestCode, Uri outputUri) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        // 制定图片保存路径
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 进入系统拍照 (输出为Bitmap)
     * Tips: 返回的Bitmap并非原图的Bitmap而是经过压缩的Bitmap
     *
     * @param activity
     */
    public static void startActivityForCamera(Activity activity, int requestCode) {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 进入系统图库
     *
     * @param activity
     */
    public static void startActivityForGallery(Activity activity, int requestCode) {
        // 弹出系统图库
        Intent i = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(i, requestCode);
    }

    /**
     * 进入系统裁剪
     *
     * @param inputUri  需要裁剪的图片路径
     * @param outputUri 裁剪后图片路径 Environment.getExternalStorageDirectory() + "/image.jpg")
     * @param width     裁剪后宽度(px)
     * @param height    裁剪后高度(px)
     */
    private void startActivityForImageCut(Activity activity, int requestCode, Uri inputUri, Uri outputUri,
                                          int width, int height) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(inputUri, "image/*");
        // 下面这个crop=true是设置在开启的Intent中设置显示的VIEW可裁剪
        intent.putExtra("crop", "true");
        intent.putExtra("scale", true); // 去黑边
        intent.putExtra("scaleUpIfNeeded", true); // 去黑边
        // aspectX aspectY 是宽高的比例
        intent.putExtra("aspectX", 1); // 输出是X方向的比例
        intent.putExtra("aspectY", 1);
        // outputX outputY 是裁剪图片宽高，切忌不要再改动下列数字，会卡死
        intent.putExtra("outputX", width); // 输出X方向的像素
        intent.putExtra("outputY", height);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("noFaceDetection", true);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        intent.putExtra("return-data", false); // 设置为不返回数据
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 检测是否存在快捷键
     *
     * @param activity Activity
     * @return 是否存在桌面图标
     */
    public static boolean hasShortcut(Activity activity) {
        boolean isInstallShortcut = false;
        final ContentResolver cr = activity.getContentResolver();
        final String AUTHORITY = "com.android.launcher.settings";
        final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/favorites?notify=true");
        Cursor c = cr.query(CONTENT_URI,
                new String[]{"title", "iconResource"}, "title=?",
                new String[]{activity.getString(R.string.app_name).trim()},
                null);
        if (c != null && c.getCount() > 0) {
            isInstallShortcut = true;
        }
        return isInstallShortcut;
    }

    /**
     * 为程序创建桌面快捷方式
     *
     * @param activity Activity
     */
    public static void addShortcut(Activity activity, int resId) {
        Intent shortcut = new Intent("com.android.launcher.action.INSTALL_SHORTCUT");
        // 快捷方式的名称
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME,
                activity.getString(R.string.app_name));
        shortcut.putExtra("duplicate", false); // 不允许重复创建
        Intent shortcutIntent = new Intent(Intent.ACTION_MAIN);
        shortcutIntent.setClassName(activity, activity.getClass().getName());
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
        // 快捷方式的图标
        Intent.ShortcutIconResource iconRes = Intent.ShortcutIconResource.fromContext(activity, resId);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconRes);
        activity.sendBroadcast(shortcut);
    }

    /**
     * 删除快捷方式
     *
     * @param activity
     * @param strName
     */
    public static void delShortcut(Activity activity, String strName) {
        Intent shortcut = new Intent("com.android.launcher.action.UNINSTALL_SHORTCUT");
        // 快捷方式的名称
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_NAME, strName);
        String appClass = activity.getPackageName() + "" + activity.getLocalClassName();
        ComponentName comp = new ComponentName(activity.getPackageName(), appClass);
        shortcut.putExtra(Intent.EXTRA_SHORTCUT_INTENT, new Intent(
                Intent.ACTION_MAIN).setComponent(comp));
        activity.sendBroadcast(shortcut);
    }

    /**
     * 打开网络设置界面
     */
    public static void openNetWorkSettings(Context context) {
        if (android.os.Build.VERSION.SDK_INT > 10) {
            context.startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
        } else {
            context.startActivity(new Intent(android.provider.Settings.ACTION_SETTINGS).setFlags
                    (Intent.FLAG_ACTIVITY_NEW_TASK));
        }
    }

    /**
     * 使用系统程序打开文件
     *
     * @param activity Activity
     * @param file     File
     * @throws Exception
     */
    public static void openFile(Activity activity, File file) throws Exception {
        Intent intent = new Intent();
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), getMimeType(file, activity));
        activity.startActivity(intent);
    }
}
