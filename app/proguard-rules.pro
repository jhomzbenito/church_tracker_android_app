# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in /Users/joedsantiago/Library/Android/sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile


###Retrofit
# Platform calls Class.forName on types which do not exist on Android to determine platform.
-keepattributes InnerClasses

-dontwarn java.lang.invoke.*


#Crashlytics
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable

#retrofit
# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on RoboVM on iOS. Will not be used at runtime.
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions


-dontwarn okio.**

# Retrofit 2.X
## https://square.github.io/retrofit/ ##

-dontwarn retrofit2.**
-keep class com.journeyapps.zxing.** { *; }
-keep class org.ispeech.** { *; }
-keep class retrofit2.** { *; }
-keep class rx.** { *; }
-dontwarn org.simpleframework.**
-dontwarn javax.xml.**
-keep class org.simpleframework.xml.** { *; }
-keepattributes Signature
-keepattributes Exceptions
-keepclasseswithmembers class * {
    @retrofit2.http.* <methods>;
}

-dontwarn org.joda.convert.**
-dontwarn org.joda.time.**
-keep class org.joda.time.** { *; }
-keep interface org.joda.time.** { *; }


-keep class com.mobsandgeeks.saripaar.** {*;}
-keep @com.mobsandgeeks.saripaar.annotation.ValidateUsing class * {*;}
-keep class com.fsgcapital.digipay.common.utility.** {*;}
-keep class net.payswitch.api.** {*;}
-keep class com.appeaser.sublimepickerlibrary.datepicker.** {*;}
-keep class com.github.mikephil.charting.** { *; }

-keep class com.RT_Printer.BluetoothPrinter.BLUETOOTH.** {*;}
-dontwarn com.RT_Printer.BluetoothPrinter.BLUETOOTH.**
-keep class com.fsgcapital.digipay.ui.print.** {*;}

#Kayako
-keep class com.kayako.sdk.android.k5.** { *; }
-dontwarn com.kayako.sdk.android.k5.**
-keepattributes InnerClasses

# Proguard configuration for Jackson 2.x (fasterxml package instead of codehaus package)
-keep class com.fasterxml.jackson.databind.ObjectMapper {
    public <methods>;
    protected <methods>;
}
-keep class com.fasterxml.jackson.databind.ObjectWriter {
    public ** writeValueAsString(**);
}
-keepnames class com.fasterxml.jackson.** { *; }
-dontwarn com.fasterxml.jackson.databind.**

## Square Picasso specific rules ##
## https://square.github.io/picasso/ ##

-dontwarn com.squareup.okhttp.**


# JSR 305 annotations are for embedding nullability information.
-dontwarn javax.annotation.**

# A resource is loaded with a relative path so the package of this class must be preserved.
-keepnames class okhttp3.internal.publicsuffix.PublicSuffixDatabase

# Animal Sniffer compileOnly dependency to ensure APIs are compatible with older versions of Java.
-dontwarn org.codehaus.mojo.animal_sniffer.*

# OkHttp platform used only on JVM and when Conscrypt dependency is available.
-dontwarn okhttp3.internal.platform.ConscryptPlatform