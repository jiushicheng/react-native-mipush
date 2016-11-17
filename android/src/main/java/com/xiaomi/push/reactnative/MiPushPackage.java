package com.xiaomi.push.reactnative;

import android.content.Intent;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.List;

public class MiPushPackage implements ReactPackage {
    private MiPushModule mPushModule;
    private Intent mIntent;
    private String app_id;
    private String app_key;

    public MiPushPackage(String app_id, String app_key) {
        this.app_id = app_id;
        this.app_key = app_key;
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactApplicationContext) {
        mPushModule = new MiPushModule(reactApplicationContext, app_id, app_key);
        List<NativeModule> modules = new ArrayList<>();
        modules.add(mPushModule);
        return modules;
    }

    @Override
    public List<Class<? extends JavaScriptModule>> createJSModules() {
        return new ArrayList<>();
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactApplicationContext) {
        return new ArrayList<>();
    }
}
