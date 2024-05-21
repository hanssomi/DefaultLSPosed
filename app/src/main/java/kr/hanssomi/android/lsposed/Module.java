package kr.hanssomi.android.lsposed;

import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;

import android.util.Log;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class Module implements IXposedHookLoadPackage {

    private String TAG = "[TAG:HANSSOMI]";
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        findAndHookMethod("android.app.Activity",
                lpparam.classLoader,
                "setTitle",
                CharSequence.class,
                new XC_MethodHook() {
                    @Override
                    protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                        super.beforeHookedMethod(param);

                        String title = param.args[0].toString();
                        Log.e(TAG, "title: " + title);
                        title = "Hanssomi Settings";

                        param.args[0] = title;


                    }

                    @Override
                    protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                        super.afterHookedMethod(param);

                    }
                }
        );
    }
}
