This repository teaches you how to change the title of "Android settings" using Magisk + LSPosed.

The LSPosed is https://github.com/LSPosed/LSPosed

1. Add the following line to the AndroidManifest.xml

<application>
    <meta-data
        android:name="xposedmodule"
        android:value="true" />
    <meta-data
        android:name="xposeddescription"
        android:value="Modify Android Settings Title" />
    <meta-data
        android:name="xposedminversion"
        android:value="82" />
</applicaiton>

2. open the app-level build.gradle
dependencies add the line
    - compileOnly 'de.robv.android.xposed:api:82'

3. open the project-level settings.gradle
    ...
    - maven { url 'https://api.xposed.info/' }

4. create a file app/src/main/assets
    - xposed_init
    - Initialize the class to be injected.
    - ex) kr.hanssomi.android.lsposed.Module

5. Module.java
    - open th Module.java
