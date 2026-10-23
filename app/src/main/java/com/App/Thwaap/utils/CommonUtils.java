package com.App.Thwaap.utils;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class CommonUtils {

    public static void setupFullscreen(Activity activity) {
        if (activity == null) return;
        Window window = activity.getWindow();
        if (window == null) return;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            WindowInsetsControllerCompat controller = WindowCompat.getInsetsController(window, window.getDecorView());
            controller.hide(WindowInsetsCompat.Type.statusBars());
            controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
        } else {
            @SuppressWarnings("deprecation")
            int flag = WindowManager.LayoutParams.FLAG_FULLSCREEN;
            window.setFlags(flag, flag);
        }
    }

    public static void copyToClipboard(Context context, String label, String text, String successMessage) {
        if (context == null || text == null) return;
        ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboard != null) {
            ClipData clip = ClipData.newPlainText(label, text);
            clipboard.setPrimaryClip(clip);
            if (successMessage != null && !successMessage.isEmpty()) {
                Toast.makeText(context, successMessage, Toast.LENGTH_SHORT).show();
            }
        }
    }

    public static void shareText(Context context, String subject, String text, String chooserTitle) {
        if (context == null || text == null) return;
        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        if (subject != null) {
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
        }
        sendIntent.putExtra(Intent.EXTRA_TEXT, text);
        context.startActivity(Intent.createChooser(sendIntent, chooserTitle != null ? chooserTitle : "مشاركة"));
    }

    public static void openUrl(Context context, String url) {
        if (context == null || url == null || url.isEmpty()) return;
        try {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            context.startActivity(intent);
        } catch (Exception e) {
            Toast.makeText(context, "تعذر فتح الرابط", Toast.LENGTH_SHORT).show();
        }
    }

    public static void openPlayStore(Context context) {
        if (context == null) return;
        String packageName = context.getPackageName();
        openUrl(context, "https://play.google.com/store/apps/details?id=" + packageName);
    }

    public static void sendEmail(Context context, String email, String subject, String defaultText) {
        if (context == null || email == null) return;
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", email, null));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject != null ? subject : "");
        emailIntent.putExtra(Intent.EXTRA_TEXT, defaultText != null ? defaultText : "");
        try {
            context.startActivity(Intent.createChooser(emailIntent, "إرسال بريد إلكتروني..."));
        } catch (Exception e) {
            Toast.makeText(context, "لا يوجد تطبيق بريد إلكتروني مثبّت", Toast.LENGTH_SHORT).show();
        }
    }
}
