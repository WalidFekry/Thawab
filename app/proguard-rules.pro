# R8 / ProGuard Rules for Thawab App

# Keep App Data Models and Serialization
-keep class com.App.Thwaap.models.** { *; }
-keep class com.App.Thwaap.item** { *; }
-keep class com.App.Thwaap.rec_item { *; }
-keep class com.App.Thwaap.qoutes.new_item_post { *; }

# Keep ViewBinding and DataBinding
-keep class com.App.Thwaap.databinding.** { *; }

# Preserve Fragment default constructors
-keep public class * extends androidx.fragment.app.Fragment {
    public <init>();
}

# Keep Activities, Services, and Receivers referenced in Manifest
-keep public class * extends android.app.Activity
-keep public class * extends android.app.Service
-keep public class * extends android.content.BroadcastReceiver
-keep public class * extends android.app.Application

# Google Play Services Ads
-keep class com.google.android.gms.ads.** { *; }
-dontwarn com.google.android.gms.ads.**

# Firebase Services
-keep class com.google.firebase.** { *; }
-dontwarn com.google.firebase.**

# OkHttp & Retrofit
-keep class okhttp3.** { *; }
-dontwarn okhttp3.**
-keep class retrofit2.** { *; }
-dontwarn retrofit2.**

# Lottie Animations
-keep class com.airbnb.lottie.** { *; }

# Third Party UI Libraries
-keep class com.r0adkll.slidr.** { *; }
-keep class com.romainpiel.shimmer.** { *; }
-keep class net.steamcrafted.materialiconlib.** { *; }
-keep class com.github.ybq.android.spinkit.** { *; }

# Optimization settings
-optimizationpasses 5
-allowaccessmodification
-repackageclasses ''
