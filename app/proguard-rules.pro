# Add project specific ProGuard rules here.

# Preserve Fragment default empty constructors for FragmentManager restoration
-keep public class * extends androidx.fragment.app.Fragment {
    public <init>();
}

# Preserve ViewBinding classes
-keep class com.App.Thwaap.databinding.** { *; }
