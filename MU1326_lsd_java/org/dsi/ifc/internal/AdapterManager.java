/*
 * Decompiled with CFR 0.152.
 */
package org.dsi.ifc.internal;

import java.lang.reflect.Field;
import java.util.HashMap;
import org.dsi.ifc.base.IAdapterManager;
import org.dsi.ifc.base.IFactory;

public class AdapterManager
implements IAdapterManager {
    private HashMap factories = new HashMap(5);
    private static final AdapterManager singleton = new AdapterManager();

    public static AdapterManager getDefault() {
        return singleton;
    }

    private AdapterManager() {
    }

    @Override
    public synchronized void registerFactories(IFactory iFactory) {
        Class[] classArray = iFactory.getFactoryList();
        int n = classArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            String string = classArray[i2].getName();
            Object object = this.factories.get(string);
            if (object != null && !iFactory.shouldOverride((IFactory)object)) {
                return;
            }
            this.factories.put(string, iFactory);
        }
    }

    @Override
    public synchronized void unregisterFactories(IFactory iFactory) {
        Class[] classArray = iFactory.getFactoryList();
        int n = classArray.length;
        for (int i2 = 0; i2 < n; ++i2) {
            String string = classArray[i2].getName();
            Object object = this.factories.get(string);
            if (object == null || object != iFactory) continue;
            this.factories.remove(string);
        }
    }

    public synchronized void unregisterAllFactories() {
        this.factories.clear();
    }

    @Override
    public synchronized Object getFactory(Class clazz) {
        IFactory iFactory = (IFactory)this.factories.get(clazz.getName());
        Object object = null;
        if (iFactory != null) {
            object = iFactory.getFactory(clazz);
        }
        return object;
    }

    public String getVersionInfo(Object object) {
        if (object == null) {
            return null;
        }
        try {
            Field field = object.getClass().getDeclaredField("VERSION");
            field.setAccessible(true);
            Object object2 = field.get(object);
            return new StringBuffer().append(object.getClass().getName()).append("@@").append(String.valueOf(object2)).toString();
        }
        catch (Throwable throwable) {
            return null;
        }
    }
}

